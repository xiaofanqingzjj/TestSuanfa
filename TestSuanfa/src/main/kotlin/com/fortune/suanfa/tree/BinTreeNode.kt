package com.fortune.suanfa.tree



/**
 * 二叉树节点对象和二叉树指针对象
 *
 * 以及一些二叉树常用的操作
 *
 * @author fortunexiao
 */
class BinTreeNode<T> (var data: T,
                      var left: BinTreeNode<T>? = null,
                      var right: BinTreeNode<T>? = null) {

    companion object {

        // 一些工具方法

        /**
         * 从列表中创建一颗排序二叉排序树
         * 主要用来测试用
         */
        fun fromList(list: IntArray): BinTreeNode<Int>? {
            var tree : BinTreeNode<Int>? = null
            list.forEach {
                tree = insertToBST(tree, it)
            }
            return tree
        }

        private fun insertToBST(tree: BinTreeNode<Int>?, value: Int): BinTreeNode<Int> {
            if (tree == null) {
                return BinTreeNode(value)
            }
            when {
                tree.data < value -> tree.right = insertToBST(tree.right, value) // 插入右孩子
                tree.data > value -> tree.left = insertToBST(tree.left, value) // 插入左孩子
                else -> { // 命中，不插入

                }
            }
            return tree
        }
    }


    /**
     * 遍历二叉树
     *
     * @param type 遍历类型：0先序遍历，1中序遍历，2后续遍历
     */
    fun traversal(type: Int, visit: (node: BinTreeNode<T>) -> kotlin.Unit) {
        when (type) {
            0-> {
                visit(this)
                left?.traversal(type, visit)
                right?.traversal(type, visit)
            }
            1-> {
                left?.traversal(type, visit)
                visit(this)
                right?.traversal(type, visit)
            }
            2-> {
                left?.traversal(type, visit)
                right?.traversal(type, visit)
                visit(this)
            }
        }
    }

    /**
     * 返回二叉树的节点数量
     */
    fun nodeCount(): Int {
        return nodeCount(this)
    }

    /**
     * 递归计算二叉树节点的个数
     */
    private fun nodeCount(node: BinTreeNode<T>?): Int {
        if (node == null) return 0
        return nodeCount(node.left) + nodeCount(node.right) + 1
    }

    /**
     * 返回二叉树的深度
     */
    fun depth(): Int {
        return depth(this)
    }

    /**
     * 树的叶子节点个数
     */
    fun leafCount(): Int {
        return leafCount(this)
    }

    /**
     * 树的叶子节点个数
     */
    fun leafCount(tree: BinTreeNode<T>?): Int {
        if (tree == null) return 0

        if (tree.left == null && tree.right == null) {
            return 1
        }
        return leafCount(tree.left) + leafCount(tree.right)
    }

    /**
     * 返回二叉树的深度
     */
    private fun depth(tree: BinTreeNode<T>?): Int {
        if (tree == null) return 0
        val leftDepth = depth(tree.left)
        val rightDepth = depth(tree.right)
        return if (leftDepth > rightDepth) leftDepth + 1 else rightDepth + 1
    }

    fun reverse(){
        reverse(this)
    }

    fun reverse(tree: BinTreeNode<T>?) {
        if (tree == null) return

        reverse(tree.left)
        reverse(tree.right)

        val tmp = tree.left
        tree.left = tree.right
        tree.right = tmp
    }


    fun reOrder(visit: (node: BinTreeNode<T>)->Unit) {
        visit(this)
        left?.reOrder(visit)
        right?.reOrder(visit)
    }

    fun inOrder(visit: (node: BinTreeNode<T>)->Unit) {
        left?.reOrder(visit)
        visit(this)
        right?.reOrder(visit)
    }


    override fun toString(): String {
        return super.toString()
    }
}

fun main(args: Array<String>) {
    val list = intArrayOf(2, 1, 5, 3, 4, 8)
    val tree = BinTreeNode.fromList(list)

    tree?.traversal(1) {
        println("node:${it.data}")
    }

    println("tree node count:${tree?.nodeCount()}")
    println("tree depth :${tree?.depth()}")
    println("tree leaCount :${tree?.leafCount()}")


    tree?.reverse()
    tree?.traversal(0) {
        println("node:${it.data}")
    }


}
