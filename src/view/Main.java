package view;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Main extends Application {
	public static Scene MainStage;

	@Override
	public void start(Stage primaryStage) {
		MainScreen mainScreen = new MainScreen();
		MainStage = mainScreen.show();
		primaryStage.setScene(MainStage);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
