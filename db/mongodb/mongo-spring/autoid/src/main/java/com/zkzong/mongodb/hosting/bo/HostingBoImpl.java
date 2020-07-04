package com.zkzong.mongodb.hosting.bo;

import com.zkzong.mongodb.hosting.dao.HostingDao;
import com.zkzong.mongodb.hosting.model.Hosting;
import com.zkzong.mongodb.seq.dao.SequenceDao;
import com.zkzong.mongodb.seq.exception.SequenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HostingBoImpl implements HostingBo {

	private static final String HOSTING_SEQ_KEY = "hosting";

	@Autowired
	private SequenceDao sequenceDao;

	@Autowired
	private HostingDao hostingDao;

	@Override
	public void save(String name) throws SequenceException {

		Hosting hosting = new Hosting();

		hosting.setId(sequenceDao.getNextSequenceId(HOSTING_SEQ_KEY));
		hosting.setName(name);
		hostingDao.save(hosting);

		System.out.println(hosting);

	}

}