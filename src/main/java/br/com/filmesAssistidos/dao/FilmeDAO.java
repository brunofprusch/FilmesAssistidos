package br.com.filmesAssistidos.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import br.com.filmesAssistidos.model.Filme;

public class FilmeDAO extends RootDAO {

	private static FilmeDAO instance;
	
	
	public static FilmeDAO getInstance(){
		if(instance == null){
			instance = new FilmeDAO();
		}
		return instance;
	}
	
	public Long save(Filme filme, Session s){
		return (Long) s.save(filme);
	}
	
	public Filme load(Long id, Session s){
		Filme filme = (Filme) s.load(Filme.class, id);
		Hibernate.initialize(filme);
		return filme;
	}
	
	public void delete(Filme filme, Session s){
		s.delete(filme);
	}
	
	public void update(Filme filme, Session s){
		s.update(filme);
	}
	
	public List<Filme> findAll(Session s){
		List<Filme> filme= s.createCriteria(Filme.class).list();
		return filme;
	}
	
	/*
	public List<Tarefa> findAll(Session s){
		String hql = "from Tarefa t where t.usuario_id = :usuarioId";
		Query query = s.createQuery(hql);
		query.setLong("usuarioId", );
		
		
		return tarefa;
	*/	
}
