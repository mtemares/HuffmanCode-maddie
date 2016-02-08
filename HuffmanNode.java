/*
@author Maddie Temares

HuffmanNode is the node for each element in the HuffmanTree. It holds the frequency and value
of each letter and then each set of combined characters when the tree is being formed
upwards. A HuffmanNode has a left and right value, similar to binary tree, because the values
that the huffmanNode holds has subtrees. For example, a huffmannode with value "sf" would have 
subtrees of "s" and "f".

*/

import java.util.HashMap;
import java.util.PriorityQueue;


public class HuffmanNode implements Comparable
{
	protected int frequency;
	protected String value;
	protected HuffmanNode left;
	protected HuffmanNode right;
	
	/*
	Constructor - sets left and right to null - these would be leaf nodes
	@param v Value
	@param f Frequency
	*/
	public HuffmanNode(String v, int f)
	{
		value = v;
		frequency = f;
		left = null;
		right = null;
	}
	
	/*
	Constructor that makes new node with 2 existing nodes as its left and right
	@param l Left node
	@param r Right node
	*/
	public HuffmanNode(HuffmanNode l, HuffmanNode r)
	{
		left = l;
		right = r;
		value = l.value() + r.value();
		frequency = l.frequency() + r.frequency();
	}
	
	/*
	Accessor for frequency
	@return int Frequency
	*/
	public int frequency()
	{
		return frequency;
	}
	
	/*
	Modifier for frequency
	@param f Frequency to be set
	@return void
	*/
	public void setFrequency(int f)
	{
		frequency = f;
	}
		
	/*
	Accessor for value
	@return String Frequency
	*/
	public String value()
	{
		return value;
	}
	
	/*
	Modifier for value
	@param v Value to be set
	@return void
	*/
	public void setValue(String v)
	{
		value = v;
	}
	
	/*
	Accessor for left
	@return HuffmanNode left
	*/
	public HuffmanNode left()
	{
		return left;
	}
	
	/*
	Modifier for left
	@param l Left huffmannode to be set
	@return void
	*/
	public void setLeft(HuffmanNode l)
	{
		left = l;
	}
	
	/*
	Accessor for right
	@return HuffmanNode right
	*/
	public HuffmanNode right()
	{
		return right;
	}
	
	/*
	Modifier for right
	@param l Right huffmannode to be set
	@return void
	*/
	public void setRight(HuffmanNode r)
	{
		right = r;
	}
	
	/*
	CompareTo method - here so that the priorityqueue knows how to sort the huffmannodes
	It compares the huffmannodes with their frequencies
	@param o Object it is being compared to
	@return int Positive if frequency is greater and negative if frequency is less
	*/
	public int compareTo(Object o)
	{
		return frequency - ((HuffmanNode)o).frequency();
	}
	
	/*
	Checks to see if the huffmanNode is a leaf - if there are no nodes to the left and right
	It only needs to check if the left is null because the way the nodes are made, they will either
	have both left and right values or both be null - it cannot be one or the other
	@return boolean Whether or not huffmannode is a leaf
	*/
	public boolean isLeaf()
	{
		if (null == left())
		{
			return true;
		}
		return false;
	}	
}
