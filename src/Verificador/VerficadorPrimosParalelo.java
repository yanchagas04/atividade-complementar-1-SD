package Verificador;
import Utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class VerficadorPrimosParalelo extends Object {

    public List<Integer> numeros;
    public List<Integer> primos = new ArrayList<>();
    private int currentIndex = 0;

    public VerficadorPrimosParalelo(List<Integer> numeros) throws Exception {
        this.numeros = numeros;
    }

    public void loopThread() {
        int numerosAnalisados = 0;
        while (true) {
            try {
                verificarProximoNumero();
                numerosAnalisados++;
            } catch (Exception e) {
                break;
            }
        }
        System.out.println("Thread " + Thread.currentThread().getName() + " analisou " + numerosAnalisados + " numeros.");
    }

    public synchronized void verificarProximoNumero() throws Exception {
        try {
            //System.out.println("Thread " + Thread.currentThread().getName() + " verificou o número " + numeros.get(currentIndex));
            if (Utils.ehPrimo(numeros.get(currentIndex))) {
                primos.add(numeros.get(currentIndex));
            }
            currentIndex++;
        } catch (Exception e) {
            throw new Exception("Todos os números analisados");
        }
    }
}
