package View;

import Model.Client;
import Model.UserData;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class ChatController
{
	public Button SendBtn;
	public TextArea InputArea;
	public TextArea messageArea;
	public Label informationLabel;
	private static String receiveMessage = "";
	private static String lastMes = "";

	@FXML
	protected void initialize() throws IOException
	{
		Thread thread = new Thread()
		{
			public void run()
			{
				while (true)
				{
					printGetMessage();
					try
					{
						Thread.sleep(200);
					} catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}
			}
		};
		thread.start();
		if(UserData.getMode().equals("client"))
		{
			informationLabel.setText("Your ID is: " + UserData.getNickName() + "\n In The Room: " + UserData.getRoomName());
			Client.firstMessage();
		}
		else
		{
			informationLabel.setText("Now You're Running in Server Mode!");
			serverMode();
			Model.Server.runServer();
		}
	}

	public static void receiveMessages(String messages)
	{
		receiveMessage = messages;
	}

	public void printGetMessage()
	{
		if (!receiveMessage.equals(lastMes))
		{
			messageArea.appendText("\n" + receiveMessage);
			lastMes = "";
			receiveMessage = "";
		}
	}

	public void serverMode()
	{
		InputArea.setDisable(true);
		SendBtn.setDisable(true);
	}

	public void sendBtnOnClick() throws IOException
	{
		if(!InputArea.getText().isEmpty())
		{
			String message = InputArea.getText();
			Model.Client.sendMessages(UserData.getNickName() + " Say: " + message);
			InputArea.clear();
		}
	}

}
