package ihm;

import modele.*;
import java.util.Scanner;

public class IHMTextuelle implements IHM
{
	private ZoneTexteImpl zT_;
	
	public IHMTextuelle(ZoneTexteImpl zT)
	{
		zT_ = zT;
	}
	
	@Override
	public void demarrer() 
	{
		boolean finir = false;
		Scanner sc = new Scanner(System.in);

		System.out.print("Initialiser le texte : ");
		String tmp = sc.nextLine();
		zT_.setTexte(tmp);

		while(!finir){
			System.out.println(this.toString()+"\n");
			afficherMenu();
			int choix = sc.nextInt();
			switch(choix){
				case 0:
					System.out.println("Fin de traitement");
					finir = true;
					break;
				case 1:
					selectionner();
					break;
				case 2:
					copier();
					break;
				case 3:
					couper();
					break;
				case 4:
					coller();
					break;
				case 5:
					System.out.println("buffer : "+zT_.getBuffer_());
					break;
				default :
					System.out.println("Mauvais choix");
					break;
			}
		}
	}

	@Override
	public String toString() 
	{
		return "\n--------\nContenu : \""+zT_.getTexte()+"\"\n--------";
	}

	private void afficherMenu(){
		System.out.print(
				"MENU EDITEUR TEXTE \n"+
						"0/ Quitter\n"+
						"1/ Sélectionner\n"+
						"2/ Copier\n"+
						"3/ Couper\n"+
						"4/ Coller\n"+
						"Faites votre choix : "
		);
	}

	private void selectionner() {
		int lim = zT_.getTexte().length();

		System.out.println("Donnez l'indice de début et de fin de la sélection (entre 0 et "+lim+")");
		Scanner sc = new Scanner(System.in);
		int debut = sc.nextInt();
		int fin = sc.nextInt();

		if((fin <= lim) && (debut <= fin)){
			ActionZoneTexte command = new Selectionner(zT_, debut, fin);
			command.execute();
		}
	}

	private void copier() {
		ActionZoneTexte command = new Copier(zT_);
		command.execute();
	}

	private void coller() {
		ActionZoneTexte command = new Coller(zT_);
		command.execute();
	}

	private void couper() {
		ActionZoneTexte command = new Couper(zT_);
		command.execute();
	}
}
