package br.com.filmesAssistidos.util;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import br.com.filmesAssistidos.model.Filme;
import br.com.filmesAssistidos.model.HistoricoFilme;


public class CreateTables {
	public static void main (String[] args){
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(HistoricoFilme.class);
		cfg.addAnnotatedClass(Filme.class);
		
		
		SchemaExport se = new SchemaExport(cfg);
		se.create(true, true);
	}
}
