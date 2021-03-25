import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chenyijie
 * @Date 2021/3/15 8:32 下午
 */
public class Test {


    public static void main(String[] args) {
     List<Integer> a = new ArrayList<>();
     a.add(2);
     a.add(1);
     a.add(3);

        System.out.println(a.stream().sorted().collect(Collectors.toList()).get(0));
    }
}
