package medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 表示数字 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;

        while ((str = br.readLine()) != null) {

            char[] input = str.toCharArray();

            StringBuilder stringBuilder = new StringBuilder();

            boolean flag = false;

            for (char s : input) {

                boolean now = Character.isDigit(s);

                if (flag && now) {
                    stringBuilder.append(s);
                } else if (!flag && !now) {
                    stringBuilder.append(s);
                } else {
                    stringBuilder.append("*");
                    stringBuilder.append(s);
                }
                flag = now;
            }

            if (Character.isDigit(input[input.length - 1])) {
                stringBuilder.append("*");
            }

            System.out.println(stringBuilder.toString());

        }
    }
}
