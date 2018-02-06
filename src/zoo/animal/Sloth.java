package zoo.animal;

import javafx.beans.property.SimpleStringProperty;
import zoo.pen.PenType;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by quinns on 29/01/18.
 */
public class Sloth extends Animal implements Serializable {

    public Sloth(String name) {
        super(name);
        this.requiredPenType = new ArrayList<>();
        this.requiredPenType.add(PenType.DRY);
        this.requiredArea = 3;
        this.requiredVolume = 0;
        this.viewableRequiredSpace = new SimpleStringProperty("3m squared");
    }
}
