package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.DateControl;
import view.IOHandler;
import view.Main;

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

	}

	@FXML
	void startBtnAction(ActionEvent event) {
		this.dateOrig.setText(head.firstRunTotalTime());
		head.startSession();
	}

	@FXML
	void stopBtnAction(ActionEvent event) {
		head.stopSession();
		this.total.setText("TOTAL: " + head.millisToTime(head.getTotalHoursPlayed()));
		this.sessionLabel.setText("THIS SESSION: " + head.millisToTime(head.getSessionTime()));
	}

	@FXML
	void initialize() {
		io.clearContent();
		
		Main.getWindow().setOnCloseRequest(e -> {
			io.saveObj(head);
		});

		this.head = this.io.initialize();
		this.total.setText("TOTAL: " + head.getTotalHoursPlayed() + " hours");
		this.dateOrig.setText("od " + head.getTotalTime());

	}
}
