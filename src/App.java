import Utils.Utils;
import Verificador.*;
import java.util.ArrayList;
import java.util.List;

public class App { 
    public static void main(String[] args) throws Exception {

        //SEQUENCIAL
        System.out.println("Resultados sequenciais: ");
        long start = System.currentTimeMillis();
        VerificadorPrimosSequencial sequencialVerificador = new VerificadorPrimosSequencial();
        List<Integer> numeros = Utils.lerArquivo("Entrada01.txt");
        Thread sequencial = new Thread(() -> sequencialVerificador.Verifique(numeros), "Sequencial");
        sequencial.start();
        sequencial.join();
        Utils.escreverArquivo("Saidas/SaidaSequencial.txt", sequencialVerificador.primos);
        long end = System.currentTimeMillis();
        long tempo = end - start;
        System.out.println("Tempo sequencial: " + tempo + " ms");
        
        //PARALELO 5
        System.out.println("\nResultados paralelos com 5 threads: ");
        long start5 = System.currentTimeMillis();
        List<Thread> threads5 = new ArrayList<>();
        List<Integer> numeros5 = Utils.lerArquivo("Entrada01.txt");
        Verificador.VerficadorPrimosParalelo verificador5 = new Verificador.VerficadorPrimosParalelo(numeros5);
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> verificador5.loopThread(), "Thread " + i);
            threads5.add(thread);
            thread.start();
        }
        while (true) {
            int count = 0;
            for (Thread thread : threads5) {
                if (!thread.isAlive()) {
                    count++;
                }
            }
            if (count == threads5.size()) {
                break;
            }
        }
        Utils.escreverArquivo("Saidas/SaidaParalelo5.txt", verificador5.primos);
        long end5 = System.currentTimeMillis();
        long tempo5 = end5 - start5;
        System.out.println("Tempo paralelo com 5 threads: " + tempo5 + " ms");

        //PARALELO 10
        System.out.println("\nResultados paralelos com 10 threads: ");
        List<Integer> numeros10 = Utils.lerArquivo("Entrada01.txt");
        Verificador.VerficadorPrimosParalelo verificador10 = new Verificador.VerficadorPrimosParalelo(numeros10);
        List<Thread> threads10 = new ArrayList<>();
        long start10 = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> verificador10.loopThread(), "Thread " + i);
            threads10.add(thread);
            thread.start();
        }
        while (true) {
            int count = 0;
            for (Thread thread : threads10) {
                if (!thread.isAlive()) {
                    count++;
                }
            }
            if (count == threads10.size()) {
                break;
            }
        }
        Utils.escreverArquivo("Saidas/SaidaParalelo10.txt", verificador10.primos);
        long end10 = System.currentTimeMillis();
        long tempo10 = end10 - start10;
        System.out.println("Tempo paralelo com 10 threads: " + tempo10 + " ms");
    }
}
