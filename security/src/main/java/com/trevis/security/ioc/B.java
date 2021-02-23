package com.trevis.security.ioc;

import org.springframework.stereotype.Component;

@Component
public class B {
    /*@Autowired
    private A a;*/

    private  A a;

    /**
     * setter注入
     */
    public void setA(A a) {
        this.a = a;
    }
    /* public B(A a){
        this.a =a;
    }*/
}
