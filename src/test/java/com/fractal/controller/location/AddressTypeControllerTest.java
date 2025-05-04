package com.fractal.controller.location;

import com.fractal.domain.location.address.type.dto.AddressTypeCreate;
import com.fractal.domain.location.address.type.dto.AddressTypeResponse;
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
import java.util.stream.Collectors;

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
        AddressTypeCreate addressTypeResponse = new AddressTypeCreate(null, "TESTCODE", "Test Name",null);
        AddressTypeResponse createdAddressTypeResponse = new AddressTypeResponse(14L, "TESTCODE", "Test Name", LocalDateTime.now());

        given(addressTypeService.toDTO(addressTypeService.create(addressTypeResponse))).willReturn(createdAddressTypeResponse);

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
        List<AddressTypeResponse> addressTypeResponseList = Arrays.asList(
                new AddressTypeResponse(1L, "Code1", "Name1",LocalDateTime.now()),
                new AddressTypeResponse(2L, "Code2", "Name2",LocalDateTime.now())
        );
        given(addressTypeService.getAll().stream().map(addressTypeService::toDTO).collect(Collectors.toList())).willReturn(addressTypeResponseList);

        mockMvc.perform(get("/api/v1/location/address_type"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[1].id").value(2));
    }

    @Test
    void getByIdTest() throws Exception {
        Long id = 1L;
        AddressTypeResponse addressTypeResponse = new AddressTypeResponse(id, "Code1", "Name1",LocalDateTime.now());
        given(addressTypeService.toDTO(addressTypeService.getById(id))).willReturn(addressTypeResponse);

        mockMvc.perform(get("/api/v1/location/address_type/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.code").value("Code1"))
                .andExpect(jsonPath("$.name").value("Name1"));
    }

    @Test
    void getByCodeTest() throws Exception {
        String code = "SOLID";
        AddressTypeResponse addressTypeResponse = new AddressTypeResponse(1L, code, "Name1",LocalDateTime.now());
        given(addressTypeService.toDTO(addressTypeService.getByCode(code))).willReturn(addressTypeResponse);

        mockMvc.perform(get("/api/v1/location/address_type/code/{code}", code))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.code").value(code))
                .andExpect(jsonPath("$.name").value("Name1"));
    }

    @Test
    void updateTest() throws Exception {
        Long id = 1L;
        AddressTypeCreate addressTypeCreate = new AddressTypeCreate(null, "UPDCODE", "Updated Name",null);
        AddressTypeResponse updatedAddressTypeResponse = new AddressTypeResponse(id, "UPDCODE", "Updated Name",LocalDateTime.now());

        given(addressTypeService.toDTO(addressTypeService.update(id, addressTypeCreate))).willReturn(updatedAddressTypeResponse);

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