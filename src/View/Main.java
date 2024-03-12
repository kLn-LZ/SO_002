package View;

import Controller.KillController;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        KillController KC = new KillController();


        Scanner scan = new Scanner(System.in);
        String opc;

        do {
            System.out.print("MENU \n 1) Listar processos  \n 2) Matar PID \n 3) Matar Nome do Processo \n 9) Encerrar \n Escolha uma opção:");
            opc = scan.next();

            switch (opc) {
                case "1": KC.listaProcessos();
                    break;
                case "2":
                    System.out.print("Insira o PID: ");
                    int PID = scan.nextInt();
                    KC.mataPid(PID);
                    break;
                case "3":
                    System.out.print("Insira o nome do processo: ");
                    String nomeProcesso = scan.next();
                    KC.mataNome(nomeProcesso);
                    break;
                case "9":System.out.println("Aplicação Encerrada");
                    break;
                default:System.out.println("Opção inválida");

                    break;
            }
        } while(!(opc.contains("9")));
    }
}
