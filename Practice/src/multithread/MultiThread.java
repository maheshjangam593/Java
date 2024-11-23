package multithread;

public class MultiThread {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		Thread t1 = new Thread(new Hello());
		Thread t2 = new Thread(new Hi());
		t1.start();
		
		t2.start();
		
		
	}
}

class Hello extends Thread{
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("A " + i);
			
		}
	}
}

class Hi extends Thread{
	public void run() {
		for (int j = 0; j < 10; j++) {
			System.out.println("B " + j);

		

		}
	}
}