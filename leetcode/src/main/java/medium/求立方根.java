package medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 牛顿迭代法
 */
public class 求立方根 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double d = Double.parseDouble(br.readLine());

        boolean fuFlag = false;
        double rs = 0;
        if (d < 0) {
            d = 0 - d;
            fuFlag = true;
        }

        int flag = 0;

        if (d < 1) {
            for (int m = 1; m <= 10; m++) {
                double temp = (double) m / 10;
                if (temp * temp * temp >= d) {
                    double min = (double) (m - 1) / 10;

                    if (temp * temp * temp - d >= d - min * min * min) {
                        rs = min;
                    } else {
                        rs = temp;
                    }

                    flag = 1;
                    break;
                }
            }
        }

        for (int i = 0; i < d; i++) {

            if (flag == 1) {
                break;
            }
            if (i * i * i == d) {
                rs = i;
                break;
            }

            if (i * i * i > d) {
                //flag = 1 则退出循环
                for (int j = 1; j <= 10; j++) {
                    double temp = (i - 1) + (double) j / 10;
                    if (temp * temp * temp >= d) {
                        double min = (i - 1) + (double) (j - 1) / 10;

                        if (temp * temp * temp - d >= d - min * min * min) {
                            rs = min;
                        } else {
                            rs = temp;
                        }

                        flag = 1;
                        break;
                    }
                }
            }

        }

        if (fuFlag) {
            System.out.println(0 - rs);
        } else {
            System.out.println(rs);
        }
    }
}
