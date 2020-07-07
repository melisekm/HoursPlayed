package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.DateControl;
import view.IOHandler;

public class MainController extends Controller {
	DateControl head;
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button startBtn;

	@FXML
	private Button stopBtn;

	@FXML
	private Label playingLabel;

	@FXML
	private Label notPlayingLabel;

	@FXML
	private Label date;

	@FXML
	private Label total;

	@FXML
	private Label dateOrig;

	@FXML
	private Label hrsCurr;

	@FXML
	private Label sessionLabel;

	@FXML
	private Button refreshBtn;

	@FXML
	void refreshAction(ActionEvent event) {
		this.total.setText("TOTAL: " + head.totalF + " hours");
	}

	@FXML
	void startBtnAction(ActionEvent event) {

	}

	@FXML
	void stopBtnAction(ActionEvent event) {

	}

	@FXML
	void initialize() {
		this.head = this.io.initialize();
		this.total.setText("TOTAL: " + head.getTotalHoursPlayed() + " hours");
		this.dateOrig.setText("od " + head.getTotalTime());

	}
}
