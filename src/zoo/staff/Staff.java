package zoo.staff;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import sun.java2d.pipe.SpanShapeRenderer;
import zoo.pen.Pen;
import zoo.pen.PenType;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by quinns on 30/01/18.
 */
public class Staff implements Serializable {
    public String name;
    public transient SimpleStringProperty viewableName;

    public ArrayList<PenType> speciality;
    public transient SimpleStringProperty viewableSpeciality;

    public ArrayList<Pen> pens;
    public transient SimpleStringProperty viewablePens;

    public Staff(String name, PenType speciality) {
        this.name = name;
        this.viewableName = new SimpleStringProperty(name);
        this.speciality = new ArrayList<>();
        this.speciality.add(speciality);
        this.pens = new ArrayList<>();
        this.updateViewableProperties();
    }

    public Staff(String name, ArrayList<PenType> speciality) {
        this.name = name;
        this.speciality = speciality;
        this.pens = new ArrayList<>();
        this.updateViewableProperties();
    }

    public void updateSpecialities() {
        ArrayList<String> specialityList = new ArrayList<>();
        for (PenType type: this.speciality) {
            specialityList.add(type.name());
        }
        String specialityString = String.join(", ", specialityList);
        this.viewableSpeciality = new SimpleStringProperty(specialityString);
    }

    public void updateViewablePens() {
        ArrayList<String> pensList = new ArrayList<>();
        for (Pen pen : this.pens) {
            System.out.println("Pen id: " + pen.id);
            pensList.add(String.valueOf(pen.id));
        }
        String penString = String.join(", ", pensList);
        this.viewablePens = new SimpleStringProperty(penString);
    }

    public void updateViewableProperties() {
        this.viewableName = new SimpleStringProperty(this.name);
        this.updateViewablePens();
        this.updateSpecialities();
    }

    public StringProperty staffNameProperty() { return this.viewableName; }
    public StringProperty staffSpecialityProperty() { return this.viewableSpeciality; }
    public StringProperty staffViewablePensProperty() { return this.viewablePens; }


}
