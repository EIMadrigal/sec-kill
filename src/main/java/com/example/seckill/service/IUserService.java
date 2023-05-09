package com.example.seckill.service;

import com.example.seckill.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.seckill.vo.LoginVo;
import com.example.seckill.vo.RespBean;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author EIMadrigal
 * @since 2023-05-06
 */
public interface IUserService extends IService<User> {

    RespBean doLogin(LoginVo loginVo);
}
