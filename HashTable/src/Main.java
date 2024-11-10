import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        String filePath = "HashTable/src/Resources/female_names.txt";
        int tableSize = 100;

        HashTable hashTableSOMA = new HashTableSoma(tableSize);
        HashTable hashTableTAMANHO = new HashTableTamanho(tableSize);

        readTxt(filePath, hashTableSOMA);
        readTxt(filePath, hashTableTAMANHO);

        hashTableSOMA.printTable();
        hashTableTAMANHO.printTable();

    }

    public static void readTxt(String filePath, HashTable hashTable) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                hashTable.insert(line);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

}