package ADA;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Principal extends JFrame{	
	boolean first;
	JPanel menuPanel;
	JPanel laminasPanel;
	PanelSort lamina1;
	PanelSort lamina2;
	PanelSort lamina3;
	PanelSort lamina4;
	JButton btnStart;
	Color darkGreen=new Color(0,128,0);
	Color seaGreen=new Color(32,178,170);
	public Principal() {
		setBounds(75,5,1220,720);
		setTitle("Sorting Algorithms");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
		first = true;
		setVisible(true);
	}
	public void initComponents() {
		laminasPanel = new JPanel();
		laminasPanel.setLayout(new GridLayout(2,2));
		laminasPanel.setSize(new Dimension(1000,720));
		int[] ar = generateArray(30,100);
		lamina1 = new PanelSort(Arrays.copyOf(ar, ar.length),100);
		lamina2 = new PanelSort(Arrays.copyOf(ar, ar.length),100);
		lamina3 = new PanelSort(Arrays.copyOf(ar, ar.length),100);
		lamina4 = new PanelSort(Arrays.copyOf(ar, ar.length),100);
		Border bubbleBorder = new TitledBorder(new EtchedBorder(), "Bubble Sort");
		Border insertionBorder = new TitledBorder(new EtchedBorder(), "Insertion Sort");
		Border quickBorder = new TitledBorder(new EtchedBorder(), "Quick Sort");
		Border mergeBorder = new TitledBorder(new EtchedBorder(), "Merge Sort");
		lamina1.setBorder(bubbleBorder);
		lamina2.setBorder(mergeBorder);
		lamina3.setBorder(insertionBorder);
		lamina4.setBorder(quickBorder);
		laminasPanel.add(lamina1);
		laminasPanel.add(lamina2);
		laminasPanel.add(lamina3);
		laminasPanel.add(lamina4);
		menuPanel = new JPanel();
		Border menuBorder = new TitledBorder(new EtchedBorder(), "Options");
		menuPanel.setBorder(menuBorder);
		menuPanel.setPreferredSize(new Dimension(200,720));
		menuPanel.setMaximumSize(new Dimension(200,720));
		menuPanel.setMinimumSize(new Dimension(200,720));
		menuPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		btnStart = new JButton("START");
		btnStart.setPreferredSize(new Dimension(150,40));
		btnStart.setBackground(seaGreen);
		btnStart.setForeground(Color.BLACK);
		btnStart.setFont(new Font("Open Sans",Font.BOLD,20));
		ponerBoton(menuPanel, btnStart, new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				int milis=30;
				int elements = 45;
				if(first) {
					Thread bubbleThread = new BubbleSort(lamina1.getArray(),lamina1,milis);
					Thread mergeThread = new MergeSort(lamina2.getArray(),lamina2,milis);
					Thread insertionThread = new InsertionSort(lamina3.getArray(),lamina3,milis);
					Thread quickThread = new QuickSort(lamina4.getArray(),lamina4,milis);
					
					bubbleThread.start();
					insertionThread.start();
					quickThread.start();
					mergeThread.start();
					first = false;
				}else {
					lamina1.clearWindow(lamina1.getGraphics());
					lamina2.clearWindow(lamina2.getGraphics());
					lamina3.clearWindow(lamina3.getGraphics());
					lamina4.clearWindow(lamina4.getGraphics());
					int[] ar = generateArray(elements,elements*2);
					lamina1.updateData(Arrays.copyOf(ar, ar.length),elements*2);
					lamina2.updateData(Arrays.copyOf(ar, ar.length),elements*2);
					lamina3.updateData(Arrays.copyOf(ar, ar.length),elements*2);
					lamina4.updateData(Arrays.copyOf(ar, ar.length),elements*2);
					Thread bubbleThread = new BubbleSort(lamina1.getArray(),lamina1,milis);
					Thread mergeThread = new MergeSort(lamina2.getArray(),lamina2,milis);
					Thread insertionThread = new InsertionSort(lamina3.getArray(),lamina3,milis);
					Thread quickThread = new QuickSort(lamina4.getArray(),lamina4,milis);
					
					bubbleThread.start();
					insertionThread.start();
					quickThread.start();
					mergeThread.start();
				}
			}
		});
		add(laminasPanel, BorderLayout.CENTER);
		add(menuPanel,BorderLayout.EAST);
	}
	public void ponerBoton(Container c, JButton boton, ActionListener oyente){
		c.add(boton);
		boton.addActionListener(oyente);
	}
	private int[] generateArray(int length, int maxValue) {
		int[] ar = new int[length];
		Random rd = new Random();
		for(int i=0;i<ar.length;i++)
			ar[i] = rd.nextInt(maxValue-10)+1;
		return ar;
	}	
}