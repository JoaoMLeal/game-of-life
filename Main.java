import java.io.IOException;

/**
 * Created by joao on 07-07-2017.
 */
public class Main {

    public static void main(String[] args) {
        Game g = new Game(40, 40);
        gliderGun(g);
        for(int i = 0; i < 3000; i++) {
            clearScreen();
            System.out.println(g);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            g.makeTurn();
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void makeGlider(Game g) {
        int startX = g.getLength()/2;
        int startY = g.getWidth()/2;
        g.addCell(startX,startY-2);
        g.addCell(startX,startY-1);
        g.addCell(startX,startY);
        g.addCell(startX-1,startY);
        g.addCell(startX-2,startY-1);
    }

    public static void gliderGun(Game g) {
        g.addCell(2,7);
        g.addCell(2,8);
        g.addCell(3,7);
        g.addCell(3,8);

        g.addCell(12,7);
        g.addCell(12,8);
        g.addCell(12,9);
        g.addCell(13,6);
        g.addCell(13,10);
        g.addCell(14,5);
        g.addCell(15,5);
        g.addCell(14,11);
        g.addCell(15,11);
        g.addCell(16,8);
        g.addCell(17,6);
        g.addCell(17,10);
        g.addCell(18,7);
        g.addCell(18,8);
        g.addCell(18,9);
        g.addCell(19,8);

        g.addCell(22,7);
        g.addCell(22,6);
        g.addCell(22,5);
        g.addCell(23,7);
        g.addCell(23,6);
        g.addCell(23,5);
        g.addCell(24,8);
        g.addCell(24,4);
        g.addCell(26,8);
        g.addCell(26,4);
        g.addCell(26,9);
        g.addCell(26,3);

        g.addCell(36,5);
        g.addCell(36,6);
        g.addCell(37,6);
        g.addCell(37,6);

    }

}
