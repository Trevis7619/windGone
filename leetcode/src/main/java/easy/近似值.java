package easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 近似值 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String in = br.readLine();

        String[] rs = in.split("\\.");


        if(rs.length<=1){
            System.out.println(in);
        }

        if(rs.length>1){
            int first = Integer.parseInt(rs[1].split("")[0]);

            if(first<5){
                System.out.println(rs[0]);
            }else {
                System.out.println(Integer.parseInt(rs[0])+1);
            }
        }


    }
}
