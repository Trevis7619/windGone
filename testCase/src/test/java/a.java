import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.*;

/**
 * @author chenyijie
 * @Date 2021/3/30 11:19 下午
 */
public class a {


    /**
     * 验证行为
     */
    @Test
    public void verify_test() {
        List<String> tt = mock(List.class);
        tt.add("1");

        System.out.println(verify(tt).add("1"));
    }


    /**
     * 插桩
     */
    @Test
    public void mock_test() {
        List<Integer> tt = mock(List.class);
        tt.add(1);

        when(tt.get(0)).thenReturn(100);
        System.out.println(tt.get(0));

        List<Integer> ty = spy(List.class);
        ty.add(1);

        when(ty.get(0)).thenReturn(100);
        System.out.println(ty.get(0));


        doReturn(20).when(tt).get(0);
        System.out.println(tt.get(0));
    }

    /**
     * 空指针测试
     */
    @Test
    public void null_test() {
        Person p = mock(Person.class);
        p.setAge(1);
        when(p.getAge()).thenReturn(2);
        System.out.println(p.getAge());


        Person py = spy(Person.class);
        py.setAge(2);
        when(py.getAge()).thenReturn(3);
        System.out.println(py.getAge());


        Person pyc = spy(Person.class);
        pyc.setAge(3);
        doReturn(4).when(pyc).getAge();
        System.out.println(py.getAge());
    }


    /**
     * 链式调用
     */
    @Test
    public void chain_test(){
        Person p =  spy(Person.class);
        when(p.getAge()).thenReturn(1).thenReturn(2);

        System.out.println(p.getAge());
        System.out.println(p.getAge());
        System.out.println(p.getAge());
    }


    /**
     * 参数匹配
     */
    @Test
    public void any_test(){
        List<Integer> list = mock(List.class);
        list.add(1);
        list.add(2);

        when(list.get(anyInt())).thenReturn(555);

        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
    }

}
