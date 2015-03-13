import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FileWorker {
    public static ArrayList<String> list = new ArrayList<>();
    public static ArrayList<String> listP = new ArrayList<>();
    protected static Map<String, String> map;
    protected static Map<String, String> mapP;
    protected static String addArray;
    protected static String addArray2;

    //read data from the ForeignWords file
    public static void read() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("ForeignWords.txt"), "UTF-8"));
            try {
                while ((addArray = reader.readLine()) !=null) {
                    list.add(addArray);
                }
            } finally {
                reader.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
    //read data from the NativWors file
    public static void readP() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("NativWords.txt"), "UTF-8"));
            try {
                while ((addArray2 = reader.readLine()) != null) {
                    listP.add(addArray2);
                }
            } finally {
                reader.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //метод записи
    public static void writer() {
        try {
            FileWriter writer = new FileWriter(new File("ForeignWords.txt"));
            FileWriter writer2 = new FileWriter(new File("NativWords.txt"));
            //записываем в файл данные из массива list
            for (int i = 0; i < list.size(); ++i) {
                writer.write(list.get(i) + "\n");
                writer.flush();
            }
            //записываем в файл данные из массива listP
            for (int j = 0; j < listP.size(); ++j) {
                writer2.write(listP.get(j) + "\n");
                writer2.flush();
            }
        } catch (Exception e) {e.printStackTrace();}
    }

    //write data from ArrayList to HashMap
    //Hashmap used for data transfer.
    public static void log() {
        map = new HashMap<>();
        for (int i = 0; i < list.size(); ++i) {
            String q = list.get(i);
            String w = listP.get(i);
            map.put(q, w);
        }
        mapP = new HashMap<>();

        for (int i = 0; i < listP.size(); ++i) {
            String e = listP.get(i);
            String r = list.get(i);
            mapP.put(e, r);
        }
    }
}