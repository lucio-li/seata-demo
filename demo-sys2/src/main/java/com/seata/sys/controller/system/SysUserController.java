package com.seata.sys.controller.system;

import com.seata.sys.common.dto.ServiceResponse;
import com.seata.sys.entity.system.SysUser;
import com.seata.sys.service.system.SysUserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 描述：SysUserController
 *
 */
@RestController
@RequestMapping("/sys2/user")
@Api(value = "user", description = "用户信息 ")
@ApiResponses(value = {
        @ApiResponse(code = 0, message = "操作成功", response = Integer.class),
        @ApiResponse(code = 1, message = "操作失败", response = Integer.class)
})
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;



    @ApiOperation(value = "新增用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "SysUser", name = "entity", value = "用户信息", required = true)
    })
    @PostMapping()
    public ServiceResponse save(@RequestBody SysUser entity) {
        return sysUserService.save(entity);
    }


    @ApiOperation(value = "修改用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "SysUser", name = "entity", value = "用户信息", paramType = "body", required = true)
    })
    @PutMapping()
    public ServiceResponse update(@RequestBody SysUser entity) {
        return sysUserService.update(entity);
    }

    @ApiOperation(value = "删除用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "id", value = "用户信息id", paramType = "path", required = true)
    })
    @DeleteMapping("/{id}")
    public ServiceResponse delete(@PathVariable("id")String id) {
        return sysUserService.delete(id);
    }

    @ApiOperation(value = "获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String", name = "id", value = "用户信息id", paramType = "path", required = true)
    })
    @GetMapping("/{id}")
    public ServiceResponse getById(@PathVariable("id") String id) {

        return sysUserService.getById(id);
    }









}
