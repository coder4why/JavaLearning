package com.bjsxt.com.小游戏;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SmallGame extends JFrame {

    //自动被调用：g相当于一只画笔
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Color  c = g.getColor();
        Font f = g.getFont();
        g.setColor(Color.black);
        //画线
        g.drawLine(30,30,200,200);
        g.setColor(Color.blue);
        //
        g.draw3DRect(100,100,100,100,true);
        g.setColor(Color.red);
        g.drawOval(100,100,100,100);
        g.setColor(Color.blue);
        g.fillOval(20,20,100,100);

        g.setFont(new Font("楷体",Font.BOLD,35));
        g.drawString("北京尚学堂",180,60);

        g.setColor(c);
        g.setFont(f);
    }

    public void launchFrame(){
        setTitle("北京尚学堂_小游戏演练");
        setSize(500,500);
        setLocation(100,100);
        setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        SmallGame small = new SmallGame();
        small.launchFrame();
    }


}
