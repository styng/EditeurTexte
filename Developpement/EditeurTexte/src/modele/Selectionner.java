package modele;

public class Selectionner implements ActionZoneTexte 
{
	private ZoneTexteImpl zti_;
	private int begin, end;

	public Selectionner(ZoneTexteImpl zti, int b, int e){
		this.zti_ = zti;
		begin = b;
		end = e;
	}

	@Override
	public void execute()
	{
		System.out.println("Selectionner");
		this.zti_.selectionner(begin, end);
	}
}
