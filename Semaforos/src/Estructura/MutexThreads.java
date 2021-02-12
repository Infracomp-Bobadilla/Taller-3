package Estructura;

public class MutexThreads extends Thread{
	
	private String id;
	
	private Mutex contador = new Mutex();
	private static Semaforo semaf = new Semaforo(1);
	
	public MutexThreads(String ident) {
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
