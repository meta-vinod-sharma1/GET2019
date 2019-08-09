package session5Pkg.bstPkg;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * This Class have Operations on a binary tree node like add , delete and sort etc
 * @author Vinod
 * @date 08/06/2019s
 */
public class BST implements DictionaryInterface {

		public Node root;

		public ArrayList<Node> sortedList = new ArrayList<Node>();
		public ArrayList<Node> sortedListInRange = new ArrayList<Node>();

		/**
		 * Constructor to Initialise root of BST.
		 * @param filepath - path of JSon file.
		 */
		public BST(String filepath) {
			this.root = null;
			this.readJSon(filepath);
		}


		/**
		 * This method used to add a node in Dictionary
		 * @param node - Node to be added
		 * @param root - root of tree.
		 * @return root of new tree
		 */
		public Node add(Node node, Node root) {

			if (this.root == null) {
				this.root = node;
				return this.root;
			}else{
				if (root == null) {
					return node;
				}
				if (node.getKey() < root.getKey()) {
					root.left = add(node, root.left);
				} else if (node.getKey() > root.getKey()) {
					root.right = add(node, root.right);
				}
				return root;
			}		
		}

		
		/**
		 * This method used to delete a node of given key
		 * @param key - key of the node.
		 * @param root - root of the node.
		 * @return the deleted node.
		 */
		@Override
		public Node delete(int key, Node root) {

			// base case
			if (root == null){
				System.out.println("-----------------\nKey is not found");
				return null;
			}

			if (key < root.getKey())
				root.left = delete(key, root.left);

			else if (key > root.getKey())
				root.right = delete(key, root.right);
			else if(key == root.getKey()) {
				// leaf node
				if (root.left == null && root.right == null) {
					return null;
				}

				// Node having 1 child
				if (root.left == null && root.right != null) {
					return root.right;
				}
				if (root.left != null && root.right == null) {
					return root.left;
				}

				// Node having two child
				if (root.left != null && root.right != null) {
					Node node = findMin(root.right);
					root.setKey(node.getKey());
					root.setValue(node.getValue());
					return root;
				}
			}else{
				System.out.println("Key is not found");
			}
			return root;
		}

		/**
		 * This method used to get value of a key
		 * @param key - key value.
		 * @param root - root node.
		 * @return the value for the key.
		 */
		@Override
		public String getValue(int Key, Node root){

			while (root != null) {
				if (Key < root.getKey())
					root = root.left;
				else if (Key > root.getKey()) {
					root = root.right;
				} else {
					return root.getValue();
				}
			}
			return null;

		}
		/**
		 * This method used to sort the all employees and put in the sortList
		 * @param root of BST
		 */
		@Override
		public void sortedList(Node root) {

			if (root != null) {
				sortedList(root.left);
				sortedList.add(root);
				sortedList(root.right);
			}
		}
		
		/**
		 * This method used to sort all employees within key range k1 and k2 and put in the sortListInRange
		 * @param keyLowerLimit lower limit of key
		 * @param keyUpperLimit upper limit of key
		 */
		@Override
		public void sortedListRange(Node root, int keyLowerLimit, int keyUpperLimit) {

			if (root != null) {
				sortedListRange(root.left, keyLowerLimit, keyUpperLimit);
				if (root.getKey() >= keyLowerLimit && root.getKey() <= keyUpperLimit){
					sortedListInRange.add(root);
				}
				sortedListRange(root.right, keyLowerLimit, keyUpperLimit);
			}
		}
		
		/**
		 * This method used to Finding minimum value in the Dictionary.
		 * @param node - Node address.
		 * @return return the node having minimum value.
		 */
		private Node findMin(Node node) {

			Node prev = null;
			while (node.left != null) {
				prev = node;
				node = node.left;
			}
			if (prev != null) {
				prev.left = null;
			}
			return node;
		}

		/**
		 * This method used to read JSon file.
		 * @param filepath  - Path of JSon file.
		 */
		private void readJSon(String filepath) {

			try {
				JSONParser parser = new JSONParser();
				Object object = parser.parse(new FileReader(filepath));
				JSONArray listOfObjects = (JSONArray) object;
				Iterator<JSONObject> iterator = listOfObjects.iterator();

				while (iterator.hasNext()) {
					JSONObject obj = iterator.next();
					Node node = new Node(Integer.parseInt((String) obj.get("key")),
							(String) obj.get("value"));
					this.add(node, root);
				}

			} catch (Exception e) {
				System.out.println(e);

			}

		}

}
