package com.app.mp;


import com.app.mp.dao.UserMapper;
import com.app.mp.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MpApplicationTests {
    private static Logger logger = LoggerFactory.getLogger(MpApplicationTests.class);
    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectTest(){
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        for(User user : userList){
            logger.debug("{}",user);
        }
    }

    @Test
    public void insertTest(){
        User user = new User();
        user.setName("郝红梅");
        user.setAge(30);
        user.setManagerId(1088248166370832385l);
        user.setCreateTime(LocalDateTime.now());
        user.setMemoInfo("test");
        int rows = userMapper.insert(user);
        logger.debug("rows = {}", rows);
    }
}
