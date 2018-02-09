package zoo.animal;

import javafx.beans.property.SimpleStringProperty;
import zoo.pen.PenType;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by quinns on 30/01/18.
 */
public class Dolphin extends Animal implements Serializable {
    static final long serialVersionUID = 455;
    public Dolphin(String name) {
        super(name);
        this.requiredPenType = new ArrayList<>();
        this.requiredPenType.add(PenType.WET);
        this.requiredVolume = 40;
        this.setViewableRequiredSpace();
    }
}
