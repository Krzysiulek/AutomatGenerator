package main;

public class Pair {
	int state;
	String letter;
	
public Pair(int state, String letter) {
	// TODO Auto-generated constructor stub
	this.state = state;
	this.letter = letter;
}

public int getState() {
	return this.state;
}

public String getLetter() {
	return this.letter;
}

public void setPair(int state, String letter) {
	// TODO Auto-generated constructor stub
	this.state = state;
	this.letter = letter;
}

@Override
public String toString() {
	// TODO Auto-generated method stub
	super.toString();
	return "S: " + this.state + " L: " + this.letter;
	
}

}
