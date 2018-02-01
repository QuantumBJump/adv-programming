package zoo.staff;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import zoo.pen.Pen;
import zoo.pen.PenType;

import java.util.ArrayList;

/**
 * Created by quinns on 30/01/18.
 */
public class Staff {
    public SimpleStringProperty name;
    public SimpleStringProperty speciality;
    public ArrayList<Pen> pens;
    public ArrayList<PenType> specialityEnum;

    public Staff(String name, PenType speciality) {
        this.name = new SimpleStringProperty(name);
        this.specialityEnum = new ArrayList<>();
        this.specialityEnum.add(speciality);
        this.speciality = new SimpleStringProperty(speciality.name());
    }

    public Staff(String name, ArrayList<PenType> speciality) {
        this.name = new SimpleStringProperty(name);
        this.specialityEnum = speciality;
        ArrayList<String> specialityList = new ArrayList<>();
        for (PenType type: specialityEnum) {
            specialityList.add(type.name());
        }
        String specialityString = String.join(", ", specialityList);
        this.speciality = new SimpleStringProperty(specialityString);
    }

    public StringProperty staffNameProperty() { return this.name; };
    public StringProperty staffSpecialityProperty() { return this.speciality; };


}
