package com.example.demo;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@WebMvcTest(value = DemoappApplication.class, secure = false)
public class ControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void greetingsTest() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/greeting").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String actual = result.getResponse().getContentAsString();
		JSONObject jsonObject = new JSONObject(actual);
		Assert.assertEquals("Hello, World!", jsonObject.get("content"));
	}
}
