package no.hvl.dat102;

import no.hvl.dat102.mengde.kjedet.KjedetMengde;

public class Medlem {
	private String navn;
	private KjedetMengde<Hobby> hobbyer; //Eller Tabellmengde
	private int statusIndeks;
	
	public Medlem(String navn, KjedetMengde<Hobby> hobbyer,int statusIndeks) {
		this.navn=navn;
		hobbyer= new KjedetMengde<Hobby>();
		this.statusIndeks=statusIndeks;
	}
	
	public KjedetMengde<Hobby> getHobbyer() {
		return hobbyer;
	}

	public void setHobbyer(KjedetMengde<Hobby> hobbyer) {
		this.hobbyer = hobbyer;
	}

	public int getStatusIndeks() {
		return statusIndeks;
	}

	public void setStatusIndeks(int statusIndeks) {
		this.statusIndeks = statusIndeks;
	}

	public String getNavn() {
		return navn;
	}
	
	public void setNavn(String navn) {
		this.navn=navn;
	}
	
	public boolean PasserTil(Medlem medlem2) {
		boolean passer=false;
		
		if(this.hobbyer.equals(medlem2.hobbyer)) {
			passer=true;
		}
		
		return passer;
	}
}
