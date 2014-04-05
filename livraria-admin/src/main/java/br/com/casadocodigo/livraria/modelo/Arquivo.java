package br.com.casadocodigo.livraria.modelo;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Arquivo {

	@Id @GeneratedValue
	private Long id;
	
	private String nome;
	@Lob
	private byte[] conteudo;
	private String contentType;
	private Calendar dataModificacao;

	public Arquivo(String nome, byte[] conteudo, String contentType,
			Calendar dataModificacao) {
		this.nome = nome;
		this.conteudo = conteudo;
		this.contentType = contentType;
		this.dataModificacao = dataModificacao;
	}
	Arquivo() {}

	public String getNome() {
		return nome;
	}

	public byte[] getConteudo() {
		return conteudo;
	}

	public String getContentType() {
		return contentType;
	}

	public Calendar getDataModificacao() {
		return dataModificacao;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
