package com.fortune.suanfa


/**
 * 完全二叉树
 *
 */


/**
 * 前序便利二叉树
 *
 */
fun preTravarseTree(tree: IntArray, nodeIndex: Int, visit:(value: Int)->Unit) {

    val nodeCount = tree.size

    // leftChild
    if (nodeIndex * 2 <= nodeCount) {
        preTravarseTree(tree, nodeIndex * 2, visit)
    }

    visit(tree[nodeIndex - 1])

    // rightChild
    if (nodeIndex * 2  + 1 <= nodeCount) {
        preTravarseTree(tree, nodeIndex  * 2 + 1, visit)
    }

}

fun main(args: Array<String>) {

    val tree = intArrayOf(1, 2, 3, 4, 5 , 6)

    preTravarseTree(tree, 1) {
        println("node:$it")
    }

}