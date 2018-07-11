package com.er.cha.shu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wz on 2018/7/11.
 */
public class ExecuteTree {


    private static TreeNode createBinaryTreeByArray(Integer[] array, int index) {
        TreeNode tn = null;
        if (index < array.length) {
            Integer value = array[index];
            if (value == null) {
                return null;
            }
            tn = new TreeNode(value);
            tn.left = createBinaryTreeByArray(array, 2 * index + 1);
            tn.right = createBinaryTreeByArray(array, 2 * index + 2);
            return tn;
        }
        return tn;
    }

    private static void printTree(TreeNode root,List list){
        if(root!=null){
            list.add(root.val);
            printTree(root.left,list);
            printTree(root.right,list);
        }
        /**                                            1
         *                                         /     \
         *                                      2         3
         *                                    /   \     /  \
         *                                  4      5  6     7
         *                                /   \
         *                              8      9
         *
         *                               1  2 4 8 9 5 3 6 7
         *
         *
         */
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode root = createBinaryTreeByArray(arr,0);
        List list =new ArrayList();
        printTree(root,list);
        System.out.println(list);
    }




}
