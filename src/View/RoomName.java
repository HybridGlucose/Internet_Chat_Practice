package View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RoomName
{
	public Button CancelBtn;
	public Button SubmitBtn;
	public TextField RoomNameField;

	public void submitBtnOnClick() throws IOException
	{
		Model.Client.runClient(RoomNameField.getText());
		Stage stage = (Stage) SubmitBtn.getScene().getWindow();
		stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Chat.fxml")),240,360));
	}
	public void cancelBtnOnClick()
	{
		Stage stage = (Stage) SubmitBtn.getScene().getWindow();
		stage.close();
	}
}
