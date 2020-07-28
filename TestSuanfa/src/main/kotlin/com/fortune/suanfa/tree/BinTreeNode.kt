package com.fortune.suanfa.tree



/**
 * 二叉树节点对象和二叉树指针对象
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
    fun traversel(type: Int, visit: (node: BinTreeNode<T>) -> kotlin.Unit) {
        when (type) {
            0-> {
                visit(this)
                left?.traversel(type, visit)
                right?.traversel(type, visit)
            }
            1-> {
                left?.traversel(type, visit)
                visit(this)
                right?.traversel(type, visit)
            }
            2-> {
                left?.traversel(type, visit)
                right?.traversel(type, visit)
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

    tree?.traversel(1) {
        println("node:${it.data}")
    }

    println("tree node count:${tree?.nodeCount()}")
    println("tree depth :${tree?.depth()}")

    tree?.reverse()
    tree?.traversel(0) {
        println("node:${it.data}")
    }


}
