package Demo.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import Demo.Data.Data;
import Demo.Role.EnemyPlane;
import Demo.Role.PlayerPlane;
import Demo.Util.ReadImageUtil;
import Demo.Util.ReadSoundUtil;

/**
 * 游戏界面暂停对话框
 * @author 董楷烽
 *
 */
public class StopDialog extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	MainMenuFrame mainMenuFrame;
	GameFrame gameFrame;
	PlayerPlane player;
	EnemyPlane BOSS;
	public StopDialog(MainMenuFrame mainMenuFrame,
			GameFrame gameFrame,
			PlayerPlane player,
			EnemyPlane BOSS) {
		setBounds(Data.DIALOG_POSITION_X, Data.DIALOG_POSITION_Y, 
				Data.DIALOG_WIDTH, Data.DIALOG_HEIGHT);
		setUndecorated(true);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		
		this.mainMenuFrame=mainMenuFrame;
		this.gameFrame=gameFrame;
		this.player=player;
		this.BOSS=BOSS;
		
		JButton continueButton = new JButton();
		continueButton.setIcon(new ImageIcon(("Imgs/backgroundImg/continueImg.png")));
		continueButton.setBounds(31, 276, 190, 60);
		continueButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				try {
					mainMenuFrame.semaphore.acquire();
					mainMenuFrame.suspend=false;
					mainMenuFrame.semaphore.release();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				synchronized (mainMenuFrame.lock) {
					mainMenuFrame.lock.notifyAll();
				}
			}
		});
		getContentPane().add(continueButton);
		
		JButton backToMainMenuButton = new JButton();
		backToMainMenuButton.setBounds(31, 377, 190, 70);
		Image temp=ReadImageUtil.backToMainMenuImg.getScaledInstance(backToMainMenuButton.getWidth(),
				backToMainMenuButton.getHeight(), Image.SCALE_DEFAULT);
		ImageIcon icon=new ImageIcon(temp);
		backToMainMenuButton.setIcon(icon);
		backToMainMenuButton.setIcon(new ImageIcon(("Imgs/backgroundImg/backToMainMenu.png")));
		
		backToMainMenuButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mainMenuFrame.setVisible(true);
				setVisible(false);
				gameFrame.dispose();
			}
		});
		getContentPane().add(backToMainMenuButton);
		
		JButton soundControlButton = new JButton();
		soundControlButton.setBounds(31, 495, 190, 60);
		soundControlButton.setIcon(new ImageIcon(("Imgs/backgroundImg/soundControlButton.png")));
		soundControlButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(mainMenuFrame.rsu.isClosed) {
					mainMenuFrame.rsu=new ReadSoundUtil();
					mainMenuFrame.rsu.loop();
				}else {
					mainMenuFrame.rsu.close();
				}	
			}
		});
		getContentPane().add(soundControlButton);
		
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(ReadImageUtil.menuDialogBackgroundImg, 0, 0, Data.DIALOG_WIDTH+200, Data.DIALOG_HEIGHT,  null);
		g.drawImage(ReadImageUtil.menuDialogImg, 0, 0, Data.DIALOG_WIDTH, Data.DIALOG_HEIGHT, null);
		g.drawImage(ReadImageUtil.continueButtonImg, 31, 276, 190, 60, null);
		g.drawImage(ReadImageUtil.backToMainMenuImg, 31, 377, 190, 70, null);
		g.drawImage(ReadImageUtil.soundControlButtonImg, 31, 495, 190, 60, null);
		g.setColor(Color.YELLOW);
		g.setFont(new Font("宋体",Font.BOLD,30));
		g.drawString("当前飞机血量："+player.blood, Data.DIALOG_WIDTH/2-100, 200);
		g.drawString("当前飞机单发伤害："+player.harm, Data.DIALOG_WIDTH/2-100, 250);
		g.drawString("当前击杀敌机数量："+player.kills, Data.DIALOG_WIDTH/2-100, 300);
		if(BOSS.live)
			g.drawString("当前BOSS血量："+BOSS.blood, Data.DIALOG_WIDTH/2-100, 350);
	}
	
}
