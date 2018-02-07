package zoo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import zoo.animal.Animal;
import zoo.pen.Pen;
import zoo.staff.Staff;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by quinns on 07/02/18.
 */
public class Zoo implements Serializable {
    public ArrayList<Staff> staff;
    public ArrayList<Animal> animals;
    public ArrayList<Pen> pens;

    public Zoo() {
        this.staff = new ArrayList<>();
        this.animals = new ArrayList<>();
        this.pens = new ArrayList<>();
    }

    public void addStaff(Staff staff) {
        this.staff.add(staff);
    }

    public void addAnimal(Animal animal) {
        this.animals.add(animal);
    }

    public void addPen(Pen pen) {
        this.pens.add(pen);
    }

    public ObservableList<Staff> getStaffObservableList() {
        return FXCollections.observableArrayList(this.staff);
    }

    public ObservableList<Animal> getAnimalObservableList() {
        return FXCollections.observableArrayList(this.animals);
    }

    public ObservableList<Pen> getPenObservableList() {
        return FXCollections.observableArrayList(this.pens);
    }
}
