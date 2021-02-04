package com.admin.crawler.utils.t;

public class Tuple9<A, B, C, D, E, F, G, H, I> extends Tuple8<A, B, C, D, E, F, G, H> {

    private I nine;

    public Tuple9(A a, B b, C c, D d, E e, F f, G g, H h, I i) {
        super(a, b, c, d, e, f, g, h);
        nine = i;
    }

    public I getNine() {
        return nine;
    }

    public void setNine(I nine) {
        this.nine = nine;
    }
}
