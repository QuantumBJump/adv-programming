package zoo.animal;

import javafx.beans.property.SimpleStringProperty;
import zoo.pen.PenType;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by quinns on 29/01/18.
 */
public class Goat extends Animal implements Serializable {
    public Goat (String name) {
        super(name);
        this.requiredPenType = new ArrayList<>();
        this.requiredPenType.add(PenType.DRY);
        this.requiredPenType.add(PenType.PET);
        this.requiredArea = 3;
        this.setViewableRequiredSpace();
    }
}
