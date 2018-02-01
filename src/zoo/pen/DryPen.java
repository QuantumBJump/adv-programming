package zoo.pen;

import zoo.animal.Animal;

import java.util.ArrayList;

/**
 * Created by quinns on 30/01/18.
 */
public class DryPen extends Pen {

    public DryPen(String name, double length, double width) {
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
            this.freeArea -= animal.requiredArea;
            animal.pen = this.viewableID;
        }
    }
}
