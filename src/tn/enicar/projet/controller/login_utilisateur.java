package tn.enicar.projet.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.enicar.projet.DAO.UtilisateurDAO;
import tn.enicar.projet.model.Utilisateur;

@ManagedBean(name="login_utilisateur")
@SessionScoped
public class login_utilisateur {
	
	private String userName;
	private String userPassWord;
	private UtilisateurDAO utilisateurDao ;
	
	
	public String connecter() {
		utilisateurDao = new UtilisateurDAO();
		Utilisateur user = utilisateurDao.findById(userName);
		if (user != null&&user.getPassword().equals(userPassWord))
			return"success";
		FacesContext.getCurrentInstance().addMessage(
				null,	new FacesMessage("Utilisateur invalide ou mot de passe incorrecte ! "));
		return"fail";
	}

		
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassWord() {
		return userPassWord;
	}
	public void setUserPassWord(String userPassWord) {
		this.userPassWord = userPassWord;
	}	
	
}
