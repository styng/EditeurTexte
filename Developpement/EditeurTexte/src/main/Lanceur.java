package main;

import ihm.IHM;
import ihm.IHMGraphique;
import ihm.IHMTextuelle;
import modele.ZoneTexte;
import modele.ZoneTexteImpl;

import java.util.Scanner;

public class Lanceur 
{
	public static void main(String[] args) 
	{
		/*Faire une factory pour la zone de texte*/
		ZoneTexteImpl zT = new ZoneTexteImpl();
		
		//IHM ihm = new IHMTextuelle(zT);
		IHM ihm = new IHMGraphique(zT);
		ihm.demarrer();

	}

}
