package View;

import Model.Client;
import Model.Server;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;
import Model.UserData;
import javafx.util.converter.NumberStringConverter;

public class ModeSelectController
{
	public RadioButton ServerRadio;
	public RadioButton ClientRadio;
	public TextField IPField;
	public TextField PortField;
	public Button CancelBtn;
	public Button SubmitBtn;
	private int mode;//mode 0 is Server.

	public void submitBtnOnClick()
	{
		//TODO  Fix when Client finished will still run in Server mode.
		if(mode == 1)
		{
			UserData.setIP(IPField.getText());
		}
		UserData.setPort(Integer.parseInt(PortField.getText()));
		if(mode == 1)
		{
			Model.Client client = new Client();
			Thread clientThread = new Thread(client);
			clientThread.start();
		}
		Model.Server server = new Server();
		Thread serverThread = new Thread(server);
		serverThread.start();
	}

	public void cancelBtnOnClick()
	{
		Stage stage  = (Stage) SubmitBtn.getScene().getWindow();
		stage.close();
	}

	public void modeSelect()
	{
		if (ServerRadio.isSelected())
		{
			//Server Mode Selected.
			IPField.setEditable(false);
			mode = 0;
		} else
		{
			//Client Mode Selected.
			IPField.setEditable(true);
			mode = 1;
		}
	}
}
