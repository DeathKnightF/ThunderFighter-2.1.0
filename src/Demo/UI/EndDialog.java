package Demo.UI;


import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import Demo.Data.Data;
import Demo.Role.EnemyPlane;
import Demo.Util.ReadImageUtil;



public class EndDialog extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	MainMenuFrame mainMenuFrame;
	
	private Image background;
	private int kills,coin,score;
	private Date startTime;
	private boolean win;
	private boolean isBossMode;
	private EnemyPlane BOSS;

	/**
	 * Create the dialog.
	 */
	public EndDialog(int kills,
			int coin,
			Date startTime,
			boolean win,
			boolean isBossMode,
			EnemyPlane BOSS,
			MainMenuFrame mainMenuFrame) {
		
		this.mainMenuFrame=mainMenuFrame;
		
		setBounds(Data.DIALOG_POSITION_X, Data.DIALOG_POSITION_Y,
				Data.DIALOG_WIDTH, Data.DIALOG_HEIGHT);
		setUndecorated(true);
		
		background=ReadImageUtil.endDialogImg;
		this.kills=kills;
		this.coin=coin;
		this.startTime=startTime;
		this.win=win;
		this.isBossMode=isBossMode;
		this.BOSS=BOSS;
		getContentPane().setLayout(null);
		
		JButton button=new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainMenuFrame.setVisible(true);
				setVisible(false); 
			}
		});
		button.setIcon(new ImageIcon(("Imgs/backgroundImg/confirmImg.png")));
		button.setBounds( Data.CHOOSE_BOSS_BACK_TO_MAIN_MENU_BUTTON_POSITION_X,
				Data.WINDOW_HEIGHT*3/4,
				Data.CHOOSE_BOSS_BACK_TO_MAIN_MENU_BUTTON_WIDTH,
				Data.CHOOSE_BOSS_BACK_TO_MAIN_MENU_BUTTON_HEIGHT);
		getContentPane().add(button);
	}
	@Override
	public void paint(Graphics g) {
		if(background!=null)
			g.drawImage(background, 0, 0, Data.DIALOG_WIDTH, Data.DIALOG_HEIGHT, null);
		if(!win)
			g.drawImage(ReadImageUtil.failureImg, 230, 0, 100, 170, null);
		g.setFont(new Font("宋体", Font.BOLD,40));
		Date endTime=new Date();
		int liveTime=(int)((endTime.getTime()-startTime.getTime())/1000);
		score=liveTime+kills*10;
		coin=score/10;
		mainMenuFrame.rpdu.coin+=coin;
		mainMenuFrame.rpdu.topGrade=Math.max(mainMenuFrame.rpdu.topGrade, score);
		if(isBossMode) {
			g.drawString("生存时间："+liveTime,Data.END_DIALOG_POSITION_X,Data.END_DIALOG_FIRST_POSITION_Y);
			g.drawString("最终得分：", Data.END_DIALOG_POSITION_X,Data.END_DIALOG_FIRST_POSITION_Y+Data.END_DIALOG_INTERVAL);
			g.drawString(" "+(BOSS.max_blood-BOSS.blood), Data.END_DIALOG_POSITION_X,
					Data.END_DIALOG_FIRST_POSITION_Y+Data.END_DIALOG_INTERVAL*2);
			g.drawString(""+(BOSS.max_blood-BOSS.blood)/10, Data.END_DIALOG_COIN_POSITION_X,
					Data.END_DIALOG_COIN_POSITION_Y);//金币
			g.drawString("null",Data.WINDOW_WIDTH*5/8,
					Data.WINDOW_HEIGHT*10/11);
		}else {
			g.drawString("击毁敌机："+kills, Data.END_DIALOG_POSITION_X,Data.END_DIALOG_FIRST_POSITION_Y);
			g.drawString("生存时间："+liveTime,Data.END_DIALOG_POSITION_X,
					Data.END_DIALOG_FIRST_POSITION_Y+Data.END_DIALOG_INTERVAL);
			g.drawString("最终得分：", Data.END_DIALOG_POSITION_X,
					Data.END_DIALOG_FIRST_POSITION_Y+Data.END_DIALOG_INTERVAL*2);
			g.drawString(" "+score, Data.END_DIALOG_POSITION_X,
					Data.END_DIALOG_FIRST_POSITION_Y+Data.END_DIALOG_INTERVAL*3);
			g.drawString(""+coin, Data.END_DIALOG_COIN_POSITION_X,
					Data.END_DIALOG_COIN_POSITION_Y);
			g.drawString(""+mainMenuFrame.rpdu.topGrade,Data.WINDOW_WIDTH*5/8,
					Data.WINDOW_HEIGHT*10/11);
		}
		
	}

}
