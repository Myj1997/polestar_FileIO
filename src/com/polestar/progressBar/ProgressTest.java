package com.polestar.progressBar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgressTest implements INotification {
    private JProgressBar progressBar;
    private JPanel panelProgress;
    private JButton buttonIncress;
    private JButton buttonDecress;

    int position = 0;
    public JPanel getPanel() {
        return panelProgress;
    }

    public ProgressTest() {
        // 1. 프로그래스 바의 최대는 100
        progressBar.setMaximum(100);

        // 인크리스 버튼 클릭 시 이벤트
        buttonIncress.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // startIncreate 메소드 호출
                startIncreate();

            }
        });
        buttonDecress.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startDecress();
            }
        });
    }

    private void startIncreate() {
        System.out.println("ProgressTest.actionPerformed 눌림");
        Thread increaseThread = new Thread(new IncreaseThreadTest(this));
        increaseThread.start();

    }

    private void startDecress(){
        System.out.println("ProgressTest.actionPerforemd 눌림2");
        Thread decreaseThread = new Thread(new DecreaseThread(this));
        decreaseThread.start();
    }

    @Override
    public void notificationCalled() {
        position ++;
            if ( 100 < position) {
                position = 100;
            }
            progressBar.setValue(position);
    }

    @Override
    public void decreaseNotificationCalled() {
        position --;
        if ( 0 > position){
            position = 0;
        }

        progressBar.setValue(position);
    }
}
