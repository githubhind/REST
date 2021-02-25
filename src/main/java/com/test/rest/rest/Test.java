package com.test.rest.rest;

import java.util.Optional;

public class Test {

    public static void main(String[] args) {
        System.out.println(Optional.of("aa").map(a -> {System.out.println("map"); return "map";}));
    }
}
