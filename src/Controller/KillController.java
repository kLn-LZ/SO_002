package Controller;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {

    public KillController() {

        super();

    }

    private String os() {

        String os = System.getProperty("os.name");

        return os;


    }

    public void listaProcessos() throws IOException {


        String vOs = os();

        if (vOs.contains("Windows")) {

            try {
                Process p = Runtime.getRuntime().exec("TASKLIST /FO TABLE");
                InputStream fluxo = p.getInputStream();
                InputStreamReader leitor = new InputStreamReader(fluxo);

                BufferedReader buffer = new BufferedReader(leitor);
                String linha = buffer.readLine();

                while (linha != null) {



                    System.out.println(linha);


                    linha = buffer.readLine();

                }

                buffer.close();
                leitor.close();
                fluxo.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }

        else if(vOs.contains("Linux")) {

            try {
                Process p = Runtime.getRuntime().exec("ps -ef");
                InputStream fluxo = p.getInputStream();
                InputStreamReader leitor = new InputStreamReader(fluxo);

                BufferedReader buffer = new BufferedReader(leitor);
                String linha = buffer.readLine();

                while (linha != null) {


                    System.out.println(linha);


                    linha = buffer.readLine();

                }

                buffer.close();
                leitor.close();
                fluxo.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }

    }


    public void mataPid(int PID) throws IOException {



        StringBuffer buffer = new StringBuffer();

        String vOs = os();

        if (vOs.contains("Windows")) {


            try {

                Runtime.getRuntime().exec("TASKKILL /PID " + PID);

                System.out.println(PID + " Killed");



            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }

        else if(vOs.contains("Linux")) {

            try {
                Runtime.getRuntime().exec("kill -9 " + PID);

                System.out.println(PID + " Killed");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }

    }


    public void mataNome(String nomeProcesso) throws IOException {



        StringBuffer buffer = new StringBuffer();

        String vOs = os();

        if (vOs.contains("Windows")) {


            try {

                Runtime.getRuntime().exec("TASKKILL /IM " + nomeProcesso);

                System.out.println(nomeProcesso + " Killed");



            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }

        else if(vOs.contains("Linux")) {

            try {
                Runtime.getRuntime().exec("pkill -f " + nomeProcesso);

                System.out.println(nomeProcesso + " Killed");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }

    }

}
