package Demo.Role;

import java.awt.Image;
import java.awt.Rectangle;

public class GameObject {
	public int x;
	public int y;
	public int width;
	public int height;
	public int speed;//当前速度
	public int frozen_speed;//被减速时的速度
	public int blood;//当前血量
	public int max_blood;//最大血量
	public int exp;//经验
	int kind;//敌机/boss/道具/玩家飞机的种类
	int form;//boss的形态
	public Image image;
	public Image[] images;
	public int duration;//负面效果持续时间
	public double degree;//速度的角度
	public boolean live;//是否存活
	public boolean isBoss;
	public int state;//状态：0正常  1减速  2眩晕
	 GameObject() {
	}
	
	public Rectangle getRectangle() {
		return new Rectangle(x, y, width, height);
	}
}
