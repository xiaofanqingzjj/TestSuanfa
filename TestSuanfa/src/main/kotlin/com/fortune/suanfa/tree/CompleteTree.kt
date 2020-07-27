package com.fortune.suanfa.tree


/**
 * 完全二叉树
 *
 */


/**
 * 遍历完全二叉树
 *
 * @param tree 一颗完全二叉树
 * @param treeNode 要遍历的树的节点，使用节点在列表中的位置来表示树节点，注意是从1开始，
 * @param traverseMethod 遍历方式1:前序遍历，2:中序遍历，3:后续遍历
 * @param visit 遍历方式
 *
 */
fun <T> traverseTree(tree: Array<T>, treeNode: Int, traverseMethod: Int,  visit:(node: T)->Unit) {


    val nodeCount = tree.size

    when (traverseMethod) {
        1-> {
            visit(tree[treeNode - 1])

            // leftChild
            if (treeNode * 2 <= nodeCount) {
                traverseTree(tree, treeNode * 2, traverseMethod, visit)
            }


            // rightChild
            if (treeNode * 2  + 1 <= nodeCount) {
                traverseTree(tree, treeNode * 2 + 1, traverseMethod, visit)
            }
        }
        2-> {


            // leftChild
            if (treeNode * 2 <= nodeCount) {
                traverseTree(tree, treeNode * 2, traverseMethod, visit)
            }

            visit(tree[treeNode - 1])


            // rightChild
            if (treeNode * 2  + 1 <= nodeCount) {
                traverseTree(tree, treeNode * 2 + 1, traverseMethod, visit)
            }
        }
        3-> {

            // leftChild
            if (treeNode * 2 <= nodeCount) {
                traverseTree(tree, treeNode * 2, traverseMethod, visit)
            }


            // rightChild
            if (treeNode * 2  + 1 <= nodeCount) {
                traverseTree(tree, treeNode * 2 + 1, traverseMethod, visit)
            }

            visit(tree[treeNode - 1])
        }
    }

}

fun main(args: Array<String>) {

    val tree: Array<Int> = arrayOf(1, 2, 3, 4, 5 , 6)

    traverseTree(tree, 1, 3) {
        println("node:$it")
    }

}