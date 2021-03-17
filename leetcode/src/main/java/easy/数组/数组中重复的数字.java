package easy.数组;

import java.util.HashSet;
import java.util.Set;

public class 数组中重复的数字 {

    public int duplicate(int[] numbers) {

        Set<Integer> s = new HashSet<>();

        for (int temp : numbers) {
            if (s.contains(temp)) {
                return temp;
            }
            s.add(temp);
        }
        return -1;
    }
}
