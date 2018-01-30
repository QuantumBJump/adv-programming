package zoo.animal;

import zoo.pen.PenType;

import java.util.ArrayList;

/**
 * Created by quinns on 30/01/18.
 */
public class Owl extends Animal {
    public Owl(String name) {
        this.name = name;
        this.requiredPenType = new ArrayList<>();
        this.requiredPenType.add(PenType.AIR);
        this.requiredVolume = 20;
    }
}
