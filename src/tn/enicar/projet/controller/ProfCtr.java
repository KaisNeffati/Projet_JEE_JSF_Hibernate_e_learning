package tn.enicar.projet.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.enicar.projet.model.Prof;
import tn.enicar.projet.DAO.ProfDao;

@ManagedBean(name = "ProfCtr")
@SessionScoped
public class ProfCtr {

	private Prof Prof = new Prof();
	private List<Prof> listProf;
	private ProfDao ProfDao;

	public List<Prof> getListProf() {
		return listProf;
	}
	public void setListProf(List<Prof> listProf) {
		this.listProf = listProf;
	}
	public void ajouterProf() {
		ProfDao = new ProfDao();
		ProfDao.persist(Prof);
	}
	@PostConstruct
	public void afficher_list() {
		ProfDao = new ProfDao();
		listProf=ProfDao.findAll();
	}
	public void supprimer(Prof pr) throws Exception {
		ProfDao.Supprimer(pr);
		this.afficher_list();
	}

	public String Edit(Prof pr) {
		this.Prof = pr;
		return "edit";
	}
	public String Modifier() throws Exception {
		ProfDao.Modifier(this.Prof);
		return "exit";
	}
	
	public Prof getProf() {
		return Prof;
	}

	public void setProf(Prof Prof) {
		this.Prof = Prof;
	}

	
}
