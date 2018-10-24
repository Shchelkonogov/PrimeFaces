package org.tn.beans;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

@Stateless
public class BeanHello {

    @PostConstruct
    public void init() {
        System.out.println("Bean created!");
    }

    public void sayHello() {
        System.out.println("Hello World!");
    }
}
