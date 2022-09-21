package org.example.jdoc.controller;

import org.example.jdoc.form.UserListForm;
import org.example.jdoc.result.ApiResult;
import org.example.jdoc.result.PageResult;
import org.example.jdoc.result.user.UserVO;
import org.springframework.web.bind.annotation.*;

/**
 * 用户接口
 * @author yeguozhong
 */
@RequestMapping("/api/user/")
@RestController
public class UserController {


    /**
     * 用户列表
     * @param listForm
     * @author yedaxia
     */
    @RequestMapping(path = "list", method = {RequestMethod.GET,  RequestMethod.POST}  )
    public ApiResult<PageResult<UserVO>> list(UserListForm listForm){
        return null;
    }

    /**
     * 用户信息
     * @param userId 用户id
     * @author 周杰伦
     */
    @GetMapping("user-info/{userId}")
    public ApiResult<UserVO> userInfo(@PathVariable Long userId){
        return null;
    }

    /**
     * 保存用户
     * @param req
     * @param userForm
     * @return
     */
    //@PostMapping(path = "save")
    //public ApiResult<UserVO> saveUser(HttpServletResponse req, @RequestBody UserForm userForm){
    //    return null;
    //}

    /**
     * 删除用户
     * @param userId 用户ID
     */
    @PostMapping("delete")
    public ApiResult deleteUser(@RequestParam Long userId){
        return null;
    }

    public ApiResult hello(){
        return null;
    }
}
