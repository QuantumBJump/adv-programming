package zoo.pen;

import zoo.animal.Animal;

/**
 * Created by quinns on 29/01/18.
 */
public class Aquarium extends Pen {
    public double height;

    public Aquarium(String name, double length, double width, double height) {
        this.name = name;
        this.length = length;
        this.width = width;
        this.height = height;
        this.freeArea = 0;
        this.freeVolume = this.length * this.width * this.height;
    }

    public boolean isValid(Animal animal) {
        if(animal.requiredPenType == PenType.WET && animal.requiredVolume < this.freeVolume) {
            return true;
        } else {
            return false;
        }
    }

    public void addAnimal(Animal animal) {
        if (isValid(animal)) {
            this.occupants.add(animal);
            this.freeVolume -= animal.requiredVolume;
        }
    }
}
