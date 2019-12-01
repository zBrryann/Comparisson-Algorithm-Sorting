package ADA;

public class BubbleSort extends Thread{
	int[] ar;
	PanelSort panel;
	int milis;
	public BubbleSort(int[] ar,PanelSort panel, int milis) {
		this.ar = ar;
		this.panel = panel;
		this.milis = milis;
	}
	public void run() {
		int n = ar.length; 
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) { 
                if (ar[j] > ar[j+1]) { 
                    int temp = ar[j]; 
                    ar[j] = ar[j+1]; 
                    ar[j+1] = temp;
                    panel.paintComponent(panel.getGraphics());
                }
                try {
					Thread.sleep(milis);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
            }
	}
}