
public class MainClassPolynomial {

	public static void main(String[] args) {
		
		MyPolynomial pol = new MyPolynomial(1, 3, 2);
		System.out.println(pol);
		System.out.println(pol.evaluate(2));
		
		System.out.println();
		
		MyPolynomial pol2 = new MyPolynomial("Polyfile.txt");
		System.out.println(pol2);
		
		System.out.println();
		
		MyPolynomial pol3 = pol.add(pol2);
		System.out.println(pol3);
	}

}
