package Demo.Role;

import java.awt.Image;
import java.awt.Rectangle;

public class GameObject {
	public int x;
	public int y;
	public int width;
	public int height;
	public int speed;//��ǰ�ٶ�
	public int frozen_speed;//������ʱ���ٶ�
	public int blood;//��ǰѪ��
	public int max_blood;//���Ѫ��
	public int exp;//����
	int kind;//�л�/boss/����/��ҷɻ�������
	int form;//boss����̬
	public Image image;
	public Image[] images;
	public int duration;//����Ч������ʱ��
	public double degree;//�ٶȵĽǶ�
	public boolean live;//�Ƿ���
	public boolean isBoss;
	public int state;//״̬��0����  1����  2ѣ��
	 GameObject() {
	}
	
	public Rectangle getRectangle() {
		return new Rectangle(x, y, width, height);
	}
}
