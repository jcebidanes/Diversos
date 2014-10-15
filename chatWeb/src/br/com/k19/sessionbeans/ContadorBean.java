package br.com.k19.sessionbeans;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Remote;
import javax.ejb.Singleton;

@Singleton

@Remote(Contador.class)
public class ContadorBean implements Contador {

	private int valor;
	
	public void incrementa() {
		this.valor++;
	}
	
	@Lock(LockType.READ)
	public int getValor() {
		return this.valor;
	}

}
