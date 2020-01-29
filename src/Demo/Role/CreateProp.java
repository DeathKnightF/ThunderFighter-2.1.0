package Demo.Role;

import java.util.concurrent.ConcurrentLinkedQueue;

import Demo.Data.Data;

public class CreateProp extends Thread{
	ConcurrentLinkedQueue<Prop> props;
	int num;
	int kind;
	PlayerPlane player;
	public CreateProp(ConcurrentLinkedQueue<Prop> props,int num,int kind,PlayerPlane player) {
		this.props=props;
		this.num=num;
		this.kind=kind;
		this.player=player;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<num;i++) {
			try {
			if(kind==0)//��Ѫƽ������ӳ�һ��
				sleep((int)(Math.random()*60000));
			if(kind==1)//���ӹ���ƽ�������ӳ�һ��
				sleep((int)(Math.random()*240000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			props.add(new Prop((int)(Math.random()*Data.WINDOW_WIDTH), 100, kind, player));
		}
	}
}
