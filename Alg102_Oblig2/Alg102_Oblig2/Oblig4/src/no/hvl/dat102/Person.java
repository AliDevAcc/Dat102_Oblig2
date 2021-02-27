package no.hvl.dat102;

public class Person implements Comparable<Person> {
	private String fornavn;
	private String etternavn;
	private int fodselsaar;
	

	public Person() {
		this("","",0);
		
	}
	public Person(String fornavn, String etternavn,int fodselsaar) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.fodselsaar=fodselsaar;
		
	}

	// Returnerer en kontakt som en strengrepresentasjon.
	public String toString() {
		return (etternavn + ", " + fornavn + "\t"+fodselsaar); 
	}
	@Override
	public int compareTo(Person arg0) {
		int resultat=0;
		if(fodselsaar==arg0.fodselsaar) {
		if (etternavn.equals(arg0.etternavn)) {
			resultat = fornavn.compareTo(arg0.fornavn);
		} else {
			resultat = etternavn.compareTo(arg0.etternavn);
		}
		} else {
			resultat=fodselsaar-arg0.fodselsaar;
		}
		return resultat;
	}

}
