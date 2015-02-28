
import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.skin.GraphiteSkin;
import org.pushingpixels.substance.api.skin.SubstanceGraphiteLookAndFeel;


import javax.swing.*;

public class DesignSubstance {
    public DesignSubstance() {
        SubstanceLookAndFeel.setSkin(new GraphiteSkin());
        SubstanceLookAndFeel.setSkin("org.pushingpixels.substance.api.skin.GraphiteSkin");
        try {
            UIManager.setLookAndFeel(new SubstanceGraphiteLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        try {
            UIManager.setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceGraphiteLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
