import java.util.HashMap;
import java.util.PriorityQueue;


public class HuffmanNode implements Comparable
{
	protected int frequency;
	protected String value;
	protected HuffmanNode left;
	protected HuffmanNode right;
	/*
	Constructor - sets left and right to null
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
	@param
	@return
	*/
	public HuffmanNode(String v)
	{
		value = v;
	}
	
	/*
	@param
	@return
	*/
	public int frequency()
	{
		return frequency;
	}
	
	/*
	@param
	@return
	*/
	public void setFrequency(int f)
	{
		frequency = f;
	}
		
	/*
	@param
	@return
	*/
	public String value()
	{
		return value;
	}
	
	/*
	@param
	@return
	*/
	public void setValue(String v)
	{
		value = v;
	}
	
	/*
	@param
	@return
	*/
	public HuffmanNode left()
	{
		return left;
	}
	
	/*
	@param
	@return
	*/
	public void setLeft(HuffmanNode l)
	{
		left = l;
	}
	
	/*
	@param
	@return
	*/
	public HuffmanNode right()
	{
		return right;
	}
	
	/*
	@param
	@return
	*/
	public void setRight(HuffmanNode r)
	{
		right = r;
	}
	
	/*
	@param
	@return
	*/
	public int compareTo(Object o)
	{
		return frequency - ((HuffmanNode)o).frequency();
	}
	
	//make constructor
	
}
