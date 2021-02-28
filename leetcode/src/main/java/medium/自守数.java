package medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 自守数 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;

        while ((str = br.readLine()) != null) {

            int total_count = 0;
            for (int i = 0; i  <= Integer.parseInt(str); i++) {

                String zi_shen = String.valueOf(i);
                String zi_shen_pin_fang = String.valueOf(i * i);

                //计算input的长度
                int length = zi_shen.length();

                total_count = total_count + 1;
                for (int j = 1; j <= length; j++) {
                    if (zi_shen.charAt(zi_shen.length() - j) != zi_shen_pin_fang.charAt(zi_shen_pin_fang.length() - j)) {
                        total_count = total_count - 1;
                        break;
                    }
                }
            }
            System.out.println(total_count);


        }
    }
}
