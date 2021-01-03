public class NBody {
	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]); 
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		String backGround = "./images/starfield.jpg";

		double r = readRadius(filename);
		int num = readPlanets(filename).length;
		Planet[] planets = new Planet[num]; 
		System.arraycopy(readPlanets(filename), 0, planets, 0, num);
		/**animation*/

		double Tt = T / dt;
		int intT = (int)Tt;
		double[] xForces = new double[num], yForces = new double[num];
		Planet[] bodies = planets; 

		StdDraw.setScale(-r, r);
		StdDraw.enableDoubleBuffering();

		for(int k = 0; k < intT; k++) {
			for(int i = 0; i < num; i++) {
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
		}
			StdDraw.clear();
			StdDraw.picture(0, 0, backGround);
			for(int a = 0; a < num; a++){
				planets[a].draw();
				planets[a].update(dt, xForces[a], yForces[a]);
			}
			StdDraw.show();
			StdDraw.pause(10);
		}
		
		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", r);
		for (int i = 0; i < planets.length; i++) {
    	StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
		}
	}
/**ger the radius of universe*/
	public static double readRadius(String fileName) {
		In in = new In(fileName);
		int number = in.readInt();
		double radius = in.readDouble();
		return radius;
	}
/**get the planets in the txt*/
	public static Planet[] readPlanets(String fileName) {
		In in = new In(fileName);
		int number = in.readInt();
		Planet[] planets = new Planet[number];
		double radius = in.readDouble();

		for(int i = 0; i < number; i++){
			planets[i] = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readString());
		}

		return planets;
	}
}