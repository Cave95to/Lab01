package it.polito.tdp.parole.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Parole {
		
	private List<String> lista;
	
	public Parole() {
		this.lista = new LinkedList<>();
	}
	
	public void addParola(String p) {
		this.lista.add(p);
	}
	
	public List<String> getElenco() {
		Collections.sort(this.lista);
		return this.lista;
	}
	
	public void reset() {
		this.lista.clear();
	}

}
