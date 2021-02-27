package no.hvl.dat102.klient;

import java.util.Scanner;

import no.hvl.dat102.Person;
import no.hvl.dat102.kjedet.KjedetOrdnetListe;
import no.hvl.dat102.tabell.TabellOrdnetListe;

public class OrdentPersonKlient {
public static void main(String[] args) {
	Person p1=lesPerson();
	Person p2=lesPerson();
	Person p3=lesPerson();
	Person p4=lesPerson();
	KjedetOrdnetListe<Person> k1 = new KjedetOrdnetListe<Person>();
	TabellOrdnetListe<Person> t1 = new TabellOrdnetListe<Person>();
	
	k1.leggTil(p1);
	k1.leggTil(p2);
	k1.leggTil(p3);
	k1.leggTil(p4);
	
	t1.leggTil(p1);
	t1.leggTil(p2);
	t1.leggTil(p3);
	t1.leggTil(p4);
	
	System.out.println(k1.fjern(p1));
	System.out.println(k1.fjern(p2));
	System.out.println(k1.fjern(p3));
	System.out.println(k1.fjern(p4));
	
	System.out.println(t1.fjern(p1));
	System.out.println(t1.fjern(p2));
	System.out.println(t1.fjern(p3));
	System.out.println(t1.fjern(p4));
	
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
