package com.seata.sys.dao.system;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.seata.sys.entity.system.SysUser;
import org.apache.ibatis.annotations.Param;

/**
 * 描述：SysUserDao
 * 用户Dao
 *
 */
public interface SysUserDao extends BaseMapper<SysUser> {
    void updateUserById(@Param("param") SysUser sysUser);
}
