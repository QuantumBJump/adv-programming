package zoo.animal;

import zoo.pen.PenType;

import java.util.ArrayList;

/**
 * Created by quinns on 29/01/18.
 */
public abstract class Animal {
    public String name;
    public ArrayList<PenType> requiredPenType;
    public double requiredArea = 0;
    public double requiredVolume = 0;
}
