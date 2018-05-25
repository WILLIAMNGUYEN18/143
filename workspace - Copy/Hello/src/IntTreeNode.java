
public class IntTreeNode {
	public int data;
	public IntTreeNode left;
	public IntTreeNode right;
	
		public IntTreeNode(int data){
			//this(data,null,null);
			this.data = data;
			left = null;
			right = null;
		}
		public IntTreeNode(int data, IntTreeNode left, IntTreeNode right){
			this.data = data;
			this.left = left;
			this.right = right;
		}
		

}
