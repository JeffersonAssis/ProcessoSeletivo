package br.com.dio.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import br.com.dio.model.Candidato;

public class Controller {
	static final double SALARIO = 2000.0;
	

	public static String[] possiveisCandidatos() {
		 String [] candidatos = {"Ana", "Maria","João","Jose","Severina","Carla","Julia","Silva","Francisco","Joaquim","Paula","Agusto"};
		 return candidatos;
	}
	
	public static void imprimirPossiveisCandidatos() {
		String [] possiveis = possiveisCandidatos();
		int i = 1;
		for(String x : possiveis) {
			System.out.print(i +"º "+x+" *** ");
			if(i == 6) {
				System.out.println("");
			}
			i++;
		}
		System.out.println("");
	}

	public static double salariosPretendidos() {
		
		double salario = ThreadLocalRandom.current().nextDouble(1800.0, 2200.0);
		return salario;
	}
	
	public static List<Candidato> selecaoCandidatos() {
		List<Candidato> listSelecao = new ArrayList<>();
		double salariopretendido= 0.0;
		String [] nome = possiveisCandidatos();
		int cont  = 0;
		
		while(listSelecao.size() < 5) {
			if(cont == nome.length) {
				cont = 0;
			}
			Candidato c = new Candidato();
			salariopretendido = formattarSalario();
			c.setNome(nome[cont]);
			c.setSalarioPretendido(salariopretendido);
			if(salariopretendido<SALARIO) {
				System.out.println("Ligar para o candidato:");
				System.out.println("Nome: " +c.getNome()+" Salario pretendido:" +c.getSalarioPretendido());
				if(!listSelecao.contains(c)) {
					listSelecao.add(c);
				}else{
					System.out.println("**************Candidato ja selecionado: "+ c.getNome()+"****************");
				}
				
			}else if(c.getSalarioPretendido() == SALARIO) {
				System.out.println("Ligar para o candidato para realizar uma contra proposta!");
			}else{
				System.out.println("Salario pretendido foi maior quer o informado: "+c.getNome()+" - R$: "+c.getSalarioPretendido());
			}
			cont++;
			
		}
		return listSelecao;
	}
	
	
	public static void imprimirSelecaoCandidatos(List<Candidato> l) {
		System.out.println("================Lista de candidatos selecionados===================");
		for(Candidato c : l) {
			System.out.println("Nome: "+c.getNome()+"  - Salario pretendido: "+c.getSalarioPretendido());
		}
	}
	
	public static double formattarSalario() {
	   double salario = salariosPretendidos(); 
	   String salarioFormatado = String.format("%.2f", salario);
	   salarioFormatado = salarioFormatado.replace(',', '.');
	   
	   return Double.parseDouble(salarioFormatado);
	}
	
	public static void EntrandoContato(List<Candidato> l) {
		for(Candidato c : l) {
			int tentativaRealizada = 1;
			boolean continuarTentando = true;
			boolean atendeu = false;
		do {
			atendeu = atender();
			continuarTentando = !atendeu;
			if(continuarTentando) { 
				tentativaRealizada++;
			}else { 
				System.out.println("O candidato atendeu");
			}
		}while(continuarTentando && tentativaRealizada < 3);
		if(atendeu)
			System.out.println("Contato Realizado com o candidato: "+c.getNome()+" atendeu na tentativa: "+ tentativaRealizada);
		else 
			System.out.println("Não conseguimos contato com "+c.getNome()+" numero maximo de tentativas "+ tentativaRealizada);
		}
	}
	
	
	public static boolean atender() {
		return new Random().nextInt(3) == 1;
	}
}
