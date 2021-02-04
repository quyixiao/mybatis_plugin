package com.admin.crawler.utils.t;

public class SuperTuple<A, B, C> {

    private A first;
    private B second;
    private C third;


    public SuperTuple(A a, B b, C c) {
        this.first = a;
        this.second = b;
        this.third = c;
    }

    public A getFirst() {
        return first;
    }

    public void setFirst(A first) {
        this.first = first;
    }

    public B getSecond() {
        return second;
    }

    public void setSecond(B second) {
        this.second = second;
    }

    public C getThird() {
        return third;
    }

    public void setThird(C third) {
        this.third = third;
    }


    public static void main(String[] args) {
        String a = "";
        String b = "";

    }
}
