import java.util.*;
public class Find_Mode_in_Binary_Search_Tree {
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
    }
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> counts = new HashMap<>();
        int[] maxCount = {0}; // Using an array to simulate nonlocal
        List<Integer> modes = new ArrayList<>();

        inorder(root, counts, maxCount, modes);

        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }

        return result;
    }

    private void inorder(TreeNode node, Map<Integer, Integer> counts, int[] maxCount, List<Integer> modes) {
        if (node == null) {
            return;
        }

        inorder(node.left, counts, maxCount, modes);

        int count = counts.getOrDefault(node.val, 0) + 1;
        counts.put(node.val, count);

        if (count > maxCount[0]) {
            maxCount[0] = count;
            modes.clear();
            modes.add(node.val);
        } else if (count == maxCount[0]) {
            modes.add(node.val);
        }

        inorder(node.right, counts, maxCount, modes);
    }
    public static void main(String[] args) {
        TreeNode s=new TreeNode();
    }
}
