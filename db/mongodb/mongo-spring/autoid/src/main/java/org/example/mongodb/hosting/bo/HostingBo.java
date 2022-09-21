package org.example.mongodb.hosting.bo;

import org.example.mongodb.seq.exception.SequenceException;

public interface HostingBo {

	void save(String name) throws SequenceException;

}