package zoo.pen;

import zoo.animal.Animal;

import java.util.ArrayList;

/**
 * Created by quinns on 29/01/18.
 */
public abstract class Pen {
    public String name;
    public ArrayList<Animal> occupants;
    public double length;
    public double width;
    public double freeArea;
    public double freeVolume;

    abstract boolean isValid(Animal animal);

    abstract void addAnimal(Animal animal);
}