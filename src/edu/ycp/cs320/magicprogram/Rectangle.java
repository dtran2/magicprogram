
package edu.ycp.cs320.magicprogram;

/**
 * Instances of this class represent rectangle with a given
 * top left point and given width and height.
 * They can be moved by setting a new top left point,
 * and resized by setting new width/height values.
 * 
 * Important: note that y coordinates increase in the down
 * direction and decrease in the up direction.
 * 
 * @author David Hovemeyer
 */
public class Rectangle {
	// TODO: add fields
	//Rectangle myRectangle;
	Point topLeft;
	double width, height;
	/**
	 * Constructor.
	 * 
	 * @param topLeft the top left corner of the rectangle
	 * @param width   the width of the rectangle
	 * @param height  the height of the rectangle
	 */
	public Rectangle(Point topLeft, double width, double height) {
		//throw new UnsupportedOperationException("TODO - implement");
		this.topLeft = topLeft;
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Get the top left point of the rectangle.
	 * 
	 * @return the top left point of the rectangle
	 */
	public Point getTopLeft() {
		//throw new UnsupportedOperationException("TODO - implement");
		Point topLeft = this.topLeft;
		return topLeft;
	}
	
	/**
	 * Set the top left point of the rectangle.
	 * 
	 * @param topLeft the (new) top left point of the rectangle
	 */
	public void setTopLeft(Point topLeft) {
		//throw new UnsupportedOperationException("TODO - implement");
		this.topLeft = topLeft;
	}
	
	/**
	 * Get the current width of the rectangle.
	 * 
	 * @return the current width of the rectangle
	 */
	public double getWidth() {
		//throw new UnsupportedOperationException("TODO - implement");
		double width = this.width;
		return width;
	}
	
	/**
	 * Set the width of the rectangle.
	 * 
	 * @param width the (new) width of the rectangle
	 */
	public void setWidth(double width) {
		//throw new UnsupportedOperationException("TODO - implement");
		this.width = width;
	}
	
	/**
	 * Get the current height of the rectangle.
	 * 
	 * @return the current height of the rectangle
	 */
	public double getHeight() {
		//throw new UnsupportedOperationException("TODO - implement");
		double height = this.height;
		return height;
	}
	
	/**
	 * Set the height of the rectangle.
	 * 
	 * @param height the (new) height of the rectangle
	 */
	public void setHeight(double height) {
		//how new UnsupportedOperationException("TODO - implement");
		this.height = height;
	}

	/**
	 * Determine whether the given circle either completely or partially
	 * overlaps this rectangle.
	 * 
	 * @param circle  a circle
	 * @return true if the circle completely or partially overlaps the rectangle,
	 *         false if there is no overlap
	 */
	//@SuppressWarnings("null")
	public boolean overlaps(Circle circle) {
		//throw new UnsupportedOperationException("TODO - implement");
		//initialize corners of rectangle
//		boolean does_overlap = false;
//		int count = 0;
		Point topRight = new Point (0, 0), botLeft = new Point (0, 0), botRight = new Point (0, 0);
		topRight.x = this.topLeft.x + this.width;
		topRight.y = this.topLeft.y;
		botLeft.x = this.topLeft.x;
		botLeft.y = this.topLeft.y + this.height;
		botRight.x = this.topLeft.x + this.width;
		botRight.y = this.topLeft.y + this.height;
		
		
//This was my original attempt at testing for overlap which passed the easy test but failed the hard test
		
		
		//check if circle pierces left or right side of rectangle and corners
//		if( ( (circle.getCenter().x + circle.getRadius() ) >= this.topLeft.x) && ( (circle.getCenter().x - circle.getRadius() ) <= (this.topLeft.x + this.width) ) && ( ( circle.getCenter().y - circle.getRadius() ) <= (this.topLeft.y + this.height) ) && ( (circle.getCenter().y + circle.getRadius() ) >= this.topLeft.y ) ) {
//			does_overlap = true;
//			count++;
//		}
//		//check to see if circle pierces top or bottom side of rectangle and corners
//		if( ( (circle.getCenter().y + circle.getRadius() ) >= this.topLeft.y ) && ( (circle.getCenter().y - circle.getRadius() ) <= (this.topLeft.y + this.height) ) && ( (circle.getCenter().x - circle.getRadius()) <= (this.topLeft.x + this.width) ) && ( (circle.getCenter().x + circle.getRadius()) >= this.topLeft.x ) ) {
//			does_overlap = true;
//			count++;
//		}
//		if(count == 2) {
//			if( (circle.center.distanceTo(this.topLeft) > circle.getRadius() ) && (circle.center.distanceTo(topRight) > circle.getRadius()) && (circle.center.distanceTo(botLeft) > circle.getRadius()) && (circle.center.distanceTo(botRight) > circle.getRadius()) ) {
//				does_overlap = false;
//			}
//		}
		
//Here is the revised attempt, a loop which iterates through every portion of the rectangle and checks against the radius of the circle
//Jeremy Halberstam advised me to add the return false at the end to complete the method. I couldn't figure out why it wouldn't run
//but it was because in the case where the circle doesn't overlap, this method still needs to return a boolean value
		
		for(double row = 0; row < topRight.x; row++) {
			for(double col = 0; col < botRight.y; col++) {
				Point perimeter = new Point(row, col);
				double overlap_distance = circle.center.distanceTo(perimeter);
				//if overlap distance is less than the radius, it overlaps
				if(overlap_distance <= circle.radius) {
					return true;
				}
			}
		}
		//otherwise, it doesn't
		return false;
	}
}
