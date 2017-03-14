package modele;

import java.nio.Buffer;

public class ZoneDeTravailImpl implements ZoneDeTravail
{

	private Buffer buffer_;
	private String texte_;
	
	public ZoneDeTravailImpl(Buffer buffer, String texte)
	{
		buffer_ = buffer;
		texte_ = texte;
	}
	
	
	
	
}
