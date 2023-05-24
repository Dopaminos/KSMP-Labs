import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) {
        // Имя хоста и номер порта
        String host = "localhost";
        int port = 3333; // Протокол передачи
        int numberClient = 2;
        boolean isReading;
        ArrayList<String> list2 = new ArrayList<>(List.of("Krasnodar", "New-York", "Berlin", "Tokio"));
        Client1.read(host, port, numberClient, list2);
        System.out.println("Полученные настройки:");
        for (String setting : list2) {
            System.out.println(setting);
        }
    }
}
