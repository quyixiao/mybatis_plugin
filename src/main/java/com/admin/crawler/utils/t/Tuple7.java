package com.admin.crawler.utils.t;

public class Tuple7<A, B, C, D, E, F, G> extends Tuple6<A, B, C, D, E, F> {

    private G seven;

    public Tuple7(A a, B b, C c, D d, E e, F f, G g) {
        super(a, b, c, d, e, f);
        seven = g;
    }

    public G getSeven() {
        return seven;
    }

    public void setSeven(G seven) {
        this.seven = seven;
    }
}
