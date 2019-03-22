package lab1.ufc.crateus.br;

public class BinarySearchTreeMap<K extends Comparable<K>, V> implements OrderedMap<K, V>{
	
	
	public class Node{
		K key;
		V value;
		int count;
		Node left;
		Node right;
		
		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			this.count = 1;
		}	
	}
	
	private Node root;
	
	@Override
	public void put(K key, V value) {
		root = put(root, key, value);
	}
	
	protected Node put(Node r, K key, V value) {
		if(r == null) return new Node(key, value);
		
		if(key.compareTo(r.key) < 0) {
			 
			r.left =  put(r.left, key, value);
		}
		else if(key.compareTo(r.key) > 0) {
			
			r.right = put(r.right, key, value);
		}
		else r.value = value;
		
		r.count = count(r.left) + count(r.right) + 1;
		
		return r;
	}
	
	protected int count(Node n) {
		return(n != null)? n.count : 0;
	}
	
	@Override
	public V get(K key) {
		return null;
	}

	@Override
	public void remove(K key) {
		root = remove(key, root);
	}
	
	private Node remove(K key, Node r) {
		if(r == null) return null;
		
		int cmp = key.compareTo(r.key);
		
		if(cmp < 0) r.left = remove(key, r.left);
		else if(cmp > 0) r.right = remove(key, r.right);
		else {
			
			if(r.left == null) return r.right;
			else if(r.right == null) return r.left;
			
			Node tmp = r;
			
			r = minNode2(r.right);
			r.left = tmp.left;
			r.right = removeMin(tmp.right);
			
		}
		
		r.count = count(r.left) + count(r.right) + 1;
		
		return r;
	}

	@Override
	public <K, V> Iterable<K> keys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public K min() {
		
		return minNode().key;
	}
	
	//iterativo
	private Node minNode(){
		
		if(root == null) return null;
		
		Node r = root;
		while(r.left != null) r = r.left;
		
		return r;
	}
	//Recursivo	
	private Node minNode2(Node r) {
		if(r == null) return null;
		else if(r.left == null) return r;
		
		return  minNode2(r.left);
	}
	
	@Override
	public K max() {

		return maxNode().key;
	}
	
	//iterativo
	private Node maxNode(){
		
		if(root == null) return null;
		
		Node r = root;
		while(r.right != null) r = r.right;
		
		return r;
	}
	
	private Node maxNode2(Node r) {
		
		if(r == null) return null;
		else if(r.right == null) return r;
		
		return  maxNode2(r.right);
	}
	
	@Override
	public K ceiling(K val) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public K floor(K val) {
		
		return floor(val, root);
	}
	
	private  K floor(K val, Node r) {
		
		if(r == null) return null;
		
		int cmp = val.compareTo(root.key);
		
		if(cmp < 0) return floor(val, r.left);
		else if( cmp > 0) {
			K tmp = floor(val, r.right);
			return (tmp!= null)?tmp:r.key;
		}
		
		return r.key;
	}
	
	public void removeMin() {
		root = removeMin(root);
	}
	
	public void removeMax() {
		root = removeMax(root);
	}
	
	private Node removeMin(Node r){
		if(r == null) return null;
		if(r.left == null) return r.right;
		
		r.left = removeMin(r.left);
		
		r.count = count(r.left) + count(r.right) + 1;
		
		
		return r;
	}
	
	private Node removeMax(Node r){
		if(r == null) return null;
		if(r.right == null) return r.left;
		
		r.right = removeMin(r.right);
		
		r.count = count(r.left) + count(r.right) + 1;
		
		return r;
	}

	@Override
	public int size() {
		return root.count;
	}
	
	public int rank(K val) {
		
		return rank(root, val);
	}
	
	private int rank(Node r, K val) {
		
		if(r == null) return 0;
		
		int cmp = r.key.compareTo(val);
		
		if(cmp < 0) return rank(r.left, val);
		else if(cmp > 0) return count(r.left) + rank(r.right, val);
		
		return count(r.left) + 1;
	}
	
	public int hright() {
		return hright(root);
	}
	
	private int hright(Node r) {
		if (r == null) return -1;
		
		int hleft = hright(r.left);
		int hright = hright(r.right);
		
		if(hleft > hright) return hleft +1;
		
		return hright+1;
	}
	
}
