package fundamentos;

public class DesafioVariaveisConstantes {

	public static void main(String[] args) {
		final double x = 32;
		final double y = 5.0 / 9;
		double C;
		double F = 90;
		
		
		C = (F - x) * y;
		
		System.out.println("O resultado é : " + C + " °C" );

//		(°F - 32) x 5/9 = °C
	}

}
