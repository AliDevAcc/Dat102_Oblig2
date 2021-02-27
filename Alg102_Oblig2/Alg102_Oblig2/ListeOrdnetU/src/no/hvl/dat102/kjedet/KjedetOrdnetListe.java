package no.hvl.dat102.kjedet;
import no.hvl.dat102.adt.*;

/**
 * 
 * @param <T>
 *            elementtypen
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
		LinearNode<T> denne;
		if(!erTom()) {
			svar=foerste();
			denne=foerste;
			foerste=foerste.getNeste();
			denne.setNeste(foerste.getNeste());
		}
		return svar;
	}

	@Override
	public T fjernSiste() {
		T svar = null;
		LinearNode<T> denne;
		if(!erTom()) {
			svar=foerste();
			denne=siste;
			siste=siste.getNeste();
			denne.setNeste(siste.getNeste());
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
	public T fjern(T element) {
		T svar = null;
		LinearNode<T> forrige = null, denne = foerste;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			forrige = denne;
			denne = denne.getNeste();
		}
		if (denne != null && element.equals(denne.getElement())) { // funnet
			antall--;
			svar = denne.getElement();
			if (forrige == null) {     // Første element
				foerste = foerste.getNeste();
				if (foerste == null) { // Tom liste
					siste = null;
				}
			} else { // Inni listen eller bak
				forrige.setNeste(denne.getNeste());
				if (denne == siste) { // bak
					siste = forrige;
				}
			}
		} // ikke-funn
		return svar;
	}

	
	@Override
	public boolean inneholder(T element) {
		boolean funnet = false;
		LinearNode<T> aktuell = foerste;
		for (int soek = 0; soek < antall && !funnet; soek++) {
			if (aktuell.getElement().equals(element)) {
				funnet = true;
			} else {
				aktuell = aktuell.getNeste();
			}
		}
		return funnet;
	}

}// class
