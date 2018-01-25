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
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;

public class FXOptionPane {
    
    /**
     * Emulate a JOptionPane Dialog using TextInputDialog
     * Shows a question-message dialog requesting input from the user 
     * @param message -- text to show user
     * @return 
     */
    public static String showInputDialog(Object message) {
       if (message instanceof String) {
           return showInputDialog("Enter Input", null, (String)message);
       }
       else {
           return showInputDialog("Enter Input", null, message.toString());
       }   
    }

    /**
     * Shows a question-message dialog requesting input from the user 
     * @param o -- ignored, for legacy purposes
     * @param message -- text to display
     * @return 
     */
    public static String showInputDialog(Object o, Object message) {
         
       if (message instanceof String) {
           return showInputDialog("Enter Input", null, (String)message);
       }
       else {
           return showInputDialog("Enter Input", null, message.toString());
       }   
    }
    
    /**
     * Shows a question-message dialog requesting input from the user 
     * @param o -- ignored, for legacy purposes
     * @param message -- text to display
     * @param initialSelectionValue -- the value used to initialize the input
     * field
     * @return 
     */
    public static String showInputDialog(Object o, Object message, Object 
            initialSelectionValue) {
       if (message instanceof String) {
           if (initialSelectionValue instanceof String) {
               return showInputDialog("Enter Input", null, (String)message, 
                   (String)initialSelectionValue);               
           }
           else {
               return showInputDialog("Enter Input", null, (String)message, 
                   initialSelectionValue.toString());               
           }
       }
       else {
           if (initialSelectionValue instanceof String) {
                return showInputDialog("Enter Input", null, message.toString(), 
                   (String)initialSelectionValue);             
           }
           else {
                return showInputDialog("Enter Input", null, message.toString(), 
                   initialSelectionValue.toString());                            
           }
       }       
    }
    /**
     * emulate JOptionPane.showMessageDialog using JavaFX dialog
     * Shows a question-message dialog requesting input from the user
     * @param title -- text to show at the top of the dialog window
     * @param header -- text to show in the dialog type pane
     * @param prompt -- text to show next to the entry prompt
     * @return 
     */
    public static String showInputDialog(String title, String header, 
            String prompt) {
       return showInputDialog(title, header, prompt, null);
    }
    
    /**
     * 
     * @param title
     * @param header
     * @param prompt
     * @param initialSelectionValue
     * @return 
     */
     public static String showInputDialog(String title, String header, 
            String prompt, Object initialSelectionValue) {
        TextInputDialog dialog = new TextInputDialog();
       dialog.setTitle(title);
       dialog.setHeaderText(header);
       dialog.setContentText(prompt);
       if (initialSelectionValue instanceof String) {
          dialog.setContentText((String)initialSelectionValue);     
       }
       else if (initialSelectionValue != null) {
           dialog.setContentText(initialSelectionValue.toString());    
       }
       
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
    public static void showMessageDialog(Object message) {
        if (message instanceof String) {
           showMessageDialog("Information Dialog", null, (String)message);     
        }
        else {
           showMessageDialog("Information", null, message.toString());      
        }
    }
    
    /**
     * Show an alert dialog
     * @param title -- text to show at the top of the dialog window
     * @param header -- text to show in the dialog type pane
     * @param content -- the message or core content of the dialog
     */
    public static void showMessageDialog(String title, String header, 
                                         String content) {
        showMessageDialog(title, header, content,
                Alert.AlertType.INFORMATION);
    }
    
        /**
     * Show an alert dialog
     * @param title -- text to show at the top of the dialog window
     * @param header -- text to show in the dialog type pane
     * @param content -- the message or core content of the dialog
     * @param messageType -- type of alert dialog to show
     */
    public static void showMessageDialog(String title, String header, 
                                         String content, 
                                         Alert.AlertType messageType) {
       Alert alert = new Alert(messageType);
       alert.setTitle(title);
       alert.setHeaderText(header);
       alert.setContentText(content);
       alert.showAndWait();
    }
    
    /**
     * Bring up a dialog with OK and CANCEL choices
     * @param message -- text to display
     * @param title -- text to show at the top of the dialog window
     * @param messageType
     * @return string of button pressed by user
     */
    public static String showConfirmdialog(Object message, String title, 
                                           Alert.AlertType messageType) {
        Alert alert = new Alert(messageType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        if (message instanceof String) {
            alert.setContentText((String)message);    
        }
        else {
            if (message != null) {
                alert.setContentText(message.toString());    
            }            
            else {
                return ButtonType.CANCEL.getText();
            }
        }
        Optional<ButtonType> result = alert.showAndWait();
        return result.get().getText();
    }
    
    public static String showConfirmdialog(Object message){
        return showConfirmdialog(message, "Confirmation Dialog", 
                           Alert.AlertType.CONFIRMATION);
    }
}