package zoo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import zoo.animal.Animal;

import java.lang.reflect.*;

/**
 * Created by quinns on 31/01/18.
 */
public class AddAnimalController {

    ObservableList<String> speciesObservableList = FXCollections.observableArrayList(
            "Cat", "Dog", "Dolphin", "Goat", "Hippo", "Owl", "Penguin", "Sloth"
    );
    public ComboBox speciesComboBox;
    public TextField nameTextField;
    public Button confirmAddAnimalButton;

    public void initialize() {
        speciesComboBox.getItems().addAll(speciesObservableList);
    }

    public void confirmAddAnimal() {
        // check if species is filled in.
        if (speciesComboBox.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No species selected");
            alert.setContentText("Species is required\nfor without a species\nwhat even are we?");
            alert.showAndWait();
            return;
        }
        // check if name is filled in.
        if (nameTextField.getText() == null || nameTextField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No name given");
            alert.setContentText("Can an animal\nbe really truly famous \nhaving not a name?");
            alert.showAndWait();
            return;
        }
        // populate params to use
        String animalSpecies = speciesComboBox.getValue().toString();
        String animalName = nameTextField.getText();
        Animal animal = generateAnimal(animalName, animalSpecies);
        System.out.println("Animal exists: " + Main.zooControllerHandle.animalExists(animal.animalNameProperty().get()));

        if (animal != null && !Main.zooControllerHandle.animalExists(animal.animalNameProperty().get())) {
            Main.zooControllerHandle.addAnimal(animal);
            Stage stage = (Stage)confirmAddAnimalButton.getScene().getWindow();
            stage.close();
        } else if (Main.zooControllerHandle.animalExists(animal.animalNameProperty().get())) {
            System.out.println("repeated name");
            // there's already an animal with this name. Error message?
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Repeated Name");
            alert.setHeaderText(null);
            alert.setContentText("Sorry, you can't have \nmany famous animals \nwith a single name.");
            alert.showAndWait();
        }

    }
    private Animal generateAnimal(String name, String species) {
        String nameParam = name;
        String className = "zoo.animal." + species;
        Class cl = null;
        try {
            cl = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Constructor con = null;
        try {
            con = cl.getConstructor(String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            Object animal = con.newInstance(nameParam);
            return (Animal)animal;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }


}
