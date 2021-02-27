package medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 汽水瓶 {

    /**
     * 汽水瓶,
     *
     * 思路2:每两个汽水瓶换一个
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            String in = br.readLine();


            //输入0程序终止
            if ("0".equals(in)) {
                break;
            }
            int input = Integer.parseInt(in);
            int count = 0;

            while (true) {
                //余数,多出来的,计到下一喝
                int yu = input % 3;

                //这次喝了几瓶
                count = count + input / 3;

                //下一次喝的数量就是  3的整数+余数
                input = input / 3 + yu;


                if (input == 1) {
                    break;
                }
                if (input == 2) {
                    count = count + 1;
                    break;
                }
            }
            System.out.println(count);

        }


    }
}
