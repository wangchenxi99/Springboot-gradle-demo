package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.UserDemo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest //获取启动类，加载配置，寻找主配置启动类 （被 @SpringBootApplication 注解的）
@RunWith(SpringRunner.class) //让JUnit运行Spring的测试环境,获得Spring环境的上下文的支持
@AutoConfigureMockMvc  //用于自动配置MockMvc,配置后MockMvc类可以直接注入,相当于new MockMvc
public class DemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	/*
        mockMvc Get接口请求的demo
        测试的接口位于 DemoController
    */
	@Test
	public void testGetDemoController() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
				.andExpect(MockMvcResultMatchers.status().isOk());//判断请求的接口是不是200
	}

	@Test
	public void testPostDemoController() throws Exception {
		UserDemo user = new UserDemo();
		user.setName("TEST1");
		user.setAge(18);
		String json = JSON.toJSONString(user);
		//执行一个RequestBuilder请求，会自动执行SpringMVC的流程并映射到相应的控制器执行处理；
		mockMvc.perform(MockMvcRequestBuilders
						.post("/insertDemo")
						.content(json.getBytes()) //传json参数
						.accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON_VALUE)
						//header放入的参数
						.header("Authorization", "Bearer ********-****-****-****-************")
				)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(print());
	}



}
