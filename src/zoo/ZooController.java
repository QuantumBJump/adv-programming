package zoo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
    public Zoo zoo;

    public TableView<Animal> animalTable;
    public TableColumn<Animal, String> animalName;
    public TableColumn<Animal, String> animalSpecies;
    public TableColumn<Animal, String> animalPen;
    public TableColumn<Animal, String> animalKeeper;
    public TableColumn<Animal, String> animalRequiredSpace;

    public TableView<Staff> staffTable;
    public TableColumn<Staff, String> staffName;
    public TableColumn<Staff, String> staffSpeciality;
    public TableColumn<Staff, String> staffPens;

    public TableView<Pen> penTable;
    public TableColumn<Pen, String> penID;
    public TableColumn<Pen, String> penType;
    public TableColumn<Pen, String> penKeeper;
    public TableColumn<Pen, String> penOccupants;

    public Label weatherLabel;

    public ObservableList<Animal> animalObservableList = FXCollections.observableArrayList();

    public ObservableList<Staff> staffObservableList = FXCollections.observableArrayList();

    public ObservableList<Pen> penObservableList = FXCollections.observableArrayList();

    public void initialize() {

        // Get weather from openweathermap
        WeatherReporter weatherReporter = new WeatherReporter();
        try {
            weatherLabel.setText(weatherReporter.getWeather());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Load saved data from .ser file if one exists, otherwise open empty client.
        FileReader fr = new FileReader();
        this.zoo = fr.loadData();
        if (this.zoo != null) {
            this.zoo.populateObservables();
        } else {
            this.zoo = new Zoo();
        }
        updateObservableLists();

        // fill animal table.
        animalTable.setItems(animalObservableList);
        animalName.setCellValueFactory(cellData -> cellData.getValue().animalNameProperty());
        animalSpecies.setCellValueFactory(cellData -> cellData.getValue().animalSpeciesProperty());
        animalPen.setCellValueFactory(cellData -> cellData.getValue().animalPenProperty());
        animalKeeper.setCellValueFactory(cellData -> cellData.getValue().animalKeeperProperty());
        animalRequiredSpace.setCellValueFactory(cellData -> cellData.getValue().animalRequiredSpaceProperty());

        // fill staff table.
        staffTable.setItems(staffObservableList);
        staffName.setCellValueFactory(cellData -> cellData.getValue().staffNameProperty());
        staffSpeciality.setCellValueFactory(cellData -> cellData.getValue().staffSpecialityProperty());
        staffPens.setCellValueFactory(cellData -> cellData.getValue().staffViewablePensProperty());

        // fill pen table.

        penTable.setItems(penObservableList);
        penID.setCellValueFactory(cellData -> cellData.getValue().penViewableIDProperty());
        penType.setCellValueFactory(cellData -> cellData.getValue().penViewablePenTypeProperty());
        penKeeper.setCellValueFactory(cellData -> cellData.getValue().penViewableKeeperProperty());
        penOccupants.setCellValueFactory(cellData -> cellData.getValue().penViewableOccupantsProperty());
    }

    public void updateObservableLists() {
        staffObservableList.clear();
        staffObservableList.addAll(zoo.getStaffObservableList());
        animalObservableList.clear();
        animalObservableList.addAll(zoo.getAnimalObservableList());
        penObservableList.clear();
        penObservableList.addAll(zoo.getPenObservableList());
        penTable.refresh();
        staffTable.refresh();
        animalTable.refresh();
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
        for (Animal animal: zoo.animals) {
            if(name.equals(animal.animalNameProperty().get())) {
                return true;
            }
        }
        return false;
    }

    public void addAnimal(Animal animal) {
        zoo.addAnimal(animal);
        updateObservableLists();
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

    public void addPen(Pen pen) {
        this.zoo.addPen(pen);
        this.updateObservableLists();
        penTable.refresh();
        staffTable.refresh();
    }

    public void saveData() {
        FileReader fileReader = new FileReader();
        fileReader.saveData(this.zoo);
    }
}
