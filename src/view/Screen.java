package view;

import javafx.fxml.FXMLLoader;

public abstract class Screen {
	FXMLLoader loader;

	Screen(String location) {
		this.loader = new FXMLLoader();
		loader.setLocation(getClass().getResource(location));
	}
}
