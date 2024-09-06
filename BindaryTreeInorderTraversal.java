import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, return the inorder traversal of its nodes'
 * values.
 */
public class BindaryTreeInorderTraversal {
	List<Integer> res = new ArrayList<>();

	public List<Integer> solution(TreeNode root) {
		if (root == null) {
			return res;
		}
		solution(root.left);
		res.add(root.val);
		solution(root.right);

		return res;
	}
}
