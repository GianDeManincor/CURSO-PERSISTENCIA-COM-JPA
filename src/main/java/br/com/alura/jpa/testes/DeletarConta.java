package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class DeletarConta {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em3 = emf.createEntityManager();
		Conta deletarConta = em3.find(Conta.class, 4L);
		
		em3.getTransaction().begin();
		em3.remove(deletarConta);
		em3.getTransaction().commit();
		
	}

}
