package Model;

import java.util.ArrayList;
import java.util.List;

public class UserData
{
    private static String NickName;
    private static String IP;
    private static int port;
    public static String theyNickName;
    public static int count = 0;
    public static List<onlineUser> onlineUsers = new ArrayList<onlineUser>();

    public static void setNickName(String nickName)
    {
        NickName = nickName;
    }
    public static String getNickName()
    {
        return NickName;
    }

    public static void setIP(String IP)
    {
        UserData.IP = IP;
    }
    public static String getIP()
    {
        return IP;
    }

    public static void setPort(int port)
    {
        UserData.port = port;
    }
    public static int getPort()
    {
        return port;
    }

    public static void addNewUser(String nickName,String IP)
    {
        onlineUsers.add(count,new onlineUser(nickName,IP));
        count = count + 1;
    }
    public static void delUser(String nickName)
    {
        if(onlineUsers.iterator().equals(nickName))
        {
            onlineUsers.remove(onlineUsers.listIterator().previousIndex()+1);
        }
    }

}

class onlineUser
{
    private String nickName;
    private String IP;
    private int ID;

    public onlineUser(String nickName, String ip)
    {
        this.nickName = nickName;
        this.IP = ip;
        this.ID = UserData.count;
    }
}
