package es.stemgranada.ed.testing.validacion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidadorEdadTest {

    private ValidadorEdad validadorEdad;

    @BeforeEach
    void inicializar() {
        validadorEdad = new ValidadorEdad();
    }

    @Test
    @DisplayName("Devuelve true cuando la edad es 18")
    void esMayorDeEdad_conEdad18_devuelveTrue() {
        boolean resultado = validadorEdad.esMayorDeEdad(18);
        assertTrue(resultado);
    }

    @Test
    @DisplayName("Devuelve true cuando la edad es mayor a 18")
    void esMayorDeEdad_conEdadMayor18_devuelveTrue() {
        boolean resultado = validadorEdad.esMayorDeEdad(25);
        assertTrue(resultado);
    }

    @Test
    @DisplayName("Devuelve false cuando la edad es menor a 18")
    void esMayorDeEdad_conEdadMenor18_devuelveFalse() {
        boolean resultado = validadorEdad.esMayorDeEdad(16);
        assertFalse(resultado);
    }

    @Test
    @DisplayName("Lanza excepción si la edad es negativa")
    void esMayorDeEdad_conEdadNegativa_lanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> {
            validadorEdad.esMayorDeEdad(-5);
        });
    }

    @Test
    @DisplayName("Devuelve 'menor' si la edad es menor de 18")
    void clasificarEdad_conEdadMenor18_devuelveMenor() {
        String resultado = validadorEdad.clasificarEdad(15);
        assertEquals("menor", resultado);
    }

    @Test
    @DisplayName("Devuelve 'adulto' si la edad es menor o igual de 65")
    void clasificarEdad_conEdadMenorIgual65_devuelveAdulto() {
        String resultado = validadorEdad.clasificarEdad(45);
        assertEquals("adulto", resultado);
    }

    @Test
    @DisplayName("Devuelve 'mayor senior' si la edad es mayor de 65")
    void clasificarEdad_conEdadMayor65_devuelveMayorSenior() {
        String resultado = validadorEdad.clasificarEdad(70);
        assertEquals("mayor senior", resultado);
    }

    @Test
    @DisplayName("Lanza excepción si la edad es negativa")
    void clasificarEdad_conEdadNegativa_lanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> {
            validadorEdad.clasificarEdad(-5);
        });
    }

}
