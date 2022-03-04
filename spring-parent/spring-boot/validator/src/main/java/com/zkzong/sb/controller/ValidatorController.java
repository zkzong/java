package com.zkzong.sb.controller;

import com.zkzong.sb.dto.RspDTO;
import com.zkzong.sb.dto.UserDTO;
import com.zkzong.sb.dto.UserReq;
import com.zkzong.sb.dto.assist.Update;
import com.zkzong.sb.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ValidatorController {

    @Autowired
    private UserService userService;

    /**
     * 走参数校验注解
     *
     * @param userDTO
     * @return
     */
    @PostMapping("/save/valid")
    public RspDTO save(@RequestBody @Validated UserDTO userDTO) {
        log.info("入参：{}", userDTO);
        userService.save(userDTO);
        return RspDTO.success();
    }

    @PostMapping("/save/valid/list")
    public RspDTO save(@RequestBody @Validated UserReq req) {
        log.info("入参：{}", req);
        for (UserDTO userDTO : req.getDtoList()) {
            userService.save(userDTO);
        }
        return RspDTO.success();
    }

    /**
     * 走参数校验注解的 groups 组合校验
     *
     * @param userDTO
     * @return
     */
    @PostMapping("/update/groups")
    public RspDTO update(@RequestBody @Validated(Update.class) UserDTO userDTO) {
        userService.updateById(userDTO);
        return RspDTO.success();
    }

}
