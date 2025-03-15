package com.example.mongodb.seq.dao;

import com.example.mongodb.seq.exception.SequenceException;

public interface SequenceDao {

    long getNextSequenceId(String key) throws SequenceException;

}