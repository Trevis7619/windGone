package medium.动态规划;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 放苹果
 * <p>
 * 递归算法
 */
public class 放苹果 {

    public static int cal(int apples, int packages) {

        if (apples == 0 || packages == 1) {
            return 1;
        }

        if (packages - apples > 0) {
            return cal(apples, apples);
        } else {
            return cal(apples, packages - 1) + cal(apples - packages, packages);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       String str;

       while ((str=br.readLine())!=null){
           String[] input = str.split(" ");

           int appleNumber = Integer.parseInt(input[0]);

           int packageNumber = Integer.parseInt(input[1]);

           System.out.println(放苹果.cal(appleNumber, packageNumber));
       }

    }
}
