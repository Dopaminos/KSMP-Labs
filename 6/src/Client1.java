import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client1 {
    public static void main(String[] args) {
        // Имя хоста и номер порта
        String host = "localhost";
        int port = 3333; // Протокол передачи
        int numberClient = 1;
        ArrayList<String> list1 = new ArrayList<>(List.of("Samara", "Belgrade", "Moscow", "Shebekino"));
        read(host, port, numberClient, list1);
        System.out.println("Полученные настройки:");
        for (String setting : list1) {
            System.out.println(setting);
        }
    }

    static void read(String host, int port, int numberClient, ArrayList<String> list1) {
        boolean isReading;
        System.out.println(list1);
        try {
            System.out.println("Client is running");
            System.out.println("Введите true или false");
            Scanner scan = new Scanner(System.in);
            isReading = scan.nextBoolean();
            Socket sock = new Socket(host, port);
            if (!isReading) {
                DataOutputStream dataOutputStream = new DataOutputStream(sock.getOutputStream());

                dataOutputStream.writeInt(numberClient);
                dataOutputStream.writeBoolean(false);
                for (String str1 : list1) {
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(sock.getOutputStream());
                    objectOutputStream.writeObject(str1);
                }
            }
            if (isReading) {

                DataOutputStream dataOutputStream = new DataOutputStream(sock.getOutputStream());
                dataOutputStream.writeInt(numberClient);
                dataOutputStream.writeBoolean(true);
                for (int i = 0; i < 4; i++) {
                    ObjectInputStream objectInputStream = new ObjectInputStream(sock.getInputStream());
                    String d = (String) objectInputStream.readObject();
                    System.out.println(d);
                    list1.add(d);
                }
            }
            sock.close();
        } catch (EOFException ignored) {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
