package Demo.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.swing.JButton;
import javax.swing.JLabel;

import Demo.Data.Data;
import Demo.Role.Crash;
import Demo.Role.EnemyPlane;
import Demo.Role.Explode;
import Demo.Role.Init;
import Demo.Role.PlayerPlane;
import Demo.Role.Prop;
import Demo.Role.Shell;
import Demo.Util.ReadImageUtil;

public class GameFrame extends Frame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MainMenuFrame mainMenuFrame;
	GameFrame gameFrame;//用于向对话框构造器传送，便于暂停和恢复
	/**
	 * 背景属性
	 */
	private static Image backgroundImg11;//轮播背景图片
	private static Image backgroundImg12; 
	private int background_y1=0;//轮播背景第一张图片的纵坐标
	private int background_y2=-Data.WINDOW_HEIGHT;
	private Date startTime;//开始时间
	public int round;//第几关
	public boolean isBossMode;//是否是boss模式
	public boolean isMouseMode;
	private Clock clock;//时钟
	/**
	 * 玩家飞机
	 */
	private PlayerPlane player;
	/**
	 * 玩家导弹
	 */
	private ConcurrentLinkedQueue<Shell> playerShells;
	/**
	 * 敌机
	 */
	private ConcurrentLinkedQueue<EnemyPlane> enemyPlanes;
	private EnemyPlane BOSS;
	/**
	 * 敌机导弹
	 */
	public ConcurrentLinkedQueue<Shell> enemyShells;
	/**
	 * 爆炸
	 */
	private ConcurrentLinkedQueue<Explode> explodes;
	/**
	 * 道具
	 */
	public ConcurrentLinkedQueue<Prop> props;
	
	public GameFrame(PlayerPlane player,
			ConcurrentLinkedQueue<Shell> playerShells,
			ConcurrentLinkedQueue<EnemyPlane> enemyPlanes,
			ConcurrentLinkedQueue<Shell> enemyShells,
			ConcurrentLinkedQueue<Prop> props,
			EnemyPlane BOSS,
			int round,//第n关
			Date startTime,
			boolean isBossMode,//boss模式
			boolean isMouseMode,//鼠标模式
			MainMenuFrame mainMenuFrame) {
		
		this.player=player;
		this.playerShells=playerShells;
		this.enemyPlanes=enemyPlanes;
		this.enemyShells=enemyShells;
		this.props=props;
		this.startTime=startTime;
		this.BOSS=BOSS;
		this.round=round;
		this.isBossMode=isBossMode;
		this.isMouseMode=isBossMode;
		this.mainMenuFrame=mainMenuFrame;
		this.explodes=new ConcurrentLinkedQueue<Explode>();
		this.gameFrame=this;
		this.clock=new Clock();
		setUndecorated(true);
		setBounds(Data.WINDOW_POSITION_X, Data.WINDOW_POSITION_Y, 
				Data.WINDOW_WIDTH, Data.WINDOW_HEIGHT);
		setVisible(true);
		
		JButton menuButton=new JButton();
		menuButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					StopDialog stopDialog = new StopDialog(mainMenuFrame,gameFrame,player,BOSS);
					stopDialog.setVisible(true);
					mainMenuFrame.semaphore.acquire();//暂停游戏
					mainMenuFrame.suspend=true;
					mainMenuFrame.semaphore.release();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		menuButton.setBounds(Data.MENU_BUTTON_X, Data.MENU_BUTTON_Y,
				Data.MENU_BUTTON_WIDTH, Data.MENU_BUTTON_HEIGHT);
		add(menuButton);
		
		JButton atomicBombButton=new JButton();
		atomicBombButton.setBounds(Data.ATOMIC_BOMB_BUTTON_POSITION_X, Data.ATOMIC_BOMB_BUTTON_POSITION_Y, 
				Data.ATOMIC_BOMB_BUTTON_WIDTH, Data.ATOMIC_BOMB_BUTTON_HEIGHT);
		atomicBombButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				player.launchAtomicBomb=true;
			}
			
		});
		add(atomicBombButton);
		
		backgroundImg11=backgroundImg12=ReadImageUtil.getBackgroundImg(round);//背景图片
		
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
		
		
		new DrawThread().start();//重绘线程
		clock.start();
		addKeyListener(new KeyMonitor());//键盘控制
		JLabel jl=new JLabel();
		jl.setBounds(Data.WINDOW_POSITION_X, Data.WINDOW_POSITION_Y, 
				Data.WINDOW_WIDTH, Data.WINDOW_HEIGHT);
		if(isMouseMode)
			jl.addMouseMotionListener(new MouseMonitor());
		add(jl);
		requestFocus();//恢复键盘监听
	}
	
	
	@Override
	public  void paint(Graphics g) {
		//背景移动
		if(background_y1>=Data.WINDOW_HEIGHT)
			background_y1=-Data.WINDOW_HEIGHT;
		if(background_y2>=Data.WINDOW_HEIGHT)
			background_y2=-Data.WINDOW_HEIGHT;
		background_y1+=Data.BACKGROUND_SPEED_Y;
		background_y2+=Data.BACKGROUND_SPEED_Y;
		g.drawImage(backgroundImg11, 0, background_y1, Data.WINDOW_WIDTH,
						Data.WINDOW_HEIGHT, null);
		g.drawImage(backgroundImg12, 0, background_y2, Data.WINDOW_WIDTH,
						Data.WINDOW_HEIGHT, null);
		//画头像外框
		g.drawImage(ReadImageUtil.headPortraitFrameImg, 0, 0, Data.HEAD_PORTRAIT_FRAME_WIDTH,
				Data.HEAD_PORTRAIT_FRAME_HEIGHT, null);
		//画头像
		g.drawImage(ReadImageUtil.headPortraitImg, Data.HEAD_PORTRAIT_X, Data.HEAD_PORTRAIT_Y,
				Data.HEAD_PORTRAIT_WIDTH, Data.HEAD_PORTRAIT_HEIGHT, null);
		//画菜单选项
		g.drawImage(ReadImageUtil.menuImg, Data.MENU_BUTTON_X, Data.MENU_BUTTON_Y,
				Data.MENU_BUTTON_WIDTH, Data.MENU_BUTTON_HEIGHT, null);
		//画原子弹按钮
		g.drawImage(ReadImageUtil.atomicBombButtonImg, Data.ATOMIC_BOMB_BUTTON_POSITION_X, Data.ATOMIC_BOMB_BUTTON_POSITION_Y, 
				Data.ATOMIC_BOMB_BUTTON_WIDTH, Data.ATOMIC_BOMB_BUTTON_HEIGHT, null);
		//画道具，并判断玩家是否吃到道具
		Crash.crash(props,explodes,player, g);
		//画敌机和玩家导弹，并判断敌机是否与玩家或者玩家导弹相碰
		Crash.crash(player, playerShells, enemyPlanes,enemyShells, explodes, g);
		//画敌机导弹,并判断是否与玩家飞机相碰
		Crash.crash(player, enemyShells, explodes, g);
		//画血条
		int bloodWidth=player.blood>0?player.blood*Data.BLOOD_STRIP_MAX_WIDTH/player.max_blood:0;
		g.drawImage(ReadImageUtil.bloodStripImg, Data.BLOOD_STRIP_X+bloodWidth, Data.BLOOD_STRIP_Y,
				Data.BLOOD_STRIP_MAX_WIDTH-bloodWidth, Data.BLOOD_STRIP_HEIGHT, null);
		g.setFont(new Font("宋体",Font.CENTER_BASELINE,Data.FONT_SIZE));
		g.setColor(Color.yellow);
		g.drawString("血量", Data.BLOOD_CHARACERS_POSITION_X, Data.BLOOD_CHARACERS_POSITION_Y);
		//画经验条
		g.drawImage(ReadImageUtil.expStripImg, Data.EXP_STRIP_X, Data.EXP_STRIP_Y,
				Data.EXP_STRIP_MAX_WIDTH, Data.EXP_STRIP_HEIGHT, null);
		int currentExpWidth=Data.EXP_STRIP_MAX_WIDTH*player.exp/Data.PLAYER_UPGRADE_EXP[player.grade];
		g.drawImage(ReadImageUtil.bloodStripImg, Data.EXP_STRIP_X+currentExpWidth, Data.EXP_STRIP_Y, 
				Data.EXP_STRIP_MAX_WIDTH-currentExpWidth, Data.EXP_STRIP_HEIGHT, null);
		g.drawString("经验", Data.EXP_CHARACERS_POSITION_X, Data.EXP_CHARACERS_POSITION_Y);
		//画玩家飞机
		player.drawPlayerPlane(g);
		//画boss头框和血量
		if(BOSS!=null&&BOSS.live) {
			g.drawImage(ReadImageUtil.bossBloodFrameImg, Data.BOSS_HEAD_PORTRAIT_X, Data.BOSS_HEAD_PORTRAIT_Y,
					Data.BOSS_HEAD_PORTRAIT_WIDTH, Data.BOSS_HEAD_PORTRAIT_HEIGHT, null);
			int BossBloodStripWidth=Data.BOSS_BLOOD_STRIP_MAX_WIDTH*BOSS.blood/BOSS.max_blood;
			g.drawImage(ReadImageUtil.bossBloodStripImg, Data.BOSS_BLOOD_STRIP_X, Data.BOSS_BLOOD_STRIP_Y,
					BossBloodStripWidth, Data.BOSS_BLOOD_STRIP_HEIGHT, null);
			g.drawImage(BOSS.image, Data.BOSS_HEAD_PORTRAIT_IMG_X, Data.BOSS_HEAD_PORTRAIT_IMG_Y,
					Data.BOSS_HEAD_PORTRAIT_IMG_WIDTH, Data.BOSS_HEAD_PORTRAIT_IMG_HEIGHT, null);
		}
		//画爆炸
		Iterator<Explode> explodesIt=explodes.iterator();
		while(explodesIt.hasNext())
			((Explode) explodesIt.next()).drawExplode(g);
		//弹出结束窗口
		if(!player.live||isBossMode&&(!BOSS.live||BOSS.blood<=0)) {
			try {
				this.dispose();
				EndDialog dialog = new EndDialog(player.kills,player.coin,startTime,
						!player.live,isBossMode,BOSS,mainMenuFrame);
				dialog.setVisible(true);
				mainMenuFrame.semaphore.acquire();
				mainMenuFrame.suspend=true;
				mainMenuFrame.semaphore.release();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
//		每20秒清理一次数据
		if(clock.time%500==0)
			clean();
		if(!isBossMode&&!BOSS.live&&BOSS.blood<=0) {
			//初始化下一关
			new Init(player,playerShells,enemyPlanes,enemyShells,props,startTime,round+1,isMouseMode,mainMenuFrame).start();
			this.dispose();
		}
	}
	/**
	 * 清理过时数据
	 */
	private void clean() {
//		System.out.println("敌机数："+enemyPlanes.size()+"玩家导弹数:"+playerShells.size()+"敌机导弹:"+enemyShells.size());
//		System.out.println(clock.time);
		while(!explodes.isEmpty()) {
			Explode temp=explodes.peek();
			if(temp.live)
				break;
			explodes.poll();
		}
		while(!props.isEmpty()) {
			Prop temp=props.peek();
			if(temp.live)
				break;
			props.poll();
		}
	}
	/**
	 * 键盘监听
	 */
	class KeyMonitor extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			player.changePosition(e);
		}
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			player.cancelPosition(e);
		}
	}
	class MouseMonitor extends MouseAdapter{
		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			player.changePosition(e);
		}
		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
//			System.out.println("鼠标监听");
//			System.out.println(e.getX()+" "+e.getY());
			player.changePosition(e);
		}
	}
	/**
	 * 时钟
	 *
	 */
	class Clock extends Thread{
		public int time=0;
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true) {
				this.time++;
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	

	/**
	 * 重绘线程
	 */
	class DrawThread extends Thread{
		@Override
		public void run() {
			while(true) {
					try {
						mainMenuFrame.semaphore.acquire();
						if(mainMenuFrame.suspend) {
							mainMenuFrame.semaphore.release();
							synchronized (mainMenuFrame.lock) {
								try {
									mainMenuFrame.lock.wait();
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							requestFocus();//恢复键盘监听
						}else
							mainMenuFrame.semaphore.release();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	
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
