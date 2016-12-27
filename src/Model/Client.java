package Model;
import java.io.*;
import java.net.*;
import java.lang.*;
import java.util.*;
import java.nio.charset.Charset;
public class Client
{
    private static final int ServerPort=8888;
    private static final int ClientPort=2234;
    private static final String ServerGroup="224.0.0.3";
    private static String strTmp;
    private static MulticastSocket socket;
    public static void main(String[] args)
    {
        try{
            Scanner sc = new Scanner(System.in);
            InetAddress group = InetAddress.getByName(ServerGroup);
            socket = new MulticastSocket(ClientPort);
            socket.joinGroup(group);

            System.out.println("Please Input Group Name(Join Or Create)");
            String groupName = sc.nextLine();//input room name

            //SEND DATA TO SERVER12
            byte flag = (byte)((new Random()).nextDouble() * 255); //random flag
            byte tt[] = groupName.getBytes(Charset.forName("UTF-8"));
            byte[] b_groupName = new byte[tt.length + 1];
            for(int index = 0; index < tt.length; ++index)
            {
                b_groupName[index + 1] = tt[index];
            }
            b_groupName[0] = flag;
            DatagramPacket serverPacket =
                    new DatagramPacket(b_groupName, b_groupName.length, group, ServerPort);
            socket.send(serverPacket); //send serverPacket
            //
            //RECEVE DATA FROM SERVER
            byte[] buffer = new byte[1000];
            DatagramPacket recv = new DatagramPacket(buffer, buffer.length);//JAVA 的 SOCKET 會使用這個CLASS的方法將DATA寫入BUFFER
            do{
                socket.receive(recv);
            }while(buffer[0] != flag);
            byte tmp[] = new byte[recv.getLength() - 1];// room ip
            for(int index = 1; index < recv.getLength(); ++index)
            {
                tmp[index - 1] = buffer[index];
            }
            String communicateAddr = new String (tmp,  Charset.forName("UTF-8"));
            System.out.println("your room ip is " + communicateAddr);
            //
            socket.leaveGroup(group);
            InetAddress communicateGroup = InetAddress.getByName(communicateAddr); // java ip format
            socket.joinGroup(communicateGroup); //join group
            //RECEIVE LOOP
            Thread therad = new Thread() //執行緒
            {
                public void run()
                {
                    try{
                        DatagramPacket receive = new DatagramPacket(new byte[1024], 1024);
                        for(;;) {
                            socket.receive(receive);//接收
                            byte[] bbt = Arrays.copyOfRange(receive.getData(), 0, receive.getLength());//統一長度
                            String tmp = new String(bbt, Charset.forName("UTF-8"));
                            if(strTmp.equals(tmp))//消除字元
                            {
                                strTmp = "";
                                continue;
                            }
                            System.out.println(tmp);
                        }
                    } catch(Exception e) {
                        System.out.print(e.toString());
                        return;
                    }
                }
            };
            therad.start();
            //
            for(;;)
            {
                String str = sc.nextLine();
                strTmp = str;
                DatagramPacket message =
                        new DatagramPacket(str.getBytes(), str.getBytes().length, communicateGroup, ClientPort);
                socket.send(message);
            }
        }catch(Exception e){
            System.out.println("Error: " + e.toString());
            return;
        }
    }
}