package com.fractal.controller.location;

import com.fractal.domain.location.address.type.AddressTypeDTO;
import com.fractal.domain.location.address.type.AddressTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(AddressTypeController.class)

class AddressTypeControllerTest {
    @Autowired
    private  MockMvc mockMvc;

    @MockitoBean
    private  AddressTypeService addressTypeService;
    @BeforeEach
    void setUp() {
        // Optional: Clean the database or initialize any necessary data before each test
    }

    @Test
    void createTest() throws Exception {
        // Arrange
        AddressTypeDTO addressTypeDTO = new AddressTypeDTO(null, "TESTCODE", "Test Name",null);
        AddressTypeDTO createdAddressTypeDTO = new AddressTypeDTO(14L, "TESTCODE", "Test Name", LocalDateTime.now());

        given(addressTypeService.create(addressTypeDTO)).willReturn(createdAddressTypeDTO);

        // Act & Assert
        mockMvc.perform(post("/api/v1/location/address_type")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"code\": \"TESTCODE\", \"name\": \"Test Name\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(14))
                .andExpect(jsonPath("$.code").value("TESTCODE"))
                .andExpect(jsonPath("$.name").value("Test Name"));
    }

    @Test
    void getAllTest() throws Exception  {
        List<AddressTypeDTO> addressTypeDTOList = Arrays.asList(
                new AddressTypeDTO(1L, "Code1", "Name1",LocalDateTime.now()),
                new AddressTypeDTO(2L, "Code2", "Name2",LocalDateTime.now())
        );
        given(addressTypeService.getAll()).willReturn(addressTypeDTOList);

        mockMvc.perform(get("/api/v1/location/address_type"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[1].id").value(2));
    }

    @Test
    void getByIdTest() throws Exception {
        Long id = 1L;
        AddressTypeDTO addressTypeDTO = new AddressTypeDTO(id, "Code1", "Name1",LocalDateTime.now());
        given(addressTypeService.getById(id)).willReturn(addressTypeDTO);

        mockMvc.perform(get("/api/v1/location/address_type/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.code").value("Code1"))
                .andExpect(jsonPath("$.name").value("Name1"));
    }

    @Test
    void getByCodeTest() throws Exception {
        String code = "SOLID";
        AddressTypeDTO addressTypeDTO = new AddressTypeDTO(1L, code, "Name1",LocalDateTime.now());
        given(addressTypeService.getByCode(code)).willReturn(addressTypeDTO);

        mockMvc.perform(get("/api/v1/location/address_type/code/{code}", code))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.code").value(code))
                .andExpect(jsonPath("$.name").value("Name1"));
    }

    @Test
    void updateTest() throws Exception {
        Long id = 1L;
        AddressTypeDTO addressTypeDTO = new AddressTypeDTO(null, "UPDCODE", "Updated Name",null);
        AddressTypeDTO updatedAddressTypeDTO = new AddressTypeDTO(id, "UPDCODE", "Updated Name",LocalDateTime.now());

        given(addressTypeService.update(id, addressTypeDTO)).willReturn(updatedAddressTypeDTO);

        mockMvc.perform(put("/api/v1/location/address_type/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"code\": \"UPDCODE\", \"name\": \"Updated Name\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.code").value("UPDCODE"))
                .andExpect(jsonPath("$.name").value("Updated Name"));
    }

    @Test
    void deleteTest() throws Exception {
        Long id = 1L;
        willDoNothing().given(addressTypeService).deleteById(id);

        mockMvc.perform(delete("/api/v1/location/address_type/{id}", id))
                .andExpect(status().isNoContent());
    }
}