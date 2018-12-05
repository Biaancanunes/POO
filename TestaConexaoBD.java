package taqvim;

import java.util.ArrayList;
import taqvim.DAOPessoa;
import taqvim.Disciplina;

public class TestaConexaoBD {

	public static void main(String[] args) {
            
                ConexaoBD x = new ConexaoBD();
		DAOPessoa conexao = new DAOPessoa();
		
		System.out.println("Criando Disciplina...");
		conexao.criarDisciplina(new Disciplina("1234456","Maria Joaquina"));
                System.out.println("Criando atividade...");

		conexao.criarATV(new Atividade("1124","Fabricio","feita","bla",123));
		System.out.println("-------------------------------------");
		
		
		}
	
	
}

