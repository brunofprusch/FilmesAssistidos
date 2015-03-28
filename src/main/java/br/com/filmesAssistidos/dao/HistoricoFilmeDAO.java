package br.com.filmesAssistidos.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import br.com.filmesAssistidos.model.Filme;
import br.com.filmesAssistidos.model.HistoricoFilme;

public class HistoricoFilmeDAO extends RootDAO {

	private static HistoricoFilmeDAO instance;
	
	public static HistoricoFilmeDAO getInstance(){
		if(instance == null){
			instance = new HistoricoFilmeDAO();
		}
		return instance;
	}
	
	public Long save(HistoricoFilme historicoFilme, Session s){
		return (Long) s.save(historicoFilme);
	}
	
	public HistoricoFilme load(Long id, Session s){
		HistoricoFilme historicoFilme = (HistoricoFilme) s.load(HistoricoFilme.class, id);
		Hibernate.initialize(historicoFilme);
		return historicoFilme;
	}
	
	public void delete(HistoricoFilme historicoFilme, Session s){
		s.delete(historicoFilme);
	}
	
	public void update(HistoricoFilme historicoFilme, Session s){
		s.update(historicoFilme);
	}
	
	public List<HistoricoFilme> findAll(Session s){
		List<HistoricoFilme> historicoFilme= s.createCriteria(HistoricoFilme.class).list();
		return historicoFilme;
	}
	
	
	/*
	public List<Tarefa> findAll(Session s){
		String hql = "from Tarefa t where t.usuario_id = :usuarioId";
		Query query = s.createQuery(hql);
		query.setLong("usuarioId", );
		
		
		return tarefa;
	*/
	
}
