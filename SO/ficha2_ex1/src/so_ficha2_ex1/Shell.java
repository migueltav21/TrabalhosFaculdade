
import java.io.*;

public class Shell {
    public static void main(String[] args) throws IOException {
        boolean open = false;
        FileReader fileReader = null;

        try {
            fileReader = new FileReader("comandos.txt");
            open = true;
        } catch (FileNotFoundException e) {
            FileWriter fileWriter = new FileWriter("comandos.txt");
            fileWriter.write("ipconfig");
            fileWriter.write("systeminfo");
            fileWriter.close();
        }
        try {
            // Abre o arquivo "exemplo.txt" para leitura
            if (!open) {
                fileReader = new FileReader("comandos.txt");
            }
            BufferedReader reader = new BufferedReader(fileReader);

            String line;
            while ((line = reader.readLine()) != null) {

                try {
                    ProcessBuilder pb = new ProcessBuilder(line);
                    Process process = pb.start();

                    InputStream is = process.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is);
                    BufferedReader br = new BufferedReader(isr);

                    while ( (line = br.readLine()) != null) {
                        System.out.println(line);
                    }
                    br.close();

                    process.waitFor();
                } catch (InterruptedException ignored) {}

            }

            // Fecha o arquivo após a leitura
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}