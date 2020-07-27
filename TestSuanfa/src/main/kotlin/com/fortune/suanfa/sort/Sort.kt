package com.fortune.suanfa.sort


/**
 * 插入排序
 *
 */
fun insertSort() {

}


/**
 * 冒泡排序
 */
fun popSort() {

}

/**
 * 快速排序
 *
 *
 */
fun quickSort(list: IntArray) {



}


/**
 * 选择排序
 */
fun selectSort() {

}



/**
 * 树选择排序
 *
 * 树选择排序的核心思想：
 *
 * 把待排序列表的元素作为完全二叉树的叶子节点，所有的非叶子节点为其左右子节点的较小值。
 *
 *
 *
 */
fun treeSelectSort(list: IntArray) {

    // 首先把列表作为叶子节点构建完全二叉树

    // 完全二叉树的节点个数叶子节点
    val treeLength = if (list.size % 2 == 0) { // 偶数，满二叉树
        list.size * 2 - 1
    } else { // 奇数，完全二叉树
        list.size * 2
    }


    // 完全二叉树
    val tree = IntArray(treeLength)

    // 先填充叶子节点，把列表直接copy到tree列表到尾部即可
    list.copyInto(tree, treeLength - list.size, 0, list.size)


    //填充非叶子节点
    // 从树的尾部开始，相邻两个元素两两对比，把较小的元素放入双亲节点
    for (i in tree.size - 1 downTo 1 step 2) {
        // 注意是左孩子/2得到双亲节点
        tree[(i - 1 ) / 2] = if (tree[i] < tree[i - 1]) tree[i] else tree[i - 1]
    }

    // 到此就以列表为叶子节点构造了一颗完全二叉树
    println("build tree:${tree.asList()}")

    // 每次剔出根节点，并把叶子上的根节点替换成"最大值"，这样当所有的节点被剔出的时候就完成了排序过程

    var minIndex = 0
    for (i in 0 until list.size) {

        var min = tree[0]

        // 在叶子节点中找到最小值，从后向前搜索，找到等于根节点的元素即可
        list[i] = min
        minIndex = treeLength - 1
        while (tree[minIndex] != min) minIndex --

        // 把最小的叶子节点的最小值替换成最大值
        tree[minIndex] = Int.MAX_VALUE

        // 重新把树的最小值的叶子节点沉到根节点
        // 只需要从当前的节点开始，一直到根节点，比较兄弟节点，把较小的值给父节点
        while (minIndex > 0) {
            println("minIndex:$minIndex")
            // 注意求双亲节点的算法，如果index是从0开始，那么左右子树求父节点的算法是不一样的

            if (minIndex % 2 == 0) { // 当前节点为右子树
                tree[(minIndex - 1) / 2] = if (tree[minIndex] < tree[minIndex - 1]) tree[minIndex] else tree[minIndex - 1]
                minIndex = (minIndex - 1) / 2
            } else { // 左子树
                tree[minIndex / 2] = if (tree[minIndex] < tree[minIndex + 1]) tree[minIndex] else tree[minIndex + 1]
                minIndex = minIndex / 2
            }
        }
    }

    println("final tree:${tree.asList()}")

}


/**
 * 堆排序
 */
fun headSort() {

}








/**
 * Test方法
 *
 */
fun main(args: Array<String>) {
    val list = intArrayOf(10, 300, 2, 34, 450, 1)
    println("before:${list.asList()}")
    treeSelectSort(list)
    println("after:${list.asList()}")
}