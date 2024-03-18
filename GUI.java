import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class GUI extends JFrame {
    public static void main(String[] args) {
        new GUI("Paint");
    }

    private JToolBar toolbar; //instantiate the componenets.
    private JButton[][] button;
    private JPanel[] panel;
    private Canvas[][] canvas;
    private JComboBox<String> fontsizeBox;
    private JButton undoButton;
    private JButton redoButton;
    private Canvas mainCanvas;


    public GUI(String title){
        setTitle(title);
        setSize(1250,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        toolbar = new JToolBar();

        panel = new JPanel[7];
        button = new JButton[2][5];
        canvas = new Canvas[2][5];
        for(int col = 0; col<5; col++){
            panel[col] = new JPanel();
            button[0][col] = new JButton();
            canvas[0][col] = new Canvas();
            button[1][col] = new JButton();
            canvas[1][col] = new Canvas();

            panel[col].setLayout(new GridLayout(2,1));
            panel[col].add(button[0][col]);
            panel[col].add(button[1][col]);

            toolbar.add(panel[col]);
        }

        panel[5] = new JPanel();
        String[] options = {"", "2 pt", "4 pt", "6 pt", "8 pt", "10 pt"};
        fontsizeBox = new JComboBox<>(options);
        
        JPanel panelUndo = new JPanel();
        undoButton = new JButton("Undo");
        redoButton = new JButton("Redo");

        panelUndo.setLayout(new FlowLayout());
        panelUndo.add(undoButton);
        panelUndo.add(redoButton);

        panel[5].setLayout(new GridLayout(2,1));
        panel[5].add(fontsizeBox);
        panel[5].add(panelUndo);

        toolbar.add(panel[5]);

        panel[6] = new JPanel();
        JButton colorButton = new JButton("Color");
        JButton resetButton = new JButton("Reset"); 
        JButton saveButton = new JButton("Save");

        panel[6].setLayout(new GridLayout(3,1));
        panel[6].add(colorButton);
        panel[6].add(resetButton);
        panel[6].add(saveButton);

        toolbar.add(panel[6]);

        mainCanvas = new Canvas();

        setLayout(new BorderLayout());
        add(toolbar, BorderLayout.NORTH);
        add(mainCanvas, BorderLayout.CENTER);
        setVisible(true);
    }
}
