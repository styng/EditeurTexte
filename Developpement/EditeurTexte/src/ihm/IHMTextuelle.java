package ihm;

import modele.ZoneDeTravail;

public class IHMTextuelle implements IHM
{
	private ZoneDeTravail zDT_;
	
	public IHMTextuelle(ZoneDeTravail zDT) 
	{
		zDT_ = zDT;
	}
	
	@Override
	public void demarrer() 
	{
		
		
	}

	@Override
	public String toString() 
	{
		return "";
	}
}
