package sam.guru.spring6restmvc.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import sam.guru.spring6restmvc.models.BeerDto;
import sam.guru.spring6restmvc.service.BeerService;
import sam.guru.spring6restmvc.service.BeerServiceImpl;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    BeerService beerService;

    BeerServiceImpl beerServiceImpl = new BeerServiceImpl();
    @Test
    void getBeers() throws Exception {
        given(beerService.getBeers()).willReturn(beerServiceImpl.getBeers());
        mockMvc.perform(get("/api/v1/beer").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void saveBeer() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        BeerDto beer = beerServiceImpl.getBeers().stream().findFirst().get();
        System.out.println(mapper.writeValueAsString(beer));
    }

    @Test
    void getBeer() throws Exception {
        BeerDto beer = beerServiceImpl.getBeers().stream().findFirst().get();
        given(beerService.getBeerById(any(UUID.class))).willReturn(beer);
       /* mockMvc.perform(get("/api/v1/beer/"+ UUID.randomUUID()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON));*/

    }

    @Test
    void updateBeer() {
    }

    @Test
    void deleteBeer() {
    }
}
