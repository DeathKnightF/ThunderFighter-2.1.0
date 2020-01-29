package Demo.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.swing.JFrame;

import Demo.Data.Data;
import Demo.Role.Init;
import Demo.Role.InitBossMode;
import Demo.Role.PlayerPlane;
import Demo.Role.Shell;
import Demo.Util.ReadImageUtil;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class ChoosePlayerPlaneFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MainMenuFrame mainMenuFrame;
	
	public class PlayerData{
		Image img;
		public int blood;
		public int harm;
		public int speed;
		public int kind;
		public int upgradeBlood,upgradeSpeed,upgradeHarm;
		PlayerData(int blood,int harm,int speed,
				int upgradeBlood,int upgradeSpeed,int upgradeHarm,int kind){
			this.blood=blood;
			this.harm=harm;  
			this.speed=speed;
			this.kind=kind;
			this.upgradeBlood=upgradeBlood;
			this.upgradeHarm=upgradeHarm;
			this.upgradeSpeed=upgradeSpeed;
			this.img=ReadImageUtil.getPlayerPlaneImgs(kind)[3];
		}
	}
	
	
	private int currentChoice=0;
	private PlayerData[] playerPlanes;
	/**
	 * Create the frame.
	 */
	public ChoosePlayerPlaneFrame(MainMenuFrame mainMenuFrame,int mode,int choice,boolean isMouseMode) {
		
		setUndecorated(true);
		setBounds(Data.WINDOW_POSITION_X, Data.WINDOW_POSITION_Y, 
				Data.WINDOW_WIDTH, Data.WINDOW_HEIGHT);
		getContentPane().setLayout(null);
		
		this.mainMenuFrame=mainMenuFrame;
		/*
		 * 玩家飞机初始化
		 */
		playerPlanes=new PlayerData[4];
		playerPlanes[0]=new PlayerData(Data.PLAYER_PLANE_BLOOD/2+45 ,//95
				Data.PLAYER_SHELL_HARM,//1
				Data.PLAYER_PLANE_SPEED+3, //18
				Data.PLAYER_PLANE_UPGRADE_BLOOD,//50
				Data.PLAYER_PLANE_UPGRADE_SPEED,//1
				Data.PLAYER_PLANE_UPGRADE_HARM,//0
				0);
		playerPlanes[1]=new PlayerData(Data.PLAYER_PLANE_BLOOD*2,//200 
				Data.PLAYER_SHELL_HARM,//1
				Data.PLAYER_PLANE_SPEED-2, //13
				Data.PLAYER_PLANE_UPGRADE_BLOOD*2,//100
				Data.PLAYER_PLANE_UPGRADE_SPEED,//1
				Data.PLAYER_PLANE_UPGRADE_HARM,//0
				1);
		playerPlanes[2]=new PlayerData(Data.PLAYER_PLANE_BLOOD/2,//50 
				Data.PLAYER_SHELL_HARM*2,//2
				Data.PLAYER_PLANE_SPEED,//15 
				Data.PLAYER_PLANE_UPGRADE_BLOOD-20,//30
				Data.PLAYER_PLANE_UPGRADE_SPEED,//1
				Data.PLAYER_PLANE_UPGRADE_HARM+1,//1
				2);
		playerPlanes[3]=new PlayerData(Data.PLAYER_PLANE_BLOOD/2+20,//70 
				Data.PLAYER_SHELL_HARM,//1
				Data.PLAYER_PLANE_SPEED*2-2, //28
				Data.PLAYER_PLANE_UPGRADE_BLOOD-10,//40
				Data.PLAYER_PLANE_UPGRADE_SPEED*2,//2
				Data.PLAYER_PLANE_UPGRADE_HARM,//0
				3);
		//确认按钮
		JButton confirmButton = new JButton();
		confirmButton.setIcon(new ImageIcon(("Imgs/backgroundImg/confirmImg.png")));
		confirmButton.setBounds(Data.CHOOSE_PLAYER_PLANE_FRAME_CONFIRM_BUTTON_POSITION_X,
				Data.CHOOSE_PLAYER_PLANE_FRAME_CONFIRM_BUTTON_POSITION_Y,
				Data.DIALOG_BUTTON_WIDTH,Data.DIALOG_BUTTON_HEIGHT);
		confirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ConcurrentLinkedQueue<Shell> playerShells=new ConcurrentLinkedQueue<>();
				PlayerPlane player=new PlayerPlane(playerShells, playerPlanes[currentChoice],isMouseMode);
				switch(mode) {
				case 0://普通模式
					new Init(player,playerShells,null,null,null,null,0,isMouseMode,mainMenuFrame).start();
					break;
				case 1://boss模式
					new InitBossMode(choice,player,playerShells,mainMenuFrame,isMouseMode).start();
					break;
				}
				
				setVisible(false);
			}
		});
		getContentPane().add(confirmButton);
		
		JButton leftButton = new JButton();
		leftButton.setIcon(new ImageIcon(("Imgs/backgroundImg/leftButton.png")));
		leftButton.setBounds(Data.CHOOSE_PLAYER_PLANE_FRAME_TURN_LEFT_BUTTON_POSITION_X
				,Data.CHOOSE_PLAYER_PLANE_FRAME_TURN_BUTTON_POSITION_Y
				,Data.CHOOSE_PLAYER_PLANE_FRAME_TURN_BUTTON_WIDTH
				,Data.CHOOSE_PLAYER_PLANE_FRAME_TURN_BUTTON_HEIGHT);
		leftButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(currentChoice>0)
					currentChoice--;
				else
					currentChoice=3;
				repaint();
			}
		});
		getContentPane().add(leftButton);
		
		JButton rightButton = new JButton();
		rightButton.setIcon(new ImageIcon(("Imgs/backgroundImg/rightButton.png")));
		rightButton.setBounds(Data.CHOOSE_PLAYER_PLANE_FRAME_TURN_RIGHT_BUTTON_POSITION_X
				,Data.CHOOSE_PLAYER_PLANE_FRAME_TURN_BUTTON_POSITION_Y
				,Data.CHOOSE_PLAYER_PLANE_FRAME_TURN_BUTTON_WIDTH
				,Data.CHOOSE_PLAYER_PLANE_FRAME_TURN_BUTTON_HEIGHT);
		rightButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(currentChoice<3)
					currentChoice++;
				else
					currentChoice=0;
				repaint();
			}
		});
		getContentPane().add(rightButton);
		
		
	}

	@Override
	public void paint(Graphics g) {
		//画背景
		g.drawImage(ReadImageUtil.choosePlayerPlaneBackgroundImg,0, 0, 
				Data.WINDOW_WIDTH, Data.WINDOW_HEIGHT,null);
		//画三个按钮
		g.drawImage(ReadImageUtil.confirmImg, Data.CHOOSE_PLAYER_PLANE_FRAME_CONFIRM_BUTTON_POSITION_X,
				Data.CHOOSE_PLAYER_PLANE_FRAME_CONFIRM_BUTTON_POSITION_Y,
				Data.DIALOG_BUTTON_WIDTH,Data.DIALOG_BUTTON_HEIGHT, null);
		g.drawImage(ReadImageUtil.leftButtonImg, Data.CHOOSE_PLAYER_PLANE_FRAME_TURN_LEFT_BUTTON_POSITION_X
				,Data.CHOOSE_PLAYER_PLANE_FRAME_TURN_BUTTON_POSITION_Y
				,Data.CHOOSE_PLAYER_PLANE_FRAME_TURN_BUTTON_WIDTH
				,Data.CHOOSE_PLAYER_PLANE_FRAME_TURN_BUTTON_HEIGHT,null);
		g.drawImage(ReadImageUtil.rightButtonImg, Data.CHOOSE_PLAYER_PLANE_FRAME_TURN_RIGHT_BUTTON_POSITION_X
				,Data.CHOOSE_PLAYER_PLANE_FRAME_TURN_BUTTON_POSITION_Y
				,Data.CHOOSE_PLAYER_PLANE_FRAME_TURN_BUTTON_WIDTH
				,Data.CHOOSE_PLAYER_PLANE_FRAME_TURN_BUTTON_HEIGHT,null);
		//画飞机
		g.drawImage(playerPlanes[currentChoice].img, Data.CHOOSE_PLAYER_PLANE_FRAME_PLANE_IMG_POSITION_X
				,Data.CHOOSE_PLAYER_PLANE_FRAME_PLANE_IMG_POSITION_Y
				,Data.CHOOSE_PLAYER_PLANE_FRAME_PLANE_IMG_WIDTH
				,Data.CHOOSE_PLAYER_PLANE_FRAME_PLANE_IMG_HEIGHT,null);
		g.setFont(new Font("楷体", Font.PLAIN, Data.CHOOSE_PLAYER_PLANE_FRAME_DATA_WORD_FONT_SIZE));
		g.setColor(Color.YELLOW);
		//飞机数据显示
		g.drawString("攻击：", Data.CHOOSE_PLAYER_PLANE_FRAME_DATA_WORD_POSITION_X, 
				Data.CHOOSE_PLAYER_PLANE_FRAME_DATA_WORD_FIRST_POSITION_Y);
		g.drawString("防御：", Data.CHOOSE_PLAYER_PLANE_FRAME_DATA_WORD_POSITION_X, 
				Data.CHOOSE_PLAYER_PLANE_FRAME_DATA_WORD_FIRST_POSITION_Y+Data.CHOOSE_PLAYER_PLANE_FRAME_DATA_WORD_INTERVAL);
		g.drawString("敏捷：", Data.CHOOSE_PLAYER_PLANE_FRAME_DATA_WORD_POSITION_X, 
				Data.CHOOSE_PLAYER_PLANE_FRAME_DATA_WORD_FIRST_POSITION_Y+Data.CHOOSE_PLAYER_PLANE_FRAME_DATA_WORD_INTERVAL*2);
		int harmLength=playerPlanes[currentChoice].harm*Data.CHOOSE_PLAYER_PLANE_FRAME_DATA_STRIP_STANDARD_WIDTH/Data.PLAYER_SHELL_HARM;
		int bloodLength=playerPlanes[currentChoice].blood*Data.CHOOSE_PLAYER_PLANE_FRAME_DATA_STRIP_STANDARD_WIDTH/Data.PLAYER_PLANE_BLOOD;
		int speedLength=playerPlanes[currentChoice].speed*Data.CHOOSE_PLAYER_PLANE_FRAME_DATA_STRIP_STANDARD_WIDTH/Data.PLAYER_PLANE_SPEED;
		g.drawImage(ReadImageUtil.expStripImg, Data.CHOOSE_PLAYER_PLANE_FRAME_DATA_STRIP_POSITION_X
				, Data.CHOOSE_PLAYER_PLANE_FRAME_DATA_STRIP_FIRST_POSITION_Y
				, harmLength
				, Data.CHOOSE_PLAYER_PLANE_FRAME_DATA_STRIP_HEIGHT
				, null);
		g.drawImage(ReadImageUtil.expStripImg, Data.CHOOSE_PLAYER_PLANE_FRAME_DATA_STRIP_POSITION_X
				, Data.CHOOSE_PLAYER_PLANE_FRAME_DATA_STRIP_FIRST_POSITION_Y+Data.CHOOSE_PLAYER_PLANE_FRAME_DATA_STRIP_INTERVAL
				, bloodLength
				, Data.CHOOSE_PLAYER_PLANE_FRAME_DATA_STRIP_HEIGHT 
				, null);
		g.drawImage(ReadImageUtil.expStripImg, Data.CHOOSE_PLAYER_PLANE_FRAME_DATA_STRIP_POSITION_X
				, Data.CHOOSE_PLAYER_PLANE_FRAME_DATA_STRIP_FIRST_POSITION_Y+Data.CHOOSE_PLAYER_PLANE_FRAME_DATA_STRIP_INTERVAL*2
				, speedLength
				, Data.CHOOSE_PLAYER_PLANE_FRAME_DATA_STRIP_HEIGHT
				, null);
	}
}
