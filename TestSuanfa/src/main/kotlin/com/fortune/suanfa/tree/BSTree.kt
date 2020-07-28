package com.fortune.suanfa.tree


/**
 * 二叉排序树相关的例子
 *
 *
 *
 */


class SomeData (var key: Int) {
}


/**
 * 在二叉树搜索树中查找数据
 */
fun find(tree: BinTreeNode<Int>, key: Int): Int? {

    if (tree.data == key) {
        return tree.data
    }

    if (tree.data > key && tree.left != null) {
        return find(tree.left!!, key)
    } else if (tree.data < key && tree.right != null) {
        return find(tree.right!!, key)
    }

    // no find
    return null
}


/**
 * 向二叉排序树插入节点
 *
 *
 * @param tree
 * @param data
 *
 * @return 返回创建好的二叉排序树
 */
fun insertToBST(tree: BinTreeNode<Int>?, data: Int): BinTreeNode<Int> {
    if (tree == null) {
        return BinTreeNode(data)
    }

    if (data < tree.data) { // 插入左子树
        if (tree.left == null) {
            tree.left = insertToBST(tree.left, data)
        } else { // 递归子树
            insertToBST(tree.left, data)
        }

    } else if (data > tree.data) { // 插入右子树
        if (tree.right == null) {
            tree.right = insertToBST(tree.right, data)
        } else {
            insertToBST(tree.right, data)
        }
    }
    return tree
}




fun main(args: Array<String>) {

    val list = intArrayOf(10, 200, 3, 5, 20, 50, 21)

    var tree : BinTreeNode<Int>? = null

    for (i in list) {
        tree = insertToBST(tree = tree, data = i)
    }


    tree?.traversel(1) {
        print("${it.data}, ")
    }


    println()
    if (tree != null) {
        val fined = find(tree, 50)
        println("fined:$fined")
    }



}