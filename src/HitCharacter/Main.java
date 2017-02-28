package HitCharacter;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        Frame f = new Frame();
        f.setSize(300, 400);

        MyPanel mp = new MyPanel();
        f.add(mp);

        Thread t = new Thread(mp);
        t.start();

        f.addKeyListener(mp);
        mp.addKeyListener(mp);

        f.show();
    }
}
