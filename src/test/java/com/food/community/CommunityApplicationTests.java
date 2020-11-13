package com.food.community;

import com.food.community.dao.UserMapper;
import com.food.community.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
//import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
class CommunityApplicationTests {


	@Test
	void contextLoads() {
		System.out.println();
	}


}
