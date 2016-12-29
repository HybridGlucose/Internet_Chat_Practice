package View;

import Model.UserData;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ModeSelectController
{
	public Button ServerModeBtn;
	public Button ClientModeBtn;

	public void ServerModeBtnOnClick() throws IOException
	{
		Stage stage = (Stage) ClientModeBtn.getScene().getWindow();
		stage.hide();
		stage.setTitle("Server side");
		UserData.setMode("server");
		stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Chat.fxml")),240,360));
		stage.show();
	}

	public void ClientModeBtnOnClick() throws IOException
	{
		Stage stage = (Stage) ClientModeBtn.getScene().getWindow();
		stage.hide();
		stage.setTitle("Nick Name");
		stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Login.fxml")),320,200));
		stage.show();
		UserData.setMode("client");
	}
}
