package zoo.animal;

import javafx.beans.property.SimpleStringProperty;
import zoo.pen.PenType;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by quinns on 29/01/18.
 */
public class Penguin extends Animal implements Serializable {
    public Penguin (String name) {
        super(name);
        this.requiredPenType = new ArrayList<>();
        this.requiredPenType.add(PenType.SEMIWET);
        this.requiredArea = 2;
        this.requiredVolume = 4;
        this.setViewableRequiredSpace();
    }
}
