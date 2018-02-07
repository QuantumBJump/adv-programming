package zoo;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.*;
import javafx.stage.Stage;
import zoo.pen.*;

import java.util.ArrayList;

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
    public Button confirmAddPenButton;
    private ArrayList<TextField> textFieldsArrayList;

    public void initialize() {
        textFieldsArrayList = new ArrayList<>();
        textFieldsArrayList.add(lengthTextField);
        textFieldsArrayList.add(widthTextField);
        textFieldsArrayList.add(heightTextField);
        textFieldsArrayList.add(dryLengthTextField);
        textFieldsArrayList.add(dryWidthTextField);

    }

    public void confirmAddPen() {

        for (TextField field: textFieldsArrayList) {
            if (!field.isDisabled()) {
                if (field.getText() == null || field.getText().isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Please fill in all dimensions.");
                    alert.setContentText("Every pen must have\nA valid set of lengths\nTo exist in space.");
                    alert.showAndWait();
                    return;
                }
            }
        }
        zoo.pen.Pen pen;
        if (dryTypeRadioButton.isSelected()) {
            int length = Integer.parseInt(lengthTextField.getText());
            int width = Integer.parseInt(widthTextField.getText());
            pen = new DryPen(length, width);
        } else if (semiwetTypeRadioButton.isSelected()) {
            int length = Integer.parseInt(lengthTextField.getText());
            int width = Integer.parseInt(widthTextField.getText());
            int height = Integer.parseInt(heightTextField.getText());
            int dryLength = Integer.parseInt(dryLengthTextField.getText());
            int dryWidth = Integer.parseInt(dryWidthTextField.getText());
            pen = new SemiwetPen(dryLength, dryWidth, length, width, height);
        } else if (wetTypeRadioButton.isSelected()) {
            int length = Integer.parseInt(lengthTextField.getText());
            int width = Integer.parseInt(widthTextField.getText());
            int height = Integer.parseInt(heightTextField.getText());
            pen = new WetPen(length, width, height);
        } else if (airTypeRadioButton.isSelected()) {
            int length = Integer.parseInt(lengthTextField.getText());
            int width = Integer.parseInt(widthTextField.getText());
            int height = Integer.parseInt(heightTextField.getText());
            pen = new AirPen(length, width, height);
        } else if (petTypeRadioButton.isSelected()) {
            int length = Integer.parseInt(lengthTextField.getText());
            int width = Integer.parseInt(widthTextField.getText());
            pen = new PetPen(length, width);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No Type Selected");
            alert.setHeaderText(null);
            alert.setContentText("This pen has no type.\nFor animals to live there\nYou must give it one.");
            alert.showAndWait();
            return;
        }

        if (pen != null) {
            Main.zooControllerHandle.addPen(pen);
            Stage stage = (Stage)confirmAddPenButton.getScene().getWindow();
            stage.close();
        }

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
