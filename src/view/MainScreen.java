package view;

import java.io.IOException;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class MainScreen extends Screen {
	MainScreen() {
		super("/view/fxml/MainScreenScene.fxml");
	}

	public Scene show() {
		VBox root = null;
		try {
			root = this.loader.load();
		} catch (IOException e) {
			System.err.println("MAINSCREEN ERROR SHOW");
			//e.printStackTrace();
		}
		return new Scene(root);
	}
}
