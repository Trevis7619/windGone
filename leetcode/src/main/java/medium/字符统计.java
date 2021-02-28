package medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 字符统计
 * <p>
 * 先用hashmap 统计次数
 * <p>
 * 再用treemap根据次数排序
 *
 * 核心: treeMap.put((double)v+(double) v/(double) k,k);
 *
 * 优化: 矩阵
 */
public class 字符统计 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;

        while ((str = br.readLine()) != null) {

            char[] input = str.toCharArray();


            Map<Character, Integer> map = new HashMap<>();

            for (char s : input) {
                if (map.containsKey(s)) {
                    map.put(s, map.get(s) + 1);
                } else {
                    map.put(s, 1);
                }
            }

            TreeMap<Double, Character> treeMap = new TreeMap<>();
            // k:a,b,c  v:2,3,4
            map.forEach((k, v) -> {

                treeMap.put((double)v+(double) v/(double) k,k);

            });


            StringBuilder s = new StringBuilder();

            treeMap.forEach((index,c)->{
                s.insert(0,c);
            });

            System.out.println(s.toString());
        }
    }

}
