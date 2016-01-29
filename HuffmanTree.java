import java.util.HashMap;
import java.util.PriorityQueue;
 
 /*
 
 @author Madeline Temares
 @version January 29
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
	
	public HuffmanTree(String s)
	{
		sentence = s;
		root = null;
		//call first helper method -- init()
	}
	
	private void init()
	{
		//will call the other methods
		makeMap();
		makeQueue();
		makeTree();
	}
	
	private void makeMap();
	
	//method that initializes to a map
	//it puts each character with its frequency into a map
	//its a loop that if the character already exists, it gets that character and puts a frequency of one more
	//if its not in there it just adds the character with frequency of one
	
	private void makePriorityQueue(); 
	
	//then you add every character from the map into the priority queue
	
	
	private void makeTree();
	//take the priority queue and change everything in it into linked HuffmanNodes
	
	//once you build the tree, you set root to the top
	
	
	
	//all methods are helpers and are private except for encode, decode, and print
	
	//encode, decode, print
	
	/*
	@param String s The sentence or word that you are encoding using the tree
	@return String String value of 1s and 0s encoded
	*/
	public String encode(String s)
	{
		//should throw error if it doesn't have all those letters
	}
	
	/*
	@param String s String representation of 1s and 0s
	@return String String representation of encoded message
	*/
	public String decode(String s)
	{
		
	}
}
