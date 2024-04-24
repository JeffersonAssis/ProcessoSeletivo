package br.com.dio.view;

import java.util.List;

import br.com.dio.controller.Controller;
import br.com.dio.model.Candidato;

public class Aplicacao {
	
	public static void main(String [] args) {
				
		System.out.println("Lista de possiveis candidatos:");
		Controller.imprimirPossiveisCandidatos();
		List<Candidato> list= Controller.selecaoCandidatos();
		Controller.imprimirSelecaoCandidatos(list);
		System.out.println("_____________Tentando o contato com os Candidatos_____________");
		Controller.EntrandoContato(list);
	
	}
}
