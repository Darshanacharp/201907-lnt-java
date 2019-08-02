package demo.inheritance;

import org.junit.Test;
import static org.junit.Assert.*;

public class Point3DTests {

	@Test
	public void point3D_isATypeOfPoint() {
		Point3D p3=new Point3D();
		
		assertTrue(p3 instanceof Point);
	}
	
	@Test public void Point3d_hasXAndY() {
		Point3D p3=new Point3D();
		p3.setX(3);
		p3.setY(4);		
		assertEquals("Point(3.0,4.0,0.0)", p3.info());
		
	}
	
	@Test public void constructor_TwoArgumentConstructorIsNotInherited() {
		
		//Point3D p=new Point3d(x,y);
		//The code will not compile if you uncomment the above line
	}
	
	@Test public void subclassObjectCanReplaceSuperClassObject() {
		Point p1=new Point(3,4);		
		Point3D origin=new Point3D();		
		double d= p1.distance(origin); //Point3D object passed for Point object
		
		assertEquals(5,d,0.01);
	}
	
	@Test public void superClassMethodsAreSubClassMethods() {
		Point p=new Point(3,4);
		
		Point3D origin=new Point3D();
		
		double d= origin.distance(p);
		
		assertEquals(5,d,0.01);
	}
	
	
	@Test public void new_point3DconstructorCanUsePoint2DConstructor() {
		Point3D p3=new Point3D(3,4,5);
		assertEquals(3, p3.getX(),0);
		assertEquals(4, p3.getY(),0);
	}
	
	@Test public void getZ_subClassCanCreateAddBehaviors() {
		Point3D p3=new Point3D(3,4,5);
		
		assertEquals(5, p3.getZ(),0);
	}
	
	@Test public void distance_canOverrideExistingBehavior() {
		Point p=new Point3D(3,4,5);
		Point origin=new Point();
		double d= origin.distance(p);
		double d2=p.distance(origin);
		
		assertEquals(Math.sqrt(50), d, 0.1);
	}
	
	@Test
	public void info_returnsUpdatedInfo() {
		Point3D p3=new Point3D(3,4,5);
		System.out.println(p3.info());
		assertEquals("Point3D(3.0,4.0,5.0)",p3.info());
	}
}
