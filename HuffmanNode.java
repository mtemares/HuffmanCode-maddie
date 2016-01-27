import java.util.HashMap;
import java.util.PriorityQueue;


public class HuffmanNode implements Comparable
{
	protected int frequency;
	protected String value;
	protected HuffmanNode left;
	protected HuffmanNode right;
	
	public HuffmanNode(String v, int f)
	{
		value = v;
		frequency = f;
	}
	
	public HuffmanNode(String v)
	{
		value = v;
	}
	
	public int frequency()
	{
		return frequency;
	}
	
	public void setFrequency(int f)
	{
		frequency = f;
	}
		
	public String value()
	{
		return value;
	}
	
	public void setValue(String v)
	{
		value = v;
	}
	
	public HuffmanNode left()
	{
		return left;
	}
	
	public void setLeft(HuffmanNode l)
	{
		left = l;
	}
	
	public HuffmanNode right()
	{
		return right;
	}
	
	public void setRight(HuffmanNode r)
	{
		right = r;
	}
	
	public int compareTo(Object o)
	{
		return frequency - ((HuffmanNode)o).frequency();
	}
	
	//make constructor
	
}
