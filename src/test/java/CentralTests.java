import Dados.GrauAlerta;
import Observers.Central;
import Observers.Medidor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CentralTests {
    @Test
    void deveNotificarCentral(){
        Central central = new Central();
        Medidor medidor = new Medidor(5800f, 7845, GrauAlerta.Amarelo);
        central.conectar(medidor);
        medidor.dispararAviso();
        assertEquals("Alerta: Amarelo\nSetor: 7845 | Pressao: 5800.0" + "\nPorcentagem acima do esperado: 38.10%", central.getNotificacao());
    }

    @Test
    void naoDeveNotificarCentral(){
        //medidor nao conectado a usina
        Central central = new Central();
        Medidor medidor = new Medidor(5800f, 7845, GrauAlerta.Amarelo);
        medidor.dispararAviso();
        assertEquals(null, central.getNotificacao());
    }

}
