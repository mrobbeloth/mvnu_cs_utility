/** FXOptionPane class
 *  emulates methods from javax.swing.JOptionPane using JavaFX Dialog windows
 *  This avoids using JOptionPane methods in MacOS environments
 *  that require a different configuration than Windows.
 * @author Bob Kasper, Computer Science, Mount Vernon Nazarene University
 * @author Michael Robbeloth, Computer Science, Mount Vernon Nazarene University
 */

package mvnu.cs;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;

public class FXOptionPane {
    
    /**
     * Emulate a JOptionPane Dialog using TextInputDialog
     * @param prompt -- text to show user
     * @return 
     */
    public static String showInputDialog(String prompt) {
       return showInputDialog("Enter Input", null, prompt);       
    }
    /**
     * emulate JOptionPane.showMessageDialog using JavaFX dialog
     * @param title -- text to show at the top of the dialog window
     * @param header -- text to show in the dialog type pane
     * @param prompt -- text to show next to the entry prompt
     * @return 
     */
    public static String showInputDialog(String title, String header, 
            String prompt) {
        TextInputDialog dialog = new TextInputDialog();
       dialog.setTitle(title);
       dialog.setHeaderText(header);
       dialog.setContentText(prompt);
       // get the response value
       Optional<String> result = dialog.showAndWait();
       if (result.isPresent())
           return result.get();
       else
           return "";       
    }
   
    /**
     * emulate JOptionPane.showMessageDialog using JavaFX dialog
     * The first parameter is ignored, but included for compatibility
     * with JOptionPane.showMessageDialog
     * @param o -- for compatibility with older code bases, not used
     * @param prompt prompt -- text to show next to the entry prompt
     */
    public static void showMessageDialog(Object o, String prompt) {
       showMessageDialog(prompt);
    }
      
    /**
     * Show an alert dialog
     * @param message -- the content of the dialog
     */
    public static void showMessageDialog(String message) {
       showMessageDialog("Information", null, message);
    }
    
    /**
     * Show an alert dialog
     * @param title -- text to show at the top of the dialog window
     * @param header -- text to show in the dialog type pane
     * @param content -- the message or core content of the dialog
     */
    public static void showMessageDialog(String title, String header, String content) {
       Alert alert = new Alert(Alert.AlertType.INFORMATION);
       alert.setTitle(title);
       alert.setHeaderText(header);
       alert.setContentText(content);
       alert.showAndWait();
    }
}