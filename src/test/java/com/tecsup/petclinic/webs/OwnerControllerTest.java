package com.tecsup.petclinic.webs;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
@Slf4j
public class OwnerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testFindAllPets() throws Exception {

        //int NRO_RECORD = 73;
        int ID_FIRST_RECORD = 1;

        this.mockMvc.perform(get("/pets"))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                //		    .andExpect(jsonPath("$", hasSize(NRO_RECORD)))
                .andExpect(jsonPath("$[0].id", is(ID_FIRST_RECORD)));
    }


    /**
     *
     * @throws Exception
     *
     */
    @Test
    public void testFindPetOK() throws Exception {

        String NAME_PET = "Leo";
        int TYPE_ID = 1;
        int OWNER_ID = 1;
        String BIRTH_DATE = "2000-09-07";

        mockMvc.perform(get("/pets/1"))  // Object must be BASIL
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is(NAME_PET)))
                .andExpect(jsonPath("$.typeId", is(TYPE_ID)))
                .andExpect(jsonPath("$.ownerId", is(OWNER_ID)))
                .andExpect(jsonPath("$.birthDate", is(BIRTH_DATE)));
    }
    /**
     *
     * @throws Exception
     */
    @Test
    public void testFindPetKO() throws Exception {

        mockMvc.perform(get("/pets/666"))
                .andExpect(status().isNotFound());

    }
}
