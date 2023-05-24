import java.io.DataInputStream;
import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    static ArrayList<String> listf1t2 = new ArrayList<>();
    static ArrayList<String> listf2t1 = new ArrayList<>();

    public static void main(String[] args) {
        try {
            System.out.println("Server is running");
            int port = 3333;
            ServerSocket ss = new ServerSocket(port);
            while (true) {
                Socket s = ss.accept();
                ServerConnectionProcessor p = new ServerConnectionProcessor(s, listf1t2, listf2t1);
                p.start();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class ServerConnectionProcessor extends Thread {
    private Socket sock;
    ArrayList<String> listf1t2;
    ArrayList<String> listf2t1;

    public ServerConnectionProcessor(Socket s, ArrayList<String> listf1t2, ArrayList<String> listf2t1) {
        this.listf1t2 = listf1t2;
        this.listf2t1 = listf2t1;
        this.sock = s;
    }

    public void run() {
        try {
            // Получает запрос
            DataInputStream dataInputStream = new DataInputStream(sock.getInputStream());
            int numberClient = dataInputStream.readInt();
            boolean isReading;
            isReading = dataInputStream.readBoolean();
            if (numberClient == 1) {
                if (!isReading) {
                    while (true) {
                        ObjectInputStream objectInputStream = new ObjectInputStream(sock.getInputStream());
                        String chikChirik = (String) objectInputStream.readObject();
                        if (chikChirik == null)
                            break;
                        listf1t2.add(chikChirik);
                    }
                }
                if (isReading) {
                    for (String oK : listf2t1) {
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(sock.getOutputStream());
                        objectOutputStream.writeObject(oK);
                    }
                }
            }
            if (numberClient == 2) {
                if (!isReading) {
                    while (true) {
                        ObjectInputStream objectInputStream = new ObjectInputStream(sock.getInputStream());
                        String chikChirik = (String) objectInputStream.readObject();
                        if (chikChirik == null)
                            break;
                        listf2t1.add(chikChirik);
                    }
                }
                if (isReading) {
                    for (String oK : listf1t2) {
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(sock.getOutputStream());
                        objectOutputStream.writeObject(oK);
                    }
                }
            }

            dataInputStream.close();
            sock.close();
        } catch (EOFException ignored) {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
