public class Test {
    public static void main(String[] args) {
        Test object = new Test();

        object.bbb("January", 4);
    }

	public void bbb(String s, int p)
	{
        if (p >= 0)
	  {
           System.out.print(s.substring(p,p+1));
           bbb(s,p-1);
	  }
	}
}