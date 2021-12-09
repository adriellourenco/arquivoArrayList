package br.senai.sp.jandira.repository;

import java.util.ArrayList;

import br.senai.sp.jandira.model.Contato;

public class ContatoRepository {
	
	//Atributos
	ArrayList<Contato> contatos = new ArrayList<Contato>();
	Contato contato = new Contato();
	
	//Métodos
	public void cadastrarContato(Contato contato){
		contatos.add(contato);
	} 
	
	public ArrayList<Contato> listarContatos(){
		return contatos;
	}
	
	public int contarContatos() {
		return contatos.size();
	}
	
}
