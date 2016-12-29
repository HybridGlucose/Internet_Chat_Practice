package View;

import Model.UserData;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class ChatController
{
	public Button SendBtn;
	public TextArea InputArea;
	public TextArea messageArea;
	private static String receiveMessage = "";
	private static String lastMes = "";


	@FXML
	protected void initialize()
	{
		Thread thread = new Thread()
		{
			public void run()
			{
				while (true)
				{
					printGetMessage();
				}
			}
		};
		thread.start();
	}

	public void printGetMessage()
	{
		if (!receiveMessage.equals(lastMes))
		{
			messageArea.appendText("\n" + UserData.getNickName() + " say: " + receiveMessage);
			lastMes = receiveMessage;
		}
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
