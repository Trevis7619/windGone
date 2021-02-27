package medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 *@author chenyijie
 *@Date  2021/2/26 11:12 下午
 *
 * 优化:StringBUilder保存后一次打印
 */
public class 字符串排序2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(br.readLine());

        String[] rs = new String[number];
        for (int i = 0; i < number; i++) {
          rs[i]=br.readLine();
        }

        Arrays.sort(rs);

        for(String s:rs){
            System.out.println(s);
        }


    }
}
