/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package willpatcher;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import static java.lang.System.in;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author supmac
 */
public class Willpatcher extends JPanel {

    /**
     * @param args the command line arguments
     *
     */
    public static void main(String[] args) throws MalformedURLException, IOException, URISyntaxException {
        // TODO code application logic here
        version verify_version = new version();
        String caminho = null;
        tela jn = new tela();
        jn.setLocationRelativeTo(null);
        jn.setVisible(true);

        if (!"12".equals(verify_version.getversion())) {
            JOptionPane.showMessageDialog(null, "Seu Patcher precisa ser atualizado!  Após clicar em OK o Patch será atualizado.");

            caminho = Willpatcher.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
            caminho = caminho.substring(1, caminho.lastIndexOf('/') + 1);
            System.out.println(caminho);

            try {
                String url2 = "http://mmobrazil.com/patcher_files/Willpatcher.jar";
                URL url3 = new URL(url2);
                URLConnection conn = url3.openConnection();
                InputStream in2 = conn.getInputStream();
                FileOutputStream out = new FileOutputStream(caminho + "/Willpatcher.jar");
                byte[] b = new byte[1024];
                int count;
                while ((count = in2.read(b)) >= 0) {
                    out.write(b, 0, count);
                }
                out.flush();
                out.close();
                JOptionPane.showMessageDialog(null, "Patcher atualizado com sucesso! Favor abrir o novo Patcher salvo em " + caminho + "Willpatcher.jar");
                in.close();
                System.exit(0);

            } catch (IOException e) {
                e.printStackTrace();
                System.exit(0);

            }

        }

    }

}
