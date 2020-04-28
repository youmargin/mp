package com.app.mp;

import com.app.mp.dao.UserMapper;
import com.app.mp.entity.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SelectTest {
    private static Logger logger = LoggerFactory.getLogger(MpApplicationTests.class);
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectById() {
        User user = userMapper.selectById(1087982257332887553l);
        logger.debug("user = {}", user); // 如果查询不到返回null
    }

    @Test
    public void testSelectBatchIds() {
//        List<Long> idList = new Vector<>();
//        idList.add(1088250446457389058l);
//        idList.add(1255040456311734274l);
//        idList.add(1255040456311734275l);  //如果没有查询到，list中不显示
        List<Long> idList = Arrays.asList(1088250446457389058l, 1255040456311734274l, 1255040456311734275l);
        List<User> userList = userMapper.selectBatchIds(idList);
        logger.debug("userList = {}", userList);
    }

    @Test
    public void testSelectByMap() {
        Map map = new HashMap<>();
        map.put("age", 30);  //age是字段名，不是属性名
        map.put("name", "郝红梅"); //作为查询语句进行拼接
        List userList = userMapper.selectByMap(map);
        logger.debug("userList = {}", userList);
    }

    /**
     * 构造器查询
     */
    @Test
    public void testSelectByWrapper1() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.like("name", "雨"); //数据库列min
        queryWrapper.lt("age", 40); //可以使用链式
        List<User> userList = userMapper.selectList(queryWrapper);
        logger.debug("userList = {}", userList);
    }

    @Test
    public void testSelectByWrapper2() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.like("name", "雨")
                .between("age", 20, 40)
                .isNotNull("email");
        List<User> userList = userMapper.selectList(queryWrapper);

        for (User user : userList) {
            logger.debug("user = {}", user);
        }
    }

    @Test
    public void testSelectByWrapper3() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.likeRight("name", "王")
                .or()
                .ge("age", 40)
                .orderByDesc("age")
                .orderByAsc("id");
        List<User> userList = userMapper.selectList(queryWrapper);

        for (User user : userList) {
            logger.debug("user = {}", user);
        }
    }

    /**
     * 子查询
     */
    @Test
    public void testSelectByWrapper4() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();

        queryWrapper.apply("date_format(createTime,'%Y-%m-%d')>={0}","2020-04-28");  //使用函数

        queryWrapper.inSql("managerId","select id from user where name like '王%'");

        List<User> userList = userMapper.selectList(queryWrapper);

        for (User user : userList) {
            logger.debug("user = {}", user);
        }
    }

    @Test
    public void testSelectByWrapper5() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.likeRight("name","王");
        queryWrapper.and(wq->wq.lt("age",40).or().isNotNull("email"));

        List<User> userList = userMapper.selectList(queryWrapper);

        for (User user : userList) {
            logger.debug("user = {}", user);
        }
    }

    @Test
    public void testSelectByWrapper6() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.likeRight("name","王");
        queryWrapper.or(wq->wq.between("age",20, 40).or().isNotNull("email"));

        List<User> userList = userMapper.selectList(queryWrapper);

        for (User user : userList) {
            logger.debug("user = {}", user);
        }
    }
}
