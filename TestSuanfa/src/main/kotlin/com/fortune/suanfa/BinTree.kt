package com.fortune.suanfa


/**
 * 二叉树节点对象和二叉树指针对象
 */
class TreeNode<T> (var data: T, var left: TreeNode<T>? = null, var right: TreeNode<T>? = null) {

    fun reOrder(visit: (node: TreeNode<T>)->Unit) {
        visit(this)
        left?.reOrder(visit)
        right?.reOrder(visit)
    }

    override fun toString(): String {
        return super.toString()
    }
}


// 重建二叉树

fun rebuildTree(preList: IntArray?, inList: IntArray?): TreeNode<Int>? {

    if (preList == null) return null
    if (inList == null) return null

    if (preList.size == 1) {
        return TreeNode(preList[0])
    }

    val node = TreeNode(preList[0])

    // 前序序列的第一个元素在中序序列中的位置
    val index = inList.indexOf(preList[0])

//    print("index:$index")

    // 递归构建左子树和右子树
    node.left = rebuildTree(sub(preList, 1, index + 1), sub(inList, 0, index))
    node.right = rebuildTree(sub(preList,index + 1, preList.size), sub(inList, index + 1, inList.size))

    return node
}

private fun indexOf(list: IntArray, v: Int): Int {
    return list.indexOf(v)
}

private fun sub(list: IntArray, start: Int, end: Int): IntArray? {
    if (start >= end) return null
    return list.copyOfRange(start, end)
}


fun main(args: Array<String>) {
    val prelist = intArrayOf(1, 2, 4, 7, 3, 5, 6, 8)
    val inList = intArrayOf(4, 7, 2, 1, 5, 3, 8, 6)

//    print("sub preList:${sub(prelist, 0, 3)}")

    val tree = rebuildTree(prelist, inList)

    tree?.reOrder {
        print("${it.data} ")
    }
}


