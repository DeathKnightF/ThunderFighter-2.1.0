package Demo.Role;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

import Demo.Data.Data;

public class Crash {
	/**
	 * 判断敌机是否与玩家和玩家导弹发生碰撞，并画敌机
	 * @param player
	 * @param playerShells
	 * @param enemyPlanes
	 * @param explodes
	 * @param g
	 */
	public static void crash(PlayerPlane player,ConcurrentLinkedQueue<Shell> playerShells,
			ConcurrentLinkedQueue<EnemyPlane> enemyPlanes,
			ConcurrentLinkedQueue<Shell> enemyShells,
			ConcurrentLinkedQueue<Explode> explodes,
			Graphics g) {
		while(!enemyPlanes.isEmpty()) {
			EnemyPlane temp=enemyPlanes.peek();
			if(temp.live)
				break;
			enemyPlanes.poll();
		}
		while(!playerShells.isEmpty()) {
			Shell temp=playerShells.peek();
			if(temp.live)
				break;
			playerShells.poll();
		}
		Rectangle playerRect=player.getRectangle();
		Iterator<EnemyPlane> enemyPlanesIt=enemyPlanes.iterator();
		while(enemyPlanesIt.hasNext()) {
			EnemyPlane tempE=enemyPlanesIt.next();
			if(!tempE.live) 
				continue;
			Rectangle tempERect=tempE.getRectangle();
			if(tempERect.intersects(playerRect)) {//两飞机相撞
				if(tempE.isBOSS) {
					player.blood-=Data.BOSS_HARM;
				}else {
					tempE.live=false;
					player.blood-=10;
					explodes.add(new Explode(tempE.x, tempE.y, tempE.width, tempE.height,0));
					player.kills++;
					player.exp+=tempE.max_blood;
					int t=player.exp;
					player.upgrade();
					if(t!=player.exp)//升级
						explodes.add(new Explode(player.x, player.y, player.width, player.height, 3));
				}
				if(player.blood<=0) {
					player.live=false;
				}
					
			}
			Iterator<Shell> playerShellsIt=playerShells.iterator();
			while(playerShellsIt.hasNext()) {
				Shell tempS=playerShellsIt.next();
				if(!tempS.live)
					continue;
				if(tempS.kind==4) {//原子弹
					crash(tempS, player, playerShells, enemyPlanes, enemyShells, explodes);
					
					continue;
				}
				Rectangle tempSRect=tempS.getRectangle();
				if(tempSRect.intersects(tempERect)) {//玩家导弹攻击到敌方飞机
					tempS.live=false;
					tempE.blood-=tempS.harm;
					if(tempE.blood<=0) {//敌机死亡
						player.exp+=tempE.max_blood;
						player.kills++;
						tempE.live=false;
						int t=player.exp;
						player.upgrade();
						if(t!=player.exp)//升级
							explodes.add(new Explode(player.x, player.y, player.width, player.height, 3));
						explodes.add(new Explode(tempE.x, tempE.y, tempE.width, tempE.height,0));
					}
				}
			}
			tempE.drawEnemyPlane(g);
		}
		//画玩家导弹
		Iterator<Shell> playerShellsIt=playerShells.iterator();
		while(playerShellsIt.hasNext()) 
			playerShellsIt.next().drawPlayerShell(g);
	}
	/**
	 * 判断敌方导弹是否击中玩家，并画敌方导弹
	 * @param player
	 * @param enemyShells
	 * @param explodes
	 * @param g
	 */
	public static void crash(PlayerPlane player,ConcurrentLinkedQueue<Shell> enemyShells,
			ConcurrentLinkedQueue<Explode> explodes,Graphics g) {
		while(!enemyShells.isEmpty()) {
			Shell temp=enemyShells.peek();
			if(temp.live)
				break;
			enemyShells.poll();
		}
		Rectangle playerRect=player.getRectangle();
		Iterator<Shell> enemyShellsIt=enemyShells.iterator();
		while(enemyShellsIt.hasNext()) {
			Shell tempS=enemyShellsIt.next();
			if(!tempS.live)
				continue;
			Rectangle tempSRect=tempS.getRectangle();
			if(tempSRect.intersects(playerRect)) {//敌方导弹击中玩家
				tempS.live=false;
				player.blood-=tempS.harm;
				if(player.blood<=0) {
					player.live=false;
					explodes.add(new Explode(player.x, player.y, player.width, player.height,0));
				}
				judgeShellImpact(tempS, player,explodes);
			}
			tempS.drawEnemyShell(g);
		}
	}
	/**
	 * 判断玩家是否吃到道具
	 * @param player
	 * @param props
	 * @param g
	 */
	public static void crash(ConcurrentLinkedQueue<Prop> props,
			ConcurrentLinkedQueue<Explode> explodes,PlayerPlane player,Graphics g) {
		Rectangle playerRect=player.getRectangle();
		Iterator<Prop> propsIt=props.iterator();
		while(propsIt.hasNext()) {
			Prop tempP=propsIt.next();
			if(!tempP.live)
				continue;
			Rectangle tempPRect=tempP.getRectangle();
			if(tempPRect.intersects(playerRect)) {
				tempP.use();
				tempP.live=false;
				if(tempP.kind==1)
					explodes.add(new Explode(tempP.x, tempP.y, tempP.width, tempP.height, 4));
			}else
				tempP.drawProp(g);
		}
	}
	/**
	 * 原子弹
	 * @param atomicBomb
	 * @param player
	 * @param playerShells
	 * @param enemyPlanes
	 * @param enemyShells
	 * @param explodes
	 */
	public static void crash(Shell atomicBomb,PlayerPlane player,ConcurrentLinkedQueue<Shell> playerShells,
			ConcurrentLinkedQueue<EnemyPlane> enemyPlanes,ConcurrentLinkedQueue<Shell> enemyShells,
			ConcurrentLinkedQueue<Explode> explodes) {
		atomicBomb.harm--;//伤害当计时器用atomicBomb.harm>0&&
		if(atomicBomb.y>350)
			return;
		player.blood-=Data.ATOMIC_BOMB_HARM;
		atomicBomb.live=false;
		if(player.blood<=0)
			player.live=false;
		playerShells.clear();
		enemyShells.clear();
		Iterator<EnemyPlane> it=enemyPlanes.iterator();
		while(it.hasNext()) {
			EnemyPlane tempE=it.next();
			if(tempE.isBOSS&&tempE.live) {
				tempE.blood-=Data.ATOMIC_BOMB_HARM;
				if(tempE.blood<=0) {
					tempE.live=false;
					explodes.add(new Explode(tempE.x, tempE.y, tempE.width, tempE.height, 0));
				}
			}else {
				tempE.live=false;
			}
		}
		explodes.add(new Explode(atomicBomb.x-100, atomicBomb.y-200, 300, 300, 2));
	}
	//判断导弹的技能效果
	private static void judgeShellImpact(Shell temp,PlayerPlane player,
			ConcurrentLinkedQueue<Explode> explodes) {
		if(temp.isBoss) {
			switch(temp.kind) {
				case 0://boss1
					if(temp.form==3) {//眩晕
						player.state=2;
						player.duration=30;
					}
					break;
				case 1://boss2
					if(temp.form==1) {//减速
						player.state=1;
						player.duration=50;
					}
					if(temp.form==3) {//爆炸特效
						explodes.add(new Explode(temp.x, temp.y, player.width, player.height,1));
					}
					break;
			}
		}else {
			if(temp.kind==1||temp.kind==5) {//减速
					player.state=1;
					player.duration=30;
				}
		}
	}
}
