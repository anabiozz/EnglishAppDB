import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.pushingpixels.substance.api.SubstanceSkin;


public class Gui{
    private static String result;
    private static int count = 0;
    private static JLabel label;

    public Gui() {
        new DesignSubstance();
        //читаем данные с файла (english)
        FileWorker.read();
        //читаем данные с файла (русский)
        FileWorker.readP();
        //данные с хэшкарты
        FileWorker.log();
        //стандартный вид системы



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

        item.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                AddWords addWords = new AddWords();
                addWords.run();
            }
        });


        JMenuItem item1 = new JMenuItem("All Words");

        item1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AllWords allWords = new AllWords();
                allWords.run();
            }
        });

        JMenuItem item2 = new JMenuItem("Exit");

        item2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JMenuItem item3 = new JMenuItem("Delete");

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
    //слушатель "Next"
    public class NextButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //если выведенное слово равно последнему элементу в массиве
            if (!label.getText().equals(FileWorker.list.get(FileWorker.list.size() - 1))) {
                //следующий элемент
                result = FileWorker.list.get(++count);
                //выводим результат
                label.setText(result);
            }
        }
    }
    //Слушатель "Before"
    public class BeforeButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //если выведенное слово равно первому элементу в массиве
            if (!label.getText().equals(FileWorker.list.get(FileWorker.list.size() - FileWorker.list.size()))) {
                //предыдущий элемент
                result = FileWorker.list.get(--count);
                //выводим результат
                label.setText(result);
            }
        }
    }
    //Слушатель "Translation"
    public class TransButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //Получаем русское слово
            String rus = FileWorker.map.get(result);
            //если слово анлийское
            if (label.getText().equals(FileWorker.mapP.get(rus))) {
                //Выводим русский перевод
                label.setText(FileWorker.map.get(result));
            }else {
                //выводим английское слово
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
