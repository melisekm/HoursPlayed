package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController {
	IOHandler io = new IOHandler();
	DateControl head = io.initialize();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;;

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
    	this.total.setText("TOTAL: " + head.totalHrs + " hours");
    }

    @FXML
    void startBtnAction(ActionEvent event) {

    }

    @FXML
    void stopBtnAction(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert startBtn != null : "fx:id=\"startBtn\" was not injected: check your FXML file 'Scene.fxml'.";
        assert stopBtn != null : "fx:id=\"stopBtn\" was not injected: check your FXML file 'Scene.fxml'.";
        assert playingLabel != null : "fx:id=\"playingLabel\" was not injected: check your FXML file 'Scene.fxml'.";
        assert notPlayingLabel != null : "fx:id=\"notPlayingLabel\" was not injected: check your FXML file 'Scene.fxml'.";
        assert date != null : "fx:id=\"date\" was not injected: check your FXML file 'Scene.fxml'.";
        assert total != null : "fx:id=\"total\" was not injected: check your FXML file 'Scene.fxml'.";
        assert dateOrig != null : "fx:id=\"dateOrig\" was not injected: check your FXML file 'Scene.fxml'.";
        assert hrsCurr != null : "fx:id=\"hrsCurr\" was not injected: check your FXML file 'Scene.fxml'.";
        assert sessionLabel != null : "fx:id=\"sessionLabel\" was not injected: check your FXML file 'Scene.fxml'.";
        assert refreshBtn != null : "fx:id=\"refreshBtn\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
