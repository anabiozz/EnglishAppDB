import javax.swing.*;

public class Start {
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceGraphiteLookAndFeel");
                } catch (Exception e) {
                    System.out.println("Substance Graphite failed to initialize");
                }
        new Gui();
            }
        });
    }

}
