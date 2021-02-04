package com.admin.crawler.utils.t;



/******
 *
 *
 *
 * @param <A>
 * @param <B>
 * @param <C>
 * @param <D>
 * @param <E>
 * @param <F>
 */
public class Tuple6<A, B, C, D, E, F> extends Tuple5<A, B, C, D, E> {
    public F sixth;

    public Tuple6(A a, B b, C c, D d, E e, F f) {
        super(a, b, c, d, e);
        sixth = f;
    }


    public F getSixth() {
        return sixth;
    }

    public void setSixth(F sixth) {
        this.sixth = sixth;
    }

    static Tuple6<String, String, String, Float, Double, Byte> a() {
        return new Tuple6<String, String, String, Float, Double, Byte>(
                "11111", "", "hi", (float) 4.7,
                1.1, (byte) 1);
    }


}
