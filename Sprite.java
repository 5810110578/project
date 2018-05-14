
package gameoriginal;


import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;

public abstract class Sprite {
	int x;
	int y;
	int width;
	int height;
        boolean allve;
	
	public Sprite(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	abstract public void draw(Graphics2D g);//import Graphics2D

	public Double getRectangle() {
		return new Rectangle2D.Double(x, y, width, height);//วาด 4 เหลี่ยม
	}
        
        public boolean isAllve(){
            return allve;
        }
      
}
