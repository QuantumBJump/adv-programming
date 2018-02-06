package zoo.animal;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import zoo.Main;
import zoo.pen.Pen;
import zoo.pen.PenType;

import java.util.ArrayList;

/**
 * Created by quinns on 29/01/18.
 */
public abstract class Animal {
    public SimpleStringProperty name;
    public SimpleStringProperty species;
    public SimpleStringProperty pen;
    public SimpleStringProperty viewableRequiredSpace;
    public SimpleStringProperty viewableKeeper;
    public ArrayList<PenType> requiredPenType;
    public double requiredArea = 0;
    public double requiredVolume = 0;

    public Animal() {
        this.name = new SimpleStringProperty("Freddy");
        this.species = new SimpleStringProperty((String)this.getClass().getName());
    }

    public Animal(String name) {
        this.name = new SimpleStringProperty(name);
        String speciesString = this.getClass().getName();
        speciesString = speciesString.replace("zoo.animal.", "");
        this.species = new SimpleStringProperty(speciesString);
    }

    public StringProperty animalNameProperty() {
        return this.name;
    }
    public StringProperty animalSpeciesProperty() { return this.species;}
    public StringProperty animalPenProperty() { return this.pen; }
    public StringProperty animalKeeperProperty() { return this.viewableKeeper; }
    public StringProperty animalRequiredSpaceProperty() { return this.viewableRequiredSpace; }
}
