public class HuffmanRunner
{
	public static void main(String[] args)
	{
		HuffmanNode test = new HuffmanNode("b", 5);
		test.setValue("c");
		test.setFrequency(6);
		System.out.println(test.value());
		System.out.println(test.frequency());
		HuffmanNode test2 = new HuffmanNode("d", 10);
		System.out.println(test.compareTo(test2));
		HuffmanTree tree = new HuffmanTree("The Bluebook blamed blue Brian");
		System.out.println(tree.encode("The"));
		System.out.println(tree.decode("1110001111110"));
		System.out.println(tree);
	}
}
