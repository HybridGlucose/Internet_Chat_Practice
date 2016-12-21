package View;

import Model.Client;
import Model.Server;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import Model.UserData;
import javafx.util.converter.NumberStringConverter;

import java.io.IOException;

public class ModeSelectController
{
	public RadioButton ServerRadio;
	public RadioButton ClientRadio;
	public TextField IPField;
	public TextField PortField;
	public Button CancelBtn;
	public Button SubmitBtn;

	public void submitBtnOnClick() throws IOException
	{
		UserData.setIP(IPField.getText());
		UserData.setPort(Integer.parseInt(PortField.getText()));
		/*Thread clientThread = new Thread(new Client(),"clientThread");
		Thread serverThread = new Thread(new Server(),"serverThread");
		clientThread.start();
		serverThread.start();*/
		SubmitBtn.setDisable(true);
		Stage stage = (Stage) SubmitBtn.getScene().getWindow();
		stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Chat.fxml")),240,360));
	}

	public void cancelBtnOnClick()
	{
		Stage stage = (Stage) SubmitBtn.getScene().getWindow();
		stage.close();
	}

}
