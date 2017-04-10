package com.fengze.mybatis.domain;

import lombok.Data;

/**
 * Created by Administrator on 2017/4/10.
 */
@Data
public class UserDo extends BaseDo{
    private Long userId;

    private String userName;//登陆用户名
    private String password;//登陆密码
    private String realName;//真实姓名
    private String email;//电子邮件
    private String cellphone;//联系电话
    private String address;//地址
    private String userType;//user_type = 1:系统用户 0:注册会员用户
}
