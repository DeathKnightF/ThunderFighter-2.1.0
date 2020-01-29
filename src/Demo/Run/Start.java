package Demo.Run;
import java.awt.EventQueue;

import Demo.UI.MainMenuFrame;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenuFrame frame = new MainMenuFrame(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
