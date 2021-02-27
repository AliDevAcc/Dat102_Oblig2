package no.hvl.dat102.klient;

import java.util.Scanner;

import no.hvl.dat102.Person;
import no.hvl.dat102.kjedet.KjedetKoe;
import no.hvl.dat102.tabell.SirkulaerKoe;

public class PersonKlient {
	
public static void main(String[] args) {
	Person p1=lesPerson();
	Person p2=lesPerson();
	Person p3=lesPerson();
	Person p4=lesPerson();
	Person p5=lesPerson();
	KjedetKoe<Person> k= new KjedetKoe<Person>();
	SirkulaerKoe<Person> s= new SirkulaerKoe<Person>();
	k.innKoe(p1);
	k.innKoe(p2);
	k.innKoe(p3);
	k.innKoe(p4);
	k.innKoe(p5);
	
	s.innKoe(p1);
	s.innKoe(p2);
	s.innKoe(p3);
	s.innKoe(p4);
	s.innKoe(p5);
	
	System.out.println(s.utKoe());
	System.out.println(s.utKoe());
	System.out.println(s.utKoe());
	System.out.println(s.utKoe());
	System.out.println(s.utKoe());
	
	System.out.println(k.utKoe());
	System.out.println(k.utKoe());
	System.out.println(k.utKoe());
	System.out.println(k.utKoe());
	System.out.println(k.utKoe());
	
	
	
}

public static Person lesPerson() {
	Scanner sc=new Scanner(System.in);
	System.out.println("Skrv inn fornavn");
	String fnavn=sc.nextLine();
	System.out.println("Skriv inn etternavn");
	String enavn=sc.nextLine();
	System.out.println("Skriv inn fødselsår");
	int f_aar=sc.nextInt();
	
	Person p1= new Person(fnavn,enavn,f_aar);
	
	return p1;
	
	
}

}
