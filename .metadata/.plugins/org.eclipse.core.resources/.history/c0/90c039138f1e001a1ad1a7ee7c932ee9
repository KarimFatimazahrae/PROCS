package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import antlr.collections.List;
import util.HibernateUtil;

public class test {

	public static void main(String[] args) {

	/*Session session = HibernateUtil.getSessionFactory().getCurrentSession(); 
	session.beginTransaction();
	Contact c1 = new Contact();
	c1.setNom("c1");
	c1.setPrenom("c1");
	c1.setMail("cfcfcfc");
	
	Groupe g1 = new Groupe("amadads");
	Groupe g2 = new Groupe("famille");
	
	/*Groupe g2 = new Groupe("famille");
	session.save(g2);  
	
	

	Groupe g = (Groupe) session.createCriteria(Groupe.class).add(Restrictions.like("nomGroupe", "famille")).uniqueResult();
	System.out.println("grp: " +g.getNomGroupe());
	Contact c1 = new Contact("kkk","lll","lllo");
	g.getContacts().add(c1);
	session.saveOrUpdate(g);
	session.getTransaction().commit();
	
	Telephone t1 = new Telephone();
	t1.setNumTel("2232323");
	t1.setTypeTel("portable");
	
	
	
	HashSet<Telephone> tels = new HashSet<>(); 
	
	t1.setContact(c1);
	tels.add(t1);
	
	c1.setTels(tels);
	
	session.persist(c1);
	
	DAOContact dao = new DAOContact();
	
	String query = "from Telephone as t where t.contact.num = :idContact and t.typeTel = :type";
    Telephone tel =(Telephone) session.createQuery(query)
    		.setParameter("idContact",(long)1)
    		.setParameter("type", "portable")
    		.uniqueResult();
	
	System.out.println(tel.getNumTel());
	session.getTransaction().commit();
	
	
	
	/*Groupe g1 = new Groupe("amadads");
	Groupe g2 = new Groupe("famille");
	
	g1.getContacts().add(c1);	
	g2.getContacts().add(c1);
	
	session.persist(g1);
	session.persist(g2);
	session.getTransaction().commit();
	
	//session.persist(g1);
	//session.persist(g2);

	
	//gr1.getContacts().add(c1);
	//gr1.getContacts().add(c2);
	
	//session.persist(gr1);
	

	//session.beginTransaction();
	
	
	/*Contact c1 = new Contact();
	c1.setNom("c1");
	c1.setPrenom("c1");
	c1.setMail("cfcfcfc");
	
	/*Telephone t1 = new Telephone();
	t1.setNumTel("lkjlk");
	t1.setTypeTel("cdcd");
	t1.setContact(c1);
	
	
	session.persist(c1);
	session.persist(t1);
	
	Adresse ad = new Adresse("23", "bezons", "95870", "france");
	session.persist(ad);
	
	c1.setAdresse(ad);
	session.persist(c1);
	
	
	session.getTransaction().commit();
		
	DAOContact dao = new DAOContact();
	session.getTransaction().begin();
	Groupe g1 = new Groupe("amis");
	session.persist(g1);
	long id = 1 ; 
	Groupe groupe = (Groupe) session.get(Groupe.class, new Long(1));
	System.out.println("groupe 1 : "+ groupe.getNomGroupe());
	Query qry = session.createQuery("update Groupe g set g.nomGroupe=? where g.idGroupe=1");
			         qry.setParameter(0,"updated");
			         int res = qry.executeUpdate();
	
			         session.getTransaction().commit();
	/*
	Session session1 = HibernateUtil.getSessionFactory().getCurrentSession(); 
	groupe.setNomGroupe("gggg");
	Transaction tx1 = session1.beginTransaction();
	session1.update(groupe);
	System.out.println("groupe 2 : "+ groupe.getNomGroupe());
	tx1.commit();
	*/
DAOContact dao = new DAOContact();
dao.afficheMessage();
	
	}

}
