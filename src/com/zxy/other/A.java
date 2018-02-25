package com.zxy.other;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class A extends JFrame implements FocusListener{
    JButton jbn[]=new JButton[14];
    
    JButton jbn14=new JButton("重新开始");
    
    public A(){
        jbn[0]=new JButton("周");
        jbn[1]=new JButton("曹操");
        jbn[2]=new JButton("黄");
        jbn[3]=new JButton("张");
        jbn[4]=new JButton("关羽");
        jbn[5]=new JButton("刘");
        jbn[6]=new JButton("兵");
        jbn[7]=new JButton("兵");
        jbn[8]=new JButton("兵");
        jbn[9]=new JButton("兵");
        jbn[10]=new JButton();
        jbn[11]=new JButton();
        jbn[12]=new JButton();
        jbn[13]=new JButton();
        Container cn=getContentPane();
        cn.setLayout(null);
        
        jbn[10].setBounds(50,290,200,5);
        cn.add(jbn[10]);
        jbn[11].setBounds(45,35,210,5);
        cn.add(jbn[11]);
        jbn[12].setBounds(45,40,5,255);
        cn.add(jbn[12]);
        jbn[13].setBounds(250,40,5,255);
        cn.add(jbn[13]);
        
        jbn[0].setBounds(50,40,50,100);
        cn.add(jbn[0]);
        jbn[1].setBounds(100,40,100,100);
        cn.add(jbn[1]);
        jbn[2].setBounds(200,40,50,100);
        cn.add(jbn[2]);
        jbn[3].setBounds(50,140,50,100);
        cn.add(jbn[3]);
        jbn[4].setBounds(100,140,100,50);
        cn.add(jbn[4]);
        jbn[5].setBounds(200,140,50,100);
        cn.add(jbn[5]);
        jbn[6].setBounds(100,190,50,50);
        cn.add(jbn[6]);
        jbn[7].setBounds(150,190,50,50);
        cn.add(jbn[7]);
        jbn[8].setBounds(50,240,50,50);
        cn.add(jbn[8]);
        jbn[9].setBounds(200,240,50,50);
        cn.add(jbn[9]);
        
        jbn14.setBounds(100,320,100,20);
        cn.add(jbn14);
        
        for(int i=0;i<10;i++){
        jbn[i].setBackground(new Color(255,245,170));
        jbn[i].addFocusListener(this);
        }
        
        for(int i=0;i<jbn.length;i++){
            jbn[i].addKeyListener(new KeyAdapter(){
                public void keyPressed(KeyEvent e){
                    JButton jbntemp=(JButton)e.getSource();
                    Rectangle r=jbntemp.getBounds();
                    int x=r.x;
                    int y=r.y;
                    int z=0;
                    if (e.getKeyCode()==KeyEvent.VK_UP){
                        for(int j=0;j<jbn.length;++j){    
                            Rectangle c=jbn[j].getBounds();
                            if(c!=r){
                                r.setLocation(x,y-50);
                                if (r.intersects(c)){
                                    z=1;
                                    break;
                                }
                            }
                        }
                        if(z==0)
                        jbntemp.setLocation(x,y-50);
                    }
                    
                    if (e.getKeyCode()==KeyEvent.VK_DOWN){
                        for(int j=0;j<jbn.length;++j){    
                            Rectangle c=jbn[j].getBounds();
                            if(c!=r){    
                                r.setLocation(x,y+50);
                                if (r.intersects(c)){
                                    z=1;
                                    break;
                                }
                            }
                        }
                        if(z==0)
                        jbntemp.setLocation(x,y+50);
                    }
                    
                    if (e.getKeyCode()==KeyEvent.VK_LEFT){
                        for(int j=0;j<jbn.length;++j){    
                            Rectangle c=jbn[j].getBounds();
                            if(c!=r){    
                                r.setLocation(x-50,y);
                                if (r.intersects(c)){
                                    z=1;
                                    break;
                                }
                            }
                        }
                        if(z==0)
                        jbntemp.setLocation(x-50,y);
                    }
                    if (e.getKeyCode()==KeyEvent.VK_RIGHT){
                        for(int j=0;j<jbn.length;++j){    
                            Rectangle c=jbn[j].getBounds();
                            if(c!=r){    
                                r.setLocation(x+50,y);
                                if (r.intersects(c)){
                                    z=1;
                                    break;
                                }
                            }
                        }
                        if(z==0)
                        jbntemp.setLocation(x+50,y);
                    }
                }
            });
        }
        
        jbn14.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                jbn[10].setBounds(50,290,200,5);
                cn.add(jbn[10]);
                jbn[11].setBounds(45,35,210,5);
                cn.add(jbn[11]);
                jbn[12].setBounds(45,40,5,255);
                cn.add(jbn[12]);
                jbn[13].setBounds(250,40,5,255);
                cn.add(jbn[13]);
                
                jbn[0].setBounds(50,40,50,100);
                cn.add(jbn[0]);
                jbn[1].setBounds(100,40,100,100);
                cn.add(jbn[1]);
                jbn[2].setBounds(200,40,50,100);
                cn.add(jbn[2]);
                jbn[3].setBounds(50,140,50,100);
                cn.add(jbn[3]);
                jbn[4].setBounds(100,140,100,50);
                cn.add(jbn[4]);
                jbn[5].setBounds(200,140,50,100);
                cn.add(jbn[5]);
                jbn[6].setBounds(100,190,50,50);
                cn.add(jbn[6]);
                jbn[7].setBounds(150,190,50,50);
                cn.add(jbn[7]);
                jbn[8].setBounds(50,240,50,50);
                cn.add(jbn[8]);
                jbn[9].setBounds(200,240,50,50);
                cn.add(jbn[9]);    
            }
        });
        
        setSize(300,400);
        setVisible(true);
        validate();
    }
    
    public void focusGained(FocusEvent e)
    {
        
        ((JButton)e.getSource()).setBackground(Color.red);
    }
    public void focusLost(FocusEvent e)
    {
        ((JButton)e.getSource()).setBackground(new Color(255,245,170));    
    }
    
    public static void main(String args[]){
        A a=new A();
    }
}