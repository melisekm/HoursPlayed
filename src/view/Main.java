package view;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Main extends Application {
	private static Stage window;
	public static Scene MainStage;


	@Override
	public void start(Stage primaryStage) {
		MainScreen mainScreen = new MainScreen();
		setWindow(primaryStage);
		MainStage = mainScreen.show();
		getWindow().setScene(MainStage);
		getWindow().setTitle("Hours Played");
		getWindow().show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}

	public static Stage getWindow() {
		return window;
	}

	public static void setWindow(Stage window) {
		Main.window = window;
	}
	
	
}
