import javax.swing.*;
import java.awt.event.*;

public class Visual {

    private static String currentMode = "Merge";
    private static Boolean restartAsked = true;

    private static void sortCall( ){

    }


    public static void Start( ){
        JFrame frame = new JFrame("VisualSort"); // Для окна нужна "рама" - Frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //^ стандартное поведение при закрытии окна - завершение приложения
        frame.setSize(600, 400); // размеры окна
        frame.setResizable(false);
        frame.setLocationRelativeTo(null); // окно - в центре экрана
        JButton button = new JButton("Press"); // Экземпляр класса JButton
        frame.getContentPane().add(button); // Добавляем кнопку на Frame
        //^ getContentPane() - клиентская область окна


        JMenuBar menuBar = new JMenuBar( );
        JMenu mode = new JMenu("Mode");


        JMenuItem bubbleMode = new JMenuItem("Bubble Mode");
        JMenuItem mergeMode = new JMenuItem("Merge Mode");
        JMenuItem insertionMode = new JMenuItem("Insertion Mode");
        JMenuItem restart = new JMenuItem("Restart");
        restart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                restartAsked = true;
            }
        });
        mergeMode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentMode = "Merge";
            }
        });
        bubbleMode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentMode = "Bubble";
            }
        });
        insertionMode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentMode = "Insertion";
            }
        });


        mode.add( bubbleMode );
        mode.add( mergeMode );
        mode.add( insertionMode );



        menuBar.add(mode);
        menuBar.add(restart);
        frame.setJMenuBar(menuBar);
        frame.setVisible(true); // Делаем окно видимым

    }
}
