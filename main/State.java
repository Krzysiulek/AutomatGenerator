package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Vector;



public class State {
	private int id;
	private String name;
	boolean isFinal;
	int reducedStates = 1;
	Map<String, Integer> alphabet = new HashMap<>();
	String tmp = "";
	
	//max State jest zmienna informujacą jak dużo stanów będzie w automacie
	//tak, żeby stany przejściowe były losowane z tego przedziału
	State(int id, boolean isFinal, Vector<String> letters, int maxState){
		this.id = id;
		this.name = "q" + id;
		this.isFinal = isFinal;
		this.createMap(letters, maxState);
	}
	
	State(int id, boolean isFinal, Vector<String> letters, int maxState, int reducedStates){
		this.id = id;
		this.name = "q" + id;
		this.isFinal = isFinal;
		this.reducedStates = reducedStates;
		this.createMap(letters, maxState);
	}
	
	private void createMap(Vector<String> letters, int maxState) {
		Random generator = new Random();
		//przeszukuje calego Stringa z literami i tworzy z tego mape
		//id stanu losowe
		for(String e : letters) {
			//jezeli randomState == -1 brak przejscia do jakiegos stanu
			int randomState = generator.nextInt(maxState + this.reducedStates) - this.reducedStates;
			this.alphabet.put(e, randomState);
			//this.alphabet.put("a", 2);
			//System.out.println(e + " q" + randomState);
		}
	}

	public void printState() {
		System.out.print(
				this.name + " ");
		if(this.isFinal == true)
			System.out.print(1 + " ");
		else
			System.out.print(0 + " ");
		
		
		alphabet.forEach((k,v) -> {
			if(v >= 0)
				System.out.print("q"+v + " ");
			else
				System.out.print("-- ");		
		});
	}
	
	public String getState() {
		String tmp = "";
		//System.out.print(this.name + " ");
		tmp+= this.name + " ";
		if(this.isFinal == true)
			tmp+= 1 + " ";
			//System.out.print(1 + " ");
		else
			tmp+= 0 + " ";
			//System.out.print(0 + " ");
		
		
		alphabet.forEach((k,v) -> {
			if(v >= 0)
				this.tmp+="q"+v + " ";
				//System.out.print("q"+v + " ");
			else
				this.tmp += "-- ";
				//System.out.print("-- ");		
		});
		tmp += this.tmp;
		return tmp;
	}
	
	public void setFinalTrue() {
		this.isFinal = true;
	}
	
	public boolean getFinal() {
		return this.isFinal;
	}
	
	public int getId() {
		return this.id;
	}
	
	public Map<String, Integer> getMap() {
		return this.alphabet;
	}
}
