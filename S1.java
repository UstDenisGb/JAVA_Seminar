import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class S1 {
    public static void main (String[] args) {
        int i; // 1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
        Random random = new Random();
        i = random.nextInt(2001);
        System.out.println(i);
        
        int n; //2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
        n = Integer.toBinaryString(i).length();
        System.out.println(n);
        List<Integer> m1 = new ArrayList<>(); //3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
        for (int j = i; j < Short.MAX_VALUE; j++) {
            if (j % n == 0){
                m1.add(j);
            }
        }
        System.out.println(m1);

        List<Integer> m2 = new ArrayList<>(); //4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
        for (int k = Short.MIN_VALUE; k < i; k++) {
            if (k % n != 0){
                m2.add(k);
            }
        }
        System.out.println(m2);


    }
       }


