package no.hvl.dat102;

import static org.junit.Assert.*;
import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;
import no.hvl.dat102.mengde.tabell.TabellMengde;



public class MengdeU_Test {
	
	private MengdeADT<Integer> m1;
	private MengdeADT<Integer> m2;
	private MengdeADT<Integer> begge;
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;
	private Integer e5 = 6;
	private Integer e6 = 6;
	private Integer e7 = 8;
	private Integer e8 = 9;
	private Integer e9 = 10;
	
	
	/**
	 * Get a new mengde for each test.
	 */
	@Before
	public final void setup() {
		m1 = new KjedetMengde<Integer>();
		m2 = new KjedetMengde<Integer>();
		begge = new KjedetMengde<Integer>();
		
	}
	
	
	/**
	 * Test that two amounts "Mengde" with element(s) are not equal.
	 */
	@Test
	public final void union () {
		m2.leggTil(e0);
		m2.leggTil(e1);
		m2.leggTil(e2);
		m2.leggTil(e3);
		m2.leggTil(e4);
		
		m1.leggTil(e5);
		m1.leggTil(e6);
		m1.leggTil(e7);
		m1.leggTil(e8);
		m1.leggTil(e9);
		
		begge.leggTil(e0);
		begge.leggTil(e1);
		begge.leggTil(e2);
		begge.leggTil(e3);
		begge.leggTil(e4);
		
		begge.leggTil(e5);
		begge.leggTil(e6);
		begge.leggTil(e7);
		begge.leggTil(e8);
		begge.leggTil(e9);
		
	
		
		assertTrue(m1.union(m2).equals(begge));
		
	}
	
	/**
	 * Test that 2 amounts "Mengde" with element(s) are not equal.
	 */
	@Test
	public final void snitt() {
	
		assertTrue(m1.snitt(m2).equals(begge));
	}
	
	/**
	 * Test that 2 mengde with element(s) are not equal.
	 */
	@Test
	public final void differanse() {
		
		assertTrue(m1.differens(m2).equals(begge));
	}
	

}
