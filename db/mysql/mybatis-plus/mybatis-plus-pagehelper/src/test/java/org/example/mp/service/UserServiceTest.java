package org.example.mp.service;

import com.github.pagehelper.PageInfo;
import org.example.mp.entity.User;
import org.example.mp.vo.UserVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void query() {
        PageInfo<User> userPageInfo = userService.query(null);
        System.out.println(userPageInfo);

        // 结果转vo
        PageInfo<UserVo> userVoPageInfo = new PageInfo<>();
        BeanUtils.copyProperties(userPageInfo, userVoPageInfo, "list");

        List<UserVo> userVoList = new ArrayList<>();

        List<User> userList = userPageInfo.getList();
        for (User user : userList) {
            UserVo userVo = new UserVo();
            BeanUtils.copyProperties(user, userVo);
            if ("F".equals(userVo.getSex())) {
                userVo.setSexzh("女");
            }
            if ("M".equals(userVo.getSex())) {
                userVo.setSexzh("男");
            }
            userVoList.add(userVo);
        }
        userVoPageInfo.setList(userVoList);
        System.out.println(userVoPageInfo);
    }

    @Test
    public void saveOrUpdate() {
        User user = new User();
        user.setId(4L);
        user.setUserName("test");
        user.setAge(11);
        user.setAddress("bj");
        userService.saveOrUpdate(user);
    }
}