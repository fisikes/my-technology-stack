package liyudong;

/**
 * @author liyudong
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        String str1= new StringBuffer("计算机").append("软件").toString();
        System.out.println(str1 == str1.intern());// true

        String str2 = new StringBuffer("sca").append("la").toString();
        System.out.println(str2 == str2.intern()); // false

        String str3 = new StringBuffer("ja").append("va").toString();
        System.out.println(str3 == str3.intern()); // false
    }
}
