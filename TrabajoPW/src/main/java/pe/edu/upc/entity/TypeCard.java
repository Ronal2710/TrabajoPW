package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "typecards")
public class TypeCard implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTypeCard;
	@Column(name = "nameTypeCard", length = 80, nullable = false)
	private String nameTypeCard;

	public TypeCard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TypeCard(int idTypeCard, String nameTypeCard) {
		super();
		this.idTypeCard = idTypeCard;
		this.nameTypeCard = nameTypeCard;
	}

	public int getIdTypeCard() {
		return idTypeCard;
	}

	public void setIdTypeCard(int idTypeCard) {
		this.idTypeCard = idTypeCard;
	}

	public String getNameTypeCard() {
		return nameTypeCard;
	}

	public void setNameTypeCard(String nameTypeCard) {
		this.nameTypeCard = nameTypeCard;
	}

}
