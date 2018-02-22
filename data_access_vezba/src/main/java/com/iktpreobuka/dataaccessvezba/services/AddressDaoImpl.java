package com.iktpreobuka.dataaccessvezba.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.iktpreobuka.dataaccessvezba.entities.AddressEntity;

@Service
public class AddressDaoImpl implements AddressDao {
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<AddressEntity> findAdressesByUserName(String name) {
		String sql = "select a " +
				 "from AddressEntity a " +
				"left jpn fetch a.users u " +
				"where u.name = :name ";
		
		Query query = em.createQuery(sql);
		query.setParameter("name", name);
		
		List<AddressEntity> result = new ArrayList<>();
		result = query.getResultList();
		return result;
	}


	public List<AddressEntity> findAddressByUserName(String name) {
		// TODO Auto-generated method stub
		return null;
	}



	
	}

