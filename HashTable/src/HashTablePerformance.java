import java.util.List;

public class HashTablePerformance {
    private double insertTime;
    private double searchTime;
    private double totalTime;

    public HashTablePerformance() {
        this.insertTime = 0;
        this.searchTime = 0;
        this.totalTime = 0;
    }

    public void measureInsertTime(HashTable hashTable, List<String> names) {
        long startInsert = System.nanoTime();
        for (String name : names) {
            hashTable.insert(name);
        }
        long endInsert = System.nanoTime();
        this.insertTime = (endInsert - startInsert) / 1_000_000_000.0;
    }

    public void measureSearchTime(HashTable hashTable, List<String> names) {
        long startSearch = System.nanoTime();
        for (String name : names) {
            hashTable.search(name);
        }
        long endSearch = System.nanoTime();
        this.searchTime = (endSearch - startSearch) / 1_000_000_000.0;
        this.totalTime = this.insertTime + this.searchTime;
    }

    public double getInsertTime() { return insertTime; }
    public double getSearchTime() { return searchTime; }
    public double getTotalTime() { return totalTime; }
}
