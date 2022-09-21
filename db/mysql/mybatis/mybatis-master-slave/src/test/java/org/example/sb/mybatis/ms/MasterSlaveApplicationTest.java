package org.example.sb.mybatis.ms;

import org.example.sb.mybatis.ms.entity.Member;
import org.example.sb.mybatis.ms.service.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MasterSlaveApplicationTest {

    @Autowired
    private MemberService memberService;

    @Test
    public void testWrite() {
        Member member = new Member();
        member.setUserName("zhangsan");
        memberService.insert(member);
    }

    @Test
    public void testRead() {
        for (int i = 0; i < 4; i++) {
            memberService.selectAll();
        }
    }

    @Test
    public void testSave() {
        Member member = new Member();
        member.setUserName("wangwu");
        memberService.save(member);
    }

    @Test
    public void testReadFromMaster() {
        memberService.getToken("1234");
    }

}