package com.douane.metier.referentiel;

import java.util.List;

import com.douane.entite.Nomenclature;
import com.douane.entite.Referentiel;

public interface IRefMetier {
	public Referentiel addRef(Referentiel r);
	public void removeRef(Referentiel r);	
	public List<Referentiel> listRef(Referentiel r);
	public void saveRefs(List<Referentiel> listrefs);
}
