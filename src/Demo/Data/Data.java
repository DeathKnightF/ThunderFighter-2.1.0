package Demo.Data;

import java.awt.Toolkit;

/**
 * ����ս��ʹ�õ��ĳ�������
 * @author ������
 *
 */
public final class Data {
	
	
	/**
	 * ��Ϸ����GameFrame
	 */
//	public static final int WINDOW_WIDTH=Toolkit.getDefaultToolkit().getScreenSize().height;
//	public static final int WINDOW_HEIGHT=Toolkit.getDefaultToolkit().getScreenSize().width;
//	public static final int WINDOW_POSITION_X=0;
	//�������꣬�ߴ�
	public static int WINDOW_WIDTH=Toolkit.getDefaultToolkit().getScreenSize().width/3*2;
	public static int WINDOW_HEIGHT=Toolkit.getDefaultToolkit().getScreenSize().height;
	public static int WINDOW_POSITION_X=100;
	public static final int WINDOW_POSITION_Y=0;
	public static final int BACKGROUND_SPEED_Y=8;//�����ƶ��ٶ�
	public static final int FONT_SIZE=30;//�����С
	public static final int REFALSH_INTERVAL=40;//ˢ��ʱ����
	//���ͷ��
	public static  int HEAD_PORTRAIT_FRAME_WIDTH=WINDOW_WIDTH/2;
	public static final int HEAD_PORTRAIT_FRAME_HEIGHT=HEAD_PORTRAIT_FRAME_WIDTH/4;
	public static final int HEAD_PORTRAIT_X=15;
	public static final int HEAD_PORTRAIT_Y=15;
	public static final int HEAD_PORTRAIT_WIDTH=HEAD_PORTRAIT_FRAME_WIDTH/5+10;//ͷ�����ͷ��
	public static final int HEAD_PORTRAIT_HEIGHT=HEAD_PORTRAIT_FRAME_HEIGHT*2/3;
	//���Ѫ��
	public static final int BLOOD_STRIP_MAX_WIDTH=HEAD_PORTRAIT_FRAME_WIDTH*3/5;
	public static final int BLOOD_STRIP_HEIGHT=HEAD_PORTRAIT_FRAME_HEIGHT/5;
	public static final int BLOOD_STRIP_X=HEAD_PORTRAIT_X+HEAD_PORTRAIT_WIDTH;
	public static final int BLOOD_STRIP_Y=HEAD_PORTRAIT_FRAME_HEIGHT*3/4;
	//��(���顢Ѫ��)
	public static final int EXP_CHARACERS_POSITION_X=BLOOD_STRIP_X+BLOOD_STRIP_MAX_WIDTH+10;
	public static final int EXP_CHARACERS_POSITION_Y=BLOOD_STRIP_Y;
	public static final int BLOOD_CHARACERS_POSITION_X=EXP_CHARACERS_POSITION_X;
	public static final int BLOOD_CHARACERS_POSITION_Y=EXP_CHARACERS_POSITION_Y+FONT_SIZE+10;
	//��Ҿ�����
	public static final int EXP_STRIP_MAX_WIDTH=BLOOD_STRIP_MAX_WIDTH;
	public static final int EXP_STRIP_HEIGHT=BLOOD_STRIP_HEIGHT;
	public static final int EXP_STRIP_X=BLOOD_STRIP_X;
	public static final int EXP_STRIP_Y=BLOOD_STRIP_Y-EXP_STRIP_HEIGHT-5;
	
	
	//bossͷ��
	public static  int BOSS_HEAD_PORTRAIT_WIDTH=WINDOW_WIDTH/3;
	public static final int BOSS_HEAD_PORTRAIT_HEIGHT=75;
	public static  int BOSS_HEAD_PORTRAIT_X=HEAD_PORTRAIT_FRAME_WIDTH+WINDOW_WIDTH/10;
	public static  int BOSS_HEAD_PORTRAIT_Y=WINDOW_HEIGHT/20;
	
	//bossѪ��
	public static final int BOSS_BLOOD_STRIP_MAX_WIDTH=BOSS_HEAD_PORTRAIT_WIDTH*7/12;
	public static final int BOSS_BLOOD_STRIP_HEIGHT=20;
	public static final int BOSS_BLOOD_STRIP_X=BOSS_HEAD_PORTRAIT_X*11/10;
	public static final int BOSS_BLOOD_STRIP_Y=BOSS_HEAD_PORTRAIT_Y*5/4;
	
	//bossͷ��
	public static final int BOSS_HEAD_PORTRAIT_IMG_WIDTH=BOSS_HEAD_PORTRAIT_HEIGHT;
	public static final int BOSS_HEAD_PORTRAIT_IMG_HEIGHT=BOSS_HEAD_PORTRAIT_IMG_WIDTH;
	public static final int BOSS_HEAD_PORTRAIT_IMG_X=BOSS_HEAD_PORTRAIT_X+BOSS_HEAD_PORTRAIT_WIDTH*3/4;
	public static final int BOSS_HEAD_PORTRAIT_IMG_Y=BOSS_HEAD_PORTRAIT_Y;
	
	//�˵���ťͼ��MenuButton
	public static  int MENU_BUTTON_WIDTH=WINDOW_WIDTH/10;
	public static  int MENU_BUTTON_HEIGHT=MENU_BUTTON_WIDTH;
	public static  int MENU_BUTTON_X=WINDOW_WIDTH-MENU_BUTTON_WIDTH;
	public static  int MENU_BUTTON_Y=WINDOW_POSITION_Y+WINDOW_HEIGHT-MENU_BUTTON_HEIGHT;
	
	//����1��ť
	public static int SKILL_BUTTON_WIDTH=MENU_BUTTON_WIDTH;
	public static int SKILL_BUTTON_HEIGHT=SKILL_BUTTON_WIDTH;
	public static int SKILL_BUTTON_POSITION_X=0;
	public static int SKILL_BUTTON_POSITION_Y=WINDOW_HEIGHT-SKILL_BUTTON_HEIGHT;
	public static int SKILL_BUTTON_INTERVAL=SKILL_BUTTON_WIDTH;
	
	/**
	 * ������MainFrame
	 */
	public static  int MAIN_MENU_FRAME_BUTTON_WIDTH=WINDOW_WIDTH/4;//�����水ť���
	public static  int MAIN_MENU_FRAME_BUTTON_HEIGHT=WINDOW_HEIGHT/10;//�߶�
	public static final int MAIN_MENU_FRAME_BUTTONS_INTERVAL=MAIN_MENU_FRAME_BUTTON_HEIGHT+35;//�����������ť֮����������
	public static final int MAIN_MENU_FRAME_BUTTON_POSITION_X=MAIN_MENU_FRAME_BUTTON_WIDTH/2;//���а�ť�ĺ�����
	public static final int MAIN_MENU_FRAME_BUTTON_POSITION_START_Y=20;//��һ����ť������
	/**
	 * �Ի��򴰿ڣ���ͣ���ڡ��������ڡ�ѡ��ؿ����ڡ�ѡ����ҷɻ����ڣ�
	 */
	public static  int DIALOG_WIDTH=WINDOW_WIDTH;
	public static  int DIALOG_HEIGHT=WINDOW_HEIGHT;
	public static  int DIALOG_POSITION_X=WINDOW_POSITION_X;
	public static final int DIALOG_POSITION_Y=WINDOW_POSITION_Y;
	public static final int DIALOG_BUTTON_WIDTH=MAIN_MENU_FRAME_BUTTON_WIDTH;//��ť�ߴ�
	public static final int DIALOG_BUTTON_HEIGHT=MAIN_MENU_FRAME_BUTTON_HEIGHT;
	
	/*
	 * choosePlayerPlaneFrame
	 */
	//ȷ�ϰ�ť
	public static  int CHOOSE_PLAYER_PLANE_FRAME_CONFIRM_BUTTON_POSITION_X=WINDOW_WIDTH/2-DIALOG_BUTTON_WIDTH/2;
	public static  int CHOOSE_PLAYER_PLANE_FRAME_CONFIRM_BUTTON_POSITION_Y=WINDOW_HEIGHT*2/3;
	//�ɻ�ͼƬ
	public static  int CHOOSE_PLAYER_PLANE_FRAME_PLANE_IMG_WIDTH=WINDOW_WIDTH/4;
	public static final int CHOOSE_PLAYER_PLANE_FRAME_PLANE_IMG_HEIGHT=CHOOSE_PLAYER_PLANE_FRAME_PLANE_IMG_WIDTH;
	public static  int CHOOSE_PLAYER_PLANE_FRAME_PLANE_IMG_POSITION_X=WINDOW_WIDTH/2
			-CHOOSE_PLAYER_PLANE_FRAME_PLANE_IMG_WIDTH/2;
	public static  int CHOOSE_PLAYER_PLANE_FRAME_PLANE_IMG_POSITION_Y=WINDOW_HEIGHT/3;
	//���Ұ�ť
	public static final int CHOOSE_PLAYER_PLANE_FRAME_TURN_BUTTON_WIDTH=DIALOG_BUTTON_WIDTH/2;
	public static final int CHOOSE_PLAYER_PLANE_FRAME_TURN_BUTTON_HEIGHT=DIALOG_BUTTON_HEIGHT*2;
	public static  int CHOOSE_PLAYER_PLANE_FRAME_TURN_BUTTON_POSITION_Y=WINDOW_HEIGHT/2
			-CHOOSE_PLAYER_PLANE_FRAME_TURN_BUTTON_HEIGHT/2;
	public static final int CHOOSE_PLAYER_PLANE_FRAME_TURN_LEFT_BUTTON_POSITION_X=0;
	public static  int CHOOSE_PLAYER_PLANE_FRAME_TURN_RIGHT_BUTTON_POSITION_X=WINDOW_WIDTH
			-CHOOSE_PLAYER_PLANE_FRAME_TURN_BUTTON_WIDTH;
	//������ʾ
	public static  int CHOOSE_PLAYER_PLANE_FRAME_DATA_STRIP_STANDARD_WIDTH=WINDOW_WIDTH/4;//������
	public static final int CHOOSE_PLAYER_PLANE_FRAME_DATA_STRIP_HEIGHT=BLOOD_STRIP_HEIGHT;
	public static final int CHOOSE_PLAYER_PLANE_FRAME_DATA_WORD_FONT_SIZE=CHOOSE_PLAYER_PLANE_FRAME_DATA_STRIP_HEIGHT;//������
	public static  int CHOOSE_PLAYER_PLANE_FRAME_DATA_WORD_POSITION_X=WINDOW_WIDTH/15;
	public static  int CHOOSE_PLAYER_PLANE_FRAME_DATA_WORD_FIRST_POSITION_Y=WINDOW_HEIGHT*6/7;
	public static final int CHOOSE_PLAYER_PLANE_FRAME_DATA_WORD_INTERVAL=
			CHOOSE_PLAYER_PLANE_FRAME_DATA_WORD_FONT_SIZE+10;//�ּ���
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
	public static  int CHOOSE_BOSS_BUTTON_INTERVAL_X=WINDOW_WIDTH*3/8;//ˮƽ���
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
	 * �ɻ�
	 */
	//���
	public static  int PLAYER_PLANE_START_X=WINDOW_WIDTH/2-30;//��ʼ����
	public static  int PLAYER_PLANE_START_Y=WINDOW_HEIGHT-130;
	public static  int PLAYER_PLANE_WIDTH=WINDOW_WIDTH/15;
	public static final int PLAYER_PLANE_HEIGHT=PLAYER_PLANE_WIDTH;
	public static final int PLAYER_PLANE_SPEED=15;//��׼�ٶ�
	public static final int PLAYER_PLANE_BLOOD=100;//��׼Ѫ��
	public static final int PLAYER_PLANE_UPGRADE_BLOOD=50;//�ɻ�������������
	public static final int PLAYER_PLANE_UPGRADE_SPEED=1;
	public static final int PLAYER_PLANE_UPGRADE_HARM=0;
	public static final int[] PLAYER_UPGRADE_EXP= {300,10000,100000,Integer.MAX_VALUE};//��������

	
	//����
	public static final int ROUND=5;//�ؿ���
	public static  int ENEMY_PlANE_WIDTH=WINDOW_WIDTH/14;
	public static final int ENEMY_PlANE_HEIGHT=ENEMY_PlANE_WIDTH;
	public static final int ENEMY_PLANE_SPEED=15;
	public static final double ENEMY_PLANE_FIRE_PROBABILITY=0.01;//����������䵼���ĸ���
	public static final int ENEMY_PLANE_BLOOD=1;//Ѫ��
	
	public static  int BOSS_POSITION_X=WINDOW_WIDTH/2;
	public static final int BOSS_POSITION_Y=100;
	public static final int BOSS_SPEED=5;
	public static  int BOSS_WIDTH=WINDOW_WIDTH/5;
	public static  int BOSS_HEIGHT=BOSS_WIDTH;
	public static final int[] BOSS_BLOOD={1500,10000,100000,12000,25000};//Ѫ��
//	public static final int[] BOSS_BLOOD={10,10,100000,12000,25000};//Ѫ��
	public static final int BOSS_FORM_NUM=4;//boss���ĸ���̬
	public static final double BOSS_FIRE_PROBABILITY=0.1;
	public static final double BOSS_CHANGE_PROBABILITY=0.01;
	public static final int BOSS_HARM=5;//��boss��ײÿ֡��Ѫ��
	/**
	 * ��ҵ���
	 */
	public static final int PLAYER_SHELL_WIDTH=30;
	public static final int PLAYER_SHELL_HEIGHT=60;
	public static final int PLAYER_SHELL_SPEED=15;
	public static final int PLAYER_SHELL_HARM=1;//��׼�˺�
	public static final int SKILL_Q_NUM=5;//Q�����ͷŲ���
	public static final int SKILL_Q_COOLING_TIME=REFALSH_INTERVAL*7;//Q������ȴʱ��
	public static final int SKILL_W_COOLING_TIME=REFALSH_INTERVAL*15;//W������ȴʱ��
	public static final int SKILL_W_MAX_TIME=50;
	public static final int SKILL_E_COOLING_TIME=REFALSH_INTERVAL*12;//E������ȴʱ��
	public static final int SKILL_E_DURATION=25;//���ܳ�����ȴʱ��
//	public static final int ATOMIC_BOMB_HARM=50;//ԭ�ӵ�ɱ��
	public static final int SKILL_R_COOLING_TIME=REFALSH_INTERVAL*30;//R������ȴʱ��
	public static final int EXPLODE_RANGE_OF_ATOMIC_BOMB=350;//ԭ�ӵ���ը��Χ��ֱ��
	
	
	/**
	 * ���˵���
	 */
	public static final int ENEMY_SHELL_WIDTH=25;
	public static final int ENEMY_SHELL_HEIGHT=50;
	public static final int ENEMY_SHELL_SPEED=10;
	public static final int ENEMY_SHELL_HARM=1;//�˺�
	public static final int ENEMY_SHELL_BAD_STATE_DURATION=30;//�л�������ɸ���Ӱ�����ʱ��
	public static final int BOSS_SHELL_WIDTH=100;
	public static final int BOSS_SHELL_HEIGHT=200;
	public static final int BOSS_SHELL_SPEED=10;
	public static final int BOSS_SHELL_HARM=8;//�˺�
	public static final int BOSS_SHELL_IMAGE_NUM=4;//ÿ��boss��������
	public static final int BOSS_ONE_SHELL_WIDTH=50;//boss1������С
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
	 * ����
	 */
	public static final int PROP_WIDTH=100;
	public static final int PROP_HEIGHT=100;
	public static final int PROP_SPEED=10;
	
	/**
	 * �ļ����
	 */
	public static final String FILE_PATH="data/PlayerData.txt";
	/**
	 * ����
	 */
	public static String Target_IP="Litchi";
	public static int Port=8888;
	public static final String TCPSERVER_DISCONNECT_FLAG="#END#";//���������յ�����Ϣ���Զ��Ͽ�����
}
