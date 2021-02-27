package no.hvl.dat102.mengde.klient;

import no.hvl.dat102.Hobby;
import no.hvl.dat102.Medlem;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;

public class MedlemKlient {
public static void main(String[] args) {
	
	Hobby h1 = new Hobby("Løpe");
	KjedetMengde<Hobby> m1=new KjedetMengde<Hobby>();
	m1.leggTil(h1);
	Medlem med1= new Medlem ("Medlem",m1,1);
}
}
