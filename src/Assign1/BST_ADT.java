package Assign1;

public class BST_ADT {
	public  NodeB root;
	
	public NodeB root() {
		return root;
	}
	public NodeB TreeSearch(int k, NodeB v) {//Tree Search
		if (v.isExternal()) {//Base case
			return v;
		}
		if (k < v.key) {
			return TreeSearch(k,v.left);//General cases
		}
		else if (k>v.key)
			return TreeSearch(k,v.right);
		else
			return v;//You've found the key!
	}
	private void insertAtExternal(int k, NodeB v) {//Making node v an internal node
		v.key = k;//Place key in node
		v.external = false;
		v.left = new NodeB(v);//Making new external nodes with v being the parent
		v.right = new NodeB(v);// V became an internal node
	}
	public void TreeInsert(int k) {//Method used by users
		if (root == null)//No root exists
			root = new NodeB(k,null);//Define root and make the value k
		else
			TreeInsert(k,root);//Since it's not the root, use other TreeInsert method
	}
	private void TreeInsert(int k, NodeB v) {//Not accessible to users
		if(v.isExternal())
			insertAtExternal(k,v);//Insert because it's internal
		else if (k <v.key)
			TreeInsert(k, v.left);//Less than means go to the left to maintain inorder traversal
		else if (k>v.key)//Greater than means to the right of node
			TreeInsert(k,v.right);
		else
			TreeInsert(k,v.left);//Place it to the left of duplicate key
	}
	private void removeExternal(NodeB v) {
		NodeB w = v.parent;//Parent of v
		NodeB s;//Sibling of v
		if (w.left == v) {
	        s = w.right;
	    }
	    else {
	        s = w.left;
	    }
		if (w.parent == null) {//If v's parent is root, meaning it doesn't have a grandparent
				root = s;//Make root the Sibling of v
				s.parent = null;//garbage collection
		}
		else {
			NodeB x = w.parent;//Parent of parent
			if(x.left == w) {
				x.left = s;
			}
			else
				x.right = s;
			s.parent = x;
		}
		w.left = null;
		w.right = null;
	}
	public void remove(int k) {//Remove node from tree
		NodeB w = TreeSearch(k,root);//Search to find node that stores k
		
		if (w.isExternal()) {//k could not be found
			System.out.println("Error, this key is not in this tree");
			return;
		}
		
		NodeB x = w.left;
		NodeB y = w.right;
		if (x.isExternal() || y.isExternal()) {//Case 1
			if (x.isExternal()) {
				removeExternal(x);//Remove x and w (the node that stores k
				return;
			}
			else {
				removeExternal(y);//Then y is external and remove it and w
			    return;
			}
		}
		else {//Case 2
			NodeB temp = y;//Start from the right of w
			while (!temp.left.isExternal()) {
				temp = temp.left;//Inorder traversal to find node that follows w
			}
			w.key = temp.key;//Change the key of w to what temp is
			removeExternal(temp);//Remove the node that followed
		}
		
	}
	public void inOrder(NodeB v) {
		if (v.isExternal())
			return;//Base case
		inOrder(v.left);//Preorder traversal for left subtree
		System.out.print(v.key);
		inOrder(v.right);
	}
	
}
