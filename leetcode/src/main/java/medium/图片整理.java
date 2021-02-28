package medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 图片整理 {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String str = null;
        while((str = br.readLine())!=null) {
            char[] ar = str.toCharArray();
            Arrays.sort(ar);
            System.out.println(String.valueOf(ar));
        }
    }
}
