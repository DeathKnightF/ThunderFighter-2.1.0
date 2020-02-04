package Demo.Data;

import java.awt.Toolkit;

/**
 * 雷霆战机使用到的常数参数
 * @author 董楷烽
 *
 */
public final class Data {
	
	
	/**
	 * 游戏窗口GameFrame
	 */
//	public static final int WINDOW_WIDTH=Toolkit.getDefaultToolkit().getScreenSize().height;
//	public static final int WINDOW_HEIGHT=Toolkit.getDefaultToolkit().getScreenSize().width;
//	public static final int WINDOW_POSITION_X=0;
	//窗口坐标，尺寸
	public static int WINDOW_WIDTH=Toolkit.getDefaultToolkit().getScreenSize().width/3*2;
	public static int WINDOW_HEIGHT=Toolkit.getDefaultToolkit().getScreenSize().height;
	public static int WINDOW_POSITION_X=100;
	public static final int WINDOW_POSITION_Y=0;
	public static final int BACKGROUND_SPEED_Y=8;//背景移动速度
	public static final int FONT_SIZE=30;//字体大小
	public static final int REFALSH_INTERVAL=40;//刷新时间间隔
	//玩家头框
	public static  int HEAD_PORTRAIT_FRAME_WIDTH=WINDOW_WIDTH/2;
	public static final int HEAD_PORTRAIT_FRAME_HEIGHT=HEAD_PORTRAIT_FRAME_WIDTH/4;
	public static final int HEAD_PORTRAIT_X=15;
	public static final int HEAD_PORTRAIT_Y=15;
	public static final int HEAD_PORTRAIT_WIDTH=HEAD_PORTRAIT_FRAME_WIDTH/5+10;//头框里的头像
	public static final int HEAD_PORTRAIT_HEIGHT=HEAD_PORTRAIT_FRAME_HEIGHT*2/3;
	//玩家血条
	public static final int BLOOD_STRIP_MAX_WIDTH=HEAD_PORTRAIT_FRAME_WIDTH*3/5;
	public static final int BLOOD_STRIP_HEIGHT=HEAD_PORTRAIT_FRAME_HEIGHT/5;
	public static final int BLOOD_STRIP_X=HEAD_PORTRAIT_X+HEAD_PORTRAIT_WIDTH;
	public static final int BLOOD_STRIP_Y=HEAD_PORTRAIT_FRAME_HEIGHT*3/4;
	//字(经验、血量)
	public static final int EXP_CHARACERS_POSITION_X=BLOOD_STRIP_X+BLOOD_STRIP_MAX_WIDTH+10;
	public static final int EXP_CHARACERS_POSITION_Y=BLOOD_STRIP_Y;
	public static final int BLOOD_CHARACERS_POSITION_X=EXP_CHARACERS_POSITION_X;
	public static final int BLOOD_CHARACERS_POSITION_Y=EXP_CHARACERS_POSITION_Y+FONT_SIZE+10;
	//玩家经验条
	public static final int EXP_STRIP_MAX_WIDTH=BLOOD_STRIP_MAX_WIDTH;
	public static final int EXP_STRIP_HEIGHT=BLOOD_STRIP_HEIGHT;
	public static final int EXP_STRIP_X=BLOOD_STRIP_X;
	public static final int EXP_STRIP_Y=BLOOD_STRIP_Y-EXP_STRIP_HEIGHT-5;
	
	
	//boss头框
	public static  int BOSS_HEAD_PORTRAIT_WIDTH=WINDOW_WIDTH/3;
	public static final int BOSS_HEAD_PORTRAIT_HEIGHT=75;
	public static  int BOSS_HEAD_PORTRAIT_X=HEAD_PORTRAIT_FRAME_WIDTH+WINDOW_WIDTH/10;
	public static  int BOSS_HEAD_PORTRAIT_Y=WINDOW_HEIGHT/20;
	
	//boss血条
	public static final int BOSS_BLOOD_STRIP_MAX_WIDTH=BOSS_HEAD_PORTRAIT_WIDTH*7/12;
	public static final int BOSS_BLOOD_STRIP_HEIGHT=20;
	public static final int BOSS_BLOOD_STRIP_X=BOSS_HEAD_PORTRAIT_X*11/10;
	public static final int BOSS_BLOOD_STRIP_Y=BOSS_HEAD_PORTRAIT_Y*5/4;
	
	//boss头像
	public static final int BOSS_HEAD_PORTRAIT_IMG_WIDTH=BOSS_HEAD_PORTRAIT_HEIGHT;
	public static final int BOSS_HEAD_PORTRAIT_IMG_HEIGHT=BOSS_HEAD_PORTRAIT_IMG_WIDTH;
	public static final int BOSS_HEAD_PORTRAIT_IMG_X=BOSS_HEAD_PORTRAIT_X+BOSS_HEAD_PORTRAIT_WIDTH*3/4;
	public static final int BOSS_HEAD_PORTRAIT_IMG_Y=BOSS_HEAD_PORTRAIT_Y;
	
	//菜单按钮图标MenuButton
	public static  int MENU_BUTTON_WIDTH=WINDOW_WIDTH/10;
	public static  int MENU_BUTTON_HEIGHT=MENU_BUTTON_WIDTH;
	public static  int MENU_BUTTON_X=WINDOW_WIDTH-MENU_BUTTON_WIDTH;
	public static  int MENU_BUTTON_Y=WINDOW_POSITION_Y+WINDOW_HEIGHT-MENU_BUTTON_HEIGHT;
	
	//技能1按钮
	public static int SKILL_BUTTON_WIDTH=MENU_BUTTON_WIDTH;
	public static int SKILL_BUTTON_HEIGHT=SKILL_BUTTON_WIDTH;
	public static int SKILL_BUTTON_POSITION_X=0;
	public static int SKILL_BUTTON_POSITION_Y=WINDOW_HEIGHT-SKILL_BUTTON_HEIGHT;
	public static int SKILL_BUTTON_INTERVAL=SKILL_BUTTON_WIDTH;
	
	/**
	 * 主界面MainFrame
	 */
	public static  int MAIN_MENU_FRAME_BUTTON_WIDTH=WINDOW_WIDTH/4;//主界面按钮宽度
	public static  int MAIN_MENU_FRAME_BUTTON_HEIGHT=WINDOW_HEIGHT/10;//高度
	public static final int MAIN_MENU_FRAME_BUTTONS_INTERVAL=MAIN_MENU_FRAME_BUTTON_HEIGHT+35;//主界面各个按钮之间纵坐标间隔
	public static final int MAIN_MENU_FRAME_BUTTON_POSITION_X=MAIN_MENU_FRAME_BUTTON_WIDTH/2;//所有按钮的横坐标
	public static final int MAIN_MENU_FRAME_BUTTON_POSITION_START_Y=20;//第一个按钮纵坐标
	/**
	 * 对话框窗口（暂停窗口、结束窗口、选择关卡窗口、选择玩家飞机窗口）
	 */
	public static  int DIALOG_WIDTH=WINDOW_WIDTH;
	public static  int DIALOG_HEIGHT=WINDOW_HEIGHT;
	public static  int DIALOG_POSITION_X=WINDOW_POSITION_X;
	public static final int DIALOG_POSITION_Y=WINDOW_POSITION_Y;
	public static final int DIALOG_BUTTON_WIDTH=MAIN_MENU_FRAME_BUTTON_WIDTH;//按钮尺寸
	public static final int DIALOG_BUTTON_HEIGHT=MAIN_MENU_FRAME_BUTTON_HEIGHT;
	
	/*
	 * choosePlayerPlaneFrame
	 */
	//确认按钮
	public static  int CHOOSE_PLAYER_PLANE_FRAME_CONFIRM_BUTTON_POSITION_X=WINDOW_WIDTH/2-DIALOG_BUTTON_WIDTH/2;
	public static  int CHOOSE_PLAYER_PLANE_FRAME_CONFIRM_BUTTON_POSITION_Y=WINDOW_HEIGHT*2/3;
	//飞机图片
	public static  int CHOOSE_PLAYER_PLANE_FRAME_PLANE_IMG_WIDTH=WINDOW_WIDTH/4;
	public static final int CHOOSE_PLAYER_PLANE_FRAME_PLANE_IMG_HEIGHT=CHOOSE_PLAYER_PLANE_FRAME_PLANE_IMG_WIDTH;
	public static  int CHOOSE_PLAYER_PLANE_FRAME_PLANE_IMG_POSITION_X=WINDOW_WIDTH/2
			-CHOOSE_PLAYER_PLANE_FRAME_PLANE_IMG_WIDTH/2;
	public static  int CHOOSE_PLAYER_PLANE_FRAME_PLANE_IMG_POSITION_Y=WINDOW_HEIGHT/3;
	//左右按钮
	public static final int CHOOSE_PLAYER_PLANE_FRAME_TURN_BUTTON_WIDTH=DIALOG_BUTTON_WIDTH/2;
	public static final int CHOOSE_PLAYER_PLANE_FRAME_TURN_BUTTON_HEIGHT=DIALOG_BUTTON_HEIGHT*2;
	public static  int CHOOSE_PLAYER_PLANE_FRAME_TURN_BUTTON_POSITION_Y=WINDOW_HEIGHT/2
			-CHOOSE_PLAYER_PLANE_FRAME_TURN_BUTTON_HEIGHT/2;
	public static final int CHOOSE_PLAYER_PLANE_FRAME_TURN_LEFT_BUTTON_POSITION_X=0;
	public static  int CHOOSE_PLAYER_PLANE_FRAME_TURN_RIGHT_BUTTON_POSITION_X=WINDOW_WIDTH
			-CHOOSE_PLAYER_PLANE_FRAME_TURN_BUTTON_WIDTH;
	//数据显示
	public static  int CHOOSE_PLAYER_PLANE_FRAME_DATA_STRIP_STANDARD_WIDTH=WINDOW_WIDTH/4;//数据条
	public static final int CHOOSE_PLAYER_PLANE_FRAME_DATA_STRIP_HEIGHT=BLOOD_STRIP_HEIGHT;
	public static final int CHOOSE_PLAYER_PLANE_FRAME_DATA_WORD_FONT_SIZE=CHOOSE_PLAYER_PLANE_FRAME_DATA_STRIP_HEIGHT;//数据字
	public static  int CHOOSE_PLAYER_PLANE_FRAME_DATA_WORD_POSITION_X=WINDOW_WIDTH/15;
	public static  int CHOOSE_PLAYER_PLANE_FRAME_DATA_WORD_FIRST_POSITION_Y=WINDOW_HEIGHT*6/7;
	public static final int CHOOSE_PLAYER_PLANE_FRAME_DATA_WORD_INTERVAL=
			CHOOSE_PLAYER_PLANE_FRAME_DATA_WORD_FONT_SIZE+10;//字间间隔
	public static final int CHOOSE_PLAYER_PLANE_FRAME_DATA_STRIP_POSITION_X=CHOOSE_PLAYER_PLANE_FRAME_DATA_WORD_POSITION_X
			+CHOOSE_PLAYER_PLANE_FRAME_DATA_WORD_FONT_SIZE*2+20;
	public static  int CHOOSE_PLAYER_PLANE_FRAME_DATA_STRIP_FIRST_POSITION_Y=
			CHOOSE_PLAYER_PLANE_FRAME_DATA_WORD_FIRST_POSITION_Y-CHOOSE_PLAYER_PLANE_FRAME_DATA_STRIP_HEIGHT;
	public static final int CHOOSE_PLAYER_PLANE_FRAME_DATA_STRIP_INTERVAL=CHOOSE_PLAYER_PLANE_FRAME_DATA_WORD_INTERVAL;
	//chooseBossFrame
	public static  int CHOOSE_BOSS_BUTTON_WIDTH=WINDOW_WIDTH/8;
	public static final int CHOOSE_BOSS_BUTTON_HEIGHT=CHOOSE_BOSS_BUTTON_WIDTH;
	public static  int CHOOSE_BOSS_BUTTON_POSITIN_X=WINDOW_WIDTH/4;
	public static  int CHOOSE_BOSS_BUTTON_FIRST_POSITION_Y=WINDOW_HEIGHT/20;
	public static  int CHOOSE_BOSS_BUTTON_INTERVAL_X=WINDOW_WIDTH*3/8;//水平间隔
	public static  int CHOOSE_BOSS_BUTTON_INTERVAL_Y=CHOOSE_BOSS_BUTTON_HEIGHT+WINDOW_HEIGHT/10;
	
	public static  int CHOOSE_BOSS_BACK_TO_MAIN_MENU_BUTTON_WIDTH=WINDOW_WIDTH/3;
	public static final int CHOOSE_BOSS_BACK_TO_MAIN_MENU_BUTTON_HEIGHT=CHOOSE_BOSS_BACK_TO_MAIN_MENU_BUTTON_WIDTH/4;
	public static  int CHOOSE_BOSS_BACK_TO_MAIN_MENU_BUTTON_POSITION_X=WINDOW_WIDTH/3;
	public static  int CHOOSE_BOSS_BACK_TO_MAIN_MENU_BUTTON_POSITION_Y=WINDOW_HEIGHT*4/5;
	//endDialog
	public static  int END_DIALOG_POSITION_X=WINDOW_WIDTH*5/12;
	public static  int END_DIALOG_FIRST_POSITION_Y=WINDOW_HEIGHT/3;
	public static final int END_DIALOG_INTERVAL=FONT_SIZE*2;
	
	public static  int END_DIALOG_COIN_POSITION_Y=WINDOW_HEIGHT*31/48;
	public static  int END_DIALOG_COIN_POSITION_X=WINDOW_WIDTH*8/12;
	//setDialog
	public static  int SET_DIALOG_SELECT_BUTTON_POSITION_X1=WINDOW_WIDTH/10;
	public static  int SET_DIALOG_SELECT_BUTTON_POSITION_X2=WINDOW_WIDTH*3/5;
	public static  int SET_DIALOG_SELECT_BUTTON_POSITION_Y=WINDOW_HEIGHT/15;
	public static  int SET_DIALOG_SELECT_BUTTON_INTERVAL_Y=WINDOW_HEIGHT/10;
	public static  int SET_DIALOG_SELECT_BUTTON_WIDTH=WINDOW_WIDTH/3;
	public static  int SET_DIALOG_SELECT_BUTTON_HEIGHT=WINDOW_HEIGHT/10;
	/**
	 * 飞机
	 */
	//玩家
	public static  int PLAYER_PLANE_START_X=WINDOW_WIDTH/2-30;//起始坐标
	public static  int PLAYER_PLANE_START_Y=WINDOW_HEIGHT-130;
	public static  int PLAYER_PLANE_WIDTH=WINDOW_WIDTH/15;
	public static final int PLAYER_PLANE_HEIGHT=PLAYER_PLANE_WIDTH;
	public static final int PLAYER_PLANE_SPEED=15;//标准速度
	public static final int PLAYER_PLANE_BLOOD=100;//标准血量
	public static final int PLAYER_PLANE_UPGRADE_BLOOD=50;//飞机升级参数增量
	public static final int PLAYER_PLANE_UPGRADE_SPEED=1;
	public static final int PLAYER_PLANE_UPGRADE_HARM=0;
	public static final int[] PLAYER_UPGRADE_EXP= {300,10000,100000,Integer.MAX_VALUE};//升级经验

	
	//敌人
	public static final int ROUND=5;//关卡数
	public static  int ENEMY_PlANE_WIDTH=WINDOW_WIDTH/14;
	public static final int ENEMY_PlANE_HEIGHT=ENEMY_PlANE_WIDTH;
	public static final int ENEMY_PLANE_SPEED=15;
	public static final double ENEMY_PLANE_FIRE_PROBABILITY=0.01;//敌人随机发射导弹的概率
	public static final int ENEMY_PLANE_BLOOD=1;//血量
	
	public static  int BOSS_POSITION_X=WINDOW_WIDTH/2;
	public static final int BOSS_POSITION_Y=100;
	public static final int BOSS_SPEED=5;
	public static  int BOSS_WIDTH=WINDOW_WIDTH/5;
	public static  int BOSS_HEIGHT=BOSS_WIDTH;
	public static final int[] BOSS_BLOOD={1500,10000,100000,12000,25000};//血量
//	public static final int[] BOSS_BLOOD={10,10,100000,12000,25000};//血量
	public static final int BOSS_FORM_NUM=4;//boss有四个形态
	public static final double BOSS_FIRE_PROBABILITY=0.1;
	public static final double BOSS_CHANGE_PROBABILITY=0.01;
	public static final int BOSS_HARM=5;//与boss相撞每帧减血量
	/**
	 * 玩家导弹
	 */
	public static final int PLAYER_SHELL_WIDTH=30;
	public static final int PLAYER_SHELL_HEIGHT=60;
	public static final int PLAYER_SHELL_SPEED=15;
	public static final int PLAYER_SHELL_HARM=1;//标准伤害
	public static final int SKILL_Q_NUM=5;//Q技能释放波数
	public static final int SKILL_Q_COOLING_TIME=REFALSH_INTERVAL*7;//Q技能冷却时间
	public static final int SKILL_W_COOLING_TIME=REFALSH_INTERVAL*15;//W技能冷却时间
	public static final int SKILL_W_MAX_TIME=50;
	public static final int SKILL_E_COOLING_TIME=REFALSH_INTERVAL*12;//E技能冷却时间
	public static final int SKILL_E_DURATION=25;//护盾持续冷却时间
//	public static final int ATOMIC_BOMB_HARM=50;//原子弹杀伤
	public static final int SKILL_R_COOLING_TIME=REFALSH_INTERVAL*30;//R技能冷却时间
	public static final int EXPLODE_RANGE_OF_ATOMIC_BOMB=350;//原子弹爆炸范围，直径
	
	
	/**
	 * 敌人导弹
	 */
	public static final int ENEMY_SHELL_WIDTH=25;
	public static final int ENEMY_SHELL_HEIGHT=50;
	public static final int ENEMY_SHELL_SPEED=10;
	public static final int ENEMY_SHELL_HARM=1;//伤害
	public static final int ENEMY_SHELL_BAD_STATE_DURATION=30;//敌机导弹造成负面影响持续时间
	public static final int BOSS_SHELL_WIDTH=100;
	public static final int BOSS_SHELL_HEIGHT=200;
	public static final int BOSS_SHELL_SPEED=10;
	public static final int BOSS_SHELL_HARM=8;//伤害
	public static final int BOSS_SHELL_IMAGE_NUM=4;//每个boss导弹种类
	public static final int BOSS_ONE_SHELL_WIDTH=50;//boss1导弹大小
	public static final int BOSS_ONE_SHELL_HEIGHT=50;
	/**
	 * signInFrame
	 */
	public static final int TEXT_FIELD_POSITION_X=WINDOW_WIDTH/3;
	public static final int TEXT_FIELD_POSITION_Y=WINDOW_HEIGHT/10;
	public static final int TEXT_FIELD_WIDTH=WINDOW_WIDTH/3;
	public static final int TEXT_FIELD_HEIGHT=FONT_SIZE+20;
	public static final int BUTTON_FIRST_POSITION_X=WINDOW_WIDTH/6;
	public static final int BUTTON_POSTION_Y=TEXT_FIELD_POSITION_Y+4*TEXT_FIELD_HEIGHT;
	public static final int BUTTON_WIDTH=WINDOW_WIDTH/6;
	public static final int BUTTON_HEIGHT=TEXT_FIELD_HEIGHT;
	public static final int BUTTON_INTERVAL=WINDOW_WIDTH/4;
	
	/**
	 * 道具
	 */
	public static final int PROP_WIDTH=100;
	public static final int PROP_HEIGHT=100;
	public static final int PROP_SPEED=10;
	
	/**
	 * 文件相关
	 */
	public static final String FILE_PATH="data/PlayerData.txt";
	/**
	 * 网络
	 */
	public static String Target_IP="Litchi";
	public static int Port=8888;
	public static final String TCPSERVER_DISCONNECT_FLAG="#END#";//服务器端收到该信息会自动断开连接
}
