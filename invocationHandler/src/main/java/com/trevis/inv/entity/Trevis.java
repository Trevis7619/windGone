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
    private String name="陈艺杰";

    private String age="22";
}
