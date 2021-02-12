package Estructura;

public class Signaling {

	public static int contador = 0;

	// .. A() y B()

	public void A() {
		contador += 100;
		System.out.println("A dejo la cuenta en: " + contador);
		esperaAleatoria();
	}

	public void B() {
		contador += 10;
		System.out.println("B dejo la cuenta en: " + contador);
		esperaAleatoria();
	}

	private void esperaAleatoria() {
		try {
			Thread.sleep((long) (Math.random() * 1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// .. Main 

	public static void main(String[] args) {

		SignalingThread a = new SignalingThread("A");
		SignalingThread b = new SignalingThread("B");

		int orden = (int) (Math.random() * 100) % 2;

		if (orden == 0) {
			System.out.println("Inicia primero a");
			a.start();
			System.out.println("Inicia segundo b");
			b.start();
		} else {
			System.out.println("Inicia  primero b");
			b.start();
			System.out.println("Inicia segundo a");
			a.start();
		}

	}

}
