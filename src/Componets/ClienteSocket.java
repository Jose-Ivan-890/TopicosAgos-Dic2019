package Componets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

public class ClienteSocket {
InetAddress direccion;
Socket cliente;
byte [] ip = new byte[]{(byte )192,(byte )168,(byte )43,(byte )26};

    public ClienteSocket() {
        try {
            direccion=InetAddress.getByAddress(ip);
            cliente=new Socket(direccion,5000);
            // paso 2
            BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            System.out.println(entrada.readLine());

            //paso 3


            PrintStream salida=new PrintStream(cliente.getOutputStream());
            salida.println("Tengo Hambre >.< ");

        }catch (Exception io){}
    }
}
