import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddWords implements Runnable{
    public static String addArray;
    public static String addArray2;
    public static JTextField field;
    public static JTextField field2;

    public void run() {
        JFrame frame = new JFrame("Program For Learning");
        field = new JTextField(30);
        field2 = new JTextField(30);
        JLabel label = new JLabel("Foreign Word");
        JLabel label2 = new JLabel("Native Word");
        JButton button = new JButton("Add this words");
        JPanel panel = new JPanel();

        frame.setBounds(400, 150, 400, 230);
        frame.setPreferredSize(new Dimension(400, 230));
        panel.setPreferredSize(new Dimension(400, 230));
        button.setPreferredSize(new Dimension(370, 40));
        field.setPreferredSize(new Dimension(380, 40));
        field2.setPreferredSize(new Dimension(380, 40));

        //frame.setLayout(new FlowLayout());
        panel.setLayout(new FlowLayout());

        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);

        label2.setHorizontalAlignment(JLabel.CENTER);
        label2.setVerticalAlignment(JLabel.CENTER);

        button.setHorizontalAlignment(JButton.CENTER);
        button.setVerticalAlignment(JButton.CENTER);

        frame.add(panel);
        panel.add(label);
        panel.add(field);
        panel.add(label2);
        panel.add(field2);

        panel.add(button);

        frame.setVisible(true);
        frame.setResizable(false);
        //frame.pack();
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addArray = field.getText();
                addArray2 = field2.getText();

                if (addArray.equals("") && addArray2.equals("")){
                    field.setText("Type a word");
                    field2.setText("Type a word");
                }else if (addArray.equals("")){
                    field.setText("Type a word");
                }else if (addArray2.equals("")) {
                    field2.setText("Type a word");
                }else{
                    FileWorker.list.add(addArray);
                    FileWorker.listP.add(addArray2);
                    FileWorker.writer();
                    FileWorker.log();
                }
            }
        });
    }
}
