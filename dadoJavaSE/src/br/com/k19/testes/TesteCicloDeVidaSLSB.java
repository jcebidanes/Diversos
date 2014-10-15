package br.com.k19.testes;

import javax.naming.InitialContext;

import br.com.k19.sessionbeans.LancadorDeDado;

public class TesteCicloDeVidaSLSB {
	public static void main(String[] args) throws Exception {
		InitialContext ic = new InitialContext();
		
		for ( int i = 0; i < 100; i ++) {
			final LancadorDeDado lancadorDeDado = (LancadorDeDado) ic.lookup("java:global/dadoWeb/LancadorDeDadoBean");
			Thread thread = new Thread(new Runnable () {
				@Override
				public void run () {
					for ( int i = 0; i < 100; i ++) {
						System.out.println(lancadorDeDado.lanca());
					}
				}
			});
			
			thread.start();
		}
	}
}
