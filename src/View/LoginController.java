package View;


import Model.UserData;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class LoginController
{
	public TextField NickNameField;
	public Button CancelBtn;
	public Button SubmitBtn;

	public void submitBtnOnClick() throws IOException
	{
		UserData.setNickName(NickNameField.getText());
		//Get Parent Stage.
		Stage stage  = (Stage) SubmitBtn.getScene().getWindow();
		stage.hide();
		//Show ModeSelect Stage.
		stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("RoomName.fxml")),480,280));
		stage.setTitle("Room Name");
		stage.show();
	}
	public void cancelBtnOnClick()
	{
		Stage stage = (Stage) SubmitBtn.getScene().getWindow();
		stage.close();
	}
}
