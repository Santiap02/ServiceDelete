package com.example.ApplicationConfig;

import Model.Photo;
import Repository.ClientRepository;
import Repository.PhotoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class ServiceDeleteApplicationTests {
    static ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private MockMvc restMock;
    @MockBean
    private ClientRepository clientRepository;
    @MockBean
    PhotoRepository photoRepository;

    @Test
    @WithMockUser(username = "admin", password = "admin" ,authorities = { "ADMIN", "USER" })
    void deleteClientTest() throws Exception {
        Mockito.when(this.clientRepository.findById(Mockito.anyInt())).thenReturn(TestUtils.createClient());
        restMock.perform(delete("/clientes/"+"16"))
                .andDo(print()).andExpect(status().isOk()).andExpect(jsonPath(TestUtils.RESPONSE_STATE).value(HttpStatus.OK.value()));
    }
    @Test
    void deleteClientTestServiceException() throws Exception {
        Mockito.when(this.clientRepository.findById(Mockito.anyInt())).thenReturn(Optional.ofNullable(null));
        restMock.perform(delete("/clientes/"+"16"))
                .andDo(print()).andExpect(status().isOk()).andExpect(jsonPath(TestUtils.RESPONSE_STATE).value(HttpStatus.NOT_FOUND.value()));
    }

    @Test
    void deleteClientTestGeneralException() throws Exception {
        Mockito.when(this.clientRepository.findById(Mockito.anyInt())).thenThrow(NullPointerException.class);
        restMock.perform(delete("/clientes/"+"16"))
                .andDo(print()).andExpect(status().isOk()).andExpect(jsonPath(TestUtils.RESPONSE_STATE).value(HttpStatus.INTERNAL_SERVER_ERROR.value()));
    }
    @Test
    void deletePhotoTest() throws Exception {
        Mockito.when(this.photoRepository.findByClientId(Mockito.anyInt())).thenReturn(Optional.ofNullable(new Photo()));
        restMock.perform(delete("/photos/"+"16"))
                .andDo(print()).andExpect(status().isOk()).andExpect(jsonPath(TestUtils.RESPONSE_STATE).value(HttpStatus.OK.value()));
    }

    @Test
    void deletePhotoTestServiceException() throws Exception {
        Mockito.when(this.photoRepository.findByClientId(Mockito.anyInt())).thenReturn(Optional.ofNullable(null));
        restMock.perform(delete("/photos/"+"16"))
                .andDo(print()).andExpect(status().isOk()).andExpect(jsonPath(TestUtils.RESPONSE_STATE).value(HttpStatus.NOT_FOUND.value()));
    }

    @Test
    void deletePhotoTestGeneralException() throws Exception {
        Mockito.when(this.photoRepository.findByClientId(Mockito.anyInt())).thenThrow(NullPointerException.class);
        restMock.perform(delete("/photos/"+"16"))
                .andDo(print()).andExpect(status().isOk()).andExpect(jsonPath(TestUtils.RESPONSE_STATE).value(HttpStatus.INTERNAL_SERVER_ERROR.value()));
    }

}
