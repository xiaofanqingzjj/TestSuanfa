package com.fortune.suanfa.javadatastruct


fun main(args: Array<String>) {



    test(1233412334, 33)
    test(12335, 33)
    test(12336, 33)
    test(12337, 33)
    test(12338, 33)
    test(12339, 33)
    test(12340, 33)




}

fun test(i1: Int, i2: Int) {

    println("$i1 mod $i2 = ${mod(i1, i2)}")
    println("$i1 mod2 $i2 = ${mod2(i1, i2)}")

    println()
}

fun mod(i: Int, i2: Int): Int {

    return i % i2
}

fun mod2(i: Int, i2: Int): Int {

    println(i ushr 16)
    println(i xor (i ushr 16))

    // 高低位异或
    val finalHashCode = i xor  (i ushr 16)

    // 屏蔽高位
    return (i2 - 1) and  finalHashCode
}