package br.senai.sp.jandira;

import java.util.ArrayList;

import br.senai.sp.jandira.model.Arquivo;
import br.senai.sp.jandira.model.Contato;
import br.senai.sp.jandira.repository.ContatoRepository;

public class App {

	public static void main(String[] args) {

		ContatoRepository objContatoRepository = new ContatoRepository();
		Arquivo objArquivo = new Arquivo();

		String caminho = "C:\\Users\\21276092\\Desktop\\CONTATO\\contatos.txt";

		// Objetos de Contato para Teste:
		Contato contato1 = new Contato("Ana", "ana@gmail.com", "1111-2222", "Jandira");
		Contato contato2 = new Contato("Maria", "maria@gmail.com", "3333-4444", "Carapicuíba");
		Contato contato3 = new Contato("João", "joao@gmail.com", "5555-6666", "Osasco");
		Contato contato4 = new Contato("Carlos", "carlos@gmail.com", "7777-8888", "São Roque");

		// Teste de Cadastro de Contatos:
		objContatoRepository.cadastrarContato(contato1);
		objContatoRepository.cadastrarContato(contato2);
		objContatoRepository.cadastrarContato(contato3);
		objContatoRepository.cadastrarContato(contato4);

		System.out.println("Total de Objetos Cadastrados: " + objContatoRepository.contarContatos());

		// Percorre o ArrayList de Contatos e Grava os Dados no Arquivo TXT:

		// 1° Exemplo
		/*
		 * ArrayList<Contato> listagem = objContatoRepository.listarContatos(); for
		 * (Contato contato : listagem ) { System.out.println("Nome: "
		 * +contato.getNome() +" E-mail: " +contato.getEmail() +" Telefone "
		 * +contato.getTelefone() +" Cidade: " +contato.getCidade()); }
		 */

		// 2° Exemplo
		String texto = "";
		for (Contato contato : objContatoRepository.listarContatos()) {
			/*
			 * System.out.println("Nome: " +contato.getNome() +" E-mail: "
			 * +contato.getEmail() +" Telefone " +contato.getTelefone() +" Cidade: "
			 * +contato.getCidade());
			 */

			texto += contato.getNome() + ";" 
					+ contato.getEmail() + ";" 
					+ contato.getTelefone() + ";"
					+ contato.getCidade() + "\n";

		}
		
		System.out.println(texto);
		objArquivo.escrever(caminho, texto);

	}

}
