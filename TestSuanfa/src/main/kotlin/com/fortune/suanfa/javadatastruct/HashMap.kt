package com.fortune.suanfa.javadatastruct


/**
 * 一个自己实现的HashMap
 *
 * @author fortunexiao
 */
class HashMap<K, V> : Map<K, V> {

    companion object {


        /**
         * 默认的容量
         */
        const val DEFAULT_CAPACITY = 16

        /**
         * 扩容翻倍的基数
         */
        private val REHASH_BASE = 2

        /**
         * 默认的负载因子
         */
        private val DEFAULT_LOAD_FACTOR = 0.75f

    }

    /**
     * 保存原始数据的列表
     */
    private var elements: Array<Map.EntryNode<K, V>?> = arrayOfNulls<Map.EntryNode<K, V>>(DEFAULT_CAPACITY)

    /**
     * 当前map保存数据的大小
     */
    private var size: Int = 0

    /**
     * 增长因子
     */
    private var loadFactor: Float = DEFAULT_LOAD_FACTOR;


    constructor(capacity: Int) {
        elements = arrayOfNulls(capacity)
    }

    constructor(capacity: Int, loadFactor: Float) {
        this.elements = arrayOfNulls(capacity)
        this.loadFactor = loadFactor
    }

    init {


    }

    /**
     * 获取key对应的插槽index
     */
    private fun getIndex(key: K): Int {
        return getIndex(key, this.elements.size)
    }




    /**
     * 根据key值寻址
     */
    private fun getIndex(key: K, elementSize: Int): Int {
        return if (key == null) {
            0
        } else {
            val hashCode = key.hashCode()
            // 简单一点的做法，可以直接使用求余函数来实现寻址
            // return hashCode % elements.size


            // 奇怪， 用这种算法碰撞的概率很高呀

            // 高低位异或
            val finalHashCode = hashCode xor  (hashCode ushr 16)
            // 屏蔽高位
            (elementSize - 1) and  finalHashCode
        }
    }


    /**
     *
     * @param currentNode 桶节点
     * @param key 目标节点的key值
     * @return 返回目标节点的前一个节点
     */
    private fun getTargetPreviousEntryNode(currentNode: Map.EntryNode<K, V>, key: K): Map.EntryNode<K, V> {

        var current = currentNode

        var nextNode = current.next

        while (nextNode != null) {
            if (nextNode.keyIsEquals(key)) {
                return current
            } else {
                current = nextNode
                nextNode = current.next
            }
        }

        // 如果没有找到，则返回当前桶链表的最后一个节点
        return current
    }


    /**
     * 是否需要扩容
     * 看当前的负载因子是否大于要求的负载因子
     */
    private fun needReHash(): Boolean {
        return (this.size / this.elements.size) > this.loadFactor
    }

    private fun reHash() {

        val newElements = arrayOfNulls<Map.EntryNode<K, V>?>(this.elements.size  * REHASH_BASE)

        // 把原桶中的数据重新hash到新的桶中
        this.elements.forEachIndexed {index, entryNode ->
            reHashSlot(index, newElements)
        }

        this.elements = newElements
    }


    /**
     * 把桶中的某个位置的拉链表重新hash到到新的桶列表中
     *
     * @param index 原来桶的某个位置
     * @param newElements 新桶数组
     */
    private fun reHashSlot(index: Int, newElements: Array<Map.EntryNode<K, V>?>) {

        var currentEntryNode = this.elements[index]

        // 如果桶位置数据为空，直接返回
        if (currentEntryNode == null) return


        //低位桶链表 头部节点、尾部节点
        val lowListHead: Map.EntryNode<K, V>? = null
        val lowListTail: Map.EntryNode<K, V>? = null


        //高位桶链表 头部节点、尾部节点
        val highListHead: Map.EntryNode<K, V>? = null
        val highListTail: Map.EntryNode<K, V>? = null


        // 遍历拉链表的元素，hash每个元素的新位置
        // 有两种情况：1.还是在原来的位置，
        while (currentEntryNode != null) {

            val entryNodeNewIndex = getIndex(currentEntryNode.key, newElements.size)






            currentEntryNode = currentEntryNode.next
        }




    }




    /**
     * 插入实现
     *
     *
     */
    override fun put(k: K, v: V): V? {

//        // 判断是否需要扩容
//        if (needReHash()) {
//            reHash()
//        }


        val index = getIndex(k)
        val firstNode = this.elements[index]

        // 如果当前的桶为空，直接插入
        if (firstNode == null) {
            this.elements[index] = Map.EntryNode(k, v)
            this.size ++
            return null
        }


        if (firstNode.keyIsEquals(k)) {
            // 如果第一个节点匹配key
            val oldValue = firstNode.value
            firstNode.value = v
            return oldValue
        } else {
            // 找到目标key的前一个节点
            val targetPreviousNode  = getTargetPreviousEntryNode(firstNode, k)

            val targetNode = targetPreviousNode.next

            return if (targetNode != null) { // 原来有值
                val oldValue = targetNode.value
                targetNode.value = v
                oldValue
            } else { // 原来无值
                targetPreviousNode.next = Map.EntryNode(k, v)
                size ++
                null
            }
        }
    }

    override fun remove(k: K) {
        val index = getIndex(k)

        val firstEntryNode = this.elements[index]


    }

    override fun get(k: K): V? {

        val index = getIndex(k)

        val firstNode = this.elements[index]

        // 如果拉链为空，则直接返回null
        if (firstNode == null) {
            return null
        }

        if (firstNode.keyIsEquals(k)) {
            return firstNode.value
        }

        val targetPreviousNode = getTargetPreviousEntryNode(firstNode, k)


        return null
    }

    override fun containsKey(k: K) {
    }

    override fun containValue(v: V) {
    }

    override fun size(): Int {
        return 0
    }

    override fun isEmpty(): Boolean {
        return false
    }

    override fun clear() {
    }

}