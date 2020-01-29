package Demo.Role;


import java.util.concurrent.ConcurrentLinkedQueue;

import Demo.Data.Data;
import Demo.UI.MainMenuFrame;

/**
 * ÷∆‘Ïµ–»À
 * @author ∂≠ø¨∑È
 *
 */
public class CreateEnemy extends Thread{
	ConcurrentLinkedQueue<EnemyPlane> enemyPlanes;
	ConcurrentLinkedQueue<Shell> enemyShells;
	int num;
	int kind;
	int round;
	MainMenuFrame mainMenuFrame;
	
	public CreateEnemy(int num,
			int kind,
			int round,
			ConcurrentLinkedQueue<EnemyPlane> enemyPlanes,
			ConcurrentLinkedQueue<Shell> enemyShells,
			MainMenuFrame mainMenuFrame) {
		this.num=num;
		this.kind=kind;
		this.round=round;
		this.enemyShells=enemyShells;
		this.enemyPlanes=enemyPlanes;
		this.mainMenuFrame=mainMenuFrame;
	}
	@Override
	public void run() {
		for(int j=0;j<num;j++) {
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
				}else
					mainMenuFrame.semaphore.release();	
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
		
			enemyPlanes.add(new EnemyPlane((int)(Math.random()*(Data.WINDOW_WIDTH-200)+100), //x
					(int)(Math.random()*Data.WINDOW_HEIGHT/5), //y
					Math.random()*Math.PI,//degree
					kind,//kind 0-5
					round,
					enemyShells));
			try {
				sleep((int)(Math.random()*1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
