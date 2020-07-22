package view;

import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;

/**
 * Generuje alert screen, pouziva sa na oznamenia a vypisy na obrazovku
 * 
 * @author Martin Melisek
 *
 */
public class AlertScreen {
	/**
	 * Vyvori novy typ alert screenu so zakladom <i>Information</i>
	 * 
	 * @param header String - nadpis v alerte
	 * @param text   String, ktory vlozime do vygenerovanej textarey
	 * @see AdminScreen
	 */
	public void showTextArea(String header, String text) {
		Alert a = new Alert(AlertType.INFORMATION);
		a.setHeaderText(header);
		TextArea textArea = new TextArea(text);
		textArea.setPrefColumnCount(40);
		textArea.setPrefRowCount(20);
		textArea.setEditable(false);
		textArea.setWrapText(true);
		a.getDialogPane().setContent(textArea);
		a.showAndWait();
	}

	/**
	 * Vytvori novy <i>error</i> alert typ
	 * 
	 * @param msg String - sprava pre pouzivatela
	 * @see controller.StudentController#ucitSa(StudentScreen,
	 *      school_clients.Student, school_control.Head)
	 */
	public void showError(String msg) {
		Alert a = new Alert(AlertType.ERROR);
		a.setHeaderText(msg);
		a.showAndWait();
	}

	/**
	 * Vytvori novy <i> Information</i> alert typ
	 * 
	 * @param msg String - sprava pre pouzivatela
	 * @see controller.StudentController#ucitSa(StudentScreen,
	 *      school_clients.Student, school_control.Head)
	 */
	public void showSuccess(String msg) {
		Alert a = new Alert(AlertType.INFORMATION);
		a.setHeaderText(msg);
		a.showAndWait();
	}
}
