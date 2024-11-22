package Model;

import java.net.*;
import java.io.*;

public class GetPublicIp {
    public static void getIP() {
        try {
            //Get URL
            URL url = new URL("https://api.ipify.org");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            //This method get the call with the web
            connection.setRequestMethod("GET");

            //Read the line of the web where is the ip
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Mostrar la IP pública
            System.out.println("IP pública: " + response.toString());
        } catch (IOException e) {
            System.out.println("Error al obtener la IP pública: " + e.getMessage());
        }
    }
}
