import java.util.LinkedList;
import java.util.List;

/**
 * @author chenyijie
 * @Date 2021/3/15 8:32 下午
 */
public class Test {
    public String getUrl(String url) {
        String[] urls = url.split("/");
        List<String> x = new LinkedList<>();

        for (String s : urls) {
            if (".".equals(s)) {
                continue;
            }
            if ("".equals(s)) {
                continue;
            }
            if ("..".equals(s) && x.size() >= 1) {
                x.remove(x.size() - 1);
                continue;
            }
            if ("..".equals(s)) {
                continue;
            }
            x.add(s);
        }
        StringBuilder outPut = new StringBuilder();
        for (String s : x) {
            outPut.append("/");
            outPut.append(s);
        }
        if ("".equals(outPut.toString())) {
            return "/";
        }
        return outPut.toString();
    }

    public static void main(String[] args) {
        Test t = new Test();

        //     /a/./b/../../c/
        //
        System.out.println(t.getUrl("/a//b////c/d//././/.."));
    }
}
