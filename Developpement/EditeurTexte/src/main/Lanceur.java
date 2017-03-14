package main;

import ihm.IHM;
import ihm.IHMGraphique;
import ihm.IHMTextuelle;
import modele.ZoneTexte;
import modele.ZoneTexteImpl;

public class Lanceur 
{
	public static void main(String[] args) 
	{
		/*Faire une factory pour la zone de texte*/
		ZoneTexte zT = new ZoneTexteImpl();
		
		IHM ihm = new IHMTextuelle();
		ihm.demarrer();

	}

}
