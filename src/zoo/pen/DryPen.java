package zoo.pen;

import zoo.Main;
import zoo.animal.Animal;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by quinns on 30/01/18.
 */
public class DryPen extends Pen implements Serializable{
    static final long serialVersionUID = 463;
    public DryPen(double length, double width) {
        super(length, width, PenType.DRY);
    }


    public boolean isValid(Animal animal) {
        if(animal.requiredPenType.contains(PenType.DRY) && animal.requiredArea <= this.freeArea) {
            return true;
        }
        return false;
    }

    public void addAnimal(Animal animal) {
        if(this.isValid(animal)) {
            this.occupants.add(animal);
            this.updateViewableOccupants();
            this.freeArea -= animal.requiredArea;
            animal.pen = this;
            animal.keeper = this.keeper;
            animal.updateViewableProperties();
        }
    }
}
