package Demo.Util;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;

/**
 * 读取文件工具类，可用于读取图片和音效
 * @author 董楷烽
 * @email 1124615130@qq.com
 */
@SuppressWarnings("unchecked")
public class ReadImageUtil {
	public static Image[] atomicBombExplodeImgs;
	public static Image atomicBombImg;
	public static Image atomicBombButtonImg;
	public static List<Image> backgroundImgs;
	public static List<Image>[] bossImgs;
	public static List<Image>[] bossShellImgs;
	public static List<Image> beautyImgs;
	public static Image bossBloodFrameImg;
	public static Image bossBloodStripImg;
	public static Image bloodStripImg;
	public static Image bossButtonImg;
	public static Image backToMainMenuImg;
	public static Image chooseBossFrameBackgroundImg;
	public static Image choosePlayerPlaneBackgroundImg;
	public static Image[] chooseBossHeadPortraitImgs;
	public static Image closeButtonImg;
	public static Image continueButtonImg;
	public static Image confirmImg;
	public static List<Image> enemyPlaneImgs;
	public static List<Image> enemyShellImgs;
	public static Image endDialogImg;
	public static Image expStripImg;
	public static Image[] explodeImgs;
	public static Image failureImg;
	public static Image headPortraitFrameImg;
	public static Image headPortraitImg;
	public static Image helpButtonImg;
	public static Image helpBackgroundImg;
	public static Image laserImg;
	public static Image leftButtonImg;
	public static Image menuImg;
	public static Image menuDialogImg;
	public static Image menuDialogBackgroundImg;
	public static Image MainMenuBackgroundImg;
	public static Image[][] playerPlaneImgs;
	public static List<Image> playerShellImgs;
	public static List<Image> propImgs;
	public static List<Image> propImpathImgs;
	public static List<Image> propStateImgs;
	public static Image productionTeamButtonImg;
	public static Image productionTeamBackgroundImg;
	public static Image rightButtonImg;
	public static Image startButtonImg;
	public static Image soundControlButtonImg;
	public static Image setButton;
	public static Image upgradeImg;
	public static Image weaponUpgradeImg;
	static {
		atomicBombExplodeImgs=new Image[11];
		backgroundImgs=new ArrayList<Image>();
		bossImgs=new List[5];
		for(int i=0;i<5;i++)
			bossImgs[i]=new ArrayList<Image>();
		bossShellImgs=new List[5];
		for(int i=0;i<5;i++)
			bossShellImgs[i]=new ArrayList<Image>();
		beautyImgs=new ArrayList<Image>();
		chooseBossHeadPortraitImgs=new Image[6];
		enemyPlaneImgs=new ArrayList<Image>();
		enemyShellImgs=new ArrayList<Image>();
		explodeImgs=new Image[16];
		playerPlaneImgs=new Image[4][4];
		playerShellImgs=new ArrayList<Image>();
		propImgs=new ArrayList<Image>();
		propImpathImgs=new ArrayList<Image>();
		propStateImgs=new ArrayList<Image>();
		for(int i=0;i<11;i++)
			atomicBombExplodeImgs[i]=(new ImageIcon(("Imgs/explodeImg/原子爆炸"+(i+1)+".png"))).getImage();
		atomicBombImg=(new ImageIcon(("Imgs/ShellsImg/atomicBombImg.png"))).getImage();
		atomicBombButtonImg=new ImageIcon("Imgs/backgroundImg/atomicBombButton.png").getImage();
		for(int i=1;i<=6;i++)
			backgroundImgs.add((new ImageIcon(("Imgs/backgroundImg/background"+i+".jpg"))).getImage());
		
		bloodStripImg=(new ImageIcon(("Imgs/backgroundImg/bloodStrip.png"))).getImage();
		backToMainMenuImg=(new ImageIcon(("Imgs/backgroundImg/backToMainMenu.png"))).getImage();
		bossBloodFrameImg=(new ImageIcon(("Imgs/backgroundImg/BOSSBloodFrame.png"))).getImage();
		bossBloodStripImg=(new ImageIcon(("Imgs/backgroundImg/BossBloodStrip.png"))).getImage();
		bossButtonImg=(new ImageIcon(("Imgs/backgroundImg/BossButton.png"))).getImage();
		//boss相关
		for(int i=1;i<=4;i++)
			bossImgs[0].add((new ImageIcon(("Imgs/EnemyPlaneImg/bossOne"+i+".png"))).getImage());
		for(int i=1;i<=4;i++)
			bossImgs[1].add((new ImageIcon(("Imgs/EnemyPlaneImg/bossTwo"+i+".png"))).getImage());
		for(int i=1;i<=4;i++)
			bossImgs[2].add((new ImageIcon(("Imgs/EnemyPlaneImg/bossThree"+i+".png"))).getImage());
		
		bossShellImgs[0].add((new ImageIcon(("Imgs/EnemyShellImg/bossOneShell1.png"))).getImage());
		bossShellImgs[0].add((new ImageIcon(("Imgs/EnemyShellImg/bossOneShell2.png"))).getImage());
		
		bossShellImgs[0].add((new ImageIcon(("Imgs/EnemyShellImg/bossOneShell3.png"))).getImage());
		bossShellImgs[0].add((new ImageIcon(("Imgs/EnemyShellImg/bossOneShell4.png"))).getImage());
		bossShellImgs[1].add((new ImageIcon(("Imgs/EnemyShellImg/bossTwoShell1.png"))).getImage());
		bossShellImgs[1].add((new ImageIcon(("Imgs/EnemyShellImg/bossTwoShell2.png"))).getImage());
		bossShellImgs[1].add((new ImageIcon(("Imgs/EnemyShellImg/bossTwoShell3.png"))).getImage());
		bossShellImgs[1].add((new ImageIcon(("Imgs/EnemyShellImg/bossTwoShell41.png"))).getImage());
		bossShellImgs[1].add((new ImageIcon(("Imgs/EnemyShellImg/bossTwoShell42.png"))).getImage());
		bossShellImgs[1].add((new ImageIcon(("Imgs/EnemyShellImg/bossTwoShell43.png"))).getImage());
		bossShellImgs[1].add((new ImageIcon(("Imgs/EnemyShellImg/bossTwoShell44.png"))).getImage());
		bossShellImgs[1].add((new ImageIcon(("Imgs/EnemyShellImg/bossTwoShell45.png"))).getImage());
		bossShellImgs[1].add((new ImageIcon(("Imgs/EnemyShellImg/bossTwoShell46.png"))).getImage());
		bossShellImgs[1].add((new ImageIcon(("Imgs/EnemyShellImg/bossTwoShell47.png"))).getImage());
		bossShellImgs[2].add((new ImageIcon(("Imgs/EnemyShellImg/bossThreeShell1.png"))).getImage());
		
		for(int i=0;i<5;i++)
			beautyImgs.add((new ImageIcon(("Imgs/backgroundImg/beauty"+(i+1)+".png"))).getImage());
		
		continueButtonImg=(new ImageIcon(("Imgs/backgroundImg/continueImg.png"))).getImage();
		confirmImg=(new ImageIcon(("Imgs/backgroundImg/confirmImg.png"))).getImage();
		closeButtonImg=(new ImageIcon(("Imgs/backgroundImg/closeButton.png"))).getImage();
		chooseBossFrameBackgroundImg=(new ImageIcon(("Imgs/backgroundImg/ChooseBossFrameBackground.jpg"))).getImage();
		choosePlayerPlaneBackgroundImg=(new ImageIcon(("Imgs/backgroundImg/choosePlayerPlaneBackground.jpg"))).getImage();
		chooseBossHeadPortraitImgs[0]=(new ImageIcon(("Imgs/backgroundImg/chooseBossHeadPortrait1.gif"))).getImage();
		chooseBossHeadPortraitImgs[1]=(new ImageIcon(("Imgs/backgroundImg/chooseBossHeadPortrait2.gif"))).getImage();
		chooseBossHeadPortraitImgs[2]=(new ImageIcon(("Imgs/backgroundImg/chooseBossHeadPortrait3.gif"))).getImage();
		chooseBossHeadPortraitImgs[3]=(new ImageIcon(("Imgs/backgroundImg/chooseBossHeadPortrait4.png"))).getImage();
		chooseBossHeadPortraitImgs[4]=(new ImageIcon(("Imgs/backgroundImg/chooseBossHeadPortrait5.png"))).getImage();
		chooseBossHeadPortraitImgs[5]=(new ImageIcon(("Imgs/backgroundImg/chooseBossHeadPortrait6.gif"))).getImage();
		
		
		expStripImg=(new ImageIcon(("Imgs/backgroundImg/expStrip.png"))).getImage();
		endDialogImg=(new ImageIcon(("Imgs/backgroundImg/EndDialog1.png"))).getImage();
		
		enemyPlaneImgs.add((new ImageIcon(("Imgs/EnemyPlaneImg/EnemyPlane1.png"))).getImage());
		enemyPlaneImgs.add((new ImageIcon(("Imgs/EnemyPlaneImg/EnemyPlane2.png"))).getImage());
		enemyPlaneImgs.add((new ImageIcon(("Imgs/EnemyPlaneImg/EnemyPlane3.png"))).getImage());
		enemyPlaneImgs.add((new ImageIcon(("Imgs/EnemyPlaneImg/EnemyPlane4.png"))).getImage());
		enemyPlaneImgs.add((new ImageIcon(("Imgs/EnemyPlaneImg/EnemyPlane5.png"))).getImage());
		enemyPlaneImgs.add((new ImageIcon(("Imgs/EnemyPlaneImg/EnemyPlane6.png"))).getImage());
		
		for(int i=1;i<=6;i++)
			enemyShellImgs.add((new ImageIcon(("Imgs/EnemyShellImg/EnemyShell"+i+".png"))).getImage());

		for(int i=0;i<16;i++)
			explodeImgs[i]=(new ImageIcon(("Imgs/explodeImg/e"+(i+1)+".gif"))).getImage();
		
		failureImg=(new ImageIcon(("Imgs/backgroundImg/failure.png"))).getImage();
		headPortraitFrameImg=(new ImageIcon(("Imgs/backgroundImg/headPortraitFrame.png"))).getImage();
		headPortraitImg=(new ImageIcon(("Imgs/backgroundImg/headPortraitImg1.png"))).getImage();
		helpButtonImg=(new ImageIcon(("Imgs/backgroundImg/helpButton.png"))).getImage();
		helpBackgroundImg=(new ImageIcon(("Imgs/backgroundImg/helpBackground.jpg"))).getImage();
		
		leftButtonImg=(new ImageIcon(("Imgs/backgroundImg/leftButton.png"))).getImage();
		
		menuImg=(new ImageIcon(("Imgs/backgroundImg/menu.png"))).getImage();
		menuDialogImg=(new ImageIcon(("Imgs/backgroundImg/menuDialogImg.png"))).getImage();
		menuDialogBackgroundImg=(new ImageIcon(("Imgs/backgroundImg/menuDialogBackgroundImg.jpg"))).getImage();
		MainMenuBackgroundImg=(new ImageIcon(("Imgs/backgroundImg/MainMenuBackground.jpg"))).getImage();
		
		
		playerPlaneImgs[0][0]=(new ImageIcon(("Imgs/PlayerPlaneImg/playerPlaneOne1.png"))).getImage();
		playerPlaneImgs[0][1]=(new ImageIcon(("Imgs/PlayerPlaneImg/playerPlaneOne2.png"))).getImage();
		playerPlaneImgs[0][2]=(new ImageIcon(("Imgs/PlayerPlaneImg/playerPlaneOne3.png"))).getImage();
		playerPlaneImgs[0][3]=(new ImageIcon(("Imgs/PlayerPlaneImg/playerPlaneOne4.png"))).getImage();
		playerPlaneImgs[1][0]=(new ImageIcon(("Imgs/PlayerPlaneImg/playerPlaneTwo1.png"))).getImage();
		playerPlaneImgs[1][1]=(new ImageIcon(("Imgs/PlayerPlaneImg/playerPlaneTwo2.png"))).getImage();
		playerPlaneImgs[1][2]=(new ImageIcon(("Imgs/PlayerPlaneImg/playerPlaneTwo3.png"))).getImage();
		playerPlaneImgs[1][3]=(new ImageIcon(("Imgs/PlayerPlaneImg/playerPlaneTwo4.png"))).getImage();
		playerPlaneImgs[2][0]=(new ImageIcon(("Imgs/PlayerPlaneImg/playerPlaneThree1.png"))).getImage();
		playerPlaneImgs[2][1]=(new ImageIcon(("Imgs/PlayerPlaneImg/playerPlaneThree2.png"))).getImage();
		playerPlaneImgs[2][2]=(new ImageIcon(("Imgs/PlayerPlaneImg/playerPlaneThree3.png"))).getImage();
		playerPlaneImgs[2][3]=(new ImageIcon(("Imgs/PlayerPlaneImg/playerPlaneThree4.png"))).getImage();
		playerPlaneImgs[3][0]=(new ImageIcon(("Imgs/PlayerPlaneImg/playerPlaneFour1.png"))).getImage();
		playerPlaneImgs[3][1]=(new ImageIcon(("Imgs/PlayerPlaneImg/playerPlaneFour2.png"))).getImage();
		playerPlaneImgs[3][2]=(new ImageIcon(("Imgs/PlayerPlaneImg/playerPlaneFour3.png"))).getImage();
		playerPlaneImgs[3][3]=(new ImageIcon(("Imgs/PlayerPlaneImg/playerPlaneFour4.png"))).getImage();
		
		for(int i=1;i<=4;i++)
			playerShellImgs.add((new ImageIcon(("Imgs/ShellsImg/playerShell"+i+".png"))).getImage());
		
		//道具
		for(int i=1;i<=3;i++)
			propImgs.add((new ImageIcon(("Imgs/prop/prop"+i+".png"))).getImage());
		
		propStateImgs.add((new ImageIcon(("Imgs/prop/freezing.png"))).getImage());
		propStateImgs.add((new ImageIcon(("Imgs/prop/swimmy.png"))).getImage());
		
		productionTeamButtonImg=(new ImageIcon(("Imgs/backgroundImg/productionTeamButton.png"))).getImage();
		productionTeamBackgroundImg=(new ImageIcon(("Imgs/backgroundImg/productionTeamBackground.jpg"))).getImage();
		rightButtonImg=(new ImageIcon(("Imgs/backgroundImg/rightButton.png"))).getImage();
		
//			laserImg=ImageIO.read(new File("src\\Imgs\\ShellsImg\\Laser.png"));
		
		startButtonImg=(new ImageIcon(("Imgs/backgroundImg/StartButton.png"))).getImage();
		soundControlButtonImg=new ImageIcon("Imgs/backgroundImg/soundControlButton.png").getImage();
		setButton=new ImageIcon("Imgs/backgroundImg/setButton.png").getImage();
		upgradeImg=(new ImageIcon(("Imgs/prop/upgrade.png"))).getImage();
		weaponUpgradeImg=(new ImageIcon(("Imgs/prop/weaponUpgrade.png"))).getImage();
		
	}
	
	public static Image[] getPlayerPlaneImgs(int kind) {
		if(kind<playerPlaneImgs.length)
			return playerPlaneImgs[kind];
		return null;
	}
	public static Image getPlayerShellImg(int index) {
		if(index<playerShellImgs.size())
			return playerShellImgs.get(index);
		return null;
	}
	public static Image getBackgroundImg(int index) {
		if(index<backgroundImgs.size())
			return backgroundImgs.get(index);
		return null;
	}
	public static Image getEnemyPlaneImg(int index) {
		if(index<enemyPlaneImgs.size())
			return enemyPlaneImgs.get(index);
		return null;
	}
	public static Image getEnemyShellImg(int index) {
		if(index<enemyShellImgs.size())
			return enemyShellImgs.get(index);
		return null;
	}
	public static Image[] getExplodeImgs() {
		return explodeImgs;
	}
	public static Image[] getBatExplodeImgs() {
		Image[] res=new Image[3];
		Iterator<Image> it=bossShellImgs[1].iterator();
		for(int i=0;i<7;i++)
			it.next();
		res[0]=it.next();
		res[1]=it.next();
		res[2]=it.next();
		return res;
	}
}
