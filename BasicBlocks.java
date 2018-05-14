/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoriginal;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

public class BasicBlocks {
    private int num;
    private int num2;
    
    public BasicBlocks(int x, int y) {
       num = x;
       num2 = y;
    }

   
    public void draw(Graphics2D g) {
        
        g.setColor(Color.YELLOW);
                
	g.fillRect(num, num2, 40, 40);
    }

	
}