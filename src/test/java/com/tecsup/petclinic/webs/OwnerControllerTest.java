package com.tecsup.petclinic.webs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tecsup.petclinic.domain.OwnerTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 */
@AutoConfigureMockMvc
@SpringBootTest
@Slf4j
public class OwnerControllerTest {
    private static final ObjectMapper om = new ObjectMapper();
    @Autowired
    private MockMvc mockMvc;

    /**
     * @throws Exception
     */
    @Test
    public void testCreateOwner() throws Exception {

        String NAME_OWNER = "SANDRO";
        String LAST_NAME = "SOTO";
        String ADDRESS = "JR HUANCAYO";
        String CITY = "LIMA";
        String TELEPHONE="998015332";


        OwnerTO newOwnerTO = new OwnerTO();
        newOwnerTO.setFirst_name(NAME_OWNER);
        newOwnerTO.setLast_name(LAST_NAME);
        newOwnerTO.setAddress(ADDRESS);
        newOwnerTO.setCity(CITY);
        newOwnerTO.setTelephone(TELEPHONE);


        mockMvc.perform(post("/owners")
                        .content(om.writeValueAsString(newOwnerTO))
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                //.andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.first_name", is(NAME_OWNER)))
                .andExpect(jsonPath("$.last_name", is(LAST_NAME)))
                .andExpect(jsonPath("$.address", is(ADDRESS)))
                .andExpect(jsonPath("$.city", is(CITY)))
                .andExpect(jsonPath("$.telephone", is(TELEPHONE)));

    }



 }
