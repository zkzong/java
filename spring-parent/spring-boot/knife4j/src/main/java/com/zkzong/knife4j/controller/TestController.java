package com.zkzong.knife4j.controller;

import com.google.common.collect.ImmutableMap;
import com.zkzong.knife4j.common.RestMessage;
import com.zkzong.knife4j.domain.ReqEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/***
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2017/04/20 14:01
 */
@Api(value = "测试", tags = "测试用例")
@RestController
@RequestMapping("/api/test")
public class TestController {

    /*@ApiOperation(value = "测试接口1",notes = "测试说明1")
    @GetMapping(value = "/xdf_{code}")
    @ApiImplicitParams({@ApiImplicitParam(value = "code",name = "code",dataType = "string",paramType = "path"),@ApiImplicitParam(name = "st",value = "st",dataType = "boolean")})
    public RestMessage urlpath(@PathVariable(value = "code") String code, Boolean st){
        return new RestMessage(code);
    }

    @ApiOperation(value = "测试接口2",notes = "测试说明2")
    @PostMapping(value = "/gxx_code")
    @ApiImplicitParams({@ApiImplicitParam(value = "code",name = "code",dataType = "string",paramType = "path"),@ApiImplicitParam(name = "st",value = "st",dataType = "boolean")})
    public RestMessage gxx_code(String code, Boolean st){
        return new RestMessage(code);
    }

*/
    @ApiOperation(value = "puttest", notes = "puttest测试说明2")
    @PutMapping(value = "/puttest")
    @ApiImplicitParam(value = "code", name = "code", dataType = "string", paramType = "query", defaultValue = "abc")
    public RestMessage puttest(String code) {
        return new RestMessage(code);
    }

    @ApiOperation(value = "deletetest", notes = "deletetest测试说明2")
    @DeleteMapping(value = "/deletetest")
    @ApiImplicitParam(value = "code", name = "code", dataType = "string", paramType = "query", example = "abcefg")
    public RestMessage deletetest(@RequestParam(value = "code") String code) {
        return new RestMessage(code);
    }

    @PostMapping("/reqbody")
    @ApiOperation(value = "RequestBody接口类型", notes = "RequestBody测试接口,实体类型")
    public RestMessage reqbody(@RequestBody ReqEntity reqEntity) {
        return new RestMessage(reqEntity);
    }

    @PostMapping("/reqbody2")
    @ApiOperation(value = "RequestBody接口类型2", notes = "RequestBody测试接口2-string类型")
    public RestMessage reqbody2(@RequestBody String reqEntity) {
        return new RestMessage(reqEntity);
    }

    @PostMapping("/reqbody1")
    @ApiOperation(value = "ModelAttribute", notes = "ModelAttribute类型参数")
    public RestMessage reqbody1(@ModelAttribute ReqEntity reqEntity) {
        return new RestMessage(reqEntity);
    }

    @PostMapping("/reqbody3")
    @ApiOperation(value = "header参数", notes = "header参数")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "code", name = "code", dataType = "string", paramType = "query"),
            @ApiImplicitParam(value = "headerparam", name = "headerparam", dataType = "string", paramType = "header"),
            @ApiImplicitParam(value = "page", name = "page", dataType = "int", paramType = "query"),
            @ApiImplicitParam(value = "page1", name = "page1", dataType = "Long", paramType = "query")
    })
    public RestMessage reqbody3(@RequestHeader(value = "headerparam") String headerparam, @RequestParam(value = "code") String code,
                                @RequestParam(value = "page") int page, @RequestParam(value = "page1") Long page1) {
        return new RestMessage(ImmutableMap.of("code", code, "header", headerparam, "page", page, "page1", page1));
    }


}
