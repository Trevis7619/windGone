package com.trevis.security.ioc;

import org.springframework.stereotype.Component;

@Component
public class A {

    private B b;

    /**
     * 设置注入
     */
    public void setB(B b) {
        this.b = b;
    }


    /**
     * 构造器注入
     */
   /* @Autowired
    private A (B b){
        this.b=b;
    }*/

    /**
     * field注入
     */
    /*@Autowired
    private B b;*/
}
