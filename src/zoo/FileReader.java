package zoo;

import zoo.Main;
import zoo.animal.Animal;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by quinns on 06/02/18.
 */
public class FileReader {

    public void saveData(Zoo zoo) {
        try {
            File saveFile = new File("resources/savedata.ser");
            FileOutputStream fileOut;
            if (!saveFile.exists()) {
                // create save file if none exists.
                saveFile.getParentFile().mkdirs();
                saveFile.createNewFile();
            }
            fileOut = new FileOutputStream(saveFile);
            ObjectOutputStream dataOut = new ObjectOutputStream(fileOut);
            dataOut.writeObject(zoo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Zoo loadData() {
        try {
            File saveFile = new File("resources/savedata.ser");
            FileInputStream fileIn;
            if (saveFile.exists()) {
                fileIn = new FileInputStream(saveFile);
                ObjectInputStream dataIn = new ObjectInputStream(fileIn);
                return (Zoo)dataIn.readObject();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
