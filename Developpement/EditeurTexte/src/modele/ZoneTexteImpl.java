package modele;

import java.nio.Buffer;

public class ZoneTexteImpl implements ZoneTexte
{
	private Buffer buffer_;
	private String texte_;
	
	public ZoneTexteImpl(Buffer buffer, String texte)
	{
		buffer_ = buffer;
		texte_ = texte;
	}
	
	
	
	
}
