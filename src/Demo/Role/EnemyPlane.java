package Demo.Role;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

import Demo.Data.Data;
import Demo.Util.ReadImageUtil;

public class EnemyPlane extends GameObject{
	
	boolean isBOSS;//判断是否是BOSS
	ConcurrentLinkedQueue<Shell> enemyShells;//所有敌人发射的导弹都会放在这个集合里
	private int imgNum=1;
	private int round;//关卡
	/**
	 * 一般敌机
	 * @param x
	 * @param y
	 * @param degree
	 * @param kind//飞机类型 0~5
	 * @param round
	 * @param enemyShells//导弹集合，便于画出敌人的导弹
	 * 
	 */
	public EnemyPlane(int x,int y,double degree,int kind,int round,ConcurrentLinkedQueue<Shell> enemyShells) {
		super.x=x;
		super.y=y;
		super.width=Data.ENEMY_PlANE_WIDTH;
		super.height=Data.ENEMY_PlANE_HEIGHT;
		super.speed=Data.ENEMY_PLANE_SPEED;
		super.frozen_speed=Data.ENEMY_PLANE_SPEED/2;
		super.degree=degree;
		super.live=true;
		super.image=ReadImageUtil.getEnemyPlaneImg(kind);
		super.max_blood=(int) (Data.ENEMY_PLANE_BLOOD*Math.pow(2, round));
		super.blood=max_blood;
		super.exp=super.blood;//击毁敌机的经验数等于血量
		super.kind=kind;
		this.round=round;
		this.enemyShells=enemyShells;
	}
	/**
	 * BOSS
	 * @param x
	 * @param y
	 * @param degree
	 * @param kind
	 * @param enemyShells
	 */
	public EnemyPlane(ConcurrentLinkedQueue<Shell> enemyShells,int kind,boolean islive) {
		super.x=Data.BOSS_POSITION_X;
		super.y=Data.BOSS_POSITION_Y;
		super.width=Data.BOSS_WIDTH;
		super.height=Data.BOSS_HEIGHT;
		super.speed=Data.BOSS_SPEED;
		super.frozen_speed=Data.BOSS_SPEED/2;
		super.degree=0;
		super.live=islive;
		this.kind=kind;
		this.isBOSS=true;
		this.enemyShells=enemyShells;
		this.form=0;
		initBoss();
	}
	
	public void drawEnemyPlane(Graphics g) {
		isStillAlive();
		if(live) {
			speed=form==1?Data.BOSS_SPEED*2:Data.BOSS_SPEED;
				
			x+=speed*Math.cos(degree);
			y+=speed*Math.sin(degree);
			if(x<=0||x>=Data.WINDOW_WIDTH-width)
					degree=Math.PI-degree;
			if(y<=0||y>=Data.WINDOW_HEIGHT-height)
				degree=-degree;
			if(isBOSS&&Math.random()<Data.BOSS_CHANGE_PROBABILITY) {//改变boss形态
				form=(int)(Math.random()*imgNum);
				image=images[form];
			}
			fire();//发射导弹
			g.drawImage(image, x, y, width, height, null);
		}
	}
	private void fire() {
		if(!isBOSS) {
				if(Math.random()<Data.ENEMY_PLANE_FIRE_PROBABILITY)
					enemyShells.add(new Shell(x+width/2,y+height,Math.random()*Math.PI,kind,round));
			}else {
				if(enemyShells!=null&&Math.random()<Data.BOSS_FIRE_PROBABILITY) {
					if(kind==2) {
						for(int i=0;i<10;i++)
							enemyShells.add(new Shell(x+width/2,y+100,kind,form));
					}else {
						enemyShells.add(new Shell(x+width/2,y+height-50,kind,form));
					}
				}		
			}
	}
	
	public void initBoss() {
		if(kind==0) {
			width/=2;
		}
		if(kind==2) {
			degree=Math.random()*3/4*Math.PI+Math.PI/4;
			speed*=2;
		}
		super.blood=Data.BOSS_BLOOD[kind];
		super.max_blood=super.blood;
		super.exp=super.blood;//击毁敌机的经验数等于血量
		this.imgNum=Data.BOSS_FORM_NUM;
		super.images=new Image[imgNum];
		Iterator<Image> it=ReadImageUtil.bossImgs[kind].iterator();
		for(int i=0;it.hasNext();i++) {
			images[i]=it.next();
		}
		image=images[0];
	}
	
	private void isStillAlive() {
		live&=y>Data.WINDOW_HEIGHT+100||y<-100?false:true;
	}
}
