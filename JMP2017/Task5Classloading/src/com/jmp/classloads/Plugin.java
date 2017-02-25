package com.jmp.classloads;


public class Plugin implements IPlugin {

    public Plugin() {
        System.out.println("new object...");
    }

    @Override
    public void run() {
        System.out.println("execute method run()");
    }

}
