package org.example.mongodb.hosting.dao;

import org.example.mongodb.hosting.model.Hosting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

@Service
public class HostingDaoImpl implements HostingDao {

	@Autowired
	private MongoOperations mongoOperation;

	@Override
	public void save(Hosting hosting) {

		mongoOperation.save(hosting);

	}

}