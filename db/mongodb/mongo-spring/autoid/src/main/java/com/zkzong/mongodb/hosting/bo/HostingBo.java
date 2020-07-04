package com.zkzong.mongodb.hosting.bo;

import com.zkzong.mongodb.seq.exception.SequenceException;

public interface HostingBo {

	void save(String name) throws SequenceException;

}