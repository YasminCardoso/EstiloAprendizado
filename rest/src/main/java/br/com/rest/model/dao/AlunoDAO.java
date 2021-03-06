package br.com.rest.model.dao;

import br.com.rest.model.entity.AlunoEntity;

public class AlunoDAO extends GenericDAO<AlunoEntity>{
	
	private static AlunoDAO instance = null;
	
	private AlunoDAO() {
		super(AlunoEntity.class, PersistenceManager.getEntityManager());
	}
	
	public synchronized static AlunoDAO getInstance() {
		if(instance == null) {
			instance = new AlunoDAO();
		}
		return instance;
	}
	
	public AlunoEntity buscarByMatricula(String matricula) {
		em.clear();
		AlunoEntity aluno = (AlunoEntity) em.createQuery(
					"Select a from AlunoEntity a Where a.matricula LIKE :matricula")
				.setParameter("matricula", matricula)
				.getSingleResult();
		
		return aluno;
				
	}
	
	public AlunoEntity buscarByMatriculaSenha(String matricula, String senha) {
		em.clear();
		AlunoEntity aluno = (AlunoEntity) em.createQuery(
					"SELECT a from AlunoEntity a WHERE a.matricula = :matricula AND a.senha = :senha")
				.setParameter("matricula", matricula)
				.setParameter("senha", senha)
				.getSingleResult();
		
		return aluno;
	}

}
