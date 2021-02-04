//: net/mindview/util/FourTuple.java
package com.admin.crawler.utils.t;


/***
 *
 *
 * 355页
 *
 *
 * @param <A>
 * @param <B>
 * @param <C>
 * @param <D>
 */
public class Tuple4<A, B, C, D> extends Tuple3<A, B, C> {
    private D fourth;

    public Tuple4(A a, B b, C c, D d) {
        super(a, b, c);
        fourth = d;
    }


    public D getFourth() {
        return fourth;
    }

    public void setFourth(D fourth) {
        this.fourth = fourth;
    }
}
