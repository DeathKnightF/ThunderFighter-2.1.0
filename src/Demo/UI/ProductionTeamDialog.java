package Demo.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Demo.Data.Data;
import Demo.Util.ReadImageUtil;

public class ProductionTeamDialog extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public ProductionTeamDialog() {
		setBounds(Data.DIALOG_POSITION_X, Data.DIALOG_POSITION_Y,
				Data.DIALOG_WIDTH, Data.DIALOG_HEIGHT);
		setUndecorated(true);
		words=new StringNode[3];
		words[0]=new StringNode("董楷烽", (100*Math.random()+100), 
				(100*Math.random()+100), (10*Math.random()+10), 
				Math.random()*2*Math.PI,new Font("楷体",Font.BOLD,40),Color.YELLOW);
		words[1]=new StringNode("制作人", (100*Math.random()+200), 
				(100*Math.random()+100), (5*Math.random()+10), 
				Math.random()*2*Math.PI,new Font("楷体",Font.BOLD,30),Color.blue);
		words[2]=new StringNode("天选之人", (200*Math.random()+50), 
				(100*Math.random()+100), (20*Math.random()+10), 
				Math.random()*2*Math.PI,new Font("楷体",Font.BOLD,50),Color.RED);
		new DrawThread().start();
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
		add(confirmButton);
	}

	class StringNode{
		String word;
		double x,y;
		double speed,degree;
		Font font;
		Color color;
		int a=1;
		public StringNode(String word, double x, double y, double speed, double degree,Font font,Color color) {
			this.word = word;
			this.x = x;
			this.y = y;
			this.speed = speed;
			this.degree = degree;
			this.font=font;
			this.color=color;
		}
		
	}
	
	private StringNode[] words;
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(ReadImageUtil.productionTeamBackgroundImg, -200,0,Data.DIALOG_WIDTH*3/2, Data.DIALOG_HEIGHT,null);
		for(int i=0;i<3;i++) {
			
			words[i].speed=Math.sqrt(Math.pow(Math.sin(words[i].degree)*words[i].speed, 2)
					+Math.pow(words[i].a+words[i].speed*Math.cos(words[i].degree), 2));
			words[i].x+=words[i].speed*Math.cos(words[i].degree);
			words[i].y+=words[i].speed*Math.sin(words[i].degree);
			if(words[i].x<=0||words[i].x>=Data.DIALOG_WIDTH-100)
				words[i].degree=Math.PI-words[i].degree;
			if(words[i].y<=30||words[i].y>=Data.DIALOG_HEIGHT-50)
				words[i].degree=-words[i].degree;
			g.setFont(words[i].font);
			g.setColor(words[i].color);
			g.drawString(words[i].word, (int)words[i].x, (int)words[i].y);
		}
		g.drawImage(ReadImageUtil.confirmImg, Data.CHOOSE_BOSS_BACK_TO_MAIN_MENU_BUTTON_POSITION_X,
				Data.CHOOSE_BOSS_BACK_TO_MAIN_MENU_BUTTON_POSITION_Y,
				Data.CHOOSE_BOSS_BACK_TO_MAIN_MENU_BUTTON_WIDTH,
				Data.CHOOSE_BOSS_BACK_TO_MAIN_MENU_BUTTON_HEIGHT, null);
	}
	
	
	/**
	 * 重绘线程
	 */
	class DrawThread extends Thread{
		@Override
		public void run() {
			while(true) {
				repaint();
				try {
					sleep(40);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * 双缓冲处理闪烁
	 */
	private Image offScreenImage=null;
	public void update(Graphics g) {
		synchronized (g) {
			if(offScreenImage==null)
				offScreenImage=this.createImage(Data.WINDOW_WIDTH,Data.WINDOW_HEIGHT);
			Graphics gOff=offScreenImage.getGraphics();
			paint(gOff);
			g.drawImage(offScreenImage, 0, 0, null);
		}
	}
}
