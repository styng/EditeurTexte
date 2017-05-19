package modele;

public class Copier implements ActionZoneTexte
{
	private ZoneTexteImpl zti_;

	public Copier(ZoneTexteImpl zti){
		this.zti_ = zti;
	}

	@Override
	public void execute() 
	{
		System.out.println("Copier");
		this.zti_.copier();
	}
}
