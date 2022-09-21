package org.example.mongodb.seq.dao;

import org.example.mongodb.seq.exception.SequenceException;

public interface SequenceDao {

	long getNextSequenceId(String key) throws SequenceException;

}