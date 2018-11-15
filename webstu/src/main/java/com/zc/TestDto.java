package com.zc;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TestDto {
    private List list01;
    private List list02;

    public List getList01() {
        return list01;
    }

    public void setList01(List list01) {
        this.list01 = list01;
    }

    public List getList02() {
        return list02;
    }

    public void setList02(List list02) {
        this.list02 = list02;
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> aaa = null;

        for (String aa : aaa) {
            System.out.println(aa);
        }
    }

    public boolean hasNext() {
        return this.next().equals(null) || this.next().equals("");
    }

    public String next() {
        return "aaa";
    }


}
