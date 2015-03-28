package br.com.filmesAssistidos.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class HistoricoFilme {

	@Id 
	@GeneratedValue
	private Long id;
	private Date dataVisualizacao;
	private String local;
	private String companhias;
	private String comentario;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="filme_id")
	private Filme filme;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataVisualizacao() {
		return dataVisualizacao;
	}

	public void setDataVisualizacao(Date dataVisualizacao) {
		this.dataVisualizacao = dataVisualizacao;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getCompanhias() {
		return companhias;
	}

	public void setCompanhias(String companhias) {
		this.companhias = companhias;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}
}
