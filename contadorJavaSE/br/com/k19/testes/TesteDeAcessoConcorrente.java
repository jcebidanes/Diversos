package br.com.k19.testes;

import javax.naming.InitialContext;

import br.com.k19.sessionbeans.Contador;

public class TesteDeAcessoConcorrente {

	public static void main(String[] args) throws Exception {
		InitialContext ic = new InitialContext();
		
		final Contador contador = (Contador) ic.lookup("java:global/chatWeb/ContadorBean");
				
		final Thread[] threads = new Thread[20];
		
		System.out.println(" Contador = " + contador.getValor());
		System.out.println(" Incrementando " + threads.length * threads.length  + " vezes ");
		
		for (int i=0; i<threads.length; i++) {
			
			threads[i] = new Thread(new Runnable(){
				public void run() {
					for (int i=0; i < threads.length ; i++) {
						contador.incrementa();
					}
				}
			});
			
			threads[i].start();
		}
				
		for(Thread thread:threads) {
			thread.join();
		}
		
		System.out.println(" Contador = " + contador.getValor());

	}

}
