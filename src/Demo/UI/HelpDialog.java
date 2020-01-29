package Demo.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;


import Demo.Data.Data;
import Demo.Util.ReadImageUtil;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class HelpDialog extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public HelpDialog() {
		setBounds(Data.DIALOG_POSITION_X, Data.DIALOG_POSITION_Y,
				Data.DIALOG_WIDTH, Data.DIALOG_HEIGHT);
		setUndecorated(true);
		getContentPane().setLayout(null);
		
		JButton confirmButton = new JButton();
		confirmButton.setIcon(new ImageIcon(("Imgs/backgroundImg/confirmImg.png")));
		confirmButton.setBounds(Data.CHOOSE_BOSS_BACK_TO_MAIN_MENU_BUTTON_POSITION_X,
				Data.CHOOSE_BOSS_BACK_TO_MAIN_MENU_BUTTON_POSITION_Y,
				Data.CHOOSE_BOSS_BACK_TO_MAIN_MENU_BUTTON_WIDTH,
				Data.CHOOSE_BOSS_BACK_TO_MAIN_MENU_BUTTON_HEIGHT);
		confirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		getContentPane().add(confirmButton);
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(ReadImageUtil.helpBackgroundImg, 0, 0, Data.DIALOG_WIDTH, Data.DIALOG_HEIGHT,null);
		g.setFont(new Font("楷体", Font.BOLD, 30));
		g.setColor(Color.yellow);
		g.drawString("移动：     W      或     ↑", 100, 100);
		g.drawString("       A S D        ← ↓ →", 128, 130);
		g.drawString("开火：           空格", 100, 200);
		g.drawRect(320, 170, 200, 35);
		g.drawString("原子弹：           L", 100, 300);
		g.drawRect(400, 270, 40, 40);
		g.drawImage(ReadImageUtil.confirmImg, Data.CHOOSE_BOSS_BACK_TO_MAIN_MENU_BUTTON_POSITION_X,
				Data.CHOOSE_BOSS_BACK_TO_MAIN_MENU_BUTTON_POSITION_Y,
				Data.CHOOSE_BOSS_BACK_TO_MAIN_MENU_BUTTON_WIDTH,
				Data.CHOOSE_BOSS_BACK_TO_MAIN_MENU_BUTTON_HEIGHT, null);
	}
}
