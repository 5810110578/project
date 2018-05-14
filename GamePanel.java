
package gameoriginal;



import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
	
	private BufferedImage bi;
        
	Graphics2D big;
        
        private int a;
        private int b;
        private  BasicBlocks bb;
        
	ArrayList<Sprite> sprites = new ArrayList<Sprite>();
        

	public GamePanel() {
		bi = new BufferedImage(400, 600, BufferedImage.TYPE_INT_ARGB);//8-bit RGBA color 
              
		big = (Graphics2D) bi.getGraphics();
                
		big.setBackground(Color.CYAN);
                
                bb = new BasicBlocks(180,70);
               
	}

	public void updateGameUI(GameReporter reporter){
		big.clearRect(0, 0, 400, 600);//กำหนดการclear ค่า บนกระดาน บน ซ้าย ขวา ล่าง
		
		big.setColor(Color.RED);            
		big.drawString(String.format("Score1 : "+"%05d", reporter.getScore()), 135, 35);//เขียนคะแนน
		for(Sprite s : sprites){
			s.draw(big);
                       
		}
                
		
		repaint();
	}
        
        public void updateGameUI1(GameReporter1 reporter1){
		big.clearRect(0, 0, 400, 600);//กำหนดการclear ค่า บนกระดาน บน ซ้าย ขวา ล่าง
		
		big.setColor(Color.BLACK);
                
		big.drawString(String.format("Score2 : "+"%05d", reporter1.getScore1()), 135, 55);//เขียนคะแนน
		for(Sprite s : sprites){
			s.draw(big);
		}
		
		repaint();
	}
        
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
                
		g2d.drawImage(bi, null, 0, 0);
               
                g.drawString("คะแนนผู้เล่นสูงสุด " , 150, 15);
                bb.draw(g2d);
	}
        

}
