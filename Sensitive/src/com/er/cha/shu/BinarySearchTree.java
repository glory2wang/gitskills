package com.er.cha.shu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wz on 2018/7/12.
 */
public class BinarySearchTree {

    private static void createBinarySearchTree(Integer[] array, int index,TreeNode root) {
        TreeNode tn = null;
        if(index<0||array ==null||index>array.length-1){
            return;
        }
        Integer arrv = array[index];
        if(arrv!=null){
            if(arrv>root.val){
                if(root.right!=null){
                    createBinarySearchTree(array,index,root.right);
                }else{
                    root.right = new TreeNode(arrv);
                }
            }else {
                if(root.left!=null){
                    createBinarySearchTree(array,index,root.left);
                }else{
                    root.left = new TreeNode(arrv);
                }
            }
        }
    }
    private static void printTree(TreeNode root,List list){
        if(root!=null){
            printTree(root.left,list);
            list.add(root.val);
            printTree(root.right,list);
        }
        /**                                            5
         *                                         /     \
         *                                       4        8
         *                                    /         /  \
         *                                  2         7     9
         *                                /   \      /
         *                              1      3    6
         *
         *                               1  2 4 8 9 5 3 6 7
         *
         *
         */
    }

    public static void main(String[] args) {

        Integer[] arr = new Integer[]{5, 4, 8, 2, 7, 9, 1, 3, 6};
        TreeNode root = new TreeNode(arr[0]);
        for(int i=1;i<arr.length;i++){
            createBinarySearchTree(arr,i,root);
        }
        List list = new ArrayList();
        printTree(root,list);
        System.out.println(list);
    }
}
