import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.IntStream;


public class Visual {

    private static String currentMode = "null";
    static int n = 0;
    static int index = 0;
    static int[] A_bckp = new int[22];
    static int[] A = new int[22];
    static int[] B = new int[22];
    static Set<Integer> DuskedL = new HashSet<>();
    static Set<Integer> DuskedR = new HashSet<>();
    private static ArrayList<String> Stats_12;
    private static ArrayList<int[]> Arrays_12;
    private static ArrayList<Boolean[]> Dusked_12;
    public static Bubble handlerB = null;
    public static Merge handlerM = null;
    public static Insertion handlerI = null;


    private static class MyListCellRendererL extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
                                                      boolean cellHasFocus) {
            Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            if( DuskedL.contains(index) || !Objects.equals(currentMode, "Merge") ) c.setForeground(Color.WHITE);
            else c.setForeground(Color.darkGray);


            //((JLabel) c).setBorder(new EmptyBorder(5, 5, 5, 5));
            return c;
        }
    }


    private static class MyListCellRendererR extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
                                                      boolean cellHasFocus) {
            Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            if( DuskedR.contains(index) || !Objects.equals(currentMode, "Merge") ) c.setForeground(Color.WHITE);
            else c.setForeground(Color.darkGray);


            //((JLabel) c).setBorder(new EmptyBorder(5, 5, 5, 5));
            return c;
        }
    }


    private static int[] shrinken( int [] AE ){
        int[] temp9 = new int[AE.length];///сжимает массив для графика......
        int[] temp10 = new int[AE.length];
        for( int i = 0; i < AE.length; ++ i ){
            temp10[i] = AE[i];
        }
        IntStream sorted1 = Arrays.stream(temp10).sorted();
        temp10 = sorted1.toArray();
        HashMap<Integer, Integer> PTSD = new HashMap<>();
        for( int i = 0; i < AE.length; ++ i ){
            PTSD.put(temp10[i],i);
        }
        for( int i = 0; i < AE.length; ++ i ){
            temp9[i] = PTSD.get(AE[i]);
        }
        return temp9;
    }


    public static void Start( ){
        JFrame frame = new JFrame("VisualSort"); // Для окна нужна "рама" - Frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //^ стандартное поведение при закрытии окна - завершение приложения
        frame.setSize(600, 400); // размеры окна
        frame.setMinimumSize(new Dimension(600, 400)); // размеры окна
        frame.setPreferredSize(new Dimension(600, 400)); // размеры окна
        //frame.setResizable(false);
        frame.setLocationRelativeTo(null); // окно - в центре экрана
        JButton button = new JButton("Press"); // Экземпляр класса JButton
        //frame.getContentPane().add(button); // Добавляем кнопку на Frame
        //^ getContentPane() - клиентская область окна
        frame.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                System.out.println("Window - Resized");
                System.out.println("Current screen size: " + frame.getWidth() + "w " + frame.getHeight() + "h");
            }

            @Override
            public void componentMoved(ComponentEvent e) {
                //System.out.println("Window - Moved");
            }

            @Override
            public void componentShown(ComponentEvent e) {
                //System.out.println("Window - Shown");
            }

            @Override
            public void componentHidden(ComponentEvent e) {
                //System.out.println("Window - Hidden");
            }
        });

        JMenuBar menuBar = new JMenuBar( );
        JMenu mode = new JMenu("Mode");
        JMenu file = new JMenu("File");


        JMenuItem openFile = new JMenuItem("Open");
        JMenuItem bubbleMode = new JMenuItem("Bubble Mode");
        JMenuItem mergeMode = new JMenuItem("Merge Mode");
        JMenuItem insertionMode = new JMenuItem("Insertion Mode");
        JButton previous = new JButton("Previous");
        JButton next = new JButton("Next");





        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        model.addColumn(A);
        table.setMaximumSize(new Dimension(400, 180));
        table.setBackground(Color.PINK);


        DefaultListModel dlm = new DefaultListModel();
        JList list = new JList(dlm);
        list.setMaximumSize(new Dimension(300, 180));
        //list.setVisibleRowCount(1);
        //list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setBackground(Color.black);
        list.setCellRenderer(new MyListCellRendererL());
        if( A != null ) {
            dlm.clear();
            for(Integer word : Arrays.stream(A).toArray()) {
                dlm.addElement(word);
            }
        }


        DefaultListModel dlm2 = new DefaultListModel();
        JList list2 = new JList(dlm2);
        list2.setMaximumSize(new Dimension(300, 180));
        //list2.setVisibleRowCount(1);
        //list2.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        //JTextField tt = new JTextField("\\u001B[32md\\u001B[0m");
        //tt.setForeground(Color.magenta);
        //tt.setBackground(Color.orange);
        list2.setBackground(Color.black);
        list2.setCellRenderer(new MyListCellRendererR());

        if( B != null ) {
            dlm2.clear();
            for(Integer word : Arrays.stream(B).toArray()) {
                dlm2.addElement(word);
            }
        }

        JTextArea textLeft = new JTextArea("Open File -> Select Mode\nUse Previous and Next buttons for navigation");
        //textLeft.setMaximumSize(new Dimension(160,90));
        textLeft.setEditable(false);
        JTextArea textRight = new JTextArea("Open File -> Select Mode\nUse Previous and Next buttons for navigation");
        //textRight.setMinimumSize(new Dimension(160,90));
        textRight.setEditable(false);

        final int WI = 8, HI = 11-2;
        final int WO = 12, HO = 12-3;

        Canvas LG = new Canvas(){
            public void paint(Graphics g) {
                setBackground(Color.lightGray);
                if(Objects.equals(currentMode, "Merge")) setForeground(Color.red);
                if(Objects.equals(currentMode, "null")) setForeground(Color.darkGray);
                if(Objects.equals(currentMode, "Bubble")) setForeground(Color.blue);
                if(Objects.equals(currentMode, "Insertion")) setForeground(Color.green);

                if( Arrays_12 == null ) return;
                int [] grp = shrinken(Arrays_12.get(index));
                int x = this.getWidth(), y = 5;
                x -= WI;
                for( int i = 0; i < grp.length; ++ i ){
                    x = this.getWidth();
                    x -= WI;
                    for( int j = 0; j <= grp[i]; ++ j ){
                        if(!Objects.equals(currentMode, "Merge")){
                            g.setColor(Color.white);
                            g.fillRect(x, y, WI, HI);
                            g.setColor(Color.darkGray);
                        }else
                        if( DuskedL.contains(i) ){
                            g.setColor(Color.white);
                            g.fillRect(x, y, WI, HI);
                            g.setColor(Color.darkGray);
                        } else{
                            g.setColor(Color.darkGray);
                            g.fillRect(x, y, WI, HI);
                            g.setColor(Color.white);
                        }
                        x -= WI;
                    }
                    y += HI;
                    y += HO;
                }
            }
        };

        Canvas RG = new Canvas(){
            public void paint(Graphics g) {
                setBackground(Color.lightGray);
                if(Objects.equals(currentMode, "Merge")) setForeground(Color.red);
                if(Objects.equals(currentMode, "null")) setForeground(Color.darkGray);
                if(Objects.equals(currentMode, "Bubble")) setForeground(Color.blue);
                if(Objects.equals(currentMode, "Insertion")) setForeground(Color.green);


                if( Arrays_12 == null ) return;
                int [] grp = shrinken(Arrays_12.get(index+1));
                int x = this.getWidth(), y = 5;
                x -= WI;
                for( int i = 0; i < grp.length; ++ i ){
                    x = this.getWidth();
                    x -= WI;
                    for( int j = 0; j <= grp[i]; ++ j ){
                        if(!Objects.equals(currentMode, "Merge")){
                            g.setColor(Color.white);
                            g.fillRect(x, y, WI, HI);
                            g.setColor(Color.darkGray);
                        }else
                        if( DuskedR.contains(i) ){
                            g.setColor(Color.white);
                            g.fillRect(x, y, WI, HI);
                            g.setColor(Color.darkGray);
                        } else{
                            g.setColor(Color.darkGray);
                            g.fillRect(x, y, WI, HI);
                            g.setColor(Color.white);
                        }
                        x -= WI;
                    }
                    y += HI;
                    y += HO;
                }
            }
        };




        JSplitPane splitLG = new JSplitPane( SwingConstants.VERTICAL, LG, list );
        splitLG.getLeftComponent().setMinimumSize(new Dimension(160,200));
        JSplitPane splitLeft = new JSplitPane( SwingConstants.HORIZONTAL, textLeft, splitLG );
        splitLeft.setEnabled(false);

        JSplitPane splitRG = new JSplitPane( SwingConstants.VERTICAL, RG, list2 );
        splitRG.getLeftComponent().setMinimumSize(new Dimension(160,200));
        JSplitPane splitRight = new JSplitPane( SwingConstants.HORIZONTAL, textRight, splitRG );
        splitRight.setEnabled(false);

        JSplitPane splitPane = new JSplitPane( SwingConstants.VERTICAL, splitLeft, splitRight );
        splitPane.setBackground(Color.gray);
        //splitPane.setDividerLocation(0.5);
        splitPane.getLeftComponent().setMinimumSize(new Dimension(280,400));
        splitPane.getRightComponent().setMinimumSize(new Dimension(280,400));




        openFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //restartAsked = true;
                System.out.println("Open File Button - Clicked");
                currentMode = "null";
                mergeMode.setBackground(null);
                bubbleMode.setBackground(null);
                insertionMode.setBackground(null);


                FileDialog dialog = new FileDialog((Frame)null, "Select File to Open");
                dialog.setMode(FileDialog.LOAD);
                dialog.setVisible(true);
                String filename = dialog.getFile();
                dialog.dispose();
                System.out.println(filename + " chosen.");

                if( filename != null ) {
                    try {
                        File Obj = new File(filename);
                        Scanner Reader = new Scanner(Obj);
                        n = Reader.nextInt();
                        System.out.println("Array size: " + n);
                        A = new int[n];
                        for( int i = 0; i < n; ++ i ){
                            A[i] = Reader.nextInt();
                        }
                        System.out.println(Arrays.toString(A));
                        if( A != null ) {
                            dlm.clear();
                            for(Integer word : Arrays.stream(A).toArray()) {
                                dlm.addElement(word);
                            }
                        }
                        A_bckp = A;
                        Reader.close();
                    } catch (FileNotFoundException er) {
                        System.out.println("An error - File Open - occurred.");
                    }
                }


            }
        });
        previous.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //restartAsked = true;
                System.out.println("Previous Button - Clicked");
                if( currentMode == "null" ){
                    textLeft.setText("Select Sort Mode.\nMenu:Mode:[Any]");
                    return;
                }
                String temp123 = textRight.getText();
                if( temp123.equals("Press Next.\nTo Continue") ) return;
                index--;

                if( index < 0 ) index++;
                if(1==1)
                {
                    textLeft.setText(Arrays.toString(Arrays_12.get(index)) + "\n" + Stats_12.get(index));
                    textRight.setText(Arrays.toString(Arrays_12.get(index+1)) + "\n" + Stats_12.get(index+1));
                    if( Arrays_12.get(index) != null ) {
                        dlm.clear();
                        for(Integer word : Arrays.stream(Arrays_12.get(index)).toArray()) {
                            dlm.addElement(word);
                        }
                        DuskedL.clear();
                        for( int i = 0; i < Dusked_12.get(index).length; ++ i ){
                            if(!(Dusked_12.get(index))[i]) DuskedL.add(i);
                        }
                    }
                    if( Arrays_12.get(index+1) != null ) {
                        dlm2.clear();
                        for(Integer word : Arrays.stream(Arrays_12.get(index+1)).toArray()) {
                            dlm2.addElement(word);
                        }
                        DuskedR.clear();
                        for( int i = 0; i < Dusked_12.get(index+1).length; ++ i ){
                            if(!(Dusked_12.get(index+1))[i]) DuskedR.add(i);
                        }
                    }
                    //index--;
                    //index--;
                }
                RG.repaint();
                LG.repaint();
            }
        });
        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //restartAsked = true;
                System.out.println("Next Button - Clicked");
                if( currentMode == "null" ) {
                    textLeft.setText("Select sort.\nMenu:Mode");
                    return;
                }
                index++;
                String temp123 = textRight.getText();
                if( temp123.equals("Press Next.\nTo Continue") ) index = 0; else
                if( index + 1 >= Arrays_12.size( ) ) index --;
                if(1==1)
                {
                    textLeft.setText(Arrays.toString(Arrays_12.get(index)) + "\n" + Stats_12.get(index));
                    textRight.setText(Arrays.toString(Arrays_12.get(index+1)) + "\n" + Stats_12.get(index+1));
                    if( Arrays_12.get(index) != null ) {
                        dlm.clear();
                        for(Integer word : Arrays.stream(Arrays_12.get(index)).toArray()) {
                            dlm.addElement(word);
                        }
                        DuskedL.clear();
                        for( int i = 0; i < Dusked_12.get(index).length; ++ i ){
                            if(!(Dusked_12.get(index))[i]) DuskedL.add(i);
                        }
                    }
                    if( Arrays_12.get(index+1) != null ) {
                        dlm2.clear();
                        for(Integer word : Arrays.stream(Arrays_12.get(index+1)).toArray()) {
                            dlm2.addElement(word);
                        }
                        DuskedR.clear();
                        for( int i = 0; i < Dusked_12.get(index+1).length; ++ i ){
                            if(!(Dusked_12.get(index+1))[i]) DuskedR.add(i);
                        }
                    }
                    //index++;
                }
                RG.repaint();
                LG.repaint();
            }
        });
        mergeMode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentMode = "Merge";
                System.out.println("Merge Button - Clicked");
                mergeMode.setBackground(Color.ORANGE);
                bubbleMode.setBackground(null);
                insertionMode.setBackground(null);
                handlerM = new Merge();
                //handler.load( int[1,2] );
                A = A_bckp;
                handlerM.load(A);
                Stats_12 = handlerM.getStats();
                Arrays_12 = handlerM.getArrays();
                Dusked_12 = handlerM.getDusked();
                index = 0;
                for( int i = 0; i < Stats_12.size(); ++i ) {
                    System.out.println(Stats_12.get(i) + " -- " + Arrays.toString(Arrays_12.get(i)));
                }
                textRight.setText("Press Next.\nTo Continue");
                RG.repaint();
                LG.repaint();
            }
        });
        bubbleMode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentMode = "Bubble";
                System.out.println("Bubble Button - Clicked");
                mergeMode.setBackground(null);
                bubbleMode.setBackground(Color.ORANGE);
                insertionMode.setBackground(null);
                handlerB = new Bubble();
                //handler.load( int[1,2] );
                A = A_bckp;
                handlerB.load(A);
                Stats_12 = handlerB.getStats();
                Arrays_12 = handlerB.getArrays();
                index = 0;
                for( int i = 0; i < Stats_12.size(); ++i ) {
                    System.out.println(Stats_12.get(i) + " -- " + Arrays.toString(Arrays_12.get(i)));
                }
                textRight.setText("Press Next.\nTo Continue");
                RG.repaint();
                LG.repaint();
            }
        });
        insertionMode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentMode = "Insertion";
                System.out.println("Insertion Button - Clicked");
                mergeMode.setBackground(null);
                bubbleMode.setBackground(null);
                insertionMode.setBackground(Color.ORANGE);
                handlerI = new Insertion();
                //handler.load( int[1,2] );
                A = A_bckp;
                handlerI.load(A);
                Stats_12 = handlerI.getStats();
                Arrays_12 = handlerI.getArrays();
                index = 0;
                for( int i = 0; i < Stats_12.size(); ++i ) {
                    System.out.println(Stats_12.get(i) + " -- " + Arrays.toString(Arrays_12.get(i)));
                }
                textRight.setText("Press Next.\nTo Continue");
                RG.repaint();
                LG.repaint();
            }
        });





        file.add( openFile );
        mode.add( bubbleMode );
        mode.add( mergeMode );
        mode.add( insertionMode );



        menuBar.add(file);
        menuBar.add(mode);
        menuBar.add(previous);
        menuBar.add(next);
        frame.getContentPane().add(splitPane);
        frame.setJMenuBar(menuBar);
        frame.setVisible(true); // Делаем окно видимым

        //splitPane.setDividerLocation(0.5);
    }
}
