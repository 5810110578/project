/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoriginal;



import java.awt.Color;
import java.awt.Graphics2D;

public class SpaceShip extends Sprite{

	int step = 8;
	
	public SpaceShip(int x, int y, int width, int height) {
		super(x, y, width, height);
		
	}

	@Override
	public void draw(Graphics2D g) {//วาดยานเรา สีเขียว ตำแหน่งx y ขนาด w*d
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
	}

	public void move(int direction){//เอาไว้เปลี่ยนตำแหน่งแกน x 
		x += (step * direction);
		if(x < 0)
			x = 0;
		if(x > 400 - width)
			x = 400 - width;
	}
        public void move1(int direction){//เอาไว้เปลี่ยนตำแหน่งแกน x 
		y += (step * direction);
		if(y < 0)
			y = 0;
		if(y > 600 - width)
			y = 600 - width;
	}


}
