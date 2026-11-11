
package edu.laboratorio;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class FrontendApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    // PRUEBA 1: ACTIVA
    @Test
    void paginaPrincipalResponde() throws Exception {

        var respuesta = mockMvc.perform(get("/"))
                .andReturn()
                .getResponse();

        assertEquals(200, respuesta.getStatus());
    }

    // PRUEBA 2: DESACTIVADA TEMPORALMENTE
    @Disabled("Pendiente de revisar el título HTML")
    @Test
    void paginaContieneTitulo() throws Exception {

        String html = obtenerHtml();

        assertTrue(
            html.contains("Mi primera página con Java")
        );
    }

    // PRUEBA 3: DESACTIVADA TEMPORALMENTE
    @Disabled("Pendiente de revisar el botón HTML")
    @Test
    void paginaContieneBoton() throws Exception {

        String html = obtenerHtml();

        assertTrue(
            html.contains("Mostrar mensaje")
        );
    }

    private String obtenerHtml() throws Exception {

        return mockMvc.perform(get("/"))
                .andReturn()
                .getResponse()
                .getContentAsString();
    }
}

