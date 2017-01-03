package View;

import Model.UserData;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class Main extends Application
{

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		Parent root = FXMLLoader.load(getClass().getResource("ModeSelect.fxml"));
		primaryStage.setTitle("ModeSelect");
		primaryStage.setScene(new Scene(root, 300, 200));
		primaryStage.setResizable(false);
		primaryStage.show();

		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>()
		{
			@Override
			public void handle(WindowEvent event)
			{
				if(UserData.getMode().equals("client"))
				{
					try
					{
						Model.Client.exitMessage();
					} catch (IOException e)
					{
						e.printStackTrace();
					}
				}
				System.exit(3333);
			}
		});
	}


	public static void main(String[] args)
	{
		launch(args);
	}
}
