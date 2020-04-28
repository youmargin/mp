package com.app.mp;


import com.app.mp.dao.UserMapper;
import com.app.mp.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MpApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectTest(){
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
    }
}
