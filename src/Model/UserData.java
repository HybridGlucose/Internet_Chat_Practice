package Model;

import java.util.ArrayList;
import java.util.List;

public class UserData
{
    private static String NickName;
    private static String RoomName;

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


}
