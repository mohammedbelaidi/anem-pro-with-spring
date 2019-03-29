package dz.univbechar.service.controuller;

import java.sql.Date;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import dz.univbechar.service.entity.Addresse;
import dz.univbechar.service.entity.Information_contacte;
import dz.univbechar.service.entity.Information_etet_civil;
import dz.univbechar.service.entity.Social_Security;
import dz.univbechar.service.repository.Info_Contact;
import dz.univbechar.service.repository.Info_etat_civil;
import dz.univbechar.service.repository.Social_repository;

@RestController

public class InformationController {
	@Autowired
	Info_Contact contect;
	@Autowired
	Info_etat_civil civil;
	@Autowired
	Social_repository social;
	
	EntityManager em;

	
	
	@RequestMapping("/add_etat_civil")
	@Transactional
	public @ResponseBody Object addetatcivil(@RequestParam("first_name") String first_name,
			@RequestParam("last_name") String last_name,
			@RequestParam("certificate") @DateTimeFormat(style="yyyy-MM-dd") String certificate,
			@RequestParam("family_situation") String family_situation) {

		Date date = Date.valueOf(certificate);
		Information_etet_civil civ = new Information_etet_civil(first_name, last_name, certificate, family_situation);
		
		civil.save(civ);
		//em.refresh(civ);
		return civ;
	}
	@RequestMapping("/List_etet_civil")
	public @ResponseBody Iterable<Information_etet_civil> viewListEtatCivil(){
		return civil.findAll();
	}
	@RequestMapping("/civilById/{id}")
	public @ResponseBody Object findByIdEtatCivil(int id) {
		return civil.findById(id);
	}
	
	@RequestMapping("delete_civil")
	public @ResponseBody String deletecivil(@RequestParam(name = "id") int id) {
		civil.deleteById(id);
		return "<h1>Deleted</h1>";
	}
	
	@RequestMapping("/add_contact")
	@Transactional
	public @ResponseBody Object addetatcivil(@RequestParam("mobile") int mobile, @RequestParam("fax") int fax,
			@RequestParam("willaye") String willaye, @RequestParam("rue") String rue,
			@RequestParam("code_postal") String code_postal, @RequestParam("town") String town) {
		
		Addresse addr = new Addresse(willaye, rue, code_postal, town);
		Information_contacte civ = new Information_contacte(mobile, fax, addr);
		
		contect.save(civ);
		//em.refresh(civ);
		//em.merge(civ);
		return civ;
	}

	@RequestMapping("/List_contact")
	public @ResponseBody Iterable<Information_contacte> viewListContact() {
		return contect.findAll();
	}

	@RequestMapping("/search_list_contact")
	public @ResponseBody Object searchById(int id) {
		return contect.findById(id);
	}

	@RequestMapping("delete_contact")
	public @ResponseBody String deleteContact(@RequestParam(name = "id") int id) {
		contect.deleteById(id);
		return "<h1>Deleted</h1>";
	}

	@RequestMapping("/add_Social_Security")
	public @ResponseBody Object addsucrit(
			@RequestParam("type_of_entity") String type_of_entity,
			@RequestParam("number_of_entity") String number_of_entity,
			@RequestParam("date_of_this_entity") String date_of_this_entity,
			@RequestParam("this_entity_delivered_by") String this_entity_delivered_by,
			@RequestParam("level_instruction") String level_instruction,
			@RequestParam("level_qualification") String level_qualification,
			@RequestParam("handicape") String handicape) {

		boolean handicap;
		if(handicape.equals("true"))
			handicap = true;
		else handicap = false;
		Social_Security civ = new Social_Security(type_of_entity, number_of_entity,date_of_this_entity, this_entity_delivered_by,
				level_instruction, level_qualification, handicap);
		social.save(civ);
		return civ;
	}

	@RequestMapping("/List_Social_Security")
	public @ResponseBody Iterable<Social_Security> viewAllListInSocialSecurity() {
		return social.findAll();
	}

	@RequestMapping("/serch_List_Social_Security")
	public @ResponseBody Object viewOneListInSocialSecurity(@RequestParam("NSS") Long NSS) {
		Long l = Long.valueOf("" + NSS);
		return social.findById(NSS);
	}

	@RequestMapping("/delete_one_List_Social_Security")
	public @ResponseBody Object deleteOneListInSocialSecurity(@RequestParam("id") Long id) {
		Long l = Long.valueOf("" + id);
		social.deleteById(id);
		return "<h1>deleted</h1>";
	}

	/*
	 * @RequestMapping("/update_Social_Security") public @ResponseBody Object
	 * updateSucrit(@RequestParam("type_of_entity") String type_of_entity,
	 * 
	 * @RequestParam("number_of_entity") String number_of_entity,
	 * 
	 * @RequestParam("date_of_this_entity") @DateTimeFormat(pattern =
	 * "yyyy-MM-dd'T'HH:mm") Date date_of_this_entity,
	 * 
	 * @RequestParam("this_entity_delivered_by") String this_entity_delivered_by,
	 * 
	 * @RequestParam("level_instruction") String level_instruction,
	 * 
	 * @RequestParam("level_qualification") String level_qualification,
	 * 
	 * @RequestParam("handicape") String handicape) {
	 * 
	 * Social_Security civ = new Social_Security(type_of_entity, number_of_entity,
	 * this_entity_delivered_by, level_instruction, level_qualification, handicape,
	 * false);
	 * 
	 * return civ;
	 * 
	 * }
	 */

}
