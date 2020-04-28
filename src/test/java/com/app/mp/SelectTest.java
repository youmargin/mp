package com.app.mp;

import com.app.mp.dao.UserMapper;
import com.app.mp.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SelectTest {
    private static Logger logger = LoggerFactory.getLogger(MpApplicationTests.class);
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectById(){
        User user = userMapper.selectById(1087982257332887553l);
        logger.debug("user = {}", user); // 如果查询不到返回null
    }

    @Test
    public void testSelectBatchIds(){
//        List<Long> idList = new Vector<>();
//        idList.add(1088250446457389058l);
//        idList.add(1255040456311734274l);
//        idList.add(1255040456311734275l);  //如果没有查询到，list中不显示
        List<Long> idList = Arrays.asList(1088250446457389058l, 1255040456311734274l, 1255040456311734275l);
        List<User> userList = userMapper.selectBatchIds(idList);
        logger.debug("userList = {}", userList);
    }

    @Test
    public void testSelectByMap(){
        Map map = new HashMap<>();
        map.put("age",30);  //age是字段名，不是属性名
        map.put("name","郝红梅"); //作为查询语句进行拼接
        List userList = userMapper.selectByMap(map);
        logger.debug("userList = {}", userList);
    }
}
