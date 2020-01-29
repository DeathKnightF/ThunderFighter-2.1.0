package Demo.UI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;

import Demo.Data.Data;


public class SetDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		new SetDialog().setVisible(true);
//	}
	
	public SetDialog(MainMenuFrame mmf) {
		// TODO Auto-generated constructor stub
		setBounds(Data.WINDOW_POSITION_X, Data.WINDOW_POSITION_Y, Data.WINDOW_WIDTH, Data.WINDOW_HEIGHT);
//		setUndecorated(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JCheckBox selectSizeButton1=new JCheckBox("半屏模式");
		JCheckBox selectSizeButton2=new JCheckBox("全屏模式");
		JCheckBox selectControlButton1=new JCheckBox("鼠标操作");
		JCheckBox selectControlButton2=new JCheckBox("键盘操作");
		
		selectSizeButton1.setBounds(Data.SET_DIALOG_SELECT_BUTTON_POSITION_X1,
				Data.SET_DIALOG_SELECT_BUTTON_POSITION_Y,
				Data.SET_DIALOG_SELECT_BUTTON_WIDTH,
				Data.SET_DIALOG_SELECT_BUTTON_HEIGHT);
		selectSizeButton1.setFont(new Font("楷体",Font.BOLD,40));
		getContentPane().add(selectSizeButton1);
		
		
		selectSizeButton2.setBounds(Data.SET_DIALOG_SELECT_BUTTON_POSITION_X2,
				Data.SET_DIALOG_SELECT_BUTTON_POSITION_Y,
				Data.SET_DIALOG_SELECT_BUTTON_WIDTH,
				Data.SET_DIALOG_SELECT_BUTTON_HEIGHT);
		selectSizeButton2.setFont(new Font("楷体",Font.BOLD,40));
		getContentPane().add(selectSizeButton2);
		
		selectControlButton1.setBounds(Data.SET_DIALOG_SELECT_BUTTON_POSITION_X1,
				Data.SET_DIALOG_SELECT_BUTTON_POSITION_Y+Data.SET_DIALOG_SELECT_BUTTON_INTERVAL_Y,
				Data.SET_DIALOG_SELECT_BUTTON_WIDTH,
				Data.SET_DIALOG_SELECT_BUTTON_HEIGHT);
		selectControlButton1.setFont(new Font("楷体",Font.BOLD,40));
		getContentPane().add(selectControlButton1);
		
		
		selectControlButton2.setBounds(Data.SET_DIALOG_SELECT_BUTTON_POSITION_X2,
				Data.SET_DIALOG_SELECT_BUTTON_POSITION_Y+Data.SET_DIALOG_SELECT_BUTTON_INTERVAL_Y,
				Data.SET_DIALOG_SELECT_BUTTON_WIDTH,
				Data.SET_DIALOG_SELECT_BUTTON_HEIGHT);
		selectControlButton2.setFont(new Font("楷体",Font.BOLD,40));
		getContentPane().add(selectControlButton2);
		
		JButton conFirmButton=new JButton("确定");
		conFirmButton.setBounds(Data.SET_DIALOG_SELECT_BUTTON_POSITION_X1,
				Data.SET_DIALOG_SELECT_BUTTON_POSITION_Y+Data.SET_DIALOG_SELECT_BUTTON_INTERVAL_Y*4,
				Data.SET_DIALOG_SELECT_BUTTON_WIDTH,
				Data.SET_DIALOG_SELECT_BUTTON_HEIGHT);
		conFirmButton.setFont(new Font("楷体",Font.BOLD,40));
		conFirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							if(!mmf.rsu.isClosed)
								mmf.rsu.close();
							if(selectSizeButton2.isSelected()&&!selectSizeButton1.isSelected()) {
								Data.WINDOW_WIDTH=Toolkit.getDefaultToolkit().getScreenSize().height;
								Data.WINDOW_HEIGHT=Toolkit.getDefaultToolkit().getScreenSize().width;
								Data.WINDOW_POSITION_X=0;
								int WINDOW_WIDTH=Data.WINDOW_WIDTH;
								int WINDOW_HEIGHT=Data.WINDOW_HEIGHT;
								int WINDOW_POSITION_X=Data.WINDOW_POSITION_X;
								Data.HEAD_PORTRAIT_FRAME_WIDTH=WINDOW_WIDTH/2;
								Data.BOSS_HEAD_PORTRAIT_WIDTH=WINDOW_WIDTH/3;
								Data.BOSS_HEAD_PORTRAIT_X=Data.HEAD_PORTRAIT_FRAME_WIDTH+WINDOW_WIDTH/10;
								Data.BOSS_HEAD_PORTRAIT_Y=WINDOW_HEIGHT/20;
								Data.MENU_BUTTON_WIDTH=WINDOW_WIDTH/10;
								Data.MENU_BUTTON_HEIGHT=Data.MENU_BUTTON_WIDTH;
								Data.MENU_BUTTON_X=WINDOW_WIDTH-Data.MENU_BUTTON_WIDTH;
								Data.MENU_BUTTON_Y=WINDOW_HEIGHT-Data.MENU_BUTTON_HEIGHT;
								Data.MAIN_MENU_FRAME_BUTTON_WIDTH=WINDOW_WIDTH/4;//主界面按钮宽度
								Data.MAIN_MENU_FRAME_BUTTON_HEIGHT=WINDOW_HEIGHT/10;
								Data.ATOMIC_BOMB_BUTTON_WIDTH=Data.MENU_BUTTON_WIDTH;
								Data.ATOMIC_BOMB_BUTTON_HEIGHT=Data.ATOMIC_BOMB_BUTTON_WIDTH;
								Data.ATOMIC_BOMB_BUTTON_POSITION_X=0;
								Data.ATOMIC_BOMB_BUTTON_POSITION_Y=WINDOW_HEIGHT-Data.ATOMIC_BOMB_BUTTON_HEIGHT;
								Data.DIALOG_WIDTH=WINDOW_WIDTH;
								Data.DIALOG_HEIGHT=WINDOW_HEIGHT;
								Data.DIALOG_POSITION_X=WINDOW_POSITION_X;
								Data.CHOOSE_PLAYER_PLANE_FRAME_CONFIRM_BUTTON_POSITION_X=WINDOW_WIDTH/2-Data.DIALOG_BUTTON_WIDTH/2;
								Data.CHOOSE_PLAYER_PLANE_FRAME_CONFIRM_BUTTON_POSITION_Y=WINDOW_HEIGHT*2/3;
								Data.CHOOSE_PLAYER_PLANE_FRAME_PLANE_IMG_WIDTH=WINDOW_WIDTH/4;
								Data.CHOOSE_PLAYER_PLANE_FRAME_PLANE_IMG_POSITION_X=WINDOW_WIDTH/2
											-Data.CHOOSE_PLAYER_PLANE_FRAME_PLANE_IMG_WIDTH/2;
								Data.CHOOSE_PLAYER_PLANE_FRAME_PLANE_IMG_POSITION_Y=WINDOW_HEIGHT/3;
								Data.CHOOSE_PLAYER_PLANE_FRAME_TURN_BUTTON_POSITION_Y=WINDOW_HEIGHT/2
											-Data.CHOOSE_PLAYER_PLANE_FRAME_TURN_BUTTON_HEIGHT/2;
								Data.CHOOSE_PLAYER_PLANE_FRAME_DATA_STRIP_STANDARD_WIDTH=WINDOW_WIDTH/4;//数据条
								Data.CHOOSE_PLAYER_PLANE_FRAME_DATA_WORD_POSITION_X=WINDOW_WIDTH/15;
								Data.CHOOSE_PLAYER_PLANE_FRAME_DATA_WORD_FIRST_POSITION_Y=WINDOW_HEIGHT*6/7;
								Data.CHOOSE_BOSS_BUTTON_WIDTH=WINDOW_WIDTH/8;
								Data.CHOOSE_BOSS_BUTTON_POSITIN_X=WINDOW_WIDTH/4;
								Data.CHOOSE_BOSS_BUTTON_FIRST_POSITION_Y=WINDOW_HEIGHT/20;
								Data.CHOOSE_PLAYER_PLANE_FRAME_DATA_STRIP_FIRST_POSITION_Y=
										Data.CHOOSE_PLAYER_PLANE_FRAME_DATA_WORD_FIRST_POSITION_Y-Data.CHOOSE_PLAYER_PLANE_FRAME_DATA_STRIP_HEIGHT;
								Data.CHOOSE_BOSS_BUTTON_INTERVAL_X=WINDOW_WIDTH*3/8;//水平间隔
								Data.CHOOSE_BOSS_BUTTON_INTERVAL_Y=Data.CHOOSE_BOSS_BUTTON_HEIGHT+WINDOW_HEIGHT/10;
								Data.CHOOSE_BOSS_BACK_TO_MAIN_MENU_BUTTON_WIDTH=WINDOW_WIDTH/3;
								Data.CHOOSE_BOSS_BACK_TO_MAIN_MENU_BUTTON_POSITION_X=WINDOW_WIDTH/3;
								Data.CHOOSE_BOSS_BACK_TO_MAIN_MENU_BUTTON_POSITION_Y=WINDOW_HEIGHT*4/5;
								Data.END_DIALOG_POSITION_X=WINDOW_WIDTH*5/12;
								Data.END_DIALOG_FIRST_POSITION_Y=WINDOW_HEIGHT/3;
								Data.END_DIALOG_COIN_POSITION_Y=WINDOW_HEIGHT*8/12;
								Data.END_DIALOG_COIN_POSITION_X=WINDOW_WIDTH*8/12;
								Data.SET_DIALOG_SELECT_BUTTON_POSITION_X1=WINDOW_WIDTH/10;
								Data.SET_DIALOG_SELECT_BUTTON_POSITION_X2=WINDOW_WIDTH*3/5;
								Data.SET_DIALOG_SELECT_BUTTON_POSITION_Y=WINDOW_HEIGHT/15;
								Data.SET_DIALOG_SELECT_BUTTON_INTERVAL_Y=WINDOW_HEIGHT/10;
								Data.SET_DIALOG_SELECT_BUTTON_WIDTH=WINDOW_WIDTH/3;
								Data.SET_DIALOG_SELECT_BUTTON_HEIGHT=WINDOW_HEIGHT/10;
								Data.PLAYER_PLANE_START_X=WINDOW_WIDTH/2-30;//起始坐标
								Data.PLAYER_PLANE_START_Y=WINDOW_HEIGHT-130;
								Data.PLAYER_PLANE_WIDTH=WINDOW_WIDTH/15;
								Data.ENEMY_PlANE_WIDTH=WINDOW_WIDTH/14;
								Data.BOSS_POSITION_X=WINDOW_WIDTH/2;
								Data.BOSS_WIDTH=WINDOW_WIDTH/7;
								Data.BOSS_HEIGHT=Data.BOSS_WIDTH;
							}
							if(selectSizeButton1.isSelected()) {
								Data.WINDOW_WIDTH=Toolkit.getDefaultToolkit().getScreenSize().width*2/3;
								Data.WINDOW_HEIGHT=Toolkit.getDefaultToolkit().getScreenSize().height;
								Data.WINDOW_POSITION_X=150;
								int WINDOW_WIDTH=Data.WINDOW_WIDTH;
								int WINDOW_HEIGHT=Data.WINDOW_HEIGHT;
								int WINDOW_POSITION_X=Data.WINDOW_POSITION_X;
								Data.HEAD_PORTRAIT_FRAME_WIDTH=WINDOW_WIDTH/2;
								Data.BOSS_HEAD_PORTRAIT_WIDTH=WINDOW_WIDTH/3;
								Data.BOSS_HEAD_PORTRAIT_X=Data.HEAD_PORTRAIT_FRAME_WIDTH+WINDOW_WIDTH/10;
								Data.BOSS_HEAD_PORTRAIT_Y=WINDOW_HEIGHT/20;
								Data.MENU_BUTTON_WIDTH=WINDOW_WIDTH/10;
								Data.MENU_BUTTON_HEIGHT=Data.MENU_BUTTON_WIDTH;
								Data.MENU_BUTTON_X=WINDOW_WIDTH-2*Data.MENU_BUTTON_WIDTH;
								Data.MENU_BUTTON_Y=+WINDOW_HEIGHT-Data.MENU_BUTTON_HEIGHT;
								Data.ATOMIC_BOMB_BUTTON_WIDTH=Data.MENU_BUTTON_WIDTH;
								Data.ATOMIC_BOMB_BUTTON_HEIGHT=Data.ATOMIC_BOMB_BUTTON_WIDTH;
								Data.ATOMIC_BOMB_BUTTON_POSITION_X=0;
								Data.ATOMIC_BOMB_BUTTON_POSITION_Y=WINDOW_HEIGHT-Data.ATOMIC_BOMB_BUTTON_HEIGHT;
								Data.MAIN_MENU_FRAME_BUTTON_WIDTH=WINDOW_WIDTH/4;//主界面按钮宽度
								Data.MAIN_MENU_FRAME_BUTTON_HEIGHT=WINDOW_HEIGHT/10;
								Data.DIALOG_WIDTH=WINDOW_WIDTH;
								Data.DIALOG_HEIGHT=WINDOW_HEIGHT;
								Data.DIALOG_POSITION_X=WINDOW_POSITION_X;
								Data.CHOOSE_PLAYER_PLANE_FRAME_CONFIRM_BUTTON_POSITION_X=WINDOW_WIDTH/2-Data.DIALOG_BUTTON_WIDTH/2;
								Data.CHOOSE_PLAYER_PLANE_FRAME_CONFIRM_BUTTON_POSITION_Y=WINDOW_HEIGHT*2/3;
								Data.CHOOSE_PLAYER_PLANE_FRAME_PLANE_IMG_WIDTH=WINDOW_WIDTH/4;
								Data.CHOOSE_PLAYER_PLANE_FRAME_PLANE_IMG_POSITION_X=WINDOW_WIDTH/2
											-Data.CHOOSE_PLAYER_PLANE_FRAME_PLANE_IMG_WIDTH/2;
								Data.CHOOSE_PLAYER_PLANE_FRAME_PLANE_IMG_POSITION_Y=WINDOW_HEIGHT/3;
								Data.CHOOSE_PLAYER_PLANE_FRAME_TURN_BUTTON_POSITION_Y=WINDOW_HEIGHT/2
											-Data.CHOOSE_PLAYER_PLANE_FRAME_TURN_BUTTON_HEIGHT/2;
								Data.CHOOSE_PLAYER_PLANE_FRAME_DATA_STRIP_STANDARD_WIDTH=WINDOW_WIDTH/4;//数据条
								Data.CHOOSE_PLAYER_PLANE_FRAME_DATA_WORD_POSITION_X=WINDOW_WIDTH/15;
								Data.CHOOSE_PLAYER_PLANE_FRAME_DATA_WORD_FIRST_POSITION_Y=WINDOW_HEIGHT*6/7;
								Data.CHOOSE_BOSS_BUTTON_WIDTH=WINDOW_WIDTH/8;
								Data.CHOOSE_BOSS_BUTTON_POSITIN_X=WINDOW_WIDTH/4;
								Data.CHOOSE_BOSS_BUTTON_FIRST_POSITION_Y=WINDOW_HEIGHT/20;
								Data.CHOOSE_PLAYER_PLANE_FRAME_DATA_STRIP_FIRST_POSITION_Y=
										Data.CHOOSE_PLAYER_PLANE_FRAME_DATA_WORD_FIRST_POSITION_Y-Data.CHOOSE_PLAYER_PLANE_FRAME_DATA_STRIP_HEIGHT;
								Data.CHOOSE_BOSS_BUTTON_INTERVAL_X=WINDOW_WIDTH*3/8;//水平间隔
								Data.CHOOSE_BOSS_BUTTON_INTERVAL_Y=Data.CHOOSE_BOSS_BUTTON_HEIGHT+WINDOW_HEIGHT/10;
								Data.CHOOSE_BOSS_BACK_TO_MAIN_MENU_BUTTON_WIDTH=WINDOW_WIDTH/3;
								Data.CHOOSE_BOSS_BACK_TO_MAIN_MENU_BUTTON_POSITION_X=WINDOW_WIDTH/3;
								Data.CHOOSE_BOSS_BACK_TO_MAIN_MENU_BUTTON_POSITION_Y=WINDOW_HEIGHT*4/5;
								Data.END_DIALOG_POSITION_X=WINDOW_WIDTH*5/12;
								Data.END_DIALOG_FIRST_POSITION_Y=WINDOW_HEIGHT/3;
								Data.END_DIALOG_COIN_POSITION_Y=WINDOW_HEIGHT*8/12;
								Data.END_DIALOG_COIN_POSITION_X=WINDOW_WIDTH*8/12;
								Data.SET_DIALOG_SELECT_BUTTON_POSITION_X1=WINDOW_WIDTH/10;
								Data.SET_DIALOG_SELECT_BUTTON_POSITION_X2=WINDOW_WIDTH*3/5;
								Data.SET_DIALOG_SELECT_BUTTON_POSITION_Y=WINDOW_HEIGHT/15;
								Data.SET_DIALOG_SELECT_BUTTON_INTERVAL_Y=WINDOW_HEIGHT/10;
								Data.SET_DIALOG_SELECT_BUTTON_WIDTH=WINDOW_WIDTH/3;
								Data.SET_DIALOG_SELECT_BUTTON_HEIGHT=WINDOW_HEIGHT/10;
								Data.PLAYER_PLANE_START_X=WINDOW_WIDTH/2-30;//起始坐标
								Data.PLAYER_PLANE_START_Y=WINDOW_HEIGHT-130;
								Data.PLAYER_PLANE_WIDTH=WINDOW_WIDTH/15;
								Data.ENEMY_PlANE_WIDTH=WINDOW_WIDTH/14;
								Data.BOSS_POSITION_X=WINDOW_WIDTH/2;
								Data.BOSS_WIDTH=WINDOW_WIDTH/7;
								Data.BOSS_HEIGHT=Data.BOSS_WIDTH;	
							}
							boolean isMouseMode=true;
							if(selectControlButton2.isSelected())
								isMouseMode=false;
							dispose();
							MainMenuFrame frame = new MainMenuFrame(isMouseMode);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		getContentPane().add(conFirmButton);
		
		JButton cancelButton=new JButton("取消");
		cancelButton.setBounds(Data.SET_DIALOG_SELECT_BUTTON_POSITION_X2,
				Data.SET_DIALOG_SELECT_BUTTON_POSITION_Y+Data.SET_DIALOG_SELECT_BUTTON_INTERVAL_Y*4,
				Data.SET_DIALOG_SELECT_BUTTON_WIDTH,
				Data.SET_DIALOG_SELECT_BUTTON_HEIGHT);
		cancelButton.setFont(new Font("楷体",Font.BOLD,40));
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				mmf.setVisible(true);
			}
		});
		getContentPane().add(cancelButton);
	}

	

}
