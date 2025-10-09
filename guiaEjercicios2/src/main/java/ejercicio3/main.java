package ejercicio3;

public class main {

	public static void main(String[] args) {
		Thread jojo = new Thread(new Johnny());
		Thread gyro = new Thread(new Gyro());
		while(!jojo.isAlive() || !gyro.isAlive()) {
			jojo.start();
			gyro.start();
		}
	}

}
