import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Testando se o programa funciona."); 
        List<String> names = loadNames("female_names.txt");

        if (names.isEmpty()) {
            System.out.println("Nenhum nome foi carregado. Verifique o caminho do arquivo.");
            return;
        }

        HashTable hashTable1 = new FuncaoNormal();
        HashTable hashTable2 = new FuncaoASCII();

        HashTablePerformance performance1 = new HashTablePerformance();
        performance1.measureInsertTime(hashTable1, names);
        performance1.measureSearchTime(hashTable1, names);

        HashTablePerformance performance2 = new HashTablePerformance();
        performance2.measureInsertTime(hashTable2, names);
        performance2.measureSearchTime(hashTable2, names);

        System.out.println("\nTabela Hash 1:");
        hashTable1.displayDistribution();

        System.out.println("\nTabela Hash 2:");
        hashTable2.displayDistribution();

        System.out.println("\nComparação entre as Funções Hash:");
        System.out.println("--------------------------------------------------------");
        System.out.println("| Métrica          | HashTable 1  | HashTable 2  | Melhor |");
        System.out.println("--------------------------------------------------------");
        System.out.printf("| Colisões         | %-12d | %-12d | %-6s |\n",
                hashTable1.countCollisions(),
                hashTable2.countCollisions(),
                hashTable1.countCollisions() < hashTable2.countCollisions() ? "HT1" :
                hashTable1.countCollisions() > hashTable2.countCollisions() ? "HT2" : "Empate");
        System.out.printf("| Tempo Inserção   | %-12.9f | %-12.9f | %-6s |\n",
                performance1.getInsertTime(), performance2.getInsertTime(),
                performance1.getInsertTime() < performance2.getInsertTime() ? "HT1" : "HT2");
        System.out.printf("| Tempo Busca      | %-12.9f | %-12.9f | %-6s |\n",
                performance1.getSearchTime(), performance2.getSearchTime(),
                performance1.getSearchTime() < performance2.getSearchTime() ? "HT1" : "HT2");
        System.out.printf("| Tempo Total      | %-12.9f | %-12.9f | %-6s |\n",
                performance1.getTotalTime(), performance2.getTotalTime(),
                performance1.getTotalTime() < performance2.getTotalTime() ? "HT1" : "HT2");
        System.out.println("--------------------------------------------------------");
    }

    public static List<String> loadNames(String filePath) {
        List<String> names = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    names.add(line.trim());
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar o arquivo: " + e.getMessage());
            e.printStackTrace();
        }
        return names;
    }
}
