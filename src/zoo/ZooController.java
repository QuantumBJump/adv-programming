package zoo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import zoo.animal.Animal;
import zoo.animal.Cat;
import zoo.pen.Pen;
import zoo.pen.PenType;
import zoo.staff.Staff;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ZooController {
    public int nextPenID;

    public TableView<Animal> animalTable;
    public TableColumn<Animal, String> animalName;
    public TableColumn<Animal, String> animalSpecies;

    public TableView<Staff> staffTable;
    public TableColumn<Staff, String> staffName;
    public TableColumn<Staff, String> staffSpeciality;

    public TableView<Pen> penTable;
    public TableColumn<Pen, String> penID;
    public TableColumn<Pen, String> penType;
    public TableColumn<Pen, String> penKeeper;
    public TableColumn<Pen, String> penOccupants;

    private ObservableList<Animal> animalObservableList = FXCollections.observableArrayList(
            new Cat("Tikha")
    );

    private ObservableList<Staff> staffObservableList = FXCollections.observableArrayList(
            new Staff("Hardip", PenType.DRY),
            new Staff("Farhad", PenType.AIR),
            new Staff("Alex", new ArrayList<>(Arrays.asList(PenType.WET, PenType.SEMIWET))),
            new Staff("Alan", PenType.PET)
    );

    private ObservableList<Pen> penObservableList = FXCollections.observableArrayList();

    public void initialize() {
        nextPenID = 0;

        // fill animal table.
        animalTable.setItems(animalObservableList);
        animalName.setCellValueFactory(cellData -> cellData.getValue().animalNameProperty());
        animalSpecies.setCellValueFactory(cellData -> cellData.getValue().animalSpeciesProperty());

        // fill staff table.
        staffTable.setItems(staffObservableList);
        staffName.setCellValueFactory(cellData -> cellData.getValue().staffNameProperty());
        staffSpeciality.setCellValueFactory(cellData -> cellData.getValue().staffSpecialityProperty());

        // fill pen table.
    }
    public void openAddAnimalDialog(ActionEvent actionEvent) {
        Stage addAnimalStage = new Stage();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("addAnimalView.fxml"));
            addAnimalStage.setScene(new Scene(root, 300, 275));
            addAnimalStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean animalExists(String name) {
        for (Animal animal: animalObservableList) {
            if(name.equals(animal.animalNameProperty().get())) {
                return true;
            }
        }
        return false;
    }

    public void addAnimal(Animal animal) {
        animalObservableList.add(animal);
    }

    public void openAddPenDialog(ActionEvent actionEvent) {
        Stage addPenStage = new Stage();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("addPenView.fxml"));
            addPenStage.setScene(new Scene(root, 600, 275));
            addPenStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
