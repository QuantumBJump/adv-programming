package zoo.animal;

import javafx.beans.property.SimpleStringProperty;
import zoo.pen.PenType;

import java.util.ArrayList;

/**
 * Created by quinns on 30/01/18.
 */
public class Dog extends Animal {
    public Dog(String name) {
        super(name);
        this.requiredPenType = new ArrayList<>();
        this.requiredPenType.add(PenType.DRY);
        this.requiredPenType.add(PenType.PET);
        this.requiredArea = 3.5;
        this.setViewableRequiredSpace();
    }
}
