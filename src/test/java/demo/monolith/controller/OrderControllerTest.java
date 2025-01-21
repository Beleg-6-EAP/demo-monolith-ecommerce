package demo.monolith.controller;

import demo.monolith.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OrderController.class)
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private OrderService orderService;

    @Test
    void should_RespondWith_StatusCode_200_When_GettingAllOrders() throws Exception {
        when(orderService.getAll()).thenReturn(Collections.emptyList());

        final RequestBuilder request = get("/api/orders")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void should_RespondWith_StatusCode_201_When_CreatingOrder() throws Exception {
        when(orderService.create(any())).thenReturn(any());

        final RequestBuilder request = post("/api/orders")
                .accept(MediaType.APPLICATION_JSON)
                .content("{" +
                "    \"id\": \"1234-5678-abcd-efgh\"," +
                "    \"userId\": \"1234-5678-8765-4321\"," +
                "    \"amount\": 42.0," +
                "    \"status\": \"New\"" +
                "}")
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isCreated());
    }
}
