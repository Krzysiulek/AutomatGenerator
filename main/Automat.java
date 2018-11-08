package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Vector;


public class Automat {
	private int howManyStates;
	private int howManyFinal;
	private int howManyLetters;
	private int reducedStates = 1;
	private int tmp_word_creat; //do sprawdzenia slowa, bo Scope się sypał w Lambdzie
	private boolean tmp_word_creat_b; // -----//-----
	int state_tmp; // do losowania stanow - zmienna reprezentująca z którego stanu pobieramy literę
	Vector<String> letters = new Vector<String>(); //tutaj przechowywane sa tylko litery
	Vector<State> automat = new Vector<State>(); //vector ktory przechowuje wszystkie stany automatu
	Vector<String> randomWord = new Vector(); //vector przechowujacy losowe, pasujace slowo
	Random generator = new Random();
	
	public Automat(int howManyStates, int howManyFinal, int howManyLetters) {
		this.howManyStates = howManyStates;
		this.howManyFinal = howManyFinal;
		this.howManyLetters = howManyLetters;
		this.generateLetters();
		this.generateAutomat();
	}
	
	public Automat(int howManyStates, int howManyFinal, int howManyLetters, int reducedStates) {
		this.howManyStates = howManyStates;
		this.howManyFinal = howManyFinal;
		this.howManyLetters = howManyLetters;
		this.reducedStates = reducedStates;
		this.generateLetters();
		this.generateAutomat();
	}
	
	private void generateLetters() {
		char letter = 'a';
		for(int i = 0; i < this.howManyLetters; i++) {
			letters.add(Character.toString(letter));
			letter++;
		}
	}
	
	private void generateAutomat() {
		for(int i = 0; i < howManyStates; i++) {
			//dodaj losowość w końcowych automatach
			State state = new State(i, false, letters, howManyStates, reducedStates);
			automat.add(state);
		}
		
		Random generator = new Random();
		for(int i = 0; i < howManyFinal; i++) {
			this.automat.elementAt(generator.nextInt(howManyStates)).setFinalTrue();;
		}
	}

	public void printAutomat() {
		//Drukuje pierwszą linię dot. informacji o stanach
		System.out.print("qi f "); 
		for(String e : letters)
			System.out.print(e + "  ");
		System.out.println();
		
		//drukuje automat
		for(State e: automat) {
			e.printState();
			System.out.println();
		}
	}
	
	public String getAutomat() {
		String tmp = "";
		//Drukuje pierwszą linię dot. informacji o stanach
				//System.out.print("qi f ");
				tmp += "qi  f  ";
				for(String e : letters)
					tmp += e + "    ";
					//System.out.print(e + "  ");
				//System.out.println();
				tmp += "\n";
				
				//drukuje automat
				for(State e: automat) {
					//e.printState();
					tmp += e.getState();
					tmp += "\n";
					//System.out.println();
				}
				return tmp;
	}
	
	//losowanie słowa akceptowalnego przez automat
	public String getRandomWord() {
		state_tmp = getRandomFinalState(); //losuje stan finalny
		Vector<String> word = new Vector(); // to jest nasze "slowo", ktore generujemy
		Vector<Pair> pairs = new Vector();
		int licznik = 0;
		
		while(state_tmp != 0) {
			licznik++;
			if(licznik > 50) {
				System.out.println("ERROR");
				return null;
			}
			
			pairs.clear();
			//lecimy po całym grafie w poszukiwaniu krawedzi
			//i wrzucamy do vectora Pairs (wektor krawedzi i przejsc)
			for(State e : automat) {
				e.alphabet.forEach((k, v) -> {
					//System.out.println(k +" " + v);
					if(v == state_tmp) {
						Pair pair_tmp = new Pair(0, null);
						//System.out.println("Found: q" + e.getId() + " " + k);
						pair_tmp.setPair(e.getId(), k);
						pairs.add(pair_tmp);
					}
				});
				
				
			}
			//koniec przelotu po grafie
			
			//lecimy po vectorze przejsc
			for(Pair e: pairs) {
				//System.out.println(e.getState() + " " + e.getLetter());
			}
			///
			
			//losujemy jakis stan i litere
			
			int indexPair = 0;
			
			//bo sie wysypywal wyjatek
			if(pairs.size() > 0) {
				indexPair = generator.nextInt(pairs.size());
				//pobieramy nasza pare
				String tmp1 = pairs.get(indexPair).getLetter();
				int tmp2 = pairs.get(indexPair).getState();
				//System.out.println("\n" + tmp1 + " " + tmp2);
				
				//dodajemy do naszego slowa literke
				word.add(0, tmp1);
				
				//zmieniamy stan do ktorego chcemy potem przejsc
				state_tmp = tmp2;
			}
		}
		String a = "";
		//System.out.print("Slowo: ");
		for(String e : word) {
			//System.out.print(e);
			a+=e;
		}
		//System.out.println();
		return a;
		/*
		 * Wybieramy losowy stan finalny, 
		 * następnie przeglądamy krawędzie, które do niego dochodzą; 
		 * losujemy jedną z nich - 
		 * -wstawiamy odpowiednią literę do słowa i 
		 * przechodzimy do odpowiedniego stanu; jeżeli jest to stan początkowy q0, to kończymy generacje
		 */
	}
	
	private int getRandomFinalState() {
		int RandomState = generator.nextInt(automat.size());
		
		if(automat.elementAt(RandomState).isFinal) {
			return RandomState;
		}
		else {
			return getRandomFinalState();
		}
	}
	

	public void printToXML(String filename) {
		PrintWriter zapis;
		try {
			zapis = new PrintWriter(filename + ".jff");
			
			zapis.print("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><!--Created with JFLAP 7.1.--><structure>\n" + 
					"	<type>fa</type>\n" + 
					"	<automaton>\n" + 
					"		<!--The list of states.-->");
			//START STANÓW
			for(State e : automat) {
				zapis.print("<state id=\""+ e.getId() + "\" name=\"q" + e.getId() + "\">\n" + 
						"			<x>266.0</x>\n" + 
						"			<y>193.0</y>\n"); 
						
				if(e.getId() == 0) {
					zapis.print("<initial/>");
				}
				if(e.getFinal() == true) {
					zapis.print("<final/>");
				}
				zapis.print("</state>\n");
			}
			
			
			zapis.print("<!--The list of transitions.-->\n");
			
			int licznik = 0;
			for(State e : this.automat) {
				int tmp = licznik;
				Map<String, Integer> alphabet = e.getMap();
				alphabet.forEach((k,v) -> {
					if(v >= 0) {
						zapis.print("<transition>\n" + 
								"			<from>" + tmp + "</from>\n" + 
								"			<to>" + v + "</to>\n" + 
								"			<read>" + k + "</read>\n" + 
								"		</transition>\n");
					}
								
				});
			licznik++;
			}
			
			
			//KONIEC STANÓW
			zapis.print("	</automaton>\n" + 
					"</structure>");
			zapis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
	//nie uwzglednia stanów finalnych!!!!!!!!!!!!!
	public boolean isWordInAutomat(String word) {
		char[] wordTab = word.toCharArray();
		int state = 0;
		
		for(int i = 0; i < wordTab.length ; i++) {
			System.out.println(wordTab[i]);
			isLetterInState(wordTab[i], state);
			if(tmp_word_creat_b) {
				System.out.println("Spoko");
				state = tmp_word_creat;
			}
			
			else {
				System.out.println("Kicha");
				return false;
			}
		}
		return true;
	}
	
	private void isLetterInState(Character let, int state) {
		tmp_word_creat_b = false;
		if(state >= 0) {
			automat.get(state).alphabet.forEach((k, v) ->{
				if(let == k.charAt(0)) {
					System.out.println(v);

					tmp_word_creat = v;
					tmp_word_creat_b = true;
					System.out.println("Y");
				}
				System.out.println("X");

			});
		}
		
	}
}

/*
 * 	[ID | FINAL | MAP - alphabet ]
 * 	
 * 	1) Losuj stan finalny
 * 		-Wybierz losową literę
 * 		-przejdz do stanu, który ma ta litera
 * 			-dodaj litere do Stringa
 * 			-jezeli stan == q0 stop
 * 		
 * 
 */
