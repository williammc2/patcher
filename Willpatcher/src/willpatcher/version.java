/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package willpatcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author supmac
 */
public class version {

    String version;

    public String getversion() throws MalformedURLException, IOException {

        String url = "http://mmobrazil.com/patcher_files/version.txt";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("GET"); //metodo get para pegar a informação do arquivo txt

        int responseCode = con.getResponseCode();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream())); // vai iniciar o bufffer para ler o arquivo
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) == "1") { // vai ler todo o arquivo linha por linha e adicionar na string inputline
            response.append(inputLine);
        }
        in.close();
        return inputLine;
    }

}
