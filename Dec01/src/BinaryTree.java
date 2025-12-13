import java.util.LinkedList;
import java.util.Queue;

class User{
    String userName;
    int followers;

}


class Tree{
    int data;
    Tree left;
    Tree right;
    public Tree(int data){
        this.data = data;
    }
    public Tree(int data,Tree left,Tree right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
public class BinaryTree {
    //1. Array to binary tree
    public static Tree generateTree(int [] arr){
        Tree root = new Tree(arr[0]);
        for(int i = 1;i< arr.length;i++){
            formTree(arr[i], root);
        }
        return root;
    }
    private static void formTree(int data, Tree root){
        Tree newNode = new Tree(data);
        Queue<Tree> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Tree currNode = queue.poll();
            if(currNode.left == null){
                currNode.left = newNode;
                return;
            }else{
                queue.add(currNode.left);
            }
            if(currNode.right == null){
                currNode.right = newNode;
                return;
            }else{
                queue.add(currNode.right);
            }
        }
    }
    //2. BFS
    public
    static void main(String [] args){
        int [] arr = {2,1,4,5,6};
        Tree newTree = generateTree(arr);
    }
}
