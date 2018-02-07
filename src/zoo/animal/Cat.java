package zoo.animal;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import zoo.pen.PenType;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by quinns on 30/01/18.
 */
public class Cat extends Animal implements Serializable{
    public Cat(String name) {
        super(name);
        this.requiredPenType = new ArrayList<>();
        this.requiredPenType.add(PenType.DRY);
        this.requiredPenType.add(PenType.PET);
        this.requiredArea = 4;
        this.setViewableRequiredSpace();
    }
}
