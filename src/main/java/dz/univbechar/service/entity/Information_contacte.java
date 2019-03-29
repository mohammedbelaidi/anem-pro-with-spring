package dz.univbechar.service.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;




@Entity
public class Information_contacte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcontacte;

	private int mobile;
	private int fax;
	
	@OneToOne(cascade={    
            CascadeType.PERSIST,
            CascadeType.REFRESH
})
    @JoinColumn(name = "address_id")
	private Addresse adresse;
	
	
	public Information_contacte() {
		super();
	}

	public Information_contacte( int mobile, int fax, Addresse adresse) {
	
		
		this.mobile = mobile;
		this.fax = fax;
		this.adresse = adresse;
	}

	public int getIdcontacte() {
		return idcontacte;
	}

	public void setIdcontacte(int idcontacte) {
		this.idcontacte = idcontacte;
	}


	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public int getFax() {
		return fax;
	}

	public void setFax(int fax) {
		this.fax = fax;
	}

	public Addresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Addresse adresse) {
		this.adresse = adresse;
	}

}
