package Demo.Role;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Iterator;

import Demo.Data.Data;
import Demo.Util.ReadImageUtil;

public class Shell extends GameObject{
	public int harm;
	private boolean rebound;//导弹到边界是否反弹
	public int kind;
	public int form;
	/**
	 * 玩家飞机导弹构造器
	 * @param x
	 * @param y
	 * @param degree
	 */
	public Shell(int x,int y,int harm,double degree,int kind) {
		super.x=x;
		super.y=y;
		super.degree=degree;
		super.image=ReadImageUtil.getPlayerShellImg(kind);
		super.width=Data.PLAYER_SHELL_WIDTH;
		super.height=Data.PLAYER_SHELL_HEIGHT;
		super.speed=Data.PLAYER_SHELL_SPEED;
		super.live=true;
		this.harm=harm;
		this.kind=kind;//4原子弹
		initPlayerShell();
	}
	/**
	 * 一般敌机导弹构造器
	 * @param x
	 * @param y
	 * @param degree
	 * @param kind
	 */
	public Shell(int x,int y,double degree,int kind,int round) {
		super.x=x;
		super.y=y;
		super.degree=degree;
		super.image=ReadImageUtil.getEnemyShellImg(kind);
		super.width=Data.ENEMY_SHELL_WIDTH;
		super.height=Data.ENEMY_SHELL_HEIGHT;
		super.speed=Data.ENEMY_SHELL_SPEED;
		super.live=true;
		this.harm=Data.ENEMY_SHELL_HARM*(round+1);
		this.kind=kind;
	}
	/**
	 * BOSS
	 * @param x
	 * @param y
	 */
	public Shell(int x,int y,int kind,int form) {
		super.x=x;
		super.y=y;
		super.width=Data.BOSS_SHELL_WIDTH;
		super.height=Data.BOSS_SHELL_HEIGHT;
		super.speed=Data.BOSS_SHELL_SPEED;
		super.degree=Math.PI/2;
		super.live=true;
		super.isBoss=true;
		this.kind=kind;
		this.form=form;
		this.harm=Data.BOSS_SHELL_HARM;
		super.images=new Image[Data.BOSS_FORM_NUM];
		Iterator<Image> it=ReadImageUtil.bossShellImgs[kind].iterator();
		for(int i=0;i<Data.BOSS_FORM_NUM&&it.hasNext();i++) {
			images[i]=it.next();
		}
		initBossShell();
	}

	
	public void initPlayerShell() {
		switch(kind) {
		case 0:
			
			break;
		case 1:

			break;
		case 2:

			break;
		case 3:

			break;
		case 4:
			super.image=ReadImageUtil.atomicBombImg;
		}
	}
	
	public void initBossShell() {
		super.width=Data.BOSS_ONE_SHELL_WIDTH;
		super.height=Data.BOSS_ONE_SHELL_WIDTH;
		 super.image=super.images[form];
		switch(kind) {
			case 0://boss1
				switch(form) {
					case 0:	//篮球炮弹
						super.degree=Math.random()*Math.PI;
						this.rebound=true;
						break;
					case 1://足球炮弹
						super.speed=Data.BOSS_SHELL_SPEED*4;
						break;
					case 2://炸弹
						if(Math.random()<0.5) {//调整炸弹出现的概率为2.5%
							super.live=false;
							return;
						}
						super.speed=Data.BOSS_SHELL_SPEED/2;
						this.harm*=8;
						break;
					case 3://美队盾牌
						this.harm*=2;
						super.speed=(int) (Data.BOSS_SHELL_SPEED*1.5);
						super.degree=Math.random()*Math.PI;
						break;
					default:
				}
				break;
			case 1:
				switch(form) {
					case 0://猫爪
						super.speed*=5;
						break;
					case 1://减速
						super.speed/=2;
						break;
					case 2://普通攻击
						rebound=true;  
						break;
					case 3://乌鸦坐飞机
						x=Data.WINDOW_WIDTH;
						y=(int) (Data.WINDOW_HEIGHT-Math.random()*600);
						degree=Math.PI;
						harm*=5;
						break;
					default:
				}
				break;
			case 2:
				degree=Math.random()*2*Math.PI;
				image=images[0];
				width/=2;
				height/=2;
				switch(form) {
					case 0:
					
						break;
					case 1:
					
						break;
					case 2:
					
						break;
					case 3:
					
						break;
					default:
				}
				break;
			case 3:
				switch(form) {
					case 0:
					
						break;
					case 1:
					
						break;
					case 2:
					
						break;
					case 3:
					
						break;
					default:
				}
				break;
			default:
		}
	}
	
	
	
	
	
	
	/**
	 * 画玩家导弹
	 * @param g
	 */
	public void drawPlayerShell(Graphics g) {
		live=live&isStillAlive();//判断该导弹是否出界
		if(live) {
			y-=speed;
			g.drawImage(image, x, y, width, height, null);
		}
	}
	/**
	 * 画敌人导弹
	 */
	public void drawEnemyShell(Graphics g) {
		live=live&isStillAlive();//判断该导弹是否出界
		if(live) {
			x+=speed*Math.cos(degree);
			y+=speed*Math.sin(degree);
			if(rebound) {
				if(x<=0||x>=Data.WINDOW_WIDTH-width)
					degree=Math.PI-degree;
				if(y>=Data.WINDOW_HEIGHT-height)
					degree=-super.degree;
			}
			g.drawImage(image, x, y, width, height, null);
		}
	}
	/**
	 * 判断该导弹是否出界
	 * @param x
	 * @param y
	 * @return
	 */
	private boolean isStillAlive() {
		if(x<0||x>Data.WINDOW_WIDTH||y<0||y>Data.WINDOW_HEIGHT)
			return false;
		return true;
	}

}
