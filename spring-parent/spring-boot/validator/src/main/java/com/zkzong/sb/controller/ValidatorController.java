package com.zkzong.sb.controller;

import com.zkzong.sb.dto.RspDTO;
import com.zkzong.sb.dto.UserDTO;
import com.zkzong.sb.dto.UserReq;
import com.zkzong.sb.dto.assist.Create;
import com.zkzong.sb.dto.assist.Update;
import com.zkzong.sb.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import java.util.Set;

@RestController
@Slf4j
public class ValidatorController {

    @Autowired
    private UserService userService;

    @Autowired
    private javax.validation.Validator globalValidator;

    /**
     * 走参数校验注解
     *
     * @param userDTO
     * @return
     */
    @PostMapping("/create")
    public RspDTO save(@RequestBody @Validated UserDTO userDTO) {
        log.info("入参：{}", userDTO);
        userService.save(userDTO);
        return RspDTO.success();
    }

    /**
     * 嵌套校验
     *
     * @param req
     * @return
     */
    @PostMapping("/create/list")
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

    /**
     * 编程式校验
     *
     * @param userDTO
     * @return
     */
    @PostMapping("/create/code")
    public RspDTO save1(@RequestBody @Validated UserDTO userDTO) {
        Set<ConstraintViolation<UserDTO>> validate = globalValidator.validate(userDTO, Create.class);

        if (validate.isEmpty()) {

        } else {
            for (ConstraintViolation<UserDTO> userDTOConstraintViolation : validate) {
                System.out.println(userDTOConstraintViolation);
            }
        }
        return RspDTO.success();
    }

}
