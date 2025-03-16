package Verificador;
import Utils.Resultado;
import Utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class VerificadorPrimosSequencial {

    public static Resultado Verifique(List<Integer> numeros) throws Exception {
        List <Integer> primos = new ArrayList<>();
        long inicio = System.currentTimeMillis();
        for (Integer numero : numeros) {
            if (Utils.ehPrimo(numero)) {
                primos.add(numero);
            }
        }
        long fim = System.currentTimeMillis();
        long tempo = fim - inicio;
        return new Resultado(tempo, primos);
    }

}
