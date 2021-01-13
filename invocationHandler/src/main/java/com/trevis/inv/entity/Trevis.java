package com.trevis.inv.entity;

import com.trevis.inv.annotation.FirstAnnotation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FirstAnnotation(name="风逝")
public class Trevis {

    @FirstAnnotation(hobby = "嫦娥")
    private String name="陈艺杰";


    private String age="22";

    public  void sayHaHa(String name){
        System.out.println("你好啊"+name);
    }
}
