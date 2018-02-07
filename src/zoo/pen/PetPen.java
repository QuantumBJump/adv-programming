package zoo.pen;

import javafx.beans.property.SimpleStringProperty;
import zoo.animal.Animal;

import java.io.Serializable;

/**
 * Created by quinns on 30/01/18.
 */
public class PetPen extends Pen implements Serializable {

    public PetPen(double length, double width) {
        super(length, width, PenType.PET);
    }

    public boolean isValid(Animal animal) {
        if (animal.requiredPenType.contains(this.pentype) && animal.requiredArea < this.freeArea) {
            return true;
        }
        return false;
    }

    public void addAnimal(Animal animal) {
        if (this.isValid(animal)) {
            this.occupants.add(animal);
            this.updateViewableOccupants();
            this.freeArea -= animal.requiredArea;
            animal.pen = this;
            animal.keeper = this.keeper;
            animal.updateViewableProperties();
        }
    }
}
