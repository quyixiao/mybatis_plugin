package com.admin.crawler.utils.t;

public class Tuple2<A, B> extends Tuple1<A> {
    private B second;

    public Tuple2(A a, B b) {
        super(a);
        second = b;
    }

    public B getSecond() {
        return second;
    }

    public void setSecond(B second) {
        this.second = second;
    }

}

