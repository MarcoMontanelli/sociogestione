package socigestionep;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
class gestioneSociTest {


    private gestioneSoci circolo;

    @BeforeEach
    void setUp() {
        circolo = new gestioneSoci();
    }

    @Test
    void testAggiungiSocio() {
        Socio socio = new Socio("Mario", "Rossi", 30, 'M');
        circolo.aggiungiSocio(socio);

        assertEquals(1, circolo.getSoci().size());
        assertTrue(circolo.getSoci().contains(socio));
    }

    @Test
    void testModificaSocio() {
        Socio socio = new Socio("Mario", "Rossi", 30, 'M');
        circolo.aggiungiSocio(socio);

        Socio socioDaModificare = circolo.getSoci().get(0);
        circolo.modificaSocio(socioDaModificare, "NuovoNome", "NuovoCognome", 40);

        assertEquals("NuovoNome", socioDaModificare.getNome());
        assertEquals("NuovoCognome", socioDaModificare.getCognome());
        assertEquals(40, socioDaModificare.getEta());
        assertEquals('F', socioDaModificare.getSesso());
    }

    @Test
    void testRimuoviSocio() {
        Socio socio = new Socio("Mario", "Rossi", 30, 'M');
        circolo.aggiungiSocio(socio);

        assertEquals(1, circolo.getSoci().size());

        Socio socioDaRimuovere = circolo.getSoci().get(0);
        circolo.rimuoviSocio(socioDaRimuovere);

        assertEquals(0, circolo.getSoci().size());
    }

    @Test
    void testIncrementaEtaDiTutti() {
        Socio socio1 = new Socio("Mario", "Rossi", 30, 'M');
        Socio socio2 = new Socio("Anna", "Verdi", 25, 'F');
        circolo.aggiungiSocio(socio1);
        circolo.aggiungiSocio(socio2);

        circolo.incrementaEtaDiTutti();

        assertEquals(31, socio1.getEta());
        assertEquals(26, socio2.getEta());
    }
}
