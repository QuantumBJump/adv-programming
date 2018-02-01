package zoo.pen;

import javafx.beans.property.SimpleStringProperty;
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
    public double length = 0;
    public double width = 0;
    public double freeArea = 0;
    public double freeVolume = 0;
    public PenType pentype;
    public Staff manager;

    public Pen (double length, double width, PenType pentype) {
        this.id = Main.zooControllerHandle.nextPenID;
        Main.zooControllerHandle.nextPenID++;
        this.viewableID = new SimpleStringProperty(Integer.toString(this.id));
        this.length = length;
        this.width = width;
        this.freeArea = this.length * this.width;
        this.pentype = pentype;
        this.occupants = new ArrayList<>();
    }

    abstract boolean isValid(Animal animal);

    abstract void addAnimal(Animal animal);

    public boolean staffCanManage(Staff staff) {
        if(staff.specialityEnum.contains(this.pentype)) {
            return true;
        }
        return false;
    }

    public void setStaff(Staff staff) {
        if(this.staffCanManage(staff)) {
            this.manager = staff;
            staff.pens.add(this);
        }
    }
}