package zoo;

import zoo.Main;
import zoo.animal.Animal;
import com.fasterxml.jackson.core.*;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by quinns on 06/02/18.
 */
public class FileReader {

    public void initialize() {
    }

    public Animal loadAnimalData() {
        Animal animalData;
        try {
            File animalsFile = new File("resources/animals.ser");
            if (animalsFile.exists()) {
                FileInputStream fileIn = new FileInputStream(animalsFile);
                ObjectInputStream objIn = new ObjectInputStream(fileIn);
                animalData = (Animal)objIn.readObject();
                return animalData;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }

    public void saveData() {
        saveAnimalsData();

    }

    private void saveAnimalsData() {
        ArrayList<Animal> animals = new ArrayList<>();
        for (Animal animal: Main.zooControllerHandle.animalObservableList) {
            animals.add(animal);
        }
        try {
            File animalsFile = new File("resources/animals.ser");
            FileOutputStream fileOut;
            if (!animalsFile.exists()) {
                animalsFile.getParentFile().mkdirs();
                animalsFile.createNewFile();
            }
            fileOut = new FileOutputStream(animalsFile);
            ObjectOutputStream objOut= new ObjectOutputStream(fileOut);
            for(Animal animal: animals) {
                objOut.writeObject(animal);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
