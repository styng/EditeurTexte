package modele;

public class Coller implements ActionZoneTexte 
{
	private ZoneTexteImpl zti_;

	public Coller(ZoneTexteImpl zti){
		this.zti_ = zti;
	}

	@Override
	public void execute() 
	{
		System.out.println("Coller");
		this.zti_.coller();
	}
}
