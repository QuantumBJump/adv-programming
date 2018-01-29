package zoo.animal;

import zoo.pen.PenType;

/**
 * Created by quinns on 29/01/18.
 */
public class Sloth extends Animal {

    public Sloth(String name) {
        this.name = name;
        this.requiredPenType = PenType.DRY;
        this.requiredArea = 3;
        this.requiredVolume = 0;
    }
}
