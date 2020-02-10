package com.zyihang.codeFellowShip;

import com.zyihang.codeFellowShip.Controllers.ApplicationUserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
class CodefellowshipApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ApplicationUserController applicationUserController;
	@Test
	void contextLoads() {

	}
//	@Test
//	public void testHomePage() throws Exception {
//		this.mockMvc.perform(get("/"))
//				.andDo(print())
//				.andExpect(status().isOk())
//				.andExpect(content().string(containsString("<h2>Make new user</h2>")))
//				.andExpect(content().string(containsString("lastName <input type=\"lastName\" name=\"lastName\">")))
//				.andExpect(content().string(containsString("<a href=\"/logout\">Log out buddy</a>")))
//				.andExpect(content().string(containsString("<form action=\"/signup\" method=\"POST\">")));
//
//	}

}