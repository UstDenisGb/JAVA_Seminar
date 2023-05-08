//Написать метод принимающий строку, ищущий в ней основание и степень.
// После этого расчитывающий результат и выводящий в консоль в консоль строку параметра + ответ.
// Пример строки: "Основание -12, степень 7, результат"

public class S2 {
    public static void main (String[] args) {
        System.out.println(parse_string("Основание -12, степень 7, результат"));
    }

    public static String parse_string(String in_string) {
        String[] strings = in_string.split(" ");
        int base = 0;
        int power = 0;
        long result = 0;
        for (int i = 0; i < strings.length; i++) {
            strings[i] = strings[i].replace(",", "");
            try {
                Integer.parseInt(strings[i]);
                if (base == 0) {
                    base = Integer.parseInt(strings[i]);
                } else {
                    power = Integer.parseInt(strings[i]);
                }
            } catch (NumberFormatException e) {
                continue;
            }
        }
        result = Math.round(Math.pow(base, power));
        return String.format("%s %d.", in_string, result);
    }
}
