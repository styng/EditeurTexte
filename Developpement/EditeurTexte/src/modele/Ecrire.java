package modele;

public class Ecrire implements ActionZoneTexte
{
	private ZoneTexteImpl zti_;
	private String contenu;

	public Ecrire(ZoneTexteImpl zti, String c){
		this.zti_ = zti;
		this.contenu = c;
	}

	@Override
	public void execute() 
	{
		System.out.println("Ecrire "+contenu);
		this.zti_.ecrire(this.contenu);
	}
}
