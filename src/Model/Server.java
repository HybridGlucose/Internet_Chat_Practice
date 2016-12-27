package Model;
import java.io.*;
import java.net.*;
import java.lang.*;
import java.util.*;
import java.nio.charset.Charset;
public class Server {
    private static final int ServerPort=8888;//接收PORT server
    private static final int ClientPort=2234;//接收port client
    private static final String ServerGroup="224.0.0.3"; //virtual ip address
    private static MulticastSocket socket; //socket
    private static Map<String, String> groupMap; // map 對應 <ROOM NAME, IP ADDRESS>
    public static void main(String[] args) {
        try{ // socket exception
            groupMap = new HashMap<String, String>();
            socket = new MulticastSocket(ServerPort); //SERVER RECEIVE SERVER PORT
            InetAddress group = InetAddress.getByName(ServerGroup); // transfer to java ip format
            socket.joinGroup(group); // join to virtual ip (group)
            byte[] buffer = new byte[1000];
            DatagramPacket recv = new DatagramPacket(buffer, buffer.length); // let buffer to java data format
            System.out.println("START");
            for(;;) // main loop
            {
                socket.receive(recv); //receive data
                if(recv.getLength() < 1) //if receive error
                    continue;
                byte tmp[] = new byte[recv.getLength() - 1]; //room name buffer
                for(int index = 1; index < recv.getLength(); ++index) // copy array 1-recv.length()
                {
                    tmp[index - 1] = buffer[index];
                }
                System.out.println("Request Room Id Is " + new String(tmp, Charset.forName("UTF-8")));
                if(!groupMap.containsKey(new String(tmp))) //如果ROOM NAME 不在MAP裡面 隨機一組新的IP
                {
                    groupMap.put(new String(tmp), getIP()); // add key and value
                }
                String ip = groupMap.get(new String(tmp)); //get ip
                byte tt[] = ip.getBytes(Charset.forName("UTF-8")); // ip (String to byte)
                byte[] mes = new byte[tt.length + 1]; // send message buffer , length is ip.length + 1(flag)
                for(int index = 0; index < tt.length; ++index) //copy
                {
                    mes[index + 1] = tt[index];
                }

                mes[0] = buffer[0]; //add flag to message first byte
                DatagramPacket sendMes = new DatagramPacket(mes, mes.length, group, ClientPort);
                System.out.println("The Room " + new String(tmp, Charset.forName("UTF-8")) + " Ip Is " + ip);
                socket.send(sendMes);
            }
        }catch(Exception e)
        {
            System.out.println("Error: " + e.toString());
        }
    }

    public static String getIP()
    {
        String ip = "";
        Random r = new Random();
        ip += "224";
        ip += '.';
        ip += Integer.toString((int)(r.nextDouble() * 254) + 1);
        ip += '.';
        ip += Integer.toString((int)(r.nextDouble() * 254) + 1);
        ip += '.';
        ip += Integer.toString((int)(r.nextDouble() * 254) + 1);
        if(groupMap.containsValue(ip))
            return getIP();
        return ip;
    }
}
