package ADA;
import java.awt.*;
import java.util.*;
import javax.swing.JPanel;

public class PanelSort extends JPanel{
	Graphics2D g2D;
	int[] ar;
	int maxValue;
	boolean first;
	Color darkGreen=new Color(0,128,0);
	public PanelSort(int maxValue) {
		Random rd = new Random();
		ar = new int[30];
		for(int i = 0; i<ar.length;i++) 
			ar[i] = rd.nextInt(maxValue)+1;
		this.maxValue = maxValue;
		this.first = true;
	}	
	public PanelSort(int[] ar, int maxValue) {
		this.ar = ar;
		this.maxValue = maxValue;
	}
	public void paintComponent(Graphics g) {
		g2D = (Graphics2D) g;
		Dimension d = getSize();
		int screenWidth = d.width-20;
		int screenHeigth = d.height-30;
		int xPos;
		int width = (int) Math.floor((screenWidth/ar.length)*0.9);
		int space = (int) Math.floor((screenWidth/ar.length)*0.1);
		int yPos;
		int height;
		for(int i=0;i<ar.length;i++) {
			height = (ar[i]*screenHeigth)/maxValue;
			yPos = screenHeigth - height +15;
			xPos = (width+space)*i+10;
			g2D.setColor(getBackground());
			g2D.fillRect(xPos, 15, width, d.height-30);
			g2D.setColor(darkGreen);
			g2D.fillRect(xPos, yPos, width, height);
		}
	}
	public int[] getArray() {
		return ar;
	}
	public void clearWindow(Graphics g) {
		g.setColor(getBackground());
		Dimension d = getSize();
		g.fillRect(10,15,d.width-20,d.height-30);
	}
	public void updateData(int[] ar,int maxValue) {
		this.ar = ar;
		this.maxValue = maxValue;
	}
}