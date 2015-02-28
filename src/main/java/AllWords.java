import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

public class AllWords implements Runnable{
    public static JTextArea area;
    public static JTextArea area2;

    public void run() {
        JFrame frame = new JFrame("Program For Learning");
        frame.setPreferredSize(new Dimension(700, 400));
        frame.setLayout(new GridLayout(1, 2));
        frame.setBounds(150, 150, 700, 400);

        area = new JTextArea();
        area2 = new JTextArea();

        JScrollPane scroll = new JScrollPane(area);
        JScrollPane scroll2 = new JScrollPane(area2);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        frame.add(scroll);
        frame.add(scroll2);
        frame.setVisible(true);
        area.setEditable(false);
        area2.setEditable(false);
        frame.setResizable(false);
        frame.pack();

        reader();

    }
    public static void reader() {
        Iterator iter = FileWorker.list.iterator();
        int i = 0;
        while (iter.hasNext()){
            Object element = iter.next();
            i++;
            area.append(String.valueOf(i + ")" + " " + element) + "\r\n");
            area.append("\n");

        }
        Iterator iter2 = FileWorker.listP.iterator();
        int j = 0;
        while (iter2.hasNext()){
            Object element2 = iter2.next();
            j++;
            area2.append(String.valueOf(j + ")" + " " + element2) + "\r\n");
            area2.append("\n");
        }
    }
}
