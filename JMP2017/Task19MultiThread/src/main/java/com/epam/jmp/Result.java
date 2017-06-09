package com.epam.jmp;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Gleb88 on 09.06.2017.
 */
public class Result {

    int r = 0;
    Lock lock = new ReentrantLock();

    public Result(int r) {
        this.r = r;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }
}
