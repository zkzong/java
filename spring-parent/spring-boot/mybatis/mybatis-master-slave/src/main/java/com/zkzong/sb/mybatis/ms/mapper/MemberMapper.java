package com.zkzong.sb.mybatis.ms.mapper;

import com.zkzong.sb.mybatis.ms.entity.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    int insert(Member member);

    List<Member> selectAll();

}
