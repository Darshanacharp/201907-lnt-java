package demo.inheritance;

public class Point3D 
		extends Point{
	
	double z;	
	public Point3D(double x,double y, double z){
		super(x,y); //must be first line in constructor
		
		this.z=z;
	}
	
	public Point3D() {
		super(0,0);
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}
	
	
	
	
	@Override
	public double distance(Point p) {
		double dx= getX()-p.getX();
		double dy=getY()- p.getY();
		double dz=z;
		if(p instanceof Point3D) {
			Point3D p3=(Point3D) p;
			dz-=p3.z;
		}
		
		return Math.sqrt(dx*dx+dy*dy+dz*dz);
	}
	
	//override and re-use
	@Override
	public String info() {
		//I wan't to use info generated by super class
		String p2= super.info(); //call the super calss info
		
		//p2 = Point(3.000000,4.000000)
		
		//then add the z parameter
		return p2.replace("(", "3D(").replace(")", ","+z+")");
	}
	
	@Override
	public Point3D clone() throws CloneNotSupportedException {
		return (Point3D) super.clone();
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Point))
			return false;
		
		if(!(o instanceof Point3D))
			return super.equals(o); //Point equals
		
		Point3D p=(Point3D) o;
		
		return super.equals(p) && z==p.z;
	}
}


