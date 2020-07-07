package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.DateControl;
import model.ProcessHook;
import view.Main;

public class MainController extends Controller {
	private DateControl head;
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
		if (head.getTotalHoursPlayed() != 0)
			this.hrsCurr.setText(head.millisToTime(head.calcTwoWeekSum()));

	}

	@FXML
	void startBtnAction(ActionEvent event) {
		this.onStartBtnClick();
	}

	public void onStartBtnClick() {
		this.dateOrig.setText(head.firstRunTotalTime());
		this.head.startSession();
		this.setPlayingStateLabels();
	}

	public void onStopBtnClick() {
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
	void stopBtnAction(ActionEvent event) {
		this.onStopBtnClick();
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
		
		
		TimerTask task = new TimerTask() {
			public boolean isProcessRunning(String process) {
				String line;
				String pidInfo = "";
				Process p;
				
				try {
					p = Runtime.getRuntime().exec(System.getenv("windir") + "\\system32\\" + "tasklist.exe");

					BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));

					while ((line = input.readLine()) != null) {
						pidInfo += line;
					}

					input.close();
				} catch (IOException e) {
					System.out.println("CHYBA PRI OTVARANI TASKLIST.EXE");
					e.printStackTrace();
				}
				if (pidInfo.contains(process)) {
					System.out.println("DOGDGG");
					return true;
				}
				return false;
			}

		    @Override
		    public void run() {
		        if(this.isProcessRunning("mspaint.exe"));
		        	System.out.println("Dog");
		    }
		};

		Timer timer = new Timer();
		timer.schedule(task, new Date(), 3000);
		
		
		//Platform.runLater(new Runnable(){

			//@Override
			//public void run() {
				/*Runnable processCheck = new Runnable() {
					public void run() {
						if (new ProcessHook().isProcessRunning("notepad.exe")) {
							System.out.println("Dog");
							onStartBtnClick();
		
						}else {
							onStartBtnClick();
						}
					} 
				};
				ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
				executor.scheduleAtFixedRate(processCheck, 0, 3, TimeUnit.SECONDS);
			*/
				
			//}
			
		//});

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
