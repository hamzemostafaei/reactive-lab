package com.hamze.reactivelabblocking.controller;

import com.hamze.reactivelabblocking.service.internal.api.IFunctionalInterface;

public class TestController {

    public static void main(String[] args) {
        IFunctionalInterface function = () -> System.out.println("hamze");

        function.doSomeThing();
    }

}
