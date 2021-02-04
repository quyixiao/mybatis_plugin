package com.admin.crawler.utils.t;

import java.io.Serializable;

public class Tuple1<A> implements Serializable {
    private A first;

    public Tuple1(A a) {
        first = a;
    }

    public A getFirst() {
        return first;
    }

    public void setFirst(A first) {
        this.first = first;
    }


}

