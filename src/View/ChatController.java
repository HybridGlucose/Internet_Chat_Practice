package View;

import Model.UserData;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import java.io.IOException;

public class ChatController
{
	public Button SendBtn;
	public TextArea InputArea;
	public TextArea messageArea;
	private static String receiveMessage = "";
	private static String lastMes = "";

	{
		Thread thread = new Thread()
		{
			public void run()
			{
				if (!receiveMessage.equals(lastMes))
				{
					printGetMessage();
				}
			}
		};
		thread.start();
	}

	public void printGetMessage()
	{
		messageArea.appendText("/n" + UserData.getNickName() + "say: " + receiveMessage);
	}

	public void sendBtnOnClick() throws IOException
	{
		String message = InputArea.getText();
		Model.Client.sendMessages(message);
		messageArea.appendText("\n" + UserData.getNickName() + " say: " + message);
		InputArea.clear();
	}

	public static void receiveMessages(String messages)
	{
		receiveMessage = messages;
	}
}
