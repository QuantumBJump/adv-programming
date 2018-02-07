package zoo.animal;

import javafx.beans.property.SimpleStringProperty;
import zoo.pen.PenType;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by quinns on 30/01/18.
 */
public class Owl extends Animal implements Serializable {
    public Owl(String name) {
        super(name);
        this.requiredPenType = new ArrayList<>();
        this.requiredPenType.add(PenType.AIR);
        this.requiredVolume = 20;
        this.setViewableRequiredSpace();
    }
}
