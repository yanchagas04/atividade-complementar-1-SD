import Utils.Resultado;
import Utils.Utils;
import Verificador.*;
import java.util.List;

public class App { 
    public static void main(String[] args) throws Exception {
        //SEQUENCIAL
        System.out.println("Resultados sequenciais: ");
        List<Integer> numeros = Utils.lerArquivo("Entrada01.txt");
        Resultado resultado = VerificadorPrimosSequencial.Verifique(numeros);
        System.out.println("Tempo sequencial: " + resultado.tempo + " ms");
        Utils.escreverArquivo("src/Saidas/SaidaSequencial.txt", resultado.primos);

        //PARALELO 5
        System.out.println("\nResultados paralelos com 5 threads: ");
        Verificador.VerficadorPrimosParalelo verificador5 = new Verificador.VerficadorPrimosParalelo(numeros);
        long start5 = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> verificador5.loopThread(), "Thread " + i).start();
        }
        long end5 = System.currentTimeMillis();
        long tempo5 = end5 - start5;
        System.out.println("Tempo paralelo com 5 threads: " + tempo5 + " ms");
        Utils.escreverArquivo("src/Saidas/SaidaParalelo5.txt", resultado.primos);

        Thread.sleep(1000);

        //PARALELO 10
        System.out.println("\nResultados paralelos com 10 threads: ");
        Verificador.VerficadorPrimosParalelo verificador10 = new Verificador.VerficadorPrimosParalelo(numeros);
        long start10 = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> verificador10.loopThread(), "Thread " + i).start();
        }
        long end10 = System.currentTimeMillis();
        long tempo10 = end10 - start10;
        System.out.println("Tempo paralelo com 10 threads: " + tempo10 + " ms");
        Utils.escreverArquivo("src/Saidas/SaidaParalelo10.txt", resultado.primos);
    }
}
