module HoursPlayed {
	requires transitive javafx.base;
	requires transitive javafx.controls;
	requires transitive javafx.fxml;
	requires transitive javafx.graphics;
	requires transitive javafx.media;
	requires transitive javafx.swing;
	requires transitive javafx.swt;
	requires transitive javafx.web;
	exports view;
	exports controller;
	opens view;
	opens controller;
}