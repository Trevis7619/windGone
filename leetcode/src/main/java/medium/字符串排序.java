package medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

/**
 * @author chenyijie
 * @Date 2021/2/26 10:47 下午
 *
 * {@link 字符串排序2}
 */
public class 字符串排序 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(br.readLine());


        TreeMap<String, Integer> rs = new TreeMap<>();
        for (int i = 0; i < number; i++) {
            String temp = br.readLine();
            if (rs.containsKey(temp)) {
                rs.put(temp, rs.get(temp) + 1);
            } else {
                rs.put(temp, 1);
            }
        }

        rs.forEach((a,b)->{
            for(int i =0;i<b;i++){
                System.out.println(a);
            }
        });

    }
}
