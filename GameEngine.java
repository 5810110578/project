/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoriginal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Timer;


public class GameEngine implements KeyListener, GameReporter{
	GamePanel gp;
		
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();	
	private SpaceShip v;	
	
	private Timer timer;
	
	private long score = 0;
	private double difficulty = 0.1;
	private double num = 0;
        
        private int a=0;
	public GameEngine(GamePanel gp, SpaceShip v) {
		this.gp = gp;
		this.v = v;		
		
		gp.sprites.add(v);
		
		timer = new Timer(50, new ActionListener() {//หน่วงเวลาการเขียนข้อมูลใหม่
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				process();
                                
			}
		});
		timer.setRepeats(true);//มาครั้งเดียว
                timer.start();
		
	}
	
	public void start(){
            
		timer.start();
	}
	
	private void generateEnemy(){
		Enemy e = new Enemy((int)(Math.random()*390), 20);
		gp.sprites.add(e);
		enemies.add(e);
	}
	
	private void process(){
		if(Math.random() < difficulty){
			generateEnemy();
		}
		
		Iterator<Enemy> e_iter = enemies.iterator();
		while(e_iter.hasNext()){
			Enemy e = e_iter.next();
			e.proceed();
			num++;                     
                        
			if(!e.isAlive()){
				e_iter.remove();
				gp.sprites.remove(e);
                                
                                    score += 10;
                                
			}
                        if(num%50==0){
                            difficulty += 0.01;
                        }
		}
		if(a==0){
                    gp.updateGameUI(this);
                }
                
		Rectangle2D.Double vr = v.getRectangle();
		Rectangle2D.Double er;
		for(Enemy e : enemies){
			er = e.getRectangle();
			if(er.intersects(vr)){
                               a = 1;
				die();
                                
				return ;
			}
		}
	}
	
	public void die(){
		timer.stop();
               
                
	}
	
	void controlVehicle(KeyEvent e) {//ตัวรับคีย์ที่กด 
            if(a==0){
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			v.move(-1);
			break;
		case KeyEvent.VK_RIGHT:
			v.move(1);
			break;
                case KeyEvent.VK_UP:
			v.move1(-1);
			break;
		case KeyEvent.VK_DOWN:
			v.move1(1);
			break;        
		case KeyEvent.VK_O://เริ่ม
			timer.start();
			break;
                case KeyEvent.VK_P://หยุด
			timer.stop();
			break;  
		}
            }
            else if (a==1){
                switch (e.getKeyCode()) {
                    
                }
            }
	}

	public long getScore(){
            
		return score;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {//ทำงานเมื่อกด คีย์บอร์ด
		controlVehicle(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {//ทำเมื่อปล่อย
		//do nothing
	}

	@Override
	public void keyTyped(KeyEvent e) {//
		//do nothing		
	}
}
