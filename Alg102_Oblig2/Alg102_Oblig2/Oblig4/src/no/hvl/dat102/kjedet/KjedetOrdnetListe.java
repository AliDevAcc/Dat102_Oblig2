package no.hvl.dat102.kjedet;

import no.hvl.dat102.adt.*;
import no.hvl.dat102.tabell.LinearNode;

/**
 * 
 * @param <T> elementtypen
 */
public class KjedetOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {
	private int antall;
	private LinearNode<T> foerste, siste;

	/**
	 * Lager en ny tom liste.
	 */
	public KjedetOrdnetListe() {
		antall = 0;
		foerste = null;
		siste = null;
	}

	@Override
	public T fjernFoerste() {
		T svar = null;
		if (!erTom()) {
			svar = foerste();
			foerste = foerste.getNeste();
			antall--;
		} else {
			siste = null;
		}
		return svar;
	}

	@Override
	public T fjernSiste() {
		T svar = null;
		if (!erTom()) {
			svar = siste();
			
			if (antall == 0) {
				foerste = null;
				siste = null;
			} else {
				siste = foerste;
				for (int i = 0; i < antall-1; i++) {
					siste = siste.getNeste();
				}

				siste.setNeste(null);
				antall--;
			}
		}
		return svar;
	}

	@Override
	public T foerste() {
		T svar = null;
		if (!erTom()) {
			svar = foerste.getElement();
		}
		return svar;
	}

	@Override
	public T siste() {
		T svar = null;
		if (!erTom()) {
			svar = siste.getElement();
		}
		return svar;
	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public void leggTil(T element) {

		LinearNode<T> node = new LinearNode<T>(element);
		LinearNode<T> denne = foerste;
		LinearNode<T> forrige=null;

			
			
			while(denne != null && element.compareTo(denne.getElement()) >0) 
			{
				forrige=denne;
				denne = denne.getNeste();
				
				}
			
			if(forrige==null) {
				node.setNeste(denne);
				foerste=node;
			}  else {
				node.setNeste(denne);
				forrige.setNeste(node);
			}
			if(denne==null) {
				siste=node;
			}
			
			antall++;
	}

	@Override
	public T fjern(T element) { // Slette og returnere element hvis det fins
								// ellers returnere null
		T svar = null; // Hvis flere, så slettes første forekomst
		LinearNode<T> forrige = null, denne = foerste;
		while (denne != null && !element.equals(denne.getElement())) {
			forrige = denne;
			denne = denne.getNeste();
		}
		if (denne != null) {// funnet
			antall--;
			svar = denne.getElement();
			if (forrige == null) { // Første element
				foerste = foerste.getNeste();
				if (foerste == null) { // Tom liste
					siste = null;
				} 
				
			}
			else { // Midt i listen eller bak
					forrige.setNeste(denne.getNeste());
					if (denne == siste) {
						siste = forrige;
					}
				} // ikke-funn
		 }
				return svar;
	}

	public boolean inneholder(T element) {
		LinearNode<T> denne = foerste;
		boolean resultat = false;
		while(denne != null && element.compareTo(denne.getElement()) >0) 
		{
			denne = denne.getNeste();
			}
		if(denne != null) {
			if(element.equals(denne.getElement())) {
				resultat = true;}
		}// ikke-funn
		return resultat;
	}
	
}// class
