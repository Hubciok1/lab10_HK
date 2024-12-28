import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String inputFilePath = "src/file10.txt" ;  // Ścieżka do pliku źródłowego
        String outputFilePath = "src/file20.txt"; // Ścieżka do pliku docelowego

        // Konstrukcja try-with-resources zapewnia automatyczne zamykanie plików
        try
                (
                BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))
                )
        {
            String line;
            while ((line = reader.readLine()) != null) {
                // Zastąp wszystkie spacje myślnikami
                String modifiedLine = line.replace(" ", "-");
                // Zapisz zmodyfikowaną linię do pliku wyjściowego
                writer.write(modifiedLine);
                writer.newLine();  // Dodaj nową linię po każdej linii
            }
            System.out.println("Plik został pomyślnie skopiowany i zmodyfikowany.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Wydrukuj zawartość skopiowanego pliku
        System.out.println("\nZawartość orginalengo pliku:");
        printFileContent(inputFilePath);
        System.out.println("\nZawartość skopiowanego pliku:");
        printFileContent(outputFilePath);
    }

    // Metoda pomocnicza do drukowania zawartości pliku
    public static void printFileContent(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Błąd podczas odczytu pliku: " + filePath);
            e.printStackTrace();
        }
    }
}