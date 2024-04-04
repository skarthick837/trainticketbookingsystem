package com.example.trainticketbooking;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trainticketbooking.beans.TicketBookRequest;
import com.trainticketbooking.beans.TrainData;
import com.trainticketbooking.beans.User;
import com.trainticketbooking.controller.TicketBookingController;
import com.trainticketbooking.service.TicketBookingService;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TicketBookingController.class)
@AutoConfigureMockMvc
class TrainticketbookingApplicationTests {

    @MockBean
    public TicketBookingService ticketBookingService;

	@MockBean
	public TrainData trainData;

	@Autowired
  	MockMvc mockMvc;

	@BeforeEach
  	public void setUp(WebApplicationContext webApplicationContext) {
    	this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
  	}		

	@Test
	void testDeleteTicket() throws Exception{
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/ticket/delete?seatno=test").accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk());

	}

	@Test
	void modifyTicket() throws Exception{
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/ticket/modifyseat?seatno=test").accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	void getSectionTicketDetailsTest() throws Exception{
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/ticket/get/sectionticketdetails?section=a").accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk());
		
	}

	// @Test
	// void bookTicketTest() throws Exception  {
		
	// 	TicketBookRequest t1= new TicketBookRequest();
	// 	User u1= new User();
	// 	u1.setEmail("test@test.com");
	// 	t1.setUser(u1);
	// 	String ticketRquest="{\"from\": \"London\",\"to\":\"France\",\"user\":{\"firstName\":\"sethu\",\"lastName\":\"karthick\",\"email\":\"karthi@test.com\"}}";
		
	// 	Map<String, TicketBookRequest> details=new HashMap<String, TicketBookRequest>();

	// 	Mockito.when(ticketBookingService.bookTicket(Mockito.any(), Mockito.any())).thenReturn("Ticket Booked Successfully");

	// 	mockMvc.perform(MockMvcRequestBuilders.post("/ticket/book")
	// 	.content(asJsonString(t1)).contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());	
		
	// }

	public static String asJsonString(final Object obj) {
    try {
        return new ObjectMapper().writeValueAsString(obj);
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}
}
