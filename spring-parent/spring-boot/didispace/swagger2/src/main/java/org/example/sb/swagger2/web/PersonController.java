package org.example.sb.swagger2.web;

import org.example.sb.swagger2.domain.Person;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zong on 2017/4/26.
 */
@RestController
@RequestMapping(value = "/person")
public class PersonController {
    static Map<Long, Person> persons = Collections.synchronizedMap(new HashMap<Long, Person>());

//    @ApiOperation(value = "获取用户列表", notes = "")
//    @RequestMapping(value = {""}, method = RequestMethod.GET)
//    public List<User> getUserList() {
//        List<User> r = new ArrayList<User>(users.values());
//        return r;
//    }

    @ApiOperation(value = "创建用户", notes = "根据Person对象创建用户")
    @ApiImplicitParam(name = "person", value = "用户详细实体Person", required = true, dataType = "Person")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String postUser(@RequestBody Person person) {
        persons.put(person.getId(), person);
        return "success";
    }

//    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
//    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public User getUser(@PathVariable Long id) {
//        return users.get(id);
//    }

//    @ApiOperation(value = "更新用户详细信息", notes = "根据url的id来制定更新对象，并根据传过来的user信息来更新用户详细信息")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
//            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
//    })
//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//    public String putUser(@PathVariable Long id, @RequestBody User user) {
//        User u = users.get(id);
//        u.setName(user.getName());
//        u.setAge(user.getAge());
//        users.put(id, u);
//        return "success";
//    }

//    @ApiOperation(value = "删除用户", notes = "根据url的id来指定删除对象")
//    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    public String deleteUser(@PathVariable Long id) {
//        users.remove(id);
//        return "success";
//    }

}
