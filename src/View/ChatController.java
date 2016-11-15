package View;

import Model.Server;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class ChatController
{

	public Button SendBtn;
	public static TextArea InputArea;
	public static TextArea messageArea;

	public static void printGetMessage(String message)
	{
		messageArea.appendText(Model.UserData.getTheyNickName() + " say:\n" + message);
	}

	public static String sendMessage()
	{
		String message = InputArea.getText();
		return message;
	}
	public void sendBtnOnClick()
	{
		Server.time = 0;
	}
}
