package org.example.mysql.service;

import org.example.mysql.entity.Member;

import java.util.List;

public interface MemberService {

    int insert(Member member);

    int save(Member member);

    List<Member> selectAll();

    String getToken(String appId);

}
