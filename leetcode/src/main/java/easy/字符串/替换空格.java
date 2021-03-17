package easy.字符串;

public class 替换空格 {

    public String replaceSpace(String s) {

        s = s.replace(" ", "%20");

        return s;
    }


    public static void main(String[] args) {
        替换空格 t = new 替换空格();
        System.out.println(t.replaceSpace("helloworld "));
    }
}
