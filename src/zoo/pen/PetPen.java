package zoo.pen;

import zoo.animal.Animal;

/**
 * Created by quinns on 30/01/18.
 */
public class PetPen extends Pen {

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
            animal.pen = this.viewableID;
            animal.viewableKeeper = this.viewableKeeper;
        }
    }
}
