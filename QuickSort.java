package ADA;

public class QuickSort extends Thread{
	int[] ar;
	PanelSort window;
	int sleepTime;
	
	public QuickSort(int[] ar, PanelSort panel, int milis) {
		this.ar = ar;
		this.window= panel;
		this.sleepTime= milis;
	}
	public void run() {
		quickSort(ar,0,ar.length-1);
	}
    private void quickSort(int vec[], int inicio, int fin){
                if(inicio>=fin) return;
                int pivote=vec[inicio];
                int elemIzq=inicio+1;
                int elemDer=fin;
                while(elemIzq<=elemDer){
                        while(elemIzq<=fin && vec[elemIzq]<pivote){
                                elemIzq++;
                        }
                        while(elemDer>inicio && vec[elemDer]>=pivote){
                                elemDer--;
                        }
                        if(elemIzq<elemDer){
                                int temp=vec[elemIzq];
                                vec[elemIzq]=vec[elemDer];
                                vec[elemDer]=temp;
                        }
                        window.paintComponent(window.getGraphics());
                        try {
							Thread.sleep(sleepTime);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
                }
                if(elemDer>inicio){
                        int tmp=vec[inicio];
                        vec[inicio]=vec[elemDer];
                        vec[elemDer]=tmp;
                }
                window.paintComponent(window.getGraphics());
                try {
					Thread.sleep(sleepTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
                quickSort(vec, inicio, elemDer-1);
                quickSort(vec, elemDer+1, fin);
        }
}
