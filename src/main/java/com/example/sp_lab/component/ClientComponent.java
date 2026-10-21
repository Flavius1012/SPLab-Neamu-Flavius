package com.example.sp_lab.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientComponent {

    private final SingletonComponent sc;
    private final TransientComponent tc;

    @Autowired
    public ClientComponent(SingletonComponent sc, TransientComponent tc){
        this.tc = tc;
        this.sc = sc;
        System.out.println("ClientComponent::ClientComponent = " + this);
        System.out.println(" o SingletonComponent = " + sc);
        System.out.println(" o TransientComponent = " + tc);
    }


    public void operation() {
        System.out.println("Invoked ClientComponent::operation() on " + this);
        System.out.println(" o SingletonComponent = " + sc);
        System.out.println(" o TransientComponent = " + tc);
    }
}
