package Model;

import java.util.ArrayList;
import java.util.List;

public class UserData
{
    private static String NickName;
    private static String RoomName;
    private static String Mode;

    public static void setNickName(String nickName)
    {
        NickName = nickName;
    }
    public static String getNickName()
    {
        return NickName;
    }
    public static  void setRoomName(String roomName)
    {
        RoomName = roomName;
    }
    public static String getRoomName()
    {
        return RoomName;
    }
    public static  void setMode(String mode)
    {
        Mode = mode;
    }
    public static String getMode()
    {
        return Mode;
    }


}
