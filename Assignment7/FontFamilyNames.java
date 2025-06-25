// import java.awt.Font;
// import java.awt.GraphicsEnvironment;
import java.awt.*;

public class FontFamilyNames {
    public static void main(String[] args) {
        // Get the graphics environment
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        
        // Get the names of all available font families
        String[] fontFamilies = ge.getAvailableFontFamilyNames();
        
        // Display the font families on multiple lines
        for (String fontFamily : fontFamilies) {
            System.out.println(fontFamily);
        }
    }
}