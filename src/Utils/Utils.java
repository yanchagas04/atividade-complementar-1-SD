package Utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public final class Utils {
    public static List<Integer> lerArquivo(String arquivo) throws Exception {
        List<Integer> numeros = new ArrayList<>();
        try (BufferedReader leitor = new BufferedReader(new FileReader(arquivo))) {
            while (leitor.ready()) {
                numeros.add(Integer.valueOf(leitor.readLine()));
            }
        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return numeros;
    }

    public static void escreverArquivo(String arquivo, List<Integer> numeros) throws Exception {
        try (BufferedWriter gravador = new BufferedWriter(new FileWriter(arquivo))) {
            for (Integer numero : numeros) {
                gravador.write(String.valueOf(numero) + "\n");
            }
        } catch (Exception e) {
            System.out.println("Erro ao gravar o arquivo: " + e.getMessage());
        }
    }

    public static boolean ehPrimo(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

}