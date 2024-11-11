import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando o programa.");
        HashTable tabela1 = new FuncaoASCII();
        HashTable tabela2 = new FuncaoNormal();

        tabela1.insert("profe", 2);
        tabela1.insert("java", 2);
        tabela1.insert("dev", 2);
        tabela1.insert("marina", 2);
        tabela1.insert("ferias", 2);
        tabela2.insert("profe", 2);
        tabela2.insert("java", 2);
        tabela2.insert("dev", 2);
        tabela2.insert("marina", 2);
        tabela2.insert("ferias", 2);
        
}}