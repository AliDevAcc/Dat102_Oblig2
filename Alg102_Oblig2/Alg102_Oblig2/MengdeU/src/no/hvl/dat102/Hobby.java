package no.hvl.dat102;

public class Hobby {
private String hobbyNavn;
public Hobby(String hobby) {
	hobbyNavn=hobby;
}

public String toString() {
	return "<" + hobbyNavn + ">";
}

public String getHobbyNavn() {
	return hobbyNavn;
}

public void setHobbyNavn(String hobby) {
	hobbyNavn=hobby;
}

public boolean equals(Object hobby2){
	Hobby hobbyDenAndre= (Hobby)hobby2;          
	return(hobbyNavn.equals((hobbyDenAndre).getHobbyNavn()));}  
}


