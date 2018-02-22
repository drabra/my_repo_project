package com.iktpreobuka.dataaccessvezba.services;

import java.util.List;

import com.iktpreobuka.dataaccessvezba.entities.AddressEntity;

public interface AddressDao {

	public List<AddressEntity> findAdressesByUserName(String name);

	List<AddressEntity> findAddressByUserName(String name);
}
