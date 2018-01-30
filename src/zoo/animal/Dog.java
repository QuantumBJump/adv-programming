package zoo.animal;

import zoo.pen.PenType;

import java.util.ArrayList;

/**
 * Created by quinns on 30/01/18.
 */
public class Dog extends Animal {
    public Dog(String name) {
        this.name = name;
        this.requiredPenType = new ArrayList<>();
        this.requiredPenType.add(PenType.DRY);
        this.requiredPenType.add(PenType.PET);
        this.requiredArea = 3.5;
    }
}
