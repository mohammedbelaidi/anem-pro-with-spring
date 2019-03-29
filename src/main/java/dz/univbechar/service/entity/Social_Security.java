package dz.univbechar.service.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;

@Entity
public class Social_Security {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long NSS;
	@Length(max=25)
	private String type_of_entity;
	@Length(max=25)
	private String number_of_entity;
	private Date date_of_this_entity;
	@Length(max=25)
	private String this_entity_delivered_by;
	
	@Length(max=25)
	private String level_instruction;
	@Length(max=25)
	private String level_qualification;
	private boolean handicape;
	
	public Social_Security(@Length(max = 25) String type_of_entity, @Length(max = 25) String number_of_entity,
			@Length(max = 25) String date_of_this_entity, @Length(max = 25) String this_entity_delivered_by,
			@Length(max = 25) String level_instruction, @Length(max = 25) String level_qualification,
			boolean handicape) {
		
		this.type_of_entity = type_of_entity;
		this.number_of_entity = number_of_entity;
		this.date_of_this_entity = Date.valueOf(date_of_this_entity);
		this.this_entity_delivered_by = this_entity_delivered_by;
		this.level_instruction = level_instruction;
		this.level_qualification = level_qualification;
		this.handicape = handicape;
	}
	
	public Social_Security() {
		
	}

	public String getType_of_entity() {
		return type_of_entity;
	}
	public void setType_of_entity(String type_of_entity) {
		this.type_of_entity = type_of_entity;
	}
	public String getNumber_of_entity() {
		return number_of_entity;
	}
	public void setNumber_of_entity(String number_of_entity) {
		this.number_of_entity = number_of_entity;
	}
	public Date getDate_of_this_entity() {
		return date_of_this_entity;
	}
	public void setDate_of_this_entity(Date date_of_this_entity) {
		this.date_of_this_entity = date_of_this_entity;
	}
	public String getThis_entity_delivered_by() {
		return this_entity_delivered_by;
	}
	public void setThis_entity_delivered_by(String this_entity_delivered_by) {
		this.this_entity_delivered_by = this_entity_delivered_by;
	}
	public Long getNSS() {
		return NSS;
	}
	public void setNSS(Long nSS) {
		NSS = nSS;
	}
	public String getLevel_instruction() {
		return level_instruction;
	}
	public void setLevel_instruction(String level_instruction) {
		this.level_instruction = level_instruction;
	}
	public String getLevel_qualification() {
		return level_qualification;
	}
	public void setLevel_qualification(String level_qualification) {
		this.level_qualification = level_qualification;
	}
	public boolean isHandicape() {
		return handicape;
	}
	public void setHandicape(boolean handicape) {
		this.handicape = handicape;
	}
	
}
