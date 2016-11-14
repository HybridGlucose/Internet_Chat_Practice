package View;


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
		Controller.UserDataController.setNickName(NickNameField.getText());
		//Get Parent Stage.
		Stage stage  = (Stage) SubmitBtn.getScene().getWindow();
		stage.hide();
		//Show ModeSelect Stage.
		stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("ModeSelect.fxml")),480,280));
		stage.setTitle("Mode Select");
		stage.show();
	}
	public void cancelBtnOnClick()
	{
		Stage stage = (Stage) SubmitBtn.getScene().getWindow();
		stage.close();
	}
}
