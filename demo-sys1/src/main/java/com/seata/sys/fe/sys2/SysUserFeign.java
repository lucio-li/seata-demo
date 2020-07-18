package com.seata.sys.fe.sys2;

import com.seata.sys.common.dto.ServiceResponse;
import com.seata.sys.entity.system.SysUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liqiao
 * @Description
 * @Date Create in 17:58 2020/5/23
 */
@FeignClient(name = "demo-sys2")
@RequestMapping("/sys2/user")
public interface SysUserFeign {


    @PutMapping()
    public ServiceResponse update(@RequestBody SysUser entity);
}
