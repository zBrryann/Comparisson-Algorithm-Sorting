package ADA;
public class InsertionSort extends Thread{
	int[] ar;
	PanelSort window;
	int sleepTime;
	
	public InsertionSort(int[] ar, PanelSort panel, int milis) {
		this.ar = ar;
		this.window= panel;
		this.sleepTime = milis;
	}
	public void run() {
		int n = ar.length; 
        for (int i = 1; i < n; ++i) { 
            int key = ar[i]; 
            int j = i - 1; 
            while (j >= 0 && ar[j] > key) { 
                ar[j + 1] = ar[j]; 
                j = j - 1; 
                window.paintComponent(window.getGraphics());           
                try {
					Thread.sleep(sleepTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
            } 
            ar[j + 1] = key; 
            window.paintComponent(window.getGraphics());
        } 
	}
}