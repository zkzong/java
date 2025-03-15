package com.example.mongodb.hosting.bo;

import com.example.mongodb.seq.exception.SequenceException;

public interface HostingBo {

    void save(String name) throws SequenceException;

}