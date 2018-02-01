package zoo;

import zoo.animal.Animal;
import zoo.pen.Pen;
import zoo.staff.Staff;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * Created by quinns on 01/02/18.
 */

class RepeatedNameException extends Exception {
}

public class ZooModel {
    private ArrayList<Animal> animals;
    private ArrayList<Staff> staff;
    private ArrayList<Pen> pens;

    public ZooModel() {
        this.animals = new ArrayList<>();
        this.staff = new ArrayList<>();
        this.pens = new ArrayList<>();
    }

    /*******************
     * ANIMAL FUNCTIONS*
     *******************/



    public void addAnimal(Animal animal) throws RepeatedNameException {
        for (Animal obj: animals) {
            if (animal.name == obj.name) {
                throw new RepeatedNameException();
            }
        }
        this.animals.add(animal);
    }

    public Animal getAnimalByName(String name) {
        for (Animal obj: animals) {
            if (obj.name.get() == name) {
                return obj;
            }
        }
        return null;
    }


}
