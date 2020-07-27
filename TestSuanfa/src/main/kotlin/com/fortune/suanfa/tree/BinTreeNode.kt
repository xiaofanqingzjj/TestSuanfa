package com.fortune.suanfa.tree



/**
 * 二叉树节点对象和二叉树指针对象
 */
class BinTreeNode<T> (var data: T,
                      var left: BinTreeNode<T>? = null,
                      var right: BinTreeNode<T>? = null) {


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
