import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class S4 {

    static ArrayList<String> family = new ArrayList<>();
    static ArrayList<String> name = new ArrayList<>();
    static ArrayList<String> surname = new ArrayList<>();
    static ArrayList<Integer> age = new ArrayList<>();
    static ArrayList<Boolean> gender = new ArrayList<>();
    static LinkedList<Integer> key = new LinkedList<>();

    public static void main(String[] args) {

        String str = "";
        try {
            FileReader reader = new FileReader("text.in");
            while (reader.ready()) str += (char) reader.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] strings = str.split("\n");
        for (int i = 0; i < strings.length; i++) {
            String[] tmp = strings[i].split(" ");
            family.add(tmp[0]);
            name.add(tmp[1]);
            surname.add(tmp[2]);
            age.add(Integer.parseInt(tmp[3]));
            gender.add(tmp[4].contains("М"));
            key.add(i);
        }

        int cnt = key.size() - 1;
        while (cnt > -1) {
            int max_age = age.get(key.get(cnt));
            int index = cnt;
            for (int i = 0; i < cnt; i++) {
                if (max_age < age.get(key.get(i))) {
                    max_age = age.get(key.get(i));
                    index = i;
                }
            }

            int tmp = key.get(cnt);
            key.set(cnt, key.get(index));
            key.set(index, tmp);
            cnt--;
        }

        for (int i : key) {
            System.out.println(getFIO(i));
        }
    }

    private static String getFIO(int index) {
        return family.get(index).toUpperCase().charAt(0)
                + family.get(index).toLowerCase().substring(1) + " "
                + name.get(index).toUpperCase().charAt(0) + "."
                + surname.get(index).toUpperCase().charAt(0) + ". "
                + age.get(index) + " лет, "
                + (gender.get(index) ? "Мужчина" : "Женщина");
    }
}
