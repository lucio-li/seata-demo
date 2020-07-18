package com.seata.sys.service.system;

import com.seata.sys.common.dto.ServiceResponse;
import com.seata.sys.entity.system.SysUser;

/**
 * 描述：SysUserService
 * 用户
 */
public interface SysUserService {
    ServiceResponse save(SysUser SysUser);

    ServiceResponse update(SysUser SysUser);

    ServiceResponse delete(String id);

    ServiceResponse<SysUser> getById(String id);



}
