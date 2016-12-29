package View;

import Model.UserData;
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
		UserData.setRoomNumber(RoomNameField.getText());
		Stage stage = (Stage) SubmitBtn.getScene().getWindow();
		stage.hide();
		stage.setTitle("Chat-ID: " + Model.UserData.getNickName());
		stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Chat.fxml")),240,360));
		stage.show();
	}
	public void cancelBtnOnClick()
	{
		Stage stage = (Stage) SubmitBtn.getScene().getWindow();
		stage.close();
	}
}
