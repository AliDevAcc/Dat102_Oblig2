package no.hvl.dat102;

import java.io.*;

import no.hib.dat102.kjedet.KjedetStabel;
import no.hib.dat102.exception.*;

public class Balansering {
	
	
	KjedetStabel<Parentesinfo> stabel= new KjedetStabel<Parentesinfo>();

	private boolean passer(char aapent, char lukket) {
		switch (aapent) {
		case '(':
			return (lukket == ')');
		case '[':
			return (lukket == ']');
		case '{':
			return (lukket == '}');
		default:
			return false;
		}
	}//

	public void foretaBalansering(String innDataStreng, int linjenr) {

		int lengde = innDataStreng.length();
		
		
		char symbol =' '; 
		int strengIndeks=0;
	  
	 boolean fortsatt=true; 
	  
	 
	 while(strengIndeks < lengde && fortsatt) {
		 
		 symbol=innDataStreng.charAt(strengIndeks);
		
		 if(symbol=='(' || symbol=='[' || symbol=='{') {
			 innDataStreng.charAt(strengIndeks); // viser posisjonen på symbolet 
			 Parentesinfo åpent = new  Parentesinfo(linjenr,strengIndeks,symbol);
			 stabel.push(åpent);
			
		 }else {
		 if(symbol==')'|| symbol==']' || symbol=='}') {
			 innDataStreng.charAt(strengIndeks);
			 Parentesinfo lukket = new Parentesinfo(linjenr,strengIndeks, symbol); 
			 
			 
			 if(stabel.erTom()) {
				 
				 fortsatt=false; 
				 
				 System.out.println("Stabelen er tom"+lukket+"Feilmelding" );
				 
			 }else {
				 char åpentsymbol=stabel.peek().getVenstreparentes();
				
				
				 if(!passer(åpentsymbol,symbol)) {
					 fortsatt= false; 
					 System.out.println("Lukket symbol "+ symbol +" passser ikke med åpent symbol "+åpentsymbol);
					 stabel.pop();
					 
				 }
				 
			 }
		 }
		 
		 }
	 }
		

	}//

	public void lesFraFil(String filnavn) {
		FileReader tekstFilLeser = null;
		try {
			tekstFilLeser = new FileReader(filnavn);
		} catch (FileNotFoundException unntak) {
			System.out.println("Finner ikke filen!");
			System.exit(-1);
		}

		BufferedReader tekstLeser = new BufferedReader(tekstFilLeser);
		String linje = null;
		int linjenr = 0;
		try {
			linje = tekstLeser.readLine();
			while (linje != null) {
		     foretaBalansering(linje,linjenr);
		     linjenr++;
			} 
			if(!stabel.erTom() && linje==null) {
				Parentesinfo C= new Parentesinfo(); 
				System.out.println("stabelen har blitt tømt");
				System.out.println("Ny stabel har blitt lagd ");
			}
		}

		catch (IOException unntak) {
			System.out.println("Feil ved innlesing!");
			System.exit(-1);
		}
		try {
			tekstFilLeser.close();
		} catch (IOException unntak) {
			System.out.println("Feil ved lukking av fil!");
		}

	}// metode

}// class