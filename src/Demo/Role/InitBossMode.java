package Demo.Role;

import java.awt.EventQueue;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;

import Demo.UI.GameFrame;
import Demo.UI.MainMenuFrame;

public class InitBossMode {
	MainMenuFrame mainMenuFrame;
	PlayerPlane player;
	ConcurrentLinkedQueue<Shell> playerShells;
	int kind;
	boolean isMouseMode;
	public InitBossMode(int kind,PlayerPlane player,
			ConcurrentLinkedQueue<Shell> playerShells,MainMenuFrame mainMenuFrame,boolean isMouseMode) {
		this.kind=kind;
		this.mainMenuFrame=mainMenuFrame;
		this.player=player;
		this.playerShells=playerShells;
		this.isMouseMode=isMouseMode;
	}
	
	public void start() {
		ConcurrentLinkedQueue<EnemyPlane> enemyPlanes=new ConcurrentLinkedQueue<EnemyPlane>();
		ConcurrentLinkedQueue<Shell> enemyShells=new ConcurrentLinkedQueue<Shell>();
		ConcurrentLinkedQueue<Prop> props=new ConcurrentLinkedQueue<>();
		Date startTime=new Date();
		EnemyPlane BOSS;
		if(kind==3) {
			BOSS = new EnemyPlane(enemyShells,2,true);
			enemyPlanes.add(new EnemyPlane(enemyShells, 0, true));
		}else if(kind==4) {
			BOSS = new EnemyPlane(enemyShells,2,true);
			enemyPlanes.add(new EnemyPlane(enemyShells, 0, true));
			enemyPlanes.add(new EnemyPlane(enemyShells, 1, true));
		}else
			BOSS = new EnemyPlane(enemyShells,kind,true);
		enemyPlanes.add(BOSS);
		GameFrame frame=new GameFrame(player,
				playerShells,
				enemyPlanes,
				enemyShells,
				props,
				BOSS,
				kind,
				startTime,
				true,
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
		new CreateProp(props, 200, 0, player).start();
		new CreateProp(props, 200, 1, player).start();
	}
	
}
