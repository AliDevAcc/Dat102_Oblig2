package no.hvl.dat102;

import no.hvl.dat102.*;

public class Datakontakt {
	private Medlem[] tab;
	private int ant_medlem;
	
	public Datakontakt(Medlem[] tab) {
		tab= new Medlem[ant_medlem];
	}
	
	
	public int getAnt_medlem() {
		return ant_medlem;
	}


	public void setAnt_medlem(int ant_medlem) {
		this.ant_medlem = ant_medlem;
	}


	public void leggTilMedlem(Medlem person) {
		
		tab[ant_medlem]=person;
		ant_medlem++;
	}
	
	public int finnMedlemsIndeks(Medlem medlemsnavn) {
		
		int indeks=-1;
		
		for(int i=0; i < ant_medlem; i++) {
		if(tab[i]==medlemsnavn) {
			indeks=i;
		}
		}
		return indeks;
		
	}
	
	public int finnPartnerFor (Medlem medlemsnavn) {
		
		int indeks=-1;
		int k_nr=1;
		boolean funnet=false;

		for(int i=0; i < ant_medlem; i++) {
		if(tab[i]==medlemsnavn) {
			int j=0;
			while(!funnet && j < ant_medlem) {
				
				if(tab[j].getStatusIndeks()==0) {
				if (tab[j].PasserTil(medlemsnavn)) {
					tab[i].setStatusIndeks(k_nr);
					tab[j].setStatusIndeks(k_nr);
					k_nr++;
					indeks=j;
					funnet=true;	
					}
				
				j++;
				}
				}
			}
			}
		
		return indeks;
		}
	
	public void tilbakestillStatusIndeks(Medlem medlemsnavn) {
		
		for(int i=0; i < ant_medlem; i++) {
		for(int j=0; i < ant_medlem; j++) {
			if(tab[i]==medlemsnavn) {
			if(tab[j].getStatusIndeks()==tab[i].getStatusIndeks()) {
				tab[i].setStatusIndeks(0);
				tab[j].setStatusIndeks(0);
			}
				}
		}
		}
	}
	
	public int antallPar() {
		int antall=0;
		for(int i=0; i < ant_medlem; i++) {
		for(int j=0; j < ant_medlem; i++) {
			if(tab[i].getStatusIndeks()==tab[j].getStatusIndeks()) {
				antall++;
			}
		}
		}
		return antall;
	}
	
	public void Par() {
		int antall=0;
		System.out.println("PAR NAVN");
		for(int i=0; i < ant_medlem; i++) {
		for(int j=0; j < ant_medlem; i++) {
			if(tab[i].getStatusIndeks()==tab[j].getStatusIndeks()) {
				System.out.println(tab[i].getNavn()+ ","+tab[j].getNavn());
			}
		}
		}
	}
	
	public int antall() {
		return ant_medlem;
	}
}