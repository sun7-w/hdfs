package com.bzxy.test;

import org.junit.Test;

public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("HelloWorld");
        HelloWorld hw=new HelloWorld();
        hw.go();
    }
    @Test
    public void go(){
        System.out.println("go...");
    }

    @Test
    public void action(){
        System.out.println("action...");
    }
}
