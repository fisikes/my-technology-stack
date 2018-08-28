package liyudong;

import org.junit.Test;

/**
 * Created by lydon on 2018/8/28.
 */
public class FinalAndVarTests {

    @Test
    public void one() {
        // public final class Integer
        //Integer integer = new Integer(10);

        // integer对象是final的, final修饰字在类上只是不能被继承, 而integer类没有改变自身值的方法, 因而此对象不可改变.
        // 但是如果没有final修饰引用, 改引用指向的对象是可以被替换为别的对象的.


        // 只是把class声明为final的, 只能保证class不能被继承, 其field并不是final的, 可改变其值.
        // 声明的变量final修饰, 只能保证栈中的引用地址不会发生变化, 但是对象如果是可变的, 则对象的值可变.
        // Java无不可变的概念, 只能通过编程的方式实现.
        final AFinalObject aFinalObject = new AFinalObject(1, new Integer(10));
        aFinalObject.setA(2);
        System.out.println(aFinalObject.getA());
    }
}


final class AFinalObject{

    // 将field 声明为final, 这时候set方法是没有一丝的, this.a也会报错, 不可改变.
    private int a ;
    private Integer b;

    public AFinalObject(int a, Integer b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }
}