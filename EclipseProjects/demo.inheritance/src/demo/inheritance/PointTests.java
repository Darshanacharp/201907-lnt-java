package demo.inheritance;

import static org.junit.Assert.*;

import org.junit.Test;

public class PointTests {

	@Test
	public void point_isATypeOfPoint() {
		Point p=new Point();
		
		assertTrue(p instanceof Point);
	}
	
	
	@Test
	public void new_pointInitializesXandY() {
		Point p=new Point(3,4);
		assertEquals(3, p.getX(),0);
		assertEquals(4, p.getY(),0);
		
		//assertEquals("Point(3,4)", p.info());
	}
	
	@Test
	public void new_pointDefaultsToOrigin() {
		Point p=new Point();
		assertEquals(0, p.getX(), 0);
		assertEquals(0, p.getY(), 0);
		
	}
	
	@Test
	public void distance_shouldBe5ForFromOrginToPoint3_4() {
		Point p=new Point(3,4);
		Point origin=new Point();
		
		double distance= origin.distance(p);
		
		assertEquals(5, distance, 0.01);
	}
	
	@Test
	public void slope_shouldBeYByX() {
		Point p=new Point(3,4);
		double s=p.slope();
		
		assertEquals(4/3.0, s,0.01);
		
		
	}
	
	@Test
	public void equals_twoPointsWithSameXandYshouldBeEqual() {
	
		Point p1=new Point(3,4);
		Point p2=new Point(3,4);
		
		//calls p1.equals(p2)
		assertEquals(p1, p2);
		
		
	}
	
	@Test
	public void same_twoPointsWithSameXandYshouldNotBeSame() {
	
		Point p1=new Point(3,4);
		Point p2=new Point(3,4);
		
		//calls p1!=p2 --> reference equal
		assertNotSame(p1, p2);
		
		
	}
	
	@Test
	public void same_assignmentDoesntDuplicateAnObject() {
		Point p1=new Point(3,4);
		Point p2=p1;
		
		assertSame(p1,p2);
		assertEquals(p1, p2);
		
	}
	
	
	@Test
	public void clone_shouldDuplicateAnObject() throws CloneNotSupportedException {
		
		Point p1=new Point(3,4);
		Point p2=p1.clone();
		
		assertEquals(p1,p2); //values should be same
		assertNotSame(p1, p2); //should not be same object ---> its an exact replica of original
	}
	
	
	
	

}
