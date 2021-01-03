public class TestPlanet {
	public static void main(String[] args) {
		Planet a = new Planet(1.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");
		Planet b = new Planet(2.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");	
		System.out.print(a.calcForceExertedBy(b));
	}
}