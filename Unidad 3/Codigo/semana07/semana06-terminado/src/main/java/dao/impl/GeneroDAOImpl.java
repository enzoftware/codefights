package dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import dao.IGeneroDAO;
import entities.Genero;

public class GeneroDAOImpl implements IGeneroDAO {

	EntityManagerFactory emf;
	EntityManager em;
	
	public GeneroDAOImpl() {
		emf = Persistence.createEntityManagerFactory("jpaDB");
		em = emf.createEntityManager();
	}
	
	@Override
	public List<Genero> listar() {
		List<Genero> listado = new ArrayList<Genero>();
		
		try {
			TypedQuery<Genero> tq = 
							em.createQuery("select a from Genero a", Genero.class);
			listado = tq.getResultList();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}			
		
		return listado;
	}

	@Override
	public boolean agregar(Genero obj) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			em.getTransaction().begin();
			em.persist(obj);
			em.getTransaction().commit();
			flag = true;
		} catch (Exception e) {
			if(em.getTransaction().isActive()){
				em.getTransaction().rollback();
			}
			System.out.println(e.getMessage());
		}		
		
		return flag;
	}

	@Override
	public boolean eliminar(int id) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			Genero obj = em.find(Genero.class, id);
			
			em.getTransaction().begin();
			em.remove(obj);
			em.getTransaction().commit();
			
			flag = true;
		} catch (Exception e) {
			if(em.getTransaction().isActive()){
				em.getTransaction().rollback();
			}
			System.out.println(e.getMessage());
		}
		
		return flag;
	}

}
