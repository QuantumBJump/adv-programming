package zoo.staff;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import sun.java2d.pipe.SpanShapeRenderer;
import zoo.pen.Pen;
import zoo.pen.PenType;

import java.util.ArrayList;

/**
 * Created by quinns on 30/01/18.
 */
public class Staff {
    public SimpleStringProperty name;
    public SimpleStringProperty speciality;
    public SimpleStringProperty viewablePens;
    public ArrayList<Pen> pens;
    public ArrayList<PenType> specialityEnum;

    public Staff(String name, PenType speciality) {
        this.name = new SimpleStringProperty(name);
        this.specialityEnum = new ArrayList<>();
        this.specialityEnum.add(speciality);
        updateSpecialities();
        this.pens = new ArrayList<>();
        updateViewablePens();
    }

    public Staff(String name, ArrayList<PenType> speciality) {
        this.name = new SimpleStringProperty(name);
        this.specialityEnum = speciality;
        updateSpecialities();
        this.pens = new ArrayList<>();
        updateViewablePens();
    }

    public void updateSpecialities() {
        ArrayList<String> specialityList = new ArrayList<>();
        for (PenType type: this.specialityEnum) {
            specialityList.add(type.name());
        }
        String specialityString = String.join(", ", specialityList);
        this.speciality = new SimpleStringProperty(specialityString);
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

    public StringProperty staffNameProperty() { return this.name; }
    public StringProperty staffSpecialityProperty() { return this.speciality; }
    public StringProperty staffViewablePensProperty() { return this.viewablePens; }


}
