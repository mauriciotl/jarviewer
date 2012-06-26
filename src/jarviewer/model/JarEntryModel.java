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
package jarviewer.model;

import jarviewer.utils.FileUtils;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import javax.swing.table.AbstractTableModel;

/**
 * TableModel class holding the entries (class name and package) from the Jar
 * file.  The class uses the standard Java methods for extracting class names
 * from a Jar file.
 *
 * @author david@developinjava.com
 */
public class JarEntryModel extends AbstractTableModel {

    private String[] columnNames = {"Class Name", "Package"};
    private JarFile jarFile;
    private ArrayList<JarEntry> entries = new ArrayList<JarEntry>();

    /**
     * Public constructor.  The only way to construct a JarEntryModel specifying
     * a Jar file to analyse.
     *
     * @param file The Jar file to analyse.
     */
    public JarEntryModel(JarFile file) {
        this.jarFile = file;
        initialise();
    }

    /**
     * Get the number of rows in the table (i.e. number of files in the
     * Jar file).
     *
     * @return Rows.
     */
    public int getRowCount() {
        return entries.size();
    }

    /**
     * Get the number of columns in the table.  This aways returns 2.
     * The first column represents the class name whereas the
     * second column represents the package name.
     *
     * @return Columns.
     */
    public int getColumnCount() {
        return columnNames.length;
    }

    /**
     * Gets a specific entry (class name or package name) in the table model.
     *
     * @param rowIndex Row number.
     * @param columnIndex Column number.
     * @return The vaue at the specified (row,column).
     */
    public Object getValueAt(int rowIndex, int columnIndex) {
        FileUtils fu = new FileUtils(entries.get(rowIndex).getName());
        if (columnIndex == 0) {
            return fu.getFileName();
        } else {
            return fu.getFolder();
        }
    }

    /**
     * Gets the name of the specified column.
     *
     * @param col Column number
     * @return Name of the column.
     */
    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    /**
     * Gets the Jar file and extracts all classe names and package names for
     * all the files in the Jar file.  These entries are then stored in an
     * ArrayList of JarEntry objects.
     */
    private void initialise() {
        Enumeration<JarEntry> files = jarFile.entries();
        while (files.hasMoreElements()) {
            JarEntry je = files.nextElement();
            if (!je.isDirectory()) {
                entries.add(je);
            }
        }
    }
}
