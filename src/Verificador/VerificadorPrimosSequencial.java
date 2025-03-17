package Verificador;
import Utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class VerificadorPrimosSequencial {
    public List <Integer> primos;

    public VerificadorPrimosSequencial() {
        primos = new ArrayList<>();
    }

    public void Verifique(List<Integer> numeros) {
        for (Integer numero : numeros) {
            if (Utils.ehPrimo(numero)) {
                primos.add(numero);
            }
        }
    }

}
