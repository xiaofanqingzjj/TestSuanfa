package com.fortune.suanfa;

import com.fortune.suanfa.javadatastruct.HashMap;

public class Test {

    public static void main(String[] args) {


//        test("String".hashCode(), 33);
//        test("String2".hashCode(), 33);
//        test("String3".hashCode(), 33);
//        test("S121323".hashCode(), 33);
//        test("String4safa".hashCode(), 33);


        System.out.println(hash("a")& 16);
        System.out.println(hash("b")& 16);
        System.out.println(hash("c") & 16);
        System.out.println(hash("d") & 16);


//        test(12335, 33);
//        test(12336, 33);
//        test(12337, 33);
//        test(12338, 33);
//        test(12339, 33);
//        test(12340, 33);

//        java.util.HashMap
    }

    static void test(int i1, int i2) {
        System.out.println(mod2(i1,i2));
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }


    static int mod2(int i1, int i2) {
        //:::通过 高位和低位的异或运算，获得最终的hash映射，减少碰撞的几率
        int finalHashCode = i1 ^ (i1 >>> 16);


        return (i2 - 1) & finalHashCode;
    }


//    fun mod2(i: Int, i2: Int): Int {
//
//        println(i ushr 16)
//        println(i xor (i ushr 16))
//
//        // 高低位异或
//        val finalHashCode = i xor  (i ushr 16)
//
//        // 屏蔽高位
//        return (i2 - 1) and  finalHashCode
//    }
}
