package zoo.pen;

import zoo.animal.Animal;

/**
 * Created by quinns on 29/01/18.
 */
public class WetPen extends Pen {
    public double height;

    public WetPen(double length, double width, double height) {
        super(length, width, PenType.WET);
        this.height = height;
        this.freeArea = 0;
        this.freeVolume = this.length * this.width * this.height;
    }

    public boolean isValid(Animal animal) {
        if(animal.requiredPenType.contains(this.pentype) && animal.requiredVolume < this.freeVolume) {
            return true;
        } else {
            return false;
        }
    }

    public void addAnimal(Animal animal) {
        if (isValid(animal)) {
            this.occupants.add(animal);
            this.updateViewableOccupants();
            this.freeVolume -= animal.requiredVolume;
            animal.pen = this.viewableID;
            animal.viewableKeeper = this.viewableKeeper;
        }
    }
}
