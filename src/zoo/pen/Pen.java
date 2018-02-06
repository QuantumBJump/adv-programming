package zoo.pen;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import zoo.Main;
import zoo.animal.Animal;
import zoo.staff.Staff;

import java.util.ArrayList;

/**
 * Created by quinns on 29/01/18.
 */
public abstract class Pen {
    public int id;
    public SimpleStringProperty viewableID;
    public ArrayList<Animal> occupants;
    public SimpleStringProperty viewableOccupants;
    public double length = 0;
    public double width = 0;
    public double freeArea = 0;
    public double freeVolume = 0;
    public PenType pentype;
    public SimpleStringProperty viewablePenType;
    public SimpleStringProperty viewableKeeper;
    public Staff keeper;

    public Pen (double length, double width, PenType pentype) {
        this.id = Main.zooControllerHandle.nextPenID;
        Main.zooControllerHandle.nextPenID++;
        this.viewableID = new SimpleStringProperty(Integer.toString(this.id));
        this.length = length;
        this.width = width;
        this.freeArea = this.length * this.width;
        this.pentype = pentype;
        this.viewablePenType = new SimpleStringProperty(this.pentype.name());
        this.occupants = new ArrayList<>();
        this.setKeeper();
    }

    public abstract boolean isValid(Animal animal);

    public abstract void addAnimal(Animal animal);

    public boolean staffCanManage(Staff staff) {
        if(staff.specialityEnum.contains(this.pentype)) {
            return true;
        }
        return false;
    }

    public void setKeeper() {
        for (Staff keeper: Main.zooControllerHandle.staffObservableList) {
            if (keeper.specialityEnum.contains(this.pentype)) {
                this.keeper = keeper;
                System.out.println("Keeper: " + keeper.name.getValue());
                this.viewableKeeper = new SimpleStringProperty(keeper.name.getValue());
                System.out.println(this);
                System.out.println(keeper.pens);
                keeper.pens.add(this);
                System.out.println("Keeper.pens:" + keeper.pens);
                keeper.updateViewablePens();
                System.out.println(keeper.viewablePens.getValue());
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

    public StringProperty penViewableIDProperty() { return this.viewableID; }
    public StringProperty penViewablePenTypeProperty() { return this.viewablePenType; }
    public StringProperty penViewableKeeperProperty() { return this.viewableKeeper; }
    public StringProperty penViewableOccupantsProperty() { return this.viewableOccupants; }
}