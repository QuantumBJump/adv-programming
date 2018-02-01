package zoo.pen;

import zoo.animal.Animal;

/**
 * Created by quinns on 30/01/18.
 */
public class SemiwetPen extends Pen {
    public double dryLength;
    public double dryWidth;
    public double height;

    public SemiwetPen(double dryLength, double dryWidth, double length, double width, double height) {
        super(length, width, PenType.SEMIWET);
        this.dryLength = dryLength;
        this.dryWidth = dryWidth;
        this.freeArea = this.dryLength * this.dryWidth;
        this.height = height;
        this.freeVolume = this.length * this.width * this.height;
    }

    public boolean isValid(Animal animal) {
        if (animal.requiredPenType.contains(this.pentype) && animal.requiredArea <= this.freeArea && animal.requiredVolume <= this.freeVolume) {
            return true;
        }
        return false;
    }

    public void addAnimal(Animal animal) {
        if (this.isValid(animal)) {
            this.occupants.add(animal);
            this.freeArea -= animal.requiredArea;
            this.freeVolume -= animal.requiredVolume;
            animal.pen = this.viewableID;
        }
    }
}
