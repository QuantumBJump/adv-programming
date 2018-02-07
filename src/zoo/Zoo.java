package zoo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import zoo.animal.Animal;
import zoo.pen.Pen;
import zoo.pen.PenType;
import zoo.staff.Staff;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by quinns on 07/02/18.
 */
public class Zoo implements Serializable {
    static final long serialVersionUID = 0451;
    public ArrayList<Staff> staff;
    public ArrayList<Animal> animals;
    public ArrayList<Pen> pens;
    public int nextPenID;

    public Zoo() {
        this.nextPenID = 0;
        this.staff = new ArrayList<>();
        //populate staff table
        this.addStaff(new Staff("Hardip", PenType.DRY));
        this.addStaff(new Staff("Farhad", PenType.AIR));
        this.addStaff(new Staff("Alex", new ArrayList<>(Arrays.asList(PenType.WET, PenType.SEMIWET))));
        this.addStaff(new Staff("Alan", PenType.PET));
        this.animals = new ArrayList<>();
        this.pens = new ArrayList<>();
    }

    public void populateObservables() {
        for (Animal animal: this.animals) {
            animal.updateViewableProperties();
        }
        for (Staff staff: this.staff) {
            staff.updateViewableProperties();
        }
        for (Pen pen: this.pens) {
            pen.updateViewableProperties();
        }
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
