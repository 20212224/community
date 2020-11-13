package com.food.community;

import com.food.community.dao.DiscussPostMapper;
import com.food.community.dao.LoginTicketMapper;
import com.food.community.dao.UserMapper;
import com.food.community.entity.DiscussPost;
import com.food.community.entity.LoginTicket;
import com.food.community.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTest {

    @Autowired
    private LoginTicketMapper loginTicketMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void testSelect(){
        User user = userMapper.selectById(101);
        System.out.println(user);


        user = userMapper.selectByName("liubei");
        System.out.println(user);


    }

    @Test
    public void testInsert(){
        User user = new User();

        user.setUsername("test");
        user.setPassword("123456");
        user.setSalt("asd");
        user.setEmail("12345@qq.com");
        user.setHeaderUrl("http://www.baidu.com");
        user.setCreateTime(new Date());

        int rows = userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());

    }

    @Test
    public void testSelectPost(){
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(152,0,10,0);
        for(DiscussPost post: list){
            System.out.println(post);
        }

        int row = discussPostMapper.selectDiscussPostRows(0);
        System.out.println(row);
    }

    @Test
    public void testInsertLoginTicket(){
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setUserId(11);
        loginTicket.setTicket("asd");
        loginTicket.setStatus(0);
        loginTicket.setExpired(new Date(System.currentTimeMillis() + 1000*60*10));

        loginTicketMapper.insertLoginTicket(loginTicket);
    }

    @Test
    public void testSelectLoginTicket(){
        LoginTicket loginTicket = loginTicketMapper.selectByTicket("asd");
        System.out.println(loginTicket);

        loginTicketMapper.updateStatus("asd",1);

        loginTicket = loginTicketMapper.selectByTicket("asd");
        System.out.println(loginTicket);
    }

}
