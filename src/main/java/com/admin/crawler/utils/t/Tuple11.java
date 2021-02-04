package com.admin.crawler.utils.t;

import java.io.Serializable;

public class Tuple11<A, B, C, D, E, F, G, H, I, J, K> extends Tuple10<A, B, C, D, E, F, G, H, I, J> implements Serializable {

    private K elevent;

    public Tuple11(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j, K k) {
        super(a, b, c, d, e, f, g, h, i, j);
        elevent = k;
    }

    public K getElevent() {
        return elevent;
    }

    public void setElevent(K elevent) {
        this.elevent = elevent;
    }

}
