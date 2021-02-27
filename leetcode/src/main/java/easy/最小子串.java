package easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 最小子串 {


    /**
     * 最小子串
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a1 = br.readLine();

        String a2 = br.readLine();

        String smaller = a1.length() <= a2.length() ? a1 : a2;
        String bigger = a1.length() >= a2.length() ? a1 : a2;
        int length = smaller.length();

        //最小长度
        int result = 0;

        for (int i = 0; i <= length; i++) {
            for (int j = i + 1; j <= length; j++) {
                String temp = smaller.substring(i, j);

                if(bigger.contains(temp)){
                    result=Math.max(result,temp.length());
                }
            }
        }
        System.out.println(result);
    }
}
