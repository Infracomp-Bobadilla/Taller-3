package Estructura;

import java.util.LinkedList;

public class Semaforo {

	private int contador;
	private LinkedList<Object> colaEspera;

	public Semaforo(int contador) {
		this.contador = contador;
		this.colaEspera = new LinkedList<Object>();
		
		System.out.println("El contador del semaforo inicia en: " + contador);
	}

	// Solicitar turno
	public void p() {

		while(contador < 0) {
			
			Object s = new Object();
			colaEspera.add(s);
			
			synchronized(s) {
				try { s.wait(); } catch (InterruptedException e) {}
			}

		}
		
		contador--;
		System.out.println("Se resto y semaforo en P esta en: " + contador);

	}
	// Liberar turno
	public void v() {

		if (contador >= 0) 
		{
			Object o = colaEspera.poll();
			synchronized(o) {
				o.notify();
				contador++;
				System.out.println("Se sumo y semaforo en V esta en: " + contador);
			}
		}

	}

}
