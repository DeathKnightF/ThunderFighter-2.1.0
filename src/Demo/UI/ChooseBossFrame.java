package Demo.UI;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import Demo.Data.Data;
import Demo.Util.ReadImageUtil;


public class ChooseBossFrame extends JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the frame.
	 */
	public ChooseBossFrame(MainMenuFrame mainMenuFrame,boolean isMouseMode) {
		setUndecorated(true);
		setBounds(Data.WINDOW_POSITION_X, Data.WINDOW_POSITION_Y, 
				Data.WINDOW_WIDTH, Data.WINDOW_HEIGHT);
		getContentPane().setLayout(null);
		
		JButton bossOneButton = new JButton();
		bossOneButton.setIcon(new ImageIcon("Imgs/EnemyPlaneImg/bossOne1.png"));
		bossOneButton.setBounds(Data.CHOOSE_BOSS_BUTTON_POSITIN_X,
				Data.CHOOSE_BOSS_BUTTON_FIRST_POSITION_Y,
				Data.CHOOSE_BOSS_BUTTON_WIDTH,
				Data.CHOOSE_BOSS_BUTTON_HEIGHT);
		bossOneButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ChoosePlayerPlaneFrame cppf=new ChoosePlayerPlaneFrame(mainMenuFrame, 1, 0,isMouseMode);
				cppf.setVisible(true);
				dispose();
			}
		});
		getContentPane().add(bossOneButton);
		
		JButton bossTwoButton = new JButton();
		bossTwoButton.setBounds(Data.CHOOSE_BOSS_BUTTON_POSITIN_X+Data.CHOOSE_BOSS_BUTTON_INTERVAL_X,
				Data.CHOOSE_BOSS_BUTTON_FIRST_POSITION_Y,
				Data.CHOOSE_BOSS_BUTTON_WIDTH,
				Data.CHOOSE_BOSS_BUTTON_HEIGHT);
		ReadImageUtil.bossImgs[1].get(0);
		Image temp=ReadImageUtil.bossImgs[1].get(0).getScaledInstance(bossTwoButton.getWidth(),
				bossTwoButton.getHeight(), Image.SCALE_DEFAULT);
		ImageIcon icon=new ImageIcon(temp);
		bossTwoButton.setIcon(icon);
		bossTwoButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ChoosePlayerPlaneFrame cppf=new ChoosePlayerPlaneFrame(mainMenuFrame, 1, 1,isMouseMode);
				cppf.setVisible(true);
				dispose();
			}
		});
		getContentPane().add(bossTwoButton);
		
		JButton bossThreeButton = new JButton();
		bossThreeButton.setBounds(Data.CHOOSE_BOSS_BUTTON_POSITIN_X,
				Data.CHOOSE_BOSS_BUTTON_FIRST_POSITION_Y+Data.CHOOSE_BOSS_BUTTON_INTERVAL_Y,
				Data.CHOOSE_BOSS_BUTTON_WIDTH,
				Data.CHOOSE_BOSS_BUTTON_HEIGHT);
		ReadImageUtil.bossImgs[2].get(0);
		temp=ReadImageUtil.bossImgs[2].get(0).getScaledInstance(bossThreeButton.getWidth(),
				bossThreeButton.getHeight(), Image.SCALE_DEFAULT);
		icon=new ImageIcon(temp);
		bossThreeButton.setIcon(icon);
		bossThreeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ChoosePlayerPlaneFrame cppf=new ChoosePlayerPlaneFrame(mainMenuFrame, 1, 2,isMouseMode);
				cppf.setVisible(true);
				dispose();
			}
		});
		getContentPane().add(bossThreeButton);
		
		JButton bossFourButton = new JButton();
		bossFourButton.setBounds(Data.CHOOSE_BOSS_BUTTON_POSITIN_X+Data.CHOOSE_BOSS_BUTTON_INTERVAL_X,
				Data.CHOOSE_BOSS_BUTTON_FIRST_POSITION_Y+Data.CHOOSE_BOSS_BUTTON_INTERVAL_Y,
				Data.CHOOSE_BOSS_BUTTON_WIDTH,
				Data.CHOOSE_BOSS_BUTTON_HEIGHT);
		
		bossFourButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ChoosePlayerPlaneFrame cppf=new ChoosePlayerPlaneFrame(mainMenuFrame, 1, 3,isMouseMode);
				cppf.setVisible(true);
				dispose();
			}
		});
		getContentPane().add(bossFourButton);
		
		JButton bossFiveButton = new JButton();
		bossFiveButton.setBounds(Data.CHOOSE_BOSS_BUTTON_POSITIN_X,
				Data.CHOOSE_BOSS_BUTTON_FIRST_POSITION_Y+Data.CHOOSE_BOSS_BUTTON_INTERVAL_Y*2,
				Data.CHOOSE_BOSS_BUTTON_WIDTH,
				Data.CHOOSE_BOSS_BUTTON_HEIGHT);
		
		bossFiveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ChoosePlayerPlaneFrame cppf=new ChoosePlayerPlaneFrame(mainMenuFrame, 1, 4,isMouseMode);
				cppf.setVisible(true);
				dispose();
			}
		});
		getContentPane().add(bossFiveButton);
		
		JButton mirrorButton = new JButton();
		mirrorButton.setBounds(Data.CHOOSE_BOSS_BUTTON_POSITIN_X+Data.CHOOSE_BOSS_BUTTON_INTERVAL_X,
				Data.CHOOSE_BOSS_BUTTON_FIRST_POSITION_Y+Data.CHOOSE_BOSS_BUTTON_INTERVAL_Y*2,
				Data.CHOOSE_BOSS_BUTTON_WIDTH,
				Data.CHOOSE_BOSS_BUTTON_HEIGHT);
		
		mirrorButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ChoosePlayerPlaneFrame cppf=new ChoosePlayerPlaneFrame(mainMenuFrame, 1, 5,isMouseMode);
				cppf.setVisible(true);
				dispose();
			}
		});
		getContentPane().add(mirrorButton);
		
		JButton backToMainMenuButton = new JButton();
		backToMainMenuButton.setIcon(new ImageIcon(("Imgs/backgroundImg/backToMainMenu.png")));
		backToMainMenuButton.setBounds(Data.CHOOSE_BOSS_BACK_TO_MAIN_MENU_BUTTON_POSITION_X,
				Data.CHOOSE_BOSS_BACK_TO_MAIN_MENU_BUTTON_POSITION_Y,
				Data.CHOOSE_BOSS_BACK_TO_MAIN_MENU_BUTTON_WIDTH,
				Data.CHOOSE_BOSS_BACK_TO_MAIN_MENU_BUTTON_HEIGHT);
		backToMainMenuButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				mainMenuFrame.setVisible(true);
			}
		});
		getContentPane().add(backToMainMenuButton);
		
		
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(ReadImageUtil.chooseBossFrameBackgroundImg, 0, 0, 
				Data.WINDOW_WIDTH, Data.WINDOW_HEIGHT, null);
		g.drawImage(ReadImageUtil.bossImgs[0].get(0),  Data.CHOOSE_BOSS_BUTTON_POSITIN_X,
				Data.CHOOSE_BOSS_BUTTON_FIRST_POSITION_Y,
				Data.CHOOSE_BOSS_BUTTON_WIDTH,
				Data.CHOOSE_BOSS_BUTTON_HEIGHT, null);
		g.drawImage(ReadImageUtil.bossImgs[1].get(0),  Data.CHOOSE_BOSS_BUTTON_POSITIN_X+Data.CHOOSE_BOSS_BUTTON_INTERVAL_X,
				Data.CHOOSE_BOSS_BUTTON_FIRST_POSITION_Y,
				Data.CHOOSE_BOSS_BUTTON_WIDTH,
				Data.CHOOSE_BOSS_BUTTON_HEIGHT, null);
		g.drawImage(ReadImageUtil.bossImgs[2].get(0),  Data.CHOOSE_BOSS_BUTTON_POSITIN_X,
				Data.CHOOSE_BOSS_BUTTON_FIRST_POSITION_Y+Data.CHOOSE_BOSS_BUTTON_INTERVAL_Y,
				Data.CHOOSE_BOSS_BUTTON_WIDTH,
				Data.CHOOSE_BOSS_BUTTON_HEIGHT, null);
		
		g.drawImage(ReadImageUtil.chooseBossHeadPortraitImgs[0], Data.CHOOSE_BOSS_BUTTON_POSITIN_X-10,
				Data.CHOOSE_BOSS_BUTTON_FIRST_POSITION_Y-10,
				Data.CHOOSE_BOSS_BUTTON_WIDTH+20,
				Data.CHOOSE_BOSS_BUTTON_HEIGHT+20, null);
		g.drawImage(ReadImageUtil.chooseBossHeadPortraitImgs[1], Data.CHOOSE_BOSS_BUTTON_POSITIN_X+Data.CHOOSE_BOSS_BUTTON_INTERVAL_X-10,
				Data.CHOOSE_BOSS_BUTTON_FIRST_POSITION_Y-10,
				Data.CHOOSE_BOSS_BUTTON_WIDTH+20,
				Data.CHOOSE_BOSS_BUTTON_HEIGHT+20, null);
		g.drawImage(ReadImageUtil.chooseBossHeadPortraitImgs[2], Data.CHOOSE_BOSS_BUTTON_POSITIN_X-10,
				Data.CHOOSE_BOSS_BUTTON_FIRST_POSITION_Y+Data.CHOOSE_BOSS_BUTTON_INTERVAL_Y-10,
				Data.CHOOSE_BOSS_BUTTON_WIDTH+20,
				Data.CHOOSE_BOSS_BUTTON_HEIGHT+20, null);
		g.drawImage(ReadImageUtil.chooseBossHeadPortraitImgs[3], Data.CHOOSE_BOSS_BUTTON_POSITIN_X+Data.CHOOSE_BOSS_BUTTON_INTERVAL_X-10,
				Data.CHOOSE_BOSS_BUTTON_FIRST_POSITION_Y+Data.CHOOSE_BOSS_BUTTON_INTERVAL_Y-10,
				Data.CHOOSE_BOSS_BUTTON_WIDTH+20,
				Data.CHOOSE_BOSS_BUTTON_HEIGHT+20, null);
		g.drawImage(ReadImageUtil.chooseBossHeadPortraitImgs[4], Data.CHOOSE_BOSS_BUTTON_POSITIN_X-10,
				Data.CHOOSE_BOSS_BUTTON_FIRST_POSITION_Y+Data.CHOOSE_BOSS_BUTTON_INTERVAL_Y*2-10,
				Data.CHOOSE_BOSS_BUTTON_WIDTH+20,
				Data.CHOOSE_BOSS_BUTTON_HEIGHT+20, null);
		g.drawImage(ReadImageUtil.chooseBossHeadPortraitImgs[5], Data.CHOOSE_BOSS_BUTTON_POSITIN_X+Data.CHOOSE_BOSS_BUTTON_INTERVAL_X-10,
				Data.CHOOSE_BOSS_BUTTON_FIRST_POSITION_Y+Data.CHOOSE_BOSS_BUTTON_INTERVAL_Y*2-10,
				Data.CHOOSE_BOSS_BUTTON_WIDTH+20,
				Data.CHOOSE_BOSS_BUTTON_HEIGHT+20, null);
		g.drawImage(ReadImageUtil.backToMainMenuImg, Data.CHOOSE_BOSS_BACK_TO_MAIN_MENU_BUTTON_POSITION_X,
				Data.CHOOSE_BOSS_BACK_TO_MAIN_MENU_BUTTON_POSITION_Y,
				Data.CHOOSE_BOSS_BACK_TO_MAIN_MENU_BUTTON_WIDTH,
				Data.CHOOSE_BOSS_BACK_TO_MAIN_MENU_BUTTON_HEIGHT, null);
	}
	
	
}
