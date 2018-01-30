package zad2;

public class Zad2 {
	public static void main(String[] args) {
		String a, b;
		int n;
		a = args[0];
		b = args[1];
		n = Integer.parseInt(args[2]);


		String[] sc = new String[n];
		sc[0] = a;
		sc[1] = b;

		System.out.println(sc[0]);
		System.out.println(sc[1]);
		
		for(int i=2; i<n; i++){
			sc[i] = sc[i-1].concat(sc[i-2]);
			System.out.println(sc[i]);
		}

	}

}
