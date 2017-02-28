package HitCharacter;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by JiajieZhuo on 2017/2/27.
 */
public class MyPanel extends Panel implements Runnable, KeyListener {
    private int[] x = new int[10];
    private int[] y = new int[10];
    private char[] c = new char[10];
    private int score = 1000;

    public MyPanel() {
        for (int i = 0; i < 10; i++) {
            x[i] = (int)(Math.random() * 300);
            y[i] = (int)(Math.random() * 300);
            c[i] = (char)(Math.random() * 26 + 97);
        }
    }

    @Override
    public void paint(Graphics g) {
        for (int i = 0; i < 10; i++) {
            g.drawString(new Character(c[i]).toString(), x[i], y[i]);
        }
        g.setColor(Color.RED);
        g.drawString("Your score is " + score, 5, 15);
    }

    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 10; i++) {
                y[i]++;
                if (y[i] > 400) {
                    y[i] = 0;
                    x[i] = (int)(Math.random() * 300);
                    c[i] = (char)(Math.random() * 26 + 97);
                    score -= 100;
                }
            }

            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        char keyC = e.getKeyChar();
        int nowY = -1;
        int nowIndex = -1;

        for (int i = 0; i < 10; i++) {
            if (keyC == c[i]) {
                if (y[i] > nowY) {
                    nowY = y[i];
                    nowIndex = i;
                }
            }
        }

        if (nowIndex != -1) {
            y[nowIndex] = 0;
            x[nowIndex] = (int)(Math.random() * 300);
            c[nowIndex] = (char)(Math.random() * 26 + 97);
            score += 10;
        } else {
            score -= 100;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
