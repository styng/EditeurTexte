package modele;

public class Couper implements ActionZoneTexte 
{
	private ZoneTexteImpl zti_;

	public Couper(ZoneTexteImpl zti){
		this.zti_ = zti;
	}

	@Override
	public void execute() 
	{
		System.out.println("Couper");
		this.zti_.couper();
	}
}
