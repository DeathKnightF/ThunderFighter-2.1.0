package Demo.Role;

import java.awt.Graphics;


import Demo.Data.Data;
import Demo.Util.ReadImageUtil;

public class Prop extends GameObject{
	PlayerPlane player;
	public Prop(int x,int y,int kind,PlayerPlane player) {
		super.x=x;
		super.y=y;
		super.width=Data.PROP_WIDTH;
		super.height=Data.PROP_HEIGHT;
		super.speed=Data.PROP_SPEED;
		super.degree=Math.random()*Math.PI*3/4+Math.PI/4;
		super.kind=kind;
		super.image=ReadImageUtil.propImgs.get(kind);
		this.player=player;
		super.live=true;
	}
	
	public void use() {
		switch(kind) {
			case 0://加血
				player.blood=player.blood+50>player.max_blood?player.max_blood:player.blood+50;
				break;
			case 1://加伤害
				player.harm++;
				break;
			case 2://加盾牌
				
		}
	}
	public void drawProp(Graphics g) {
		live=live&isStillAlive();
		if(live) {
			x+=speed*Math.cos(degree);
			y+=speed*Math.sin(degree);
			if(x<=0||x>=Data.WINDOW_WIDTH-width)
				degree=Math.PI-degree;
			g.drawImage(image, x, y, width, height, null);
		}
	}
	/**
	 * 判断该道具是否出界
	 * @param x
	 * @param y
	 * @return
	 */
	private boolean isStillAlive() {
		if(y>Data.WINDOW_HEIGHT)
			return false;
		return true;
	}
}
