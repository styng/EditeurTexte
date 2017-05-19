package modele;


public class ZoneTexteImpl implements ZoneTexte
{
	private String buffer_;
	private String texte_;
	private int begin, end;

	public ZoneTexteImpl(){
		buffer_ = "";
		texte_ = "";
		begin = -1;
		end = -1;
	}

	public void selectionner(int b, int e){
		begin = b;
		end = e;
	}

	public void ecrire(String s){
		setTexte(s);
	}

	public void copier(){
		if(begin < end){
			buffer_ = texte_.substring(begin, end);
			begin = -1;
			end = -1;
		}
		else
			System.out.println("Erreur copie : sélection vide !");
	}

	public void coller(){
		if(begin < end){
			texte_ = this.texte_.replace(texte_.substring(begin, end), this.buffer_);
			buffer_ = "";
			begin = -1;
			end = -1;
			System.out.println(texte_);
		}else
			System.out.println("Erreur collage : sélection vide !");
	}

	public void couper(){
		if(begin < end){
			buffer_ = texte_.substring(begin, end);
			texte_ = texte_.replace(texte_.substring(begin, end), "");
		}
		else
			System.out.println("Erreur couper : sélection vide !");

	}

	public String getTexte() {
		return texte_;
	}

	public void setTexte(String texte_) {
		this.texte_ = texte_;
	}

	public String getBuffer_() {
		return buffer_;
	}

	public void setBuffer_(String buffer_) {
		this.buffer_ = buffer_;
	}
}
