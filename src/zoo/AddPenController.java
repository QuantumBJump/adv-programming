package zoo;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

/**
 * Created by quinns on 01/02/18.
 */
public class AddPenController {

    public ToggleGroup typeToggleGroup;
    public RadioButton dryTypeRadioButton;
    public RadioButton wetTypeRadioButton;
    public RadioButton semiwetTypeRadioButton;
    public RadioButton airTypeRadioButton;
    public RadioButton petTypeRadioButton;
    public TextField lengthTextField;
    public TextField widthTextField;
    public TextField heightTextField;
    public TextField dryLengthTextField;
    public TextField dryWidthTextField;

    public void initialize() {

    }

    public void typeSetDry() {
        heightTextField.setDisable(true);
        heightTextField.setText("");
        dryLengthTextField.setDisable(true);
        dryLengthTextField.setText("");
        dryWidthTextField.setDisable(true);
        dryWidthTextField.setText("");
    }
    public void typeSetSemiwet() {
        heightTextField.setDisable(false);
        dryLengthTextField.setDisable(false);
        dryWidthTextField.setDisable(false);
    }
    public void typeSetWet() {
        heightTextField.setDisable(false);
        dryLengthTextField.setDisable(true);
        dryLengthTextField.setText("");
        dryWidthTextField.setDisable(true);
        dryWidthTextField.setText("");
    }
    public void typeSetAir() {
        heightTextField.setDisable(false);
        dryLengthTextField.setDisable(true);
        dryLengthTextField.setText("");
        dryWidthTextField.setDisable(true);
        dryWidthTextField.setText("");
    }
    public void typeSetPet() {
        heightTextField.setDisable(true);
        heightTextField.setText("");
        dryLengthTextField.setDisable(true);
        dryLengthTextField.setText("");
        dryWidthTextField.setDisable(true);
        dryWidthTextField.setText("");
    }
}
