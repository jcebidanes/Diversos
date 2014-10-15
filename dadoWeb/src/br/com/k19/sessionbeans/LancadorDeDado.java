package br.com.k19.sessionbeans;

import java.util.Map;
import java.util.concurrent.Future;

public interface LancadorDeDado {
	public int lanca();
	public Future<Map<Integer, Integer>> calculaFrequencia();
}
