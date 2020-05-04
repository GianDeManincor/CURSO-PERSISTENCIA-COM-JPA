package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaContaComSaldo {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		// Estado Managed - Estado que possui sincronização com o banco de dados
		Conta conta = new Conta();
		conta.setAgencia(12345);
		conta.setNumero(54321);
		conta.setTitular("Joao");
		conta.setSaldo(800.0);
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		em.close();
		
		// Estado Detached - Estado que não possui mais sincronização com o banco de dados e para se tornar Managed novamente, 
		// deve-se criar uma nova instancia com EntityManager e dar um merge na alteração.
		EntityManager em2 = emf.createEntityManager();
		conta.setSaldo(400.0);
		em2.getTransaction().begin();
		em2.merge(conta);
		em2.getTransaction().commit();
		
	}

}
