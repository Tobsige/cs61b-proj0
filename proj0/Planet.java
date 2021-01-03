public class Planet {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	public Planet(double xP, double yP, double xV,
              double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p) {
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet pl) {
 		double dx = this.xxPos - pl.xxPos;
 		double dy = this.yyPos - pl.yyPos;
 		double d = Math.sqrt(dx * dx + dy * dy);
 		
 		return d;
	} 

	public double calcForceExertedBy(Planet pla) {
		double r = this.calcDistance(pla);
		double m1 = this.mass, m2 = pla.mass, force = 6.67e-11 * m1 * m2 / r / r;
		return force;
	}

	public double calcNetForceExertedByX(Planet[] all) {
		double fx = 0;
		for(int i = 0; i < all.length; i++){		
				if (this.equals(all[i])){
					continue;
				}
				double dx = -(this.xxPos - all[i].xxPos);
				double r = this.calcDistance(all[i]), f = this.calcForceExertedBy(all[i]);
				fx += f * dx / r; 
		}
		//if (fx < 0) fx = -fx;
		return fx;
	}

	public double calcNetForceExertedByY(Planet[] all) {
		double fy = 0;
		for(int i = 0; i < all.length; i++){
				if (this.equals(all[i])) {
					continue;
				}
				double dy = -(this.yyPos - all[i].yyPos);
				double r = this.calcDistance(all[i]), f = this.calcForceExertedBy(all[i]);
				fy += f * dy / r;
		}
		//if (fy < 0) fy = -fy; 
		return fy;
	}

	public void update(double dt, double dfx, double dfy) {
		double ax = dfx / this.mass, ay = dfy / this. mass;
		this.xxVel += ax * dt;
		this.yyVel += ay * dt;
		this.xxPos += this.xxVel * dt;
		this.yyPos += this.yyVel *dt;
	}

	public void draw() {
		String imagePath = "./images/" + this.imgFileName;
		StdDraw.picture(this.xxPos/(NBody.r)*100, this.yyPos/(NBody.r)*100, imagePath);	
	}

}