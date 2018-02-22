package com.iktpreobuka.dataaccess.services;

import java.util.List;

public interface AddressDao {
	
	public List<AddressEntity> findAdressesByUserName(String name); 
	

}
