package com.douane.metier.referentiel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.airial.repository.RefRepository;
import com.airial.repository.UserRepository;
import com.douane.dao.referentiel.IRefDAO;
import com.douane.entite.Nomenclature;
import com.douane.entite.Referentiel;

@Transactional
public class RefMetierImpl implements IRefMetier{

	private IRefDAO refdao;
	
	@Autowired
	private RefRepository refrepos;

	public IRefDAO getRefdao() {
		return refdao;
	}

	public void setRefdao(IRefDAO dao) {
		this.refdao = dao;
	}
	public RefMetierImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Referentiel addRef(Referentiel r) {
		// TODO Auto-generated method stub
		return refrepos.save(r);
	}

	@Override
	public void removeRef(Referentiel r) {
		// TODO Auto-generated method stub
		//dao.delRef((Nomenclature)r);
		refrepos.delete(r);
	}

	@Override
	public List<Referentiel> listRef(Referentiel r) {
		// TODO Auto-generated method stub
		return refdao.listRef(r);
	}

	@Override
	public void saveRefs(List<Referentiel> listrefs) {
		// TODO Auto-generated method stub
		refrepos.save(listrefs);
	}

}
