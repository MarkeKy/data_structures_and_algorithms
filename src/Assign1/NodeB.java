package Assign1;

public class NodeB {
    int key;//Stores the key
	NodeB parent;//Fields of the struct
	NodeB left;
	NodeB right;
	boolean external;
	
	public NodeB(int key, NodeB parent) {//Internal node, has key
		this.key = key;
		this.parent = parent;
		external = false;
		left = new NodeB(this);//Creates External Node
		right = new NodeB(this);//Creates External Node
	}
	public NodeB(NodeB parent) {//External Node constructor
		external = true;
		this.parent = parent;
		left = null;
		right = null;
	}
	public boolean isExternal() {
		return external;
	}
	
}
