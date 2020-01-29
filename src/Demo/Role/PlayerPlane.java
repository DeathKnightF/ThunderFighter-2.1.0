package Demo.Role;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.concurrent.ConcurrentLinkedQueue;

import Demo.Data.Data;
import Demo.UI.ChoosePlayerPlaneFrame;
import Demo.Util.ReadImageUtil;

/**
 * 玩家飞机类
 * @author 董楷烽
 * @Email 1124615130@qq.com
 */
public class PlayerPlane extends GameObject{
	public boolean up,down,left,right,launchShells=true,launchAtomicBomb;
	private int upgradeBlood,upgradeSpeed,upgradeHarm;//升级时各个参数增量
	public int grade;
	public int harm;//玩家飞机的伤害
	public int kills,coin;//杀敌数和金币数
	public Image[] images;
	public int atomicBombNum=1;
	public int target_x;//鼠标指向的位置
	public int target_y;
	public boolean isMouseMode;
	ConcurrentLinkedQueue<Shell> playerShells;
	public PlayerPlane(ConcurrentLinkedQueue<Shell> playerShells,
			ChoosePlayerPlaneFrame.PlayerData playerData,boolean isMouseMode) {
		super.x=Data.PLAYER_PLANE_START_X;
		super.y=Data.PLAYER_PLANE_START_Y;
		target_x=x;
		target_y=y;
		super.width=Data.PLAYER_PLANE_WIDTH;
		super.height=Data.PLAYER_PLANE_HEIGHT;
		super.speed=playerData.speed;
		super.frozen_speed=speed/2;
		super.live=true;
		super.blood=playerData.blood;//当前血量
		super.exp=0;
		super.max_blood=super.blood;
		super.kind=playerData.kind;
		this.playerShells=playerShells;
		this.images=ReadImageUtil.getPlayerPlaneImgs(playerData.kind);
		this.grade=0;
		this.harm=playerData.harm;
		this.upgradeBlood=playerData.upgradeBlood;
		this.upgradeHarm=playerData.upgradeHarm;
		this.upgradeSpeed=playerData.upgradeSpeed;
		this.isMouseMode=isMouseMode;
	}
	
	public void drawPlayerPlane(Graphics g) {
		if(isMouseMode) {//鼠标模式的牵引线
			g.drawImage(ReadImageUtil.bossShellImgs[0].get(0), target_x-50, target_y-50, 100,100, null);
			g.drawLine(x+width/2, y+height/2, target_x, target_y);
		}
		
		if(live) {
			if(state!=0) {//负面状态
				duration--;
				if(duration<=0) {
					state=0;
					duration=0;
				}
				switch(state) {
					case 0:
						move(speed);
						g.drawImage(images[grade], x, y, width, height, null);
						break;
					case 1:
						move(frozen_speed);//减速
						g.drawImage(images[grade], x, y, width, height, null);
						g.drawImage(ReadImageUtil.propStateImgs.get(0), x, y, width, height, null);
						break;
					case 2:
						move(0);//眩晕
						g.drawImage(images[grade], x, y, width, height, null);
						g.drawImage(ReadImageUtil.propStateImgs.get(1), x, y, width, height/2, null);
						return;
					default:
				}
			}else {
				move(speed);
				g.drawImage(images[grade], x, y, width, height, null);
			}
			if(isMouseMode) {
				if(target_x-30<=x&&x<=target_x+30)
					x=target_x-width/2;
				if(target_y-30<=y&&y<=target_y+30)
					y=target_y-height/2;
			}
			
			fire();
		}
	}
	/*
	 * 改变位置
	 */
	private void move(int speed) {
		if(left&&x>=speed)
			x-=speed;
		if(right&&x<=Data.WINDOW_WIDTH-Data.PLAYER_PLANE_WIDTH-speed)
			x+=speed;
		if(up&&y>=30+speed)
			y-=speed;
		if(down&&y<=Data.WINDOW_HEIGHT-Data.PLAYER_PLANE_HEIGHT-speed) 
			y+=speed;
	}
	/*
	 * 升级
	 */
	public void upgrade() {
		if(exp>=Data.PLAYER_UPGRADE_EXP[grade]) {
			exp-=Data.PLAYER_UPGRADE_EXP[grade];
			grade++;
			upgrade();
			max_blood+=upgradeBlood;
			blood+=upgradeBlood;
			speed+=upgradeSpeed;
			harm+=upgradeHarm;
		}
	}
	/*
	 * 开火
	 */
	private boolean fire_interval1=true;
	private boolean fire_interval2=true;
	private void fire() {
		if(launchShells&&fire_interval1&&fire_interval2) {//
				switch(grade) {
					case 0:
						playerShells.add(new Shell(x+Data.PLAYER_PLANE_WIDTH/2-16,y,harm,Math.PI/2,kind));
						break;
					case 1:
						playerShells.add(new Shell(x+Data.PLAYER_PLANE_WIDTH/2-30,y,harm,Math.PI/2,kind));
						playerShells.add(new Shell(x+Data.PLAYER_PLANE_WIDTH/2,y,harm,Math.PI/2,kind));
						break;
					case 2:
						playerShells.add(new Shell(x+Data.PLAYER_PLANE_WIDTH/2-40,y,harm,Math.PI/2,kind));
						playerShells.add(new Shell(x+Data.PLAYER_PLANE_WIDTH/2-15,y,harm,Math.PI/2,kind));
						playerShells.add(new Shell(x+Data.PLAYER_PLANE_WIDTH/2+10,y,harm,Math.PI/2,kind));
						break;
					default:
						playerShells.add(new Shell(x+Data.PLAYER_PLANE_WIDTH/2-45,y,harm,Math.PI/2,kind));
						playerShells.add(new Shell(x+Data.PLAYER_PLANE_WIDTH/2-28,y,harm,Math.PI/2,kind));
						playerShells.add(new Shell(x+Data.PLAYER_PLANE_WIDTH/2-7,y,harm,Math.PI/2,kind));
						playerShells.add(new Shell(x+Data.PLAYER_PLANE_WIDTH/2+10,y,harm,Math.PI/2,kind));
				}
				
			}
			fire_interval1=!fire_interval1;
			if(fire_interval1)
				fire_interval2=!fire_interval2;
			if(launchAtomicBomb&&atomicBombNum>0) {
				playerShells.add(new Shell(x+Data.PLAYER_PLANE_WIDTH/2-16,y,100,Math.PI/2,4));//harm当计时器
				atomicBombNum--;
				launchAtomicBomb=false;
			}
				
	}
	
	/**
	 * 键盘操控
	 * @param e
	 */
	public void changePosition(MouseEvent e) {
		target_x=e.getX();
		target_y=e.getY();
		if(target_x-10<=x&&target_x+30>=x||target_x>x)
			left=false;
		else
			left=true;
		if(target_x-10<=x&&target_x+30>=x||target_x<x) 
			right=false;
		else 
			right=true;
		
		if(target_y-10<=y&&target_y+30>=y||target_y>y)
			up=false;
		else
			up=true;
		if(target_y-10<=y&&target_y+30>=y||target_y<y) 
			down=false;
		else 
			down=true;
	}
	
	public void changePosition(KeyEvent e) {
		switch( e.getKeyCode()) {
			case KeyEvent.VK_UP: case KeyEvent.VK_W:
				up=true;
				down=false;
				break;
			case KeyEvent.VK_DOWN: case KeyEvent.VK_S:
				down=true;
				up=false;
				break;
			case KeyEvent.VK_LEFT: case KeyEvent.VK_A:
				left=true;
				right=false;
				break;
			case KeyEvent.VK_RIGHT:case KeyEvent.VK_D:
				right=true;
				left=false;
				break;
			case KeyEvent.VK_SPACE:
				launchShells=true;
				break;
			case KeyEvent.VK_L:
				launchAtomicBomb=true;
				break;
		}
	}
	public void cancelPosition(KeyEvent e) {
		switch( e.getKeyCode()) {
		case KeyEvent.VK_UP:case KeyEvent.VK_W:
			up=false;
			break;
		case KeyEvent.VK_DOWN:case KeyEvent.VK_S:
			down=false;
			break;
		case KeyEvent.VK_LEFT:case KeyEvent.VK_A:
			left=false;
			break;
		case KeyEvent.VK_RIGHT:case KeyEvent.VK_D:
			right=false;
			break;
		case KeyEvent.VK_SPACE:
			launchShells=false;
			break;
		case KeyEvent.VK_L:
			launchAtomicBomb=false;
			break;
		}
	}
}
