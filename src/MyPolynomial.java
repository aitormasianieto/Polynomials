import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyPolynomial {

	private double[] coeffs;
	
	public MyPolynomial(double... array) {
		
		coeffs = array;
	}
	
	public MyPolynomial(String filename) { 
		
		Scanner in = null; 
		
		  try { 
		      in = new Scanner(new File(filename));  // open file 
		   } 
		  catch (FileNotFoundException e) { 
		      e.printStackTrace(); 
		   } 
		  
		   int degree = in.nextInt();      // read the degree 
		   coeffs = new double[degree+1];  // allocate the array 
		   for (int i= 0; i< coeffs.length; ++i) { 
		      coeffs[i] = in.nextDouble(); 
		   }
	} 
	
	public double getDegree() {
		
		return coeffs[coeffs.length-1];
	}
	
	public String toString() {
		
		String s = "";
		
		if (coeffs[coeffs.length-1] != 0.0) {
			s = coeffs[coeffs.length - 1] + "X^" + (coeffs.length - 1);
		}
		
		for (int i= coeffs.length - 2; i> 1; i--) {
			if (coeffs[i] != 0.0) {
				if (coeffs[coeffs.length -1] == 0.0)
					s += coeffs[i] + "X^" + i;
				}
				else {
					s += " + " + coeffs[i] + "X^" + i;
				}	
		}
		
		if (coeffs[1] != 0.0) {
			s += " + " + coeffs[1] + "X";
		}
		
		if (coeffs[0] != 0.0) {
			s += " + " + coeffs[0];
		}
		return s;
	}

	public double evaluate(double x) {
		double r = 0;
		
		for (int i= 0; i< coeffs.length; i++) {
			r += coeffs[i] * Math.pow(x, i);
		}
		return r;
	}
	
	public MyPolynomial add(MyPolynomial pol2) {
		
		int newDegree = (int)Math.max(getDegree(), pol2.getDegree());
		double[] newCoeffs = new double[newDegree];
		
		if (coeffs.length > pol2.coeffs.length) {
			for (int i= 0; i< coeffs.length; i++) {
				newCoeffs[i] = coeffs[i];
			}			
			for(int i= 0; i < pol2.coeffs.length; i++) {
				newCoeffs[i] += pol2.coeffs[i];			
			}
		}
		else {
			for (int i= 0; i< pol2.coeffs.length; i++) {
				newCoeffs[i] = pol2.coeffs[i];
			}	
			
			for(int i= 0; i<  coeffs.length; i++) {
				newCoeffs[i] += coeffs[i];			
			}
		}		
		
		MyPolynomial newPol = new MyPolynomial(newCoeffs);
		
		return newPol;
	}
	
}

//declarar, instanciar, inicializar