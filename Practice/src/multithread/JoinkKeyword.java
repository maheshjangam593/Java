package multithread;

class JoinKeyword implements Runnable {
	public void run() {
		for (int i = 1; i <= 5; i++) {
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.println(i);
		}
	}

	public static void main(String args[]) {
		JoinKeyword t4 = new JoinKeyword();
		JoinKeyword t5 = new JoinKeyword();
		JoinKeyword t6 = new JoinKeyword();
		Thread t1=new Thread(t4);
		Thread t2=new Thread(t5);
		Thread t3=new Thread(t6);
		
		t1.start();
		try {
			t1.join();
		} catch (Exception e) {
			System.out.println(e);
		}

		t2.start();
		t3.start();
	}
}