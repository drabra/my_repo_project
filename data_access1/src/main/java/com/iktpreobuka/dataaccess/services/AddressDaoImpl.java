package com.iktpreobuka.dataaccess.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

@Service
public class AddressDaoImpl implements AddressDao {
	
	@PersitenceContex
	EntityManager em;
	
	@Override
	public List<AddressEntity> findAdressByUserName(String name) {
		String sql = "select a " +
	    "from AddressEntity a " +
	    "left join fetch a.users " + 
	    "where u.name = :name";
		
		Query query = em.createQuery(sql);
		query.setParameter("name", name);
		
		List<AddressEntity> result = new ArrayList<>();
		result= query.getResultList();
		return result;
	}

}
