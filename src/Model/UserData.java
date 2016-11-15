package Model;

public class UserData
{
    private static String NickName;
    private static String IP;
    private static int port;
    public static String theyNickName;

    public static void setNickName(String nickName)
    {
        NickName = nickName;
    }
    public static String getNickName()
    {
        return NickName;
    }
    public static String getTheyNickName()
    {
        return theyNickName;
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
}
