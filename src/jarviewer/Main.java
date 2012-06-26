/* Copyright 2009-2010 david@developinjava.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package jarviewer;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

/**
 * The main entry point for the Jar Viewer application.
 *
 * @author david@developinjava.com
 */
public class Main {

    /**
     * Main entry point for application.
     *
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                MainForm form = new MainForm();
                form.setVisible(true);
                if (args.length == 1) {
                    form.setFile(args[0]);
                }
            }
        });
    }
}
