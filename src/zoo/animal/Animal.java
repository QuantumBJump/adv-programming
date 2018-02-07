package zoo.animal;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import zoo.pen.PenType;
import zoo.staff.Staff;

import java.util.ArrayList;

/**
 * Created by quinns on 29/01/18.
 */
public abstract class Animal {
    public String name;
    public SimpleStringProperty viewableName;

    public String species;
    public SimpleStringProperty viewableSpecies;

    public String pen;
    public SimpleStringProperty viewablePen;

    public double requiredArea = 0;
    public double requiredVolume = 0;
    public SimpleStringProperty viewableRequiredSpace;

    public Staff keeper;
    public SimpleStringProperty viewableKeeper;

    public ArrayList<PenType> requiredPenType;

    public Animal() {
        // set name
        this.name = "";
        this.viewableName = new SimpleStringProperty(this.name);
        // set species
        String speciesString = this.getClass().getName();
        speciesString = speciesString.replace("zoo.animal.", "");
        this.species = speciesString;
        this.viewableSpecies = new SimpleStringProperty(this.species);
    }

    public Animal(String name) {
        // set name
        this.name = name;
        this.viewableName = new SimpleStringProperty(this.name);
        // set species
        String speciesString = this.getClass().getName();
        speciesString = speciesString.replace("zoo.animal.", "");
        this.species = speciesString;
        this.viewableSpecies = new SimpleStringProperty(this.species);
    }

    public void setViewableRequiredSpace() {
        if (this.requiredArea != 0 && this.requiredVolume != 0) {
            String requiredSpaceString = requiredArea + "m squared, " + requiredVolume + "m cubed";
            this.viewableRequiredSpace = new SimpleStringProperty(requiredSpaceString);
        } else if (this.requiredArea != 0) {
            String requiredSpaceString = requiredArea + "m squared";
            this.viewableRequiredSpace = new SimpleStringProperty(requiredSpaceString);
        } else if (this.requiredVolume != 0) {
            String requiredSpaceString = requiredVolume + "m cubed";
            this.viewableRequiredSpace = new SimpleStringProperty(requiredSpaceString);
        }
    }

    public StringProperty animalNameProperty() {
        return this.viewableName;
    }
    public StringProperty animalSpeciesProperty() { return this.viewableSpecies;}
    public StringProperty animalPenProperty() { return this.viewablePen; }
    public StringProperty animalKeeperProperty() { return this.viewableKeeper; }
    public StringProperty animalRequiredSpaceProperty() { return this.viewableRequiredSpace; }
}
