import java.io.*;
import java.net.URL;
import java.util.*;

public class PBO4 {

    public static void main(String[] args) {
        String url = "https://drive.google.com/uc?export=download&id=14DWF2kG0hGD3hYJjAcsexOCGedVfrv3r";

        List<Product> listProduct = new ArrayList<>();
        Set<String> negaraPelanggan = new HashSet<>();
        Map<String, Integer> totalProdukTerjual = new HashMap<>();
        Map<String, Double> totalPendapatanNegara = new HashMap<>();
        Map<String, Product> productStockCode = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream()))) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                if (firstLine) { //skip harder
                    firstLine = false;
                    continue;
                }

            String[] values = line.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");
            
            String invoiceNo = values[0].trim();
            String stockCode = values[1].trim();
            String description = values[2].trim();
            int quantity = Integer.parseInt(values[3].trim());
            String invoiceDate = values[4].trim();
            double unitPrice = Double.parseDouble(values[5].trim());
            String customerId = values[6].trim();
            String negara = values[7].trim();

            Product product = new Product(invoiceNo, stockCode, description, quantity, invoiceDate, unitPrice, customerId, negara);

            negaraPelanggan.add(negara);
            listProduct.add(product);
            totalProdukTerjual.put(stockCode, totalProdukTerjual.getOrDefault(stockCode, 0) + quantity);
            totalPendapatanNegara.put(negara, totalPendapatanNegara.getOrDefault(negara, 0.0) + Product.getUnitPrice());
            productStockCode.put(stockCode, product);
            }

            System.out.println("Dataset berhasil dibaca! Jumlah baris: " + listProduct.size());
            System.out.println("\n=== Negara ===");
            System.out.println(negaraPelanggan);

            System.out.println("\n=== Total Pendapatan Negara ===");
            totalPendapatanNegara.forEach((negara, money) -> System.out.println("Negara:" + negara + " -> $" + money));
            
            System.out.println("\n=== Product ===");
            listProduct.stream().limit(5).forEach(System.out::println);

            System.out.println("\n=== Product Stock Code ===");
            if(productStockCode.containsKey("85123A")) {
                System.out.println(productStockCode.get("85123A"));
            } else {
                System.out.println("Produk tidak ditemukan.");
            }
           
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
