import Utils.Utils;
import Verificador.*;
import java.util.ArrayList;
import java.util.List;

public class App { 
    public static void main(String[] args) throws Exception {

        // SEQUENCIAL
        System.out.println("Resultados sequenciais: ");
        long startTotalSeq = System.currentTimeMillis();
        
        long startReadSeq = System.currentTimeMillis();
        List<Integer> numeros = Utils.lerArquivo("Entrada01.txt");
        long endReadSeq = System.currentTimeMillis();

        long startProcessSeq = System.currentTimeMillis();
        VerificadorPrimosSequencial sequencialVerificador = new VerificadorPrimosSequencial();
        sequencialVerificador.Verifique(numeros);
        long endProcessSeq = System.currentTimeMillis();

        long startWriteSeq = System.currentTimeMillis();
        Utils.escreverArquivo("Saidas/SaidaSequencial.txt", sequencialVerificador.primos);
        long endWriteSeq = System.currentTimeMillis();

        long endTotalSeq = System.currentTimeMillis();

        System.out.println("Tempo total sequencial: " + (endTotalSeq - startTotalSeq) + " ms");
        System.out.println("Tempo leitura: " + (endReadSeq - startReadSeq) + " ms");
        System.out.println("Tempo processamento: " + (endProcessSeq - startProcessSeq) + " ms");
        System.out.println("Tempo escrita: " + (endWriteSeq - startWriteSeq) + " ms");

        // PARALELO 5 THREADS
        System.out.println("\nResultados paralelos com 5 threads: ");
        long startTotal5 = System.currentTimeMillis();

        long startRead5 = System.currentTimeMillis();
        List<Integer> numeros5 = Utils.lerArquivo("Entrada01.txt");
        long endRead5 = System.currentTimeMillis();

        long startProcess5 = System.currentTimeMillis();
        VerficadorPrimosParalelo verificador5 = new VerficadorPrimosParalelo(numeros5);
        List<Thread> threads5 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> verificador5.loopThread(), "Thread " + i);
            threads5.add(thread);
            thread.start();
        }
        Utils.esperarThreads(threads5);
        long endProcess5 = System.currentTimeMillis();

        long startWrite5 = System.currentTimeMillis();
        Utils.escreverArquivo("Saidas/SaidaParalelo5.txt", verificador5.primos);
        long endWrite5 = System.currentTimeMillis();

        long endTotal5 = System.currentTimeMillis();

        System.out.println("Tempo total paralelo (5 threads): " + (endTotal5 - startTotal5) + " ms");
        System.out.println("Tempo leitura: " + (endRead5 - startRead5) + " ms");
        System.out.println("Tempo processamento: " + (endProcess5 - startProcess5) + " ms");
        System.out.println("Tempo escrita: " + (endWrite5 - startWrite5) + " ms");

        // PARALELO 10 THREADS
        System.out.println("\nResultados paralelos com 10 threads: ");
        long startTotal10 = System.currentTimeMillis();

        long startRead10 = System.currentTimeMillis();
        List<Integer> numeros10 = Utils.lerArquivo("Entrada01.txt");
        long endRead10 = System.currentTimeMillis();

        long startProcess10 = System.currentTimeMillis();
        VerficadorPrimosParalelo verificador10 = new VerficadorPrimosParalelo(numeros10);
        List<Thread> threads10 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> verificador10.loopThread(), "Thread " + i);
            threads10.add(thread);
            thread.start();
        }
        Utils.esperarThreads(threads10);
        long endProcess10 = System.currentTimeMillis();

        long startWrite10 = System.currentTimeMillis();
        Utils.escreverArquivo("Saidas/SaidaParalelo10.txt", verificador10.primos);
        long endWrite10 = System.currentTimeMillis();

        long endTotal10 = System.currentTimeMillis();

        System.out.println("Tempo total paralelo (10 threads): " + (endTotal10 - startTotal10) + " ms");
        System.out.println("Tempo leitura: " + (endRead10 - startRead10) + " ms");
        System.out.println("Tempo processamento: " + (endProcess10 - startProcess10) + " ms");
        System.out.println("Tempo escrita: " + (endWrite10 - startWrite10) + " ms");
    }
}
