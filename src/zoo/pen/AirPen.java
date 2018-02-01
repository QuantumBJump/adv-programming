package zoo.pen;

import javafx.beans.property.SimpleStringProperty;
import zoo.animal.Animal;

import java.util.ArrayList;

/**
 * Created by quinns on 30/01/18.
 */
public class AirPen extends Pen {
    public double height;

    public AirPen(String name, double length, double width, double height) {
        super(length, width, PenType.AIR);
        this.height = height;
        this.freeVolume = this.length * this.width * this.height;
    }

    public boolean isValid(Animal animal) {
        if (animal.requiredPenType.contains(this.pentype) && animal.requiredVolume <= this.freeVolume) {
            return true;
        }
        return false;
    }

    public void addAnimal(Animal animal) {
        if (this.isValid(animal)) {
            this.occupants.add(animal);
            this.freeVolume -= animal.requiredVolume;
            animal.pen = this.viewableID;
        }
    }
}
