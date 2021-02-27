package no.hvl.dat102.mengde.klient;

import java.io.File;
import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

import no.hvl.dat102.Datakontakt;
import no.hvl.dat102.Hobby;
import no.hvl.dat102.Medlem;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;

public class TekstgrenseSnitt {

	
	public static void main(String[] args) {
		Medlem m1=lesMedlem();
		Medlem m2=lesMedlem();
		Medlem[] tab= {};
		Datakontakt d1= new Datakontakt(tab);
		
		d1.leggTilMedlem(m1);
		d1.leggTilMedlem(m2);
		tab[d1.finnPartnerFor(m1)].setStatusIndeks(1);;
		m1.setStatusIndeks(1);
		skrivParListe(d1);
		
		
		
		
		skrivParListe(d1);
	}
	
	public static Medlem lesMedlem() {
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Skriv inn navn på medlem");
		String navn=sc.nextLine();	
		KjedetMengde<Hobby> hobbyer=new KjedetMengde<Hobby>();
		System.out.println("Legg inn hobbyer");
		String h = sc.nextLine();
		
		while(!h.equals("Stopp")){
		Hobby h1=new Hobby(h);
		hobbyer.leggTil(h1);
		System.out.println("Si 'Stopp' for å slutte å legge inn hobbyer");
		h=sc.nextLine();
		}
		
		System.out.println("Oppgi Status");
		int status=sc.nextInt();
		
		Medlem m1= new Medlem(navn,hobbyer,status);
		
		
		return m1;
		
	}
	
	public static void skrivHobbyListe(Medlem medlem) {
		System.out.println("Alle hobbyene ");
		System.out.println(medlem.getHobbyer().toString());
	}
	
	public static void skrivParListe(Datakontakt arkiv) {
		
		
		arkiv.Par();
		System.out.println(arkiv.antallPar());
		System.out.println("Antall Medlemmer " + arkiv.antall());
	}

}
