package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.DateControl;
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
	private Label dateTwoWeeks;

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
		this.head.checkToTwoWeekSum();
		this.dateTwoWeeks.setText(head.getTwoWeeks());
		if(head.getTotalHoursPlayed() != 0)
			this.hrsCurr.setText(head.millisToTime(head.calcTwoWeekSum()));

	}

	@FXML
	void startBtnAction(ActionEvent event) {
		this.dateOrig.setText(head.firstRunTotalTime());
		head.startSession();
		this.setPlayingStateLabels();
	}

	@FXML
	void stopBtnAction(ActionEvent event) {
		if (head.isSessionStarted()) {
			head.stopSession();
			this.total.setText("TOTAL: " + head.millisToTime(head.getTotalHoursPlayed()));
			this.sessionLabel.setText("THIS SESSION: " + head.millisToTime(head.getSessionTime()));
			this.setPlayingStateLabels();
			this.hrsCurr.setText(head.millisToTime(head.calcTwoWeekSum()));
		} else
			head.setSessionTime(0);
	}

	@FXML
	void initialize() {
		io.clearContent();

		Main.getWindow().setOnCloseRequest(e -> {
			io.saveObj(head);
		});
		this.head = this.io.initialize();
		this.head.checkToTwoWeekSum();
		this.setPlayingStateLabels();
		this.dateOrig.setText(head.getTotalTime());
		this.dateTwoWeeks.setText(head.getTwoWeeks());
	}

	public void setPlayingStateLabels() {
		try {
			if (head.isSessionStarted()) {
				this.playingLabel.setVisible(true);
				this.notPlayingLabel.setVisible(false);
				this.startBtn.setVisible(false);
				this.stopBtn.setVisible(true);
			} else {
				this.playingLabel.setVisible(false);
				this.notPlayingLabel.setVisible(true);
				this.startBtn.setVisible(true);
				this.stopBtn.setVisible(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Set playing state Error");
		}

	}
}
