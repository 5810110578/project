package gameoriginal;


import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args){
		JFrame frame = new JFrame("Space War");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 650);
		frame.getContentPane().setLayout(new BorderLayout());
		
		SpaceShip v = new SpaceShip(200, 550, 20, 20);//ตัวกำหนดขนาดของยานเรา
                SpaceShip2 v1 = new SpaceShip2(160, 550, 20, 20);
                
		GamePanel gp = new GamePanel();//เอาไว้วาดข้อมูลลงหน้าต่าง
                
		GameEngine engine = new GameEngine(gp, v);
                GameEngine2 engine1 = new GameEngine2(gp, v1);
		frame.addKeyListener(engine);
                frame.addKeyListener(engine1);
		frame.getContentPane().add(gp, BorderLayout.CENTER);
		frame.setVisible(true);
		
		engine.start();
	}
}
