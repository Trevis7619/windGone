package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenyijie
 * @Date 2020/10/2 2:58 下午
 */

@Data
//全参构造
@AllArgsConstructor
//无参构造
@NoArgsConstructor
public class Tr<T> {

    private Integer code;
    private String message;
    private T data;


    /**
     * 两个参数的构造函数
     */
    public Tr(Integer code, String message) {
        this(code, message, null);
    }

}
