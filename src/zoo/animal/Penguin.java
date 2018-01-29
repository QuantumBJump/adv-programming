package zoo.animal;

import zoo.pen.PenType;

/**
 * Created by quinns on 29/01/18.
 */
public class Penguin extends Animal {
    public Penguin (String name) {
        this.name = name;
        this.requiredPenType = PenType.SEMIWET;
        this.requiredArea = 2;
        this.requiredVolume = 4;
    }
}
