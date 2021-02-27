package medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author chenyijie
 * @Date 2021/2/26 10:28 下午
 *
 * 优化: 用数组装
 */
public class 合并表记录 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(br.readLine());


        //返回值
        Map<Integer, Integer> rs = new TreeMap<>();

        for (int i = 0; i < number; i++) {
            String input = br.readLine();
            String[] inputs = input.split(" ");
            int key = Integer.parseInt(inputs[0]);
            int value = Integer.parseInt(inputs[1]);

            if (rs.containsKey(key)) {
                rs.put(key, rs.get(key) + value);
            } else {
                rs.put(key, value);
            }
        }



        rs.forEach((k,v)->{
            System.out.println(k+" "+v);
        });
    }
}
