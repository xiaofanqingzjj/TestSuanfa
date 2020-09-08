package com.fortune.suanfa.javadatastruct


/**
 * 自己实现一个Map
 *
 */
interface Map<K, V> {


    /**
     * 向Map中添加元素
     *
     * @return 如果替换了老的值，返回老值
     */
    fun put(k: K, v: V): V?

    fun remove(k: K)

    fun get(k: K): V?

    fun containsKey(k: K)

    fun containValue(v: V)

    fun size(): Int

    fun isEmpty(): Boolean

    fun clear()


    /**
     * Map内部的存储结构
     */
    class EntryNode<K, V>(val key: K,
                          var value: V,

                          /**
                           * 链表结构
                           */
                          var next: EntryNode<K, V>? = null) {

        override fun toString(): String {
            return "EntryNode(key=$key, value=$value)"
        }

        fun keyIsEquals(key: K?): Boolean {
            return if (this.key === key) {
                true
            } else key?.equals(this.key) ?: false
        }
    }

}