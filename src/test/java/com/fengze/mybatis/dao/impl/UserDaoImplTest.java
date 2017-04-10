package com.fengze.mybatis.dao.impl;


import com.fengze.mybatis.domain.UserDo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/4/10.
 */
@Slf4j
public class UserDaoImplTest {

    SqlSessionFactory sqlSessionFactory;

    SqlSession session;

    @Before
    public void setUp() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
        //默认创建session是false 手动提交事物 ，如果是设置true，自动提交事物
        //也可以理解为 false: 开启事物 true:关闭事物
//        session = sqlSessionFactory.openSession(true);
    }

    @After
    public void tearDown() throws Exception {
        session.close();
    }

    @Test
    public void testQueryById() throws Exception {
        UserDo userDo = new UserDo();
        userDo.setUserId(1000L);

        UserDo user = session.selectOne("user.queryById", userDo);

        log.info("UserDo : {}", user);
    }

    @Test
    public void testFindById() throws Exception {

        UserDo user = session.selectOne("user.findById", 1000);

        log.info("UserDo : {}", user);
    }

    @Test
    public void testQueryByList() throws Exception {

        UserDo userDo = new UserDo();
        userDo.setAddress("南郑");

        List<UserDo> list = session.selectList("user.queryByList", userDo);

        for (UserDo user : list) {
            log.info("UserDo : {}", user);
        }
    }

    @Test
    public void testAddUser() throws Exception {
        UserDo userDo = new UserDo();

        userDo.setUserName("zhaoliu");
        userDo.setPassword("123456");
        userDo.setRealName("赵六");
        userDo.setEmail("zhaoliu@qq.com");
        userDo.setCellphone("17712345678");
        userDo.setAddress("广东深圳");
        userDo.setUserType("0");

        Integer res = session.insert("user.addUser", userDo);

        //默认情况下mybatis是手动提交的(开启事物的)
//        session.commit();

        log.info("新增影响的行数 ： {}", res);
    }

    @Test
    public void testModifyUser() throws Exception {
        UserDo userDo = new UserDo();

        userDo.setUserId(1004L);
        userDo.setPassword("654321");

        Integer res = session.update("user.modifyUser", userDo);

        log.info("修改影响的行数 ： {}", res);

        session.commit();
    }

    @Test
    public void testDelUser() throws Exception {
        UserDo userDo = new UserDo();

        userDo.setUserId(1004L);

        Integer res = session.update("user.delUser", userDo);

        log.info("修改影响的行数 ： {}", res);

        session.commit();

    }
}