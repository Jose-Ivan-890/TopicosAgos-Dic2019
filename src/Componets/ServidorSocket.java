package Componets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSocket {
    private ServerSocket servidor;
    private Socket cliente;
    private int noCliente;

    public ServidorSocket(){
        try { //siempre que se hacen recusos siempre se requiere utilizar IOExeption
            servidor = new  ServerSocket(5000);
            while (true){
                cliente=servidor.accept();
                noCliente ++;

                //paso 1
                System.out.println("llega mi cliento "+noCliente);
                PrintStream salida=new PrintStream(cliente.getOutputStream());
                salida.println("Bienvenido cliente "+noCliente);

                // paso 4
               // BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream())):
                BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                System.out.println(entrada.readLine());
            }
        }catch (Exception io){}
    }
}
