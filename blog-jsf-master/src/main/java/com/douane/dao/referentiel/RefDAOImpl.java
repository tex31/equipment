package com.douane.dao.referentiel;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.data.repository.CrudRepository;

import com.airial.domain.Post;
import com.douane.entite.ModeAcquisition;
import com.douane.entite.Nomenclature;
import com.douane.entite.Referentiel;
import com.google.common.collect.Lists;

public class RefDAOImpl  implements IRefDAO{

	@PersistenceContext
	private EntityManager em;
	
	
	public RefDAOImpl() {
		// TODO Auto-generated constructor stub
	}


	/*@Override
	public Referentiel addRef(Referentiel r) {
		// TODO Auto-generated method stub
		em.persist(r);
		return r;
	}
*/

	@Override
	public List<Referentiel> listRef(Referentiel r) {
		// TODO Auto-generated method stub
		Query req= em.createQuery("select n from "+r.getClass().getName()+" n");
		return (List<Referentiel>)req.getResultList();
	}
/*

	@Override
	public void delRef(Referentiel ref) {
		// TODO Auto-generated method stub
		//Query req= em.createQuery("delete");
		em.remove(ref);
		
	}
*/
	/*@Override
	public Referentiel addRef(E r) {
		// TODO Auto-generated method stub
		em.persist(r);
		return r;
	}

	@Override
	public List<Referentiel> listRef(String nomTable) {
		// TODO Auto-generated method stub
		Query req= em.createQuery("select * from ModeAcquisition");
		return req.getResultList();
	}

	@Override
	public void delRef(Referentiel ref) {
		// TODO Auto-generated meethod stub
		em.remove(ref);
		
	}*/

}
