import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /**
     * 字符串反转
     */
    public static void 字符串反转() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String in = br.readLine();

        String[] ins = in.split("");

        int length = ins.length;

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = length-1; i >=0; i--) {
            stringBuilder.append(ins[i]);
            //stringBuilder.append(in.charAt(i));
        }
        System.out.println(stringBuilder.toString());
    }

    /**
     * 数字颠倒
     */



    public static void main(String[] args) throws IOException {
        字符串反转();
    }




}
