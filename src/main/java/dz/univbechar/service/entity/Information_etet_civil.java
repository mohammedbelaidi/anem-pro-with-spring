package dz.univbechar.service.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="information_etat_civil")
public class Information_etet_civil {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer number_of_birth_certificate;
	
	@Column(length=25)
	private String first_name;
	
	@Column( length=25)
	private String last_name;
	
	private Date date_of_birth_certificate;
	
	@Column(length=25)
	private String  family_situation;

	public Information_etet_civil() {		
	}

	public Information_etet_civil(String first_name, String last_name, String date_of_birth_certificate,
			String family_situation) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.date_of_birth_certificate = Date.valueOf(date_of_birth_certificate);
		this.family_situation = family_situation;
	}

	public Integer getNumber_of_birth_certificate() {
		return number_of_birth_certificate;
	}

	public void setNumber_of_birth_certificate(Integer number_of_birth_certificate) {
		this.number_of_birth_certificate = number_of_birth_certificate;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Date getDate_of_birth_certificate() {
		return date_of_birth_certificate;
	}

	public void setDate_of_birth_certificate(Date date_of_birth_certificate) {
		this.date_of_birth_certificate = date_of_birth_certificate;
	}

	public String getFamily_situation() {
		return family_situation;
	}

	public void setFamily_situation(String family_situation) {
		this.family_situation = family_situation;
	}
	

}
