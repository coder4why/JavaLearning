package com.bjsxt.com.台球游戏;
import java.awt.*;
import javax.swing.*;

public class BallGame extends JFrame{

    Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.png");
    Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");

    public  void paint(Graphics g){
        System.out.println("窗口渲染一次");
        g.drawImage(desk,0,0,null);
        g.drawImage(ball,200,200,null);
    }

    void launchFrame(){
        setSize(856,501);
        setLocation(100,100);
        setVisible(true);
        while (true){
            repaint();
//            Thread.sleep(40);
        }
    }

    public static void main(String[] args) {
        System.out.println("我的小游戏开始了！");
        BallGame game = new BallGame();
        game.launchFrame();
    }

}
