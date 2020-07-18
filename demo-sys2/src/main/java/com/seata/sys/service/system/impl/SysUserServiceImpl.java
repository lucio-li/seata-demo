package com.seata.sys.service.system.impl;


import com.seata.sys.common.dto.ServiceResponse;
import com.seata.sys.dao.system.SysUserDao;
import com.seata.sys.entity.system.SysUser;
import com.seata.sys.service.system.SysUserService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述：SysUserServiceImpl
 * 用户 Service
 */
@Slf4j
@Service
public class SysUserServiceImpl implements SysUserService {


    @Autowired
    private SysUserDao sysUserDao;



    /**
     * 保存用户信息
     *
     * @param sysUser
     * @return
     */
    @Override
    public ServiceResponse save(SysUser sysUser) {
        try {
            sysUserDao.insert(sysUser);
            return ServiceResponse.createSuccess();
        } catch (Exception e) {
            log.info("保存用户信息失败", e.fillInStackTrace());
            return ServiceResponse.createByErrorMsgData("保存用户信息失败，异常", null);
        }
    }

    /**
     * 修改 用户信息
     *
     * @param sysUser
     * @return
     */
    @GlobalTransactional(timeoutMills = 300000, name = "dubbo-gts-seata-example")
    @Override
    public ServiceResponse update(SysUser sysUser) {


        sysUserDao.updateUserById(sysUser);
        try {
            Thread.sleep(5*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        boolean flag = true;
//        if (flag) {
//            log.error("事务回滚");
//            throw new RuntimeException("测试抛异常后，分布式事务回滚！");
//        }
        return ServiceResponse.createSuccess();

    }


    /**
     * 删除用户信息， 逻辑删除
     *
     * @param id 用户信息id
     * @return
     */
    @Override
    public ServiceResponse delete(String id) {
        try {

            sysUserDao.deleteById(id);

            return ServiceResponse.createSuccess();
        } catch (Exception e) {
            log.info("删除用户信息失败:", e.fillInStackTrace());
            return ServiceResponse.createByErrorMsgData("删除用户信息失败，异常", null);
        }
    }



    /**
     * 根据id获取当前用户信息
     *
     * @param id
     * @return
     */
    @Override
    public ServiceResponse<SysUser> getById(String id) {

        //执行查询
        SysUser user = null;
        try {
            user = sysUserDao.selectById(id);
        } catch (Exception e) {
            log.error("查询用户信息失败，userId：" + id, e.fillInStackTrace());
            return ServiceResponse.createError();
        }
        return ServiceResponse.createSuccessByData(user);
    }


}
