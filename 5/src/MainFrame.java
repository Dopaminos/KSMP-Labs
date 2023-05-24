import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class ComputeRects implements Runnable {
    private final MainFrame parent;
    private final int oR = (int) (Math.random() * 400);

    public ComputeRects(MainFrame parentObj) {
        parent = parentObj;
    }

    @Override
    public void run() {
        while (true) {
            if (!parent.isRectsStopped()) {
                long timeNow1 = System.currentTimeMillis() / 10;
                double oS = Math.PI / 16;
                double rad = oS * timeNow1;
                int xStart = 400;
                double drawX = xStart + oR * Math.cos(rad);
                int yStart = 400;
                double drawY = yStart + oR * Math.sin(rad);
                parent.setRectCoordinates((int) drawX, (int) drawY);
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(ComputeRects.class.getName()).log(Level.SEVERE, null, ex);
                Thread.currentThread().interrupt(); // Restore the interrupted status
            }
        }
    }
}

class ComputeOvals implements Runnable {
    private final MainFrame parent;
    private int xStart = 200, yStart = 200;
    private boolean toTop = true, toRight = true;

    public ComputeOvals(MainFrame parentObj) {
        parent = parentObj;
    }

    @Override
    public void run() {
        while (true) {
            if (!parent.isOvalsStopped()) {
                long timeNow = System.currentTimeMillis() / 1000;
                if (timeNow % 4 == 0) {
                    toTop = !toTop;
                }
                if (timeNow % 5 == 0) {
                    toRight = !toRight;
                }
                if (toTop) {
                    yStart -= 10;
                } else {
                    yStart += 10;
                }
                if (toRight) {
                    xStart += 10;
                } else {
                    xStart -= 10;
                }
                parent.setOvalCoordinates(xStart, yStart);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ComputeOvals.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

public class MainFrame extends JFrame {
    private Thread rectsThread;
    private Thread ovalsThread;
    private int rectX = 0, rectY = 0, ovalX = 0, ovalY = 0;
    private boolean stopRects = false;
    private boolean stopOvals = false;

    public MainFrame() {
        super("Thread 2");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1080, 720);
    }

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setVisible(true);
        frame.startThreads();

        Button stopper1 = new Button("Stop Circle");
        stopper1.setLocation(0, 0);
        stopper1.setSize(100, 50);
        stopper1.addActionListener(e -> frame.stopOvalsThread());

        Button player1 = new Button("Play Circle");
        player1.setLocation(100, 0);
        player1.setSize(100, 50);
        player1.addActionListener(e -> frame.resumeOvalsThread());

        Button stopper2 = new Button("Stop Square");
        stopper2.setLocation(0, 100);
        stopper2.setSize(100, 50);
        stopper2.addActionListener(e -> frame.stopRectsThread());

        Button player2 = new Button("Play Square");
        player2.setLocation(100, 100);
        player2.setSize(100, 50);
        player2.addActionListener(e -> frame.resumeRectsThread());

        frame.setLayout(null);
        frame.add(stopper1);
        frame.add(stopper2);
        frame.add(player1);
        frame.add(player2);
    }

    public synchronized void setRectCoordinates(int x, int y) {
        rectX = x;
        rectY = y;
        repaint();
    }

    public synchronized void setOvalCoordinates(int x, int y) {
        ovalX = x;
        ovalY = y;
        repaint();
    }

    public synchronized boolean isRectsStopped() {
        return stopRects;
    }

    public synchronized boolean isOvalsStopped() {
        return stopOvals;
    }

    public void startThreads() {
        rectsThread = new Thread(new ComputeRects(this));
        ovalsThread = new Thread(new ComputeOvals(this));
        rectsThread.start();
        ovalsThread.start();
    }

    public void stopRectsThread() {
        stopRects = true;
    }

    public void stopOvalsThread() {
        stopOvals = true;
    }

    public void resumeRectsThread() {
        if (stopRects) {
            stopRects = false;
            rectsThread = new Thread(new ComputeRects(this));
            rectsThread.start();
        }
    }

    public void resumeOvalsThread() {
        if (stopOvals) {
            stopOvals = false;
            ovalsThread = new Thread(new ComputeOvals(this));
            ovalsThread.start();
        }
    }

    @Override
    public void paint(Graphics g) {
        int w = getWidth(), h = getHeight();
        g.clearRect(0, 0, w, h);
        g.setColor(Color.red);
        g.fillRect(rectX, rectY, 20, 20);
        g.setColor(Color.blue);
        g.fillOval(ovalX, ovalY, 20, 20);
    }
}
