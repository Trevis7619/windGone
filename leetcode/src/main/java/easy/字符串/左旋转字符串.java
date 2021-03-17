package easy.字符串;

public class 左旋转字符串 {

    public String reverseLeftWords(String s, int n) {

        String hou =  s.substring(n);

        String qian = s.substring(0,n);



        return  hou+qian;

    }

}
