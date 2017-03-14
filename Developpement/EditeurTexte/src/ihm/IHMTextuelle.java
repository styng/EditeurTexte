package ihm;

import modele.ZoneTexte;

public class IHMTextuelle implements IHM
{
	private ZoneTexte zDT_;
	
	public IHMTextuelle(ZoneTexte zDT) 
	{
		zDT_ = zDT;
	}
	
	@Override
	public void demarrer() 
	{
		System.out.println(toString());;
		
	}

	@Override
	public String toString() 
	{
		return "Contenu : \""+zDT_.toString()+"\"";
	}
}
