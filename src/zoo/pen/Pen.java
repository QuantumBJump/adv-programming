package zoo.pen;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import zoo.Main;
import zoo.animal.Animal;
import zoo.staff.Staff;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by quinns on 29/01/18.
 */
public abstract class Pen implements Serializable {
    public int id;
    public transient SimpleStringProperty viewableID;

    public ArrayList<Animal> occupants;
    public transient SimpleStringProperty viewableOccupants;

    public double length = 0;
    public double width = 0;
    public double freeArea = 0;
    public double freeVolume = 0;

    public PenType pentype;
    public transient SimpleStringProperty viewablePenType;

    public Staff keeper;
    public transient SimpleStringProperty viewableKeeper;

    public Pen (double length, double width, PenType pentype) {
        System.out.println(Main.zooControllerHandle);
        this.id = Main.zooControllerHandle.zoo.nextPenID;
        Main.zooControllerHandle.zoo.nextPenID++;
        this.length = length;
        this.width = width;
        this.freeArea = this.length * this.width;
        this.pentype = pentype;
        this.occupants = new ArrayList<>();
        this.setKeeper();
        this.updateViewableProperties();
    }

    public Pen (int id, double length, double width, PenType pentype) {
        this.id = id;
        this.length = length;
        this.width = width;
        this.freeArea = this.length * this.width;
        this.pentype = pentype;
        this.occupants = new ArrayList<>();
        this.setKeeper();
        this.updateViewableProperties();
    }

    public abstract boolean isValid(Animal animal);

    public abstract void addAnimal(Animal animal);

    public boolean staffCanManage(Staff staff) {
        if(staff.speciality.contains(this.pentype)) {
            return true;
        }
        return false;
    }

    public void setKeeper() {
        System.out.println(Main.zooControllerHandle);
        System.out.println(Main.zooControllerHandle.zoo.staff);
        for (Staff keeper: Main.zooControllerHandle.zoo.staff) {
            if (keeper.speciality.contains(this.pentype)) {
                this.keeper = keeper;
                this.viewableKeeper = this.keeper.viewableName;
                keeper.pens.add(this);
                keeper.updateViewableProperties();
                return;
            } else {
                continue;
            }
        }
    }

    public void updateViewableOccupants() {
        ArrayList<String> occupantList = new ArrayList<>();
        for (Animal occupant: this.occupants) {
            occupantList.add(occupant.animalNameProperty().getValue());
        }
        String occupantString = String.join(", ", occupantList);
        this.viewableOccupants = new SimpleStringProperty(occupantString);
    }

    public void updateViewableProperties() {
        this.viewableID = new SimpleStringProperty(String.valueOf(this.id));
        updateViewableOccupants();
        this.viewablePenType = new SimpleStringProperty(this.pentype.name());
        this.viewableKeeper = this.keeper.viewableName;
    }

    public StringProperty penViewableIDProperty() { return this.viewableID; }
    public StringProperty penViewablePenTypeProperty() { return this.viewablePenType; }
    public StringProperty penViewableKeeperProperty() { return this.viewableKeeper; }
    public StringProperty penViewableOccupantsProperty() { return this.viewableOccupants; }
}