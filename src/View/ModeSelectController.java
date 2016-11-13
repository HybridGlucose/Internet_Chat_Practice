package View;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ModeSelectController
{
	public RadioButton ServerRadio;
	public RadioButton ClientRadio;
	public TextField IPField;
	public TextField PortField;
	public Button CancelBtn;
	public Button SubmitBtn;

	public void submitBtnOnClick()
	{

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
			IPField.setEditable(true);
		} else
		{
			//Client Mode Selected.
			IPField.setEditable(false);
		}
	}
}
