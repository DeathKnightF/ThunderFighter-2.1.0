package Demo.Role;

import java.awt.EventQueue;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;

import Demo.UI.GameFrame;
import Demo.UI.MainMenuFrame;
import Demo.Util.ReadMapData;

public class Init {
	PlayerPlane player;
	ConcurrentLinkedQueue<Shell> playerShells;
	ConcurrentLinkedQueue<Prop> props;
	ConcurrentLinkedQueue<EnemyPlane> enemyPlanes;
	ConcurrentLinkedQueue<Shell> enemyShells;
	EnemyPlane BOSS ;
	Date startTime;
	int round;
	MainMenuFrame mainMenuFrame;
	boolean isMouseMode;
	public Init(PlayerPlane player,
			ConcurrentLinkedQueue<Shell> playerShells,
			ConcurrentLinkedQueue<EnemyPlane> enemyPlanes,
			ConcurrentLinkedQueue<Shell> enemyShells,
			ConcurrentLinkedQueue<Prop> props,
			Date startTime,
			int round,
			boolean isMouseMode,
			MainMenuFrame mainMenuFrame) {
		this.player=player;
		this.playerShells=playerShells;
		this.enemyPlanes=enemyPlanes;
		this.enemyShells=enemyShells;
		this.props=props;
		this.startTime=startTime;
		this.round=round;
		this.isMouseMode=isMouseMode;
		this.mainMenuFrame=mainMenuFrame;
	}
	public void start() {
			if(round==0) {
//				playerShells=new ConcurrentLinkedQueue<Shell>();
//				player=new PlayerPlane(playerShells);
				props=new ConcurrentLinkedQueue<Prop>();
				enemyPlanes=new ConcurrentLinkedQueue<EnemyPlane>();
				enemyShells=new ConcurrentLinkedQueue<Shell>();
				startTime=new Date();
			}
			playerShells.clear();
			enemyPlanes.clear();
			enemyShells.clear();
			BOSS=new EnemyPlane(enemyShells,round,false);
			enemyPlanes.add(BOSS);
			GameFrame frame=new GameFrame(player,
					playerShells,
					enemyPlanes,
					enemyShells,
					props,
					BOSS,
					round,
					startTime,
					false,
					isMouseMode,
					mainMenuFrame);
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			new Thread(()->{
				CreateEnemy[] threads=new CreateEnemy[6];
				int[][] temp = null;
				temp = ReadMapData.readMap();
				for(int j=0;j<6;j++) {
					threads[j]=new CreateEnemy(temp[round][j],
							j,
							round, 
							enemyPlanes, 
							enemyShells,
							mainMenuFrame);
					threads[j].start();
				}
				
				while(true) {
					boolean judge=true;
					for(int i=0;i<6;i++)
						if(threads[i]!=null&&threads[i].isAlive()) {
							judge=false;
							break;
						}
					if(!judge)
						continue;
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					BOSS.live=true;
					enemyPlanes.add(BOSS);
					break;
				}
			}) .start();
			
			for(int i=0;i<2;i++)
				new CreateProp(props, 300, i, player).start();;
	}

}
