/*
https://practice.geeksforgeeks.org/problems/transform-to-sum-tree/
*/
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;

public class TransformSumTree {

    static TreeNode buildTree(String str){

        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        TreeNode root = new TreeNode(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while(queue.size()>0 && i < ip.length) {

            // Get and remove the front of the queue
            TreeNode currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if(!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new TreeNode(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if(i >= ip.length)
                break;

            currVal = ip[i];

            // If the right child is not null
            if(!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new TreeNode(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
    static void printInorder(TreeNode root)
    {
        if(root == null)
            return;

        printInorder(root.left);
        System.out.print(root.val+" ");

        printInorder(root.right);
    }

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t=Integer.parseInt(br.readLine());

        while(t > 0){
            String s = br.readLine();
            TreeNode root = buildTree(s);
            Tree g = new Tree();
            g.toSumTree(root);
            printInorder(root);
            System.out.println();
            t--;

        }
    }

}

// } Driver Code Ends


/*Complete the Given Function
Node is as follows:
class Tree{
int data;
Tree left,right;
Tree(int d){
	data=d;
	left=null;
	right=null;
}
}*/
class Tree{

    public int toSumTree(TreeNode root){
        if(root==null)
            return 0;

        int oldValue = root.val;

        root.val = toSumTree(root.left) + toSumTree(root.right);

        return root.val + oldValue;
    }
}