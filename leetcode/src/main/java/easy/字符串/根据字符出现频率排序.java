package easy.字符串;

import java.util.*;

public class 根据字符出现频率排序 {


    public String frequencySort(String s) {

        char[] chars = s.toCharArray();

        Map<Character, Integer> map = new HashMap<>();

        for (char c : chars) {

            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        class A {
            char c;
            int length;
        }

        TreeSet<A> t = new TreeSet<A>(Comparator.comparingInt(o -> o.length));
        map.forEach((a, b) -> {
            A air = new A();
            air.c = a;
            air.length = b;
            t.add(air);
        });


        StringBuilder stringBuilder = new StringBuilder();
        for(A aTemp: t){
            stringBuilder.append(aTemp.c);
        }

        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();

    }

    public static void main(String[] args) {
        根据字符出现频率排序 s = new 根据字符出现频率排序();
        s.frequencySort("tree");
    }

}
