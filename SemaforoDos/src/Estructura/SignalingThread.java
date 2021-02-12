package Estructura;

public class SignalingThread extends Thread{
	
	private String id;
	
	private Signaling contador = new Signaling();
	private static Semaforo semaf = new Semaforo(1);
	
	public SignalingThread(String ident) {
		id = ident;
	}
	
	public void run() 
	{
		if(id.equals("A")) 
		{
			semaf.p();
			contador.A();
			semaf.v();
		}	
		else 
		{
			semaf.p();
			contador.B();
			semaf.v();
		}
	}
	
}
