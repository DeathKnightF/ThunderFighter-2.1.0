package Demo.UI;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.concurrent.Semaphore;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import Demo.Data.Data;
import Demo.Util.ReadImageUtil;
import Demo.Util.ReadPlayerDataUtil;
import Demo.Util.ReadSoundUtil;

@SuppressWarnings({ "serial" })
public class MainMenuFrame extends JFrame {
//	private static final long serialVersionUID = -8339036186981064839L;
	public Semaphore semaphore;
	public boolean suspend;
	public Object lock;
	
	public boolean isMouseMode;
	
	MainMenuFrame mainMenuFrame;
	
	public ReadPlayerDataUtil rpdu;
	public ReadSoundUtil rsu;
	

	/**
	 * Create the frame.
	 */
	public MainMenuFrame(boolean isMouseMode) {//是否是鼠标模式
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(Data.WINDOW_POSITION_X, Data.WINDOW_POSITION_Y, 
				Data.WINDOW_WIDTH, Data.WINDOW_HEIGHT);
		setUndecorated(true);
		getContentPane().setLayout(null);
		
		semaphore=new Semaphore(1);
		lock=new Object();
		mainMenuFrame=this;
		this.isMouseMode=isMouseMode;
		//播放音乐
		rsu=new ReadSoundUtil();
		
		rsu.loop();
		
		rpdu=new ReadPlayerDataUtil();
		JButton startButton = new JButton();
		startButton.setBounds(Data.MAIN_MENU_FRAME_BUTTON_POSITION_X,Data.MAIN_MENU_FRAME_BUTTON_POSITION_START_Y,
				Data.MAIN_MENU_FRAME_BUTTON_WIDTH,Data.MAIN_MENU_FRAME_BUTTON_HEIGHT);
		startButton.setIcon(new ImageIcon(("Imgs/backgroundImg/StartButton.png")));
		startButton.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ChoosePlayerPlaneFrame cppf=new ChoosePlayerPlaneFrame(mainMenuFrame,0,0,isMouseMode);
				cppf.setVisible(true);
				setVisible(false);
			}
		});
		getContentPane().add(startButton);
		
		JButton BossButton = new JButton();
		BossButton.setBounds(Data.MAIN_MENU_FRAME_BUTTON_POSITION_X,
				Data.MAIN_MENU_FRAME_BUTTON_POSITION_START_Y+Data.MAIN_MENU_FRAME_BUTTONS_INTERVAL,
				Data.MAIN_MENU_FRAME_BUTTON_WIDTH,Data.MAIN_MENU_FRAME_BUTTON_HEIGHT);
		BossButton.setIcon(new ImageIcon(("Imgs/backgroundImg/BossButton.png")));
		BossButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ChooseBossFrame cbf=new ChooseBossFrame(mainMenuFrame,isMouseMode);
				cbf.setVisible(true);
				setVisible(false);
			}
		});
		getContentPane().add(BossButton);
		
		
		
		JButton helpButton = new JButton();
		helpButton.setIcon(new ImageIcon(("Imgs/backgroundImg/helpButton.png")));
		helpButton.setBounds(Data.MAIN_MENU_FRAME_BUTTON_POSITION_X,
				Data.MAIN_MENU_FRAME_BUTTON_POSITION_START_Y+Data.MAIN_MENU_FRAME_BUTTONS_INTERVAL*2,
				Data.MAIN_MENU_FRAME_BUTTON_WIDTH,Data.MAIN_MENU_FRAME_BUTTON_HEIGHT);
		helpButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				HelpDialog hd=new HelpDialog();
				hd.setVisible(true);
			}
		});
		getContentPane().add(helpButton);
		
		JButton soundControlButton = new JButton();
		soundControlButton.setIcon(new ImageIcon(("Imgs/backgroundImg/soundControlButton.png")));
		soundControlButton.setBounds(Data.MAIN_MENU_FRAME_BUTTON_POSITION_X,
				Data.MAIN_MENU_FRAME_BUTTON_POSITION_START_Y+Data.MAIN_MENU_FRAME_BUTTONS_INTERVAL*3,
				Data.MAIN_MENU_FRAME_BUTTON_WIDTH,Data.MAIN_MENU_FRAME_BUTTON_HEIGHT);
		soundControlButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(rsu.isClosed) {
					rsu=new ReadSoundUtil();
					rsu.loop();
				}else {
					rsu.close();
				}	
			}
		});
		getContentPane().add(soundControlButton);
		
		JButton productionTeamButton = new JButton();
		productionTeamButton.setIcon(new ImageIcon(("Imgs/backgroundImg/productionTeamButton.png")));
		productionTeamButton.setBounds(Data.MAIN_MENU_FRAME_BUTTON_POSITION_X,
				Data.MAIN_MENU_FRAME_BUTTON_POSITION_START_Y+Data.MAIN_MENU_FRAME_BUTTONS_INTERVAL*4,
				Data.MAIN_MENU_FRAME_BUTTON_WIDTH,Data.MAIN_MENU_FRAME_BUTTON_HEIGHT);
		productionTeamButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ProductionTeamDialog ptd=new ProductionTeamDialog();
				ptd.setVisible(true);
			}
		});
 		getContentPane().add(productionTeamButton);
		
 		JButton setButton = new JButton();
 		setButton.setIcon(new ImageIcon("Imgs/backgroundImg/setButton.png"));
 		setButton.setBounds(Data.MAIN_MENU_FRAME_BUTTON_POSITION_X,
				Data.MAIN_MENU_FRAME_BUTTON_POSITION_START_Y+Data.MAIN_MENU_FRAME_BUTTONS_INTERVAL*5,
				Data.MAIN_MENU_FRAME_BUTTON_WIDTH,Data.MAIN_MENU_FRAME_BUTTON_HEIGHT);
 		setButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				
				new SetDialog(mainMenuFrame).setVisible(true);
				
			}
		});
 		getContentPane().add(setButton);
 		
 		JButton closeButton = new JButton();
		closeButton.setIcon(new ImageIcon(("Imgs/backgroundImg/closeButton.png")));
		closeButton.setBounds(Data.MAIN_MENU_FRAME_BUTTON_POSITION_X,
				Data.MAIN_MENU_FRAME_BUTTON_POSITION_START_Y+Data.MAIN_MENU_FRAME_BUTTONS_INTERVAL*6,
				Data.MAIN_MENU_FRAME_BUTTON_WIDTH,Data.MAIN_MENU_FRAME_BUTTON_HEIGHT);
		closeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					rpdu.writeData();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.exit(0);
			}
		});
		getContentPane().add(closeButton);
		
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(ReadImageUtil.MainMenuBackgroundImg, 0, 0, 
				Data.WINDOW_WIDTH, Data.WINDOW_HEIGHT, null);
		int num=(int)(Math.random()*5);
//		int num=4;
		switch(num) {
			case 0:
				g.drawImage(ReadImageUtil.beautyImgs.get(0), 450, 0,  
						Data.WINDOW_WIDTH*2/3, Data.WINDOW_HEIGHT, null);
				break;
			case 1:
				g.drawImage(ReadImageUtil.beautyImgs.get(1), 430, 0,  
						Data.WINDOW_WIDTH*2/3, Data.WINDOW_HEIGHT, null);
				break;
			case 2:
				g.drawImage(ReadImageUtil.beautyImgs.get(2), 500, 30,  
						Data.WINDOW_WIDTH/2, Data.WINDOW_HEIGHT*9/10, null);
				break;
			case 3:
				g.drawImage(ReadImageUtil.beautyImgs.get(3), 600, 50,  
						Data.WINDOW_WIDTH*2/5, Data.WINDOW_HEIGHT*9/10, null);
				break;
			case 4:
				g.drawImage(ReadImageUtil.beautyImgs.get(4), 500, 0,  
						Data.WINDOW_WIDTH/2, Data.WINDOW_HEIGHT, null);
				break;
		}
		g.drawImage(ReadImageUtil.startButtonImg, Data.MAIN_MENU_FRAME_BUTTON_POSITION_X,
				Data.MAIN_MENU_FRAME_BUTTON_POSITION_START_Y,
				Data.MAIN_MENU_FRAME_BUTTON_WIDTH,Data.MAIN_MENU_FRAME_BUTTON_HEIGHT, null);
		g.drawImage(ReadImageUtil.bossButtonImg, Data.MAIN_MENU_FRAME_BUTTON_POSITION_X,
				Data.MAIN_MENU_FRAME_BUTTON_POSITION_START_Y+Data.MAIN_MENU_FRAME_BUTTONS_INTERVAL,
				Data.MAIN_MENU_FRAME_BUTTON_WIDTH,Data.MAIN_MENU_FRAME_BUTTON_HEIGHT, null);
		g.drawImage(ReadImageUtil.helpButtonImg, Data.MAIN_MENU_FRAME_BUTTON_POSITION_X,
				Data.MAIN_MENU_FRAME_BUTTON_POSITION_START_Y+Data.MAIN_MENU_FRAME_BUTTONS_INTERVAL*2,
				Data.MAIN_MENU_FRAME_BUTTON_WIDTH,Data.MAIN_MENU_FRAME_BUTTON_HEIGHT, null);
		g.drawImage(ReadImageUtil.soundControlButtonImg, Data.MAIN_MENU_FRAME_BUTTON_POSITION_X,
				Data.MAIN_MENU_FRAME_BUTTON_POSITION_START_Y+Data.MAIN_MENU_FRAME_BUTTONS_INTERVAL*3,
				Data.MAIN_MENU_FRAME_BUTTON_WIDTH,Data.MAIN_MENU_FRAME_BUTTON_HEIGHT, null);
		g.drawImage(ReadImageUtil.productionTeamButtonImg, Data.MAIN_MENU_FRAME_BUTTON_POSITION_X,
				Data.MAIN_MENU_FRAME_BUTTON_POSITION_START_Y+Data.MAIN_MENU_FRAME_BUTTONS_INTERVAL*4,
				Data.MAIN_MENU_FRAME_BUTTON_WIDTH,Data.MAIN_MENU_FRAME_BUTTON_HEIGHT, null);
		g.drawImage(ReadImageUtil.setButton, Data.MAIN_MENU_FRAME_BUTTON_POSITION_X,
				Data.MAIN_MENU_FRAME_BUTTON_POSITION_START_Y+Data.MAIN_MENU_FRAME_BUTTONS_INTERVAL*5,
				Data.MAIN_MENU_FRAME_BUTTON_WIDTH,Data.MAIN_MENU_FRAME_BUTTON_HEIGHT, null);
		g.drawImage(ReadImageUtil.closeButtonImg,Data.MAIN_MENU_FRAME_BUTTON_POSITION_X,
				Data.MAIN_MENU_FRAME_BUTTON_POSITION_START_Y+Data.MAIN_MENU_FRAME_BUTTONS_INTERVAL*6,
				Data.MAIN_MENU_FRAME_BUTTON_WIDTH,Data.MAIN_MENU_FRAME_BUTTON_HEIGHT, null);
	}
}
