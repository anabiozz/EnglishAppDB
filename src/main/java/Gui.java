import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui{
    private static String result;
    private static int count = 0;
    private static JLabel label;

    public Gui() {
        new DesignSubstance();
        //read from ForeignWords
        FileWorker.read();
        //read from NativWords
        FileWorker.readP();
        //read data from HashMap
        FileWorker.log();

        JFrame frame = new JFrame("Program For Learning");
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        label = new JLabel();
        JButton button = new JButton("Next");
        JButton button1 = new JButton("Before");
        JButton button2 = new JButton("Translate");
        JButton button3 = new JButton("Delete");
        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("Settings");

        JMenuItem item = new JMenuItem("Add Words");
        //Menu item (Add Words)
        item.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                AddWords addWords = new AddWords();
                addWords.run();
            }
        });

        JMenuItem item1 = new JMenuItem("All Words");
        //menu item (All Words)
        item1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AllWords allWords = new AllWords();
                allWords.run();
            }
        });

        JMenuItem item2 = new JMenuItem("Exit");
        //menu item (Exit)
        item2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JMenuItem item3 = new JMenuItem("Delete");
        //menu item (Delete)
        item3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                delete();
                FileWorker.writer();
                FileWorker.log();
                result = FileWorker.list.get(--count);
                label.setText(result);
            }
        });

        item.setFont(new Font("Ubuntu", Font.ROMAN_BASELINE, 10));
        item1.setFont(new Font("Ubuntu", Font.ROMAN_BASELINE, 10));
        item2.setFont(new Font("Ubuntu", Font.ROMAN_BASELINE, 10));
        item3.setFont(new Font("Ubuntu", Font.ROMAN_BASELINE, 10));

        frame.setBounds(300, 150, 400, 295);
        frame.setPreferredSize(new Dimension(400, 310));
        label.setPreferredSize(new Dimension(400, 200));

        frame.setLayout(new FlowLayout());
        panel.setLayout(new FlowLayout());
        panel1.setLayout(new FlowLayout());
        panel2.setLayout(new FlowLayout());
        label.setLayout(new FlowLayout());

        bar.setBackground(null);
        bar.setBorderPainted(false);

        frame.setJMenuBar(bar);
        bar.add(menu);
        menu.add(item);
        menu.add(item1);
        menu.add(item3);
        menu.add(item2);

        frame.add(panel);

        frame.add(panel1);
        frame.add(panel2);

        panel.add(label);
        panel1.add(button2);
        panel2.add(button1);
        panel2.add(button);

        label.setFont(new Font("Ubuntu", Font.ROMAN_BASELINE, 20));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);

        button2.addActionListener(new TransButton());
        button1.addActionListener(new BeforeButton());
        button.addActionListener(new NextButton());
        button.setPreferredSize(new Dimension(90, 35));
        button1.setPreferredSize(new Dimension(90, 35));
        button3.setPreferredSize(new Dimension(90, 35));
        button2.setPreferredSize(new Dimension(120, 35));
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }
    public class NextButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (!label.getText().equals(FileWorker.list.get(FileWorker.list.size() - 1))) {
                //next element
                result = FileWorker.list.get(++count);
                //output result
                label.setText(result);
            }
        }
    }
    public class BeforeButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (!label.getText().equals(FileWorker.list.get(FileWorker.list.size() - FileWorker.list.size()))) {
                //previous element
                result = FileWorker.list.get(--count);
                //output result
                label.setText(result);
            }
        }
    }
    public class TransButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String rus = FileWorker.map.get(result);
            if (label.getText().equals(FileWorker.mapP.get(rus))) {
                //output a nativ word
                label.setText(FileWorker.map.get(result));
            }else {
                //output a foreign word
                label.setText(FileWorker.mapP.get(rus));
            }
        }
    }
    public void delete() {
        String result = label.getText();
        for (int i = 0; i < FileWorker.list.size(); i++) {
            if (result.equals(FileWorker.list.get(i))) {
                FileWorker.list.remove(i);
                FileWorker.listP.remove(i);
            }else if(result.equals(FileWorker.listP.get(i))){
                FileWorker.list.remove(i);
                FileWorker.listP.remove(i);
            }
        }
    }
}
