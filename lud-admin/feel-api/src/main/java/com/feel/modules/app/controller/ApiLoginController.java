/**
 * Copyright (c) 2016-2019 feel All rights reserved.
 *
 * https://www.feel.io
 *
 * 版权所有，侵权必究！
 */

package com.feel.modules.app.controller;


import com.feel.common.annotation.Login;
import com.feel.common.utils.R;
import com.feel.common.validator.ValidatorUtils;
import com.feel.common.form.LoginForm;
import com.feel.modules.app.service.FUserService;
import com.feel.modules.app.service.TokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 登录接口
 *
 * @author Mark sunlightcs@gmail.com
 */
@RestController
@RequestMapping("/api/f")
@Api(tags="登录接口")
public class ApiLoginController {
    @Autowired
    private FUserService userService;
    @Autowired
    private TokenService tokenService;


    @PostMapping("login")
    @ApiOperation("登录")
    public R login(@RequestBody LoginForm form,HttpServletRequest request){
        //表单校验
        ValidatorUtils.validateEntity(form);

        //用户登录
        Map<String, Object> map = userService.login(form);
        if(map.containsKey("token")) {
            request.getSession().setAttribute("token", map.get("token"));
        }
        return R.ok(map);
    }

    @Login
    @PostMapping("logout")
    @ApiOperation("退出")
    public R logout(@ApiIgnore @RequestAttribute("userId") long userId){
        tokenService.expireToken(userId);
        return R.ok();
    }

}
