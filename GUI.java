import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class GUI extends JFrame {
    public static void main(String[] args) {
        new GUI("Paint");
    }

    private JToolBar toolbar;
    private JButton[][] button;
    private JPanel[] panel;
    private JPanel[][] canvas;
    private JComboBox<String> fontsizeBox;
    private JButton undoButton;
    private JButton redoButton;
    private Canvas mainCanvas;

    public GUI(String title) {
        int w = 1250;
        int h = 700;
        setTitle(title);
        setSize(w, h);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        toolbar = new JToolBar();

        panel = new JPanel[7];
        button = new JButton[2][5];
        canvas = new JPanel[2][5];

        for (int col = 0; col < 5; col++) {
            panel[col] = new JPanel();
            button[0][col] = new JButton();
            button[1][col] = new JButton();

            panel[col].setLayout(new GridLayout(2, 1));
            panel[col].add(button[0][col]);
            panel[col].add(button[1][col]);

            toolbar.add(panel[col]);
        }
        
        String imagePath = "src\\filledCircle.png"; //add images to the buttons
        ImageIcon icon = new ImageIcon(imagePath);
        ImageIcon resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        button[0][0].setIcon(resizedIcon);

        imagePath = "src\\drawCircle.png"; //add images to the buttons
        icon = new ImageIcon(imagePath);
        resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(60, 40, Image.SCALE_SMOOTH));
        button[1][0].setIcon(resizedIcon);

        imagePath = "src\\filledSquare.png"; //add images to the buttons
        icon = new ImageIcon(imagePath);
        resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        button[0][1].setIcon(resizedIcon);

        imagePath = "src\\drawSquare.png"; //add images to the buttons
        icon = new ImageIcon(imagePath);
        resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        button[1][1].setIcon(resizedIcon);

        imagePath = "src\\filledTriangle.png"; //add images to the buttons
        icon = new ImageIcon(imagePath);
        resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        button[0][2].setIcon(resizedIcon);

        imagePath = "src\\drawtriangle.jpg"; //add images to the buttons
        icon = new ImageIcon(imagePath);
        resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        button[1][2].setIcon(resizedIcon);

        imagePath = "src\\line.jpg"; //add images to the buttons
        icon = new ImageIcon(imagePath);
        resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        button[0][3].setIcon(resizedIcon);

        imagePath = "src\\dashedLine.png"; //add images to the buttons
        icon = new ImageIcon(imagePath);
        resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(80, 40, Image.SCALE_SMOOTH));
        button[1][3].setIcon(resizedIcon);

        imagePath = "src\\pencil.jpg"; //add images to the buttons
        icon = new ImageIcon(imagePath);
        resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        button[0][4].setIcon(resizedIcon);

        imagePath = "src\\eraser.jpg"; //add images to the buttons
        icon = new ImageIcon(imagePath);
        resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        button[1][4].setIcon(resizedIcon);


        // Add components to the toolbar
        panel[5] = new JPanel();
        String[] options = {"", "2 pt", "4 pt", "6 pt", "8 pt", "10 pt"};
        fontsizeBox = new JComboBox<>(options);

        JPanel panelUndo = new JPanel();
        undoButton = new JButton("Undo");
        redoButton = new JButton("Redo");

        panelUndo.setLayout(new FlowLayout());
        panelUndo.add(undoButton);
        panelUndo.add(redoButton);

        panel[5].setLayout(new GridLayout(2, 1));
        panel[5].add(fontsizeBox);
        panel[5].add(panelUndo);

        toolbar.add(panel[5]);

        panel[6] = new JPanel();
        JButton colorButton = new JButton();
        int x = 50; 
        int y = 0; 
        int width = 25; 
        int height = 25; 
        Color color = Color.RED;
        boolean fill = true;

        Rectangle button00 = new Rectangle(x, y, width, height, color, fill);

        JPanel drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                button00.draw(g); 
            }
        };
        drawingPanel.setPreferredSize(new Dimension(25, 25));
        colorButton.setLayout(new BorderLayout());
        colorButton.add(drawingPanel, BorderLayout.CENTER);
        colorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Color selectedColor = JColorChooser.showDialog(GUI.this, "Choose a Color", Color.RED);
                button00.setColor(selectedColor);

                JPanel drawingPanel = new JPanel() {
                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        button00.draw(g); 
                    }
                };
            }
        });

        
        JButton resetButton = new JButton("Reset");
        JButton saveButton = new JButton("Save");

        panel[6].setLayout(new GridLayout(3, 1));
        panel[6].add(colorButton);
        panel[6].add(resetButton);
        panel[6].add(saveButton);


        toolbar.add(panel[6]);

        // Set layout and add components to the frame
        setLayout(new BorderLayout());
        add(toolbar, BorderLayout.NORTH);
        setVisible(true);
    }
}
