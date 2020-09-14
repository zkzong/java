package com.zkzong.idempotent;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BusinessController {

    @Resource
    private TokenService tokenService;

    @PostMapping("/get/token")
    public String getToken() {
        String token = tokenService.createToken();
        if (StrUtil.isNotEmpty(token)) {
            ResultVo resultVo = new ResultVo();
            resultVo.setCode(Constant.code_success);
            resultVo.setMessage(Constant.SUCCESS);
            resultVo.setData(token);
            return JSONUtil.toJsonStr(resultVo);
        }
        return StrUtil.EMPTY;
    }


    @AutoIdempotent
    @PostMapping("/test/Idempotence")
    public String testIdempotence() {
        String businessResult = "hello i am success";
        if (StrUtil.isNotEmpty(businessResult)) {
            ResultVo successResult = ResultVo.getSuccessResult(businessResult);
            return JSONUtil.toJsonStr(successResult);
        }

        return StrUtil.EMPTY;
    }
}
