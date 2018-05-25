
public class IntTree {
	private IntTreeNode overallRoot;
	
	public IntTree(IntTreeNode overall){
		this.overallRoot = overall;
	}
	
	public IntTree(int height){
		
	}
	public IntTreeNode getOverall(){
		return this.overallRoot;
	}
	public void print(){
		print(this.overallRoot);
	}
	private void print(IntTreeNode x){
		if(x == null){
			return;
		}
		if(x != null){
			print(x.left);
			System.out.println(x.data);
			print(x.right);
		}
	}
}
