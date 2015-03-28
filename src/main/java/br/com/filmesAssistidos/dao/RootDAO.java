package br.com.filmesAssistidos.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.filmesAssistidos.model.Filme;
import br.com.filmesAssistidos.model.HistoricoFilme;

public class RootDAO {

	public static Session createSession(){
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(Filme.class);
		cfg.addAnnotatedClass(HistoricoFilme.class);
		
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		return session;
	}
	
	public static void closeSession(Session s){
		s.clear();
	}
	
	public static String teste(){
		return null;
	}	
}

