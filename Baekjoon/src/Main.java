import java.io.IOException;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] a = {1,2,3};
		int[] b = a;
		b[0] = 10;
		int[] c = a.clone();
		c[0] = 20;

		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.toString(c));
	}

}