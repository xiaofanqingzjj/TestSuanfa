package com.fortune.suanfa.tree


/**
 * 完全二叉树
 *
 * 完全二叉树的定义：
 *
 * 除最后一层外，每一层上的节点数均达到最大值；在最后一层上只缺少右边的若干结点。
 *
 *
 * 完全二叉树的性质：
 *
 * 完全二叉树一般用数组来表示
 *
 * tree[i], i>0
 *
 *（1）若i为奇数且i>1，为右子树，那么tree的左兄弟为tree[i-1]；
 *（2）若i为偶数且i<n，为左子树，那么tree的右兄弟为tree[i+1]；
 *（3）若i>1，tree的双亲为tree[i/2]；
 *（4）若2*i<=n，那么tree的左孩子为tree[2*i]；若2*i+1<=n，那么tree的右孩子为tree[2*i+1]；
 *（5）若i>n/2,那么tree[i]为叶子结点,；
 *（6）若i<(n-1)/2.那么tree[i]必有两个孩子。
 *（7）满二叉树一定是完全二叉树，完全二叉树不一定是满二叉树。
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