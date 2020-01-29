package Demo.Role;

import java.awt.Graphics;
import java.awt.Image;

import Demo.Util.ReadImageUtil;
import Demo.Util.ReadSoundUtil;

public class Explode {
	
	int x;
	int y;
	int width;
	int height;
	int kind;
	public boolean live=true;
	Image[] explodeImgs;
	Image[] batExplodeImgs;
	Image[] atomicBombExplodeImgs;
	Image upgradeImg;
	Image weaponUpgradeImg;
	ReadSoundUtil rsu;
	
	/**
	 * ±¨’®¿‡
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public Explode(int x,int y,int width,int height,int kind) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.kind=kind;
		explodeImgs=ReadImageUtil.getExplodeImgs();
		batExplodeImgs=ReadImageUtil.getBatExplodeImgs();
		atomicBombExplodeImgs=ReadImageUtil.atomicBombExplodeImgs;
		upgradeImg=ReadImageUtil.upgradeImg;
		weaponUpgradeImg=ReadImageUtil.weaponUpgradeImg;
	}
	int count=-1;
	public void drawExplode(Graphics g) {
		count++;
		isStillAlive();
		switch(kind) {
		case 0://“ª∞„±¨’®
			if(count<16) {
				g.drawImage(explodeImgs[count], (int)x, (int)y, width, height, null);
			}
			break;
		case 1://Ú˘Ú’®µØ±¨’®
			drawBatExplode(g);
			break;
		case 2://‘≠◊”µØ±¨’®
			if(count<66)
				g.drawImage(atomicBombExplodeImgs[count/6], x, y, width, height, null);
			break;
		case 3://…˝º∂
			if(count<10)
				g.drawImage(upgradeImg, x, y, width, height, null);
			break;
		case 4://Œ‰∆˜…˝º∂
			if(count<50)
				g.drawImage(weaponUpgradeImg, x, y, width*2, height, null);
			break;
		}
		
	}
	public void drawBatExplode(Graphics g) {
		isStillAlive();
		if(count<5)
			g.drawImage(batExplodeImgs[0],x, y, width, height, null);
		else if(count<10)
			g.drawImage(batExplodeImgs[1],x, y, width, height, null);
		else if(count<15)
			g.drawImage(batExplodeImgs[2],x, y, width, height, null);
	}
	
	private void isStillAlive() {
		if(count>100)
			live=false;
	}
}
