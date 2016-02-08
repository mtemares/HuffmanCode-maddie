import java.util.HashMap;
import java.util.PriorityQueue;
 

 /* 
 @author Madeline Temares
 I used HashMap because it is more efficient. TreeMap can be sorted, but we do not need 
 that function because that wouldn't help. We need to search through all of them to see if
 the character already exists in it so there is no way that it could be sorted that would 
 make it worth it.
 
 I explained how it works broken up into all of the methods below. In short, it calls init,
 which calls the 3 helper methods. First it makes a map with each of the characters and their
 frequencies. Then it makes a priorityqueue with those keys and values. And then it takes
 that priorityqueue and does the trickiest part. It takes the lowest frequencies -- 
 top of the priorityqueue i believe -- and it combines them into a huffmanNode with the 2 
 individual ones as the left and right -- it then puts that combined node into the 
 priorityqueue in place of the other 2 in the right spot. It goes on and on until all of the
 nodes are connected and every character is a leaf at the bottom of the tree.
 
 */
 
public class HuffmanTree
{
	private HuffmanNode root; //null in constructor but then set to the top of the tree once the priority queue is sorted through and the tree is made
	private String sentence;
	private HashMap<Character,Integer> map;
	private PriorityQueue<HuffmanNode> queue;
	
	/*
	Constructor - takes in a string - the opening sentence that the tree will be made with
	It calls the helper method init which calls all the other methods to make the tree
	@param s String that the tree is made with
	*/
	
	public HuffmanTree(String s)
	{
		sentence = s;
		root = null;
		init(); //calls first helper method
	}
	
	/*
	Helper method that calls the 3 other helper methods
	@return void
	*/
	private void init()
	{
		makeMap();
		makeQueue();
		makeTree();
	}
	
	/*
	Initializes to a map. It puts each character with its frequency into a map. Its a loop
	that if the character already exits, it gets that character and puts a frequency of one
	more. If its not there, it just adds the character with a frequency of one
	@return void
	*/
	private void makeMap()
	{
		map = new HashMap<Character, Integer>();
		for (int i = 0; i<sentence.length(); i++)
		{
			char c = sentence.charAt(i);
			if (map.containsKey(c))
			{
				int x = map.get(c);
				map.put(c, x+1);
			}
			else
			{
				map.put(c, 1);
			}
		}
		this.map = map;
	}
	
	
	/*
	Adds every character from the map into a priority queue of huffmanNodes
	The priority queue sorts them according to their natural sorting, which is based
	on the compareTo method
	@return void
	*/
	private void makeQueue()
	{
		queue = new PriorityQueue<HuffmanNode>();
		for (char c: map.keySet())
		{
			HuffmanNode node = new HuffmanNode(String.valueOf(c), map.get(c));
			queue.add(node);
		}
	}	
	
	/*
	Takes the priority queue and changes everything in it into linked HuffmanNodes - it links them
	by setting the left and right of each node
	@return void
	*/
	private void makeTree()
	{
		HuffmanNode n;
		while (queue.size() > 1)
		{
			n = new HuffmanNode(queue.poll(), queue.poll());
			queue.add(n);
			root = n;
			
		}
	}
		
	
	
	
	/*
	Precondition: letters in encoding message are in the tree
	Encodes a message with the use of the HuffmanTree
	For every letter that you want to encode, it calls the encodeHelp helper method with the 
	root and that character
	@param String s The sentence or word that you are encoding using the tree
	@return String String value of 1s and 0s encoded
	*/
	public String encode(String s)
	{
		String output = "";
		for (int i = 0; i<s.length(); i++)
		{
			char c = s.charAt(i);
			output += encodeHelp(root, c);
		}	
		
		return output;
	}
	
	
	/*
	Helper method for encode
	It is recursive - it takes in where you are in the tree which is how it goes to the left or the right
	@param HuffmanNode Where you start in the tree
	@return char Character you are encoding
	*/
	public String encodeHelp(HuffmanNode r, char c)
	{
		HuffmanNode h = r;
		if (h.isLeaf())
		{
			return "";
		}
		HuffmanNode left = h.left();
		HuffmanNode right = h.right();
		for (int x = 0; x<left.value().length(); x++)
		{
			char z = left.value().charAt(x);
			if (c == z)
			{
				
				return "0" + encodeHelp(left, c);
			}
		}
		
		for (int y = 0; y<right.value().length(); y++)
		{
			char zz = right.value().charAt(y);
			if (c == zz)
			{
			
				return "1" + encodeHelp(right, c);
			}
		}
		return "";
		
	}
	
	/*
	Decodes the message you are given in 1s and 0s according to the HuffmanTree
	For every 1, it goes to the right and for every 0, it goes to the left
	@param String s String representation of 1s and 0s
	@return String String representation of encoded message
	*/
	public String decode(String s)
	{
		String output = "";
		HuffmanNode h = root;
		HuffmanNode left;
		HuffmanNode right;
		for (int i =0; i <s.length(); i++)
		{
			char c = s.charAt(i);
			if (c == '0')
			{
				if (h.left().isLeaf())
				{
					output+= h.left().value();
					h = root;
				}
				else
				{
					h = h.left();
				}
			}
			else if (c== '1')
			{
				if (h.right().isLeaf())
				{
					output+= h.right().value();
					h = root;
				}
				else
				{
					h = h.right();
				}
			}
		}
		return output;
	}
	
	
	/*
	toString method - makes use of the node toString method - call it on the root
	@return String String representation of tree
	*/
	public String toString()
	{
		return root.toString();
	}
}
