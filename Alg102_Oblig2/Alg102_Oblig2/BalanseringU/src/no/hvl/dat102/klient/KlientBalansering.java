package no.hvl.dat102.klient;

import java.util.Scanner;

import no.hvl.dat102.Balansering;

public class KlientBalansering{

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			  Scanner sc= new Scanner(System.in);
			  
			  String les=sc.next();
			  
			  Balansering lesing= new Balansering();
			  
			  lesing.lesFraFil(les);
			  

		}

}//class
