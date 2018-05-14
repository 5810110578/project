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


public class GameEngine2 implements KeyListener, GameReporter1{
	GamePanel gp;
		
	private ArrayList<Enemy1> enemies = new ArrayList<Enemy1>();	
	private SpaceShip2 v1;	
	
	private Timer timer;
	
	private long score1 = 0;
	private double difficulty = 0.1;
	private double num = 0;
        private int a=0;
        private double b=0;
        
	public GameEngine2(GamePanel gp, SpaceShip2 v1) {
		this.gp = gp;
		this.v1 = v1;		
		
		gp.sprites.add(v1);
		
		timer = new Timer(50, new ActionListener() {//หน่วงเวลาการเขียนข้อมูลใหม่
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				process();
			}
		});
                timer.start();
		timer.setRepeats(true);//มาครั้งเดียว
               
                
		
	}


	
	public void start(){
		timer.start();
	}
	
	private void generateEnemy1(){
		Enemy1 e = new Enemy1((int)(Math.random()*390), 20);
		gp.sprites.add(e);
		enemies.add(e);
	}
	
	private void process(){
		if(Math.random() < difficulty){
			generateEnemy1();
		}
		
		Iterator<Enemy1> e_iter = enemies.iterator();
		while(e_iter.hasNext()){
			Enemy1 e = e_iter.next();
			e.proceed();
			num++;
			if(!e.isAlive()){
				e_iter.remove();
				gp.sprites.remove(e);
				score1 += 100;
			}
                        if(num%50==0){
                            difficulty += 0.01;
       
                        }
		}
		if(a==0){
                    gp.updateGameUI1(this);
                    
                }
                
		Rectangle2D.Double vr = v1.getRectangle();
		Rectangle2D.Double er;
		for(Enemy1 e : enemies){
			er = e.getRectangle();
			if(er.intersects(vr)){
                                a = 1;
				die();
                                return;
			}
		}
	}
	
	public void die(){
		timer.stop();
                
	}
        
	
	void controlVehicle(KeyEvent e) {//ตัวรับคีย์ที่กด 
		
                if(a==0){
		switch (e.getKeyCode()) {
		case KeyEvent.VK_A:
			v1.move(-1);
			break;
		case KeyEvent.VK_D:
                        v1.move(1);
			break;
                case KeyEvent.VK_W:
			v1.move1(-1);
			break;
		case KeyEvent.VK_S:
			v1.move1(1);
			break;        
		case KeyEvent.VK_Q://
			timer.start();
                        break; 
                case KeyEvent.VK_E://
			timer.stop();
			break;        
		}
                }
                else if (a==1){
                    switch (e.getKeyCode()) {
                    
                    }
                }
                
	}

	public long getScore1(){
		return score1;
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
