package br.senai.sp.jandira.arraylist;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Arquivo {

	String conteudo = "";
	String caminho;

	public Arquivo(String caminho) {
		this.caminho = caminho;
		String conteudo = "";
		conteudo = ler();
		this.conteudo = conteudo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	public void escrever(String texto) {
		try {

			// OBJETO QUE REPRESENTA O ARQUIVO
			FileWriter arquivo = new FileWriter(this.caminho);

			// OBJETO QUE REPRESENTA A MANIPULAÇÃO (ESCREVER) DOS DADOS DO ARQUIVO
			PrintWriter escreverArq = new PrintWriter(arquivo);

			conteudo += texto +"\n";
			escreverArq.append(conteudo);
			escreverArq.close();

		} catch (IOException e) {

			System.out.println("ERRO: " + e.getMessage());
		}
	}

	public String ler() {

		String conteudoLido = "";
		
		try {

			// Representa o Arquivo em Modo de Leitura
			FileReader arquivo = new FileReader(this.caminho);

			// Representa o Dado de Leitura na Mémoria Principal do Programa
			BufferedReader lerArquivo = new BufferedReader(arquivo);

			String linha;
			linha = lerArquivo.readLine();

			while (linha != null) {

				conteudoLido += linha + "\n";
				linha = lerArquivo.readLine();

			}
			arquivo.close();
			return conteudoLido;

		} catch (IOException e) {

			System.out.println("Erro: " + e);
			return "";

		}

	}

}
