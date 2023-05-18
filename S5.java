import java.util.HashMap;
import java.util.Map;

public class S5 {

    public static void main (String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Один", "One");
        map.put("Два", "Two");
        map.put("Три", "Three");
        map.put("Четыре", "Four");
        map.put("Пять", "Five");
        map.put("Шесть", "Six");
        printValues(map);
    }

    public static void printValues(Map<String, String> map)
    {
        for(Map.Entry<String, String> pair : map.entrySet())
        {
            String value = pair.getValue();
            System.out.println(value);
        }

        for (String key: map.keySet()) {
//            map.compute(key, (k, v) -> v+"!");
            map.merge(key, "!", String::concat);
        }

        System.out.println(map);
    }
}
