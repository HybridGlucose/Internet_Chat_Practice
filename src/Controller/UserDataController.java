package Controller;

public class UserDataController {
    private static String NickName;
    private static String IP;
    private static int port;

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
        UserDataController.IP = IP;
    }
    public static String getIP()
    {
        return IP;
    }
    public static void setPort(int port)
    {
        UserDataController.port = port;
    }
    public static int getPort()
    {
        return port;
    }
}
