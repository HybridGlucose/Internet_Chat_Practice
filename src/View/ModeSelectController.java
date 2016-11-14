package View;

import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import  Controller.UserDataController;

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
			UserDataController.setIP(IPField.getText());
		}
		UserDataController.setPort(Integer.parseInt(PortField.getText()));
		if(mode == 1)
		{
			new Model.Client().run();
		}
		new Model.server().run();
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
