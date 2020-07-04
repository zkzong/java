package com.zkzong.mongodb.seq.dao;

import com.zkzong.mongodb.seq.exception.SequenceException;

public interface SequenceDao {

	long getNextSequenceId(String key) throws SequenceException;

}