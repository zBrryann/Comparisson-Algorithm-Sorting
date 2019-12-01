package ADA;

public class MergeSort extends Thread{
	int[] ar;
	PanelSort window;
	int sleepTime;
	
	public MergeSort(int[] ar, PanelSort panel, int milis) {
		this.ar = ar;
		this.window = panel;
		this.sleepTime = milis;
	}
	public void run() {
		mergeSort(ar,0,ar.length-1);
	}
    private void mergeSort(int arr[], int l, int r){ 
        if (l < r) {  
            int m = (l+r)/2;
            mergeSort(arr, l, m); 
            mergeSort(arr , m+1, r); 
            merge(arr, l, m, r); 
        } 
    } 
    private void merge(int arr[], int l, int m, int r) { 
        int n1 = m - l + 1; 
        int n2 = r - m;
        int L[] = new int [n1]; 
        int R[] = new int [n2];
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
        int i = 0, j = 0;  
        int k = l; 
        while (i < n1 && j < n2) { 
            if (L[i] <= R[j]) { 
                arr[k] = L[i]; 
                i++; 
            } 
            else{ 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
            window.paintComponent(window.getGraphics());
            try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        } 
        while (i < n1) { 
            arr[k] = L[i]; 
            i++; 
            k++; 
            window.paintComponent(window.getGraphics());
            try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
        while (j < n2){ 
            arr[k] = R[j]; 
            j++; 
            k++;    
            window.paintComponent(window.getGraphics());
            try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        } 
    } 
}