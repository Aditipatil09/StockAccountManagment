import java.util.ArrayList;
import java.util.Scanner;

class Stock {
    String name;
    int numShares;
    double sharePrice;

    public Stock(String name, int numShares, double sharePrice) {
        this.name = name;
        this.numShares = numShares;
        this.sharePrice = sharePrice;
    }

    public double calculateStockValue() {
        return numShares * sharePrice;
    }
}

class StockPortfolio {
    ArrayList<Stock> stocks = new ArrayList<>();

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public double calculateTotalPortfolioValue() {
        double totalValue = 0;
        for (Stock stock : stocks) {
            totalValue += stock.calculateStockValue();
        }
        return totalValue;
    }

    public void printStockReport() {
        System.out.println("\nStock Report:");
        System.out.printf("%-15s %-15s %-15s %-15s%n", "Stock Name", "Num of Shares", "Share Price", "Stock Value");
        System.out.println("-".repeat(60));
        for (Stock stock : stocks) {
            System.out.printf("%-15s %-15d %-15.2f %-15.2f%n", stock.name, stock.numShares, stock.sharePrice, stock.calculateStockValue());
        }
        System.out.println("-".repeat(60));
        System.out.println("Total Portfolio Value: " + calculateTotalPortfolioValue());
    }
}

class StockManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StockPortfolio portfolio = new StockPortfolio();

        System.out.print("Enter the number of stocks: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter Stock Name: ");
            String stockName = scanner.next();
            System.out.println("Enter Number of Shares: ");
            int numShares = scanner.nextInt();
            System.out.println("Enter Share Price: ");
            double sharePrice = scanner.nextDouble();

            Stock stock = new Stock(stockName, numShares, sharePrice);
            portfolio.addStock(stock);
        }

        portfolio.printStockReport();
    }
}
