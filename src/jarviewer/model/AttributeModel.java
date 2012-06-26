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

import jarviewer.utils.NameValue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 * TableModel class holding the attributes from the Jar mainfest file.
 *
 * @author david@developinjava.com
 */
public class AttributeModel extends AbstractTableModel {

    private String[] columnNames = {"Attribute", "Value"};
    private JarFile jarFile;
    private ArrayList<NameValue> entries = new ArrayList<NameValue>();

    /**
     * Public constructor.  The only way to construct an AttributeModel specifying
     * a Jar file to analyse.
     *
     * @param file The Jar file to analyse.
     */
    public AttributeModel(JarFile file) {
        this.jarFile = file;
        initialise();
    }

    /**
     * Get the number of rows in the table (i.e. number of attributes in the
     * mainfest file).
     *
     * @return Rows.
     */
    public int getRowCount() {
        return entries.size();
    }

    /**
     * Get the number of columns in the table.  This aways returns 2.
     * The first column represents the name of the attribute whereas the
     * second column represents the value of the attribute.
     *
     * @return Columns.
     */
    public int getColumnCount() {
        return columnNames.length;
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
     * Gets a specific entry (attribute or value) in the table model.
     *
     * @param rowIndex Row number.
     * @param columnIndex Column number.
     * @return The vaue at the specified (row,column).
     */
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return entries.get(rowIndex).getName();
        } else {
            return entries.get(rowIndex).getValue();
        }
    }

    /**
     * Gets the manifest file from the Jar file and extracts all the attributes
     * and their values from it.  The attributes are then stored in an ArrayList
     * of NameValue objects.
     */
    private void initialise() {

        Manifest mf;
        try {
            mf = jarFile.getManifest();
            Attributes attr = mf.getMainAttributes();
            for (Object obj : attr.keySet()) {
                entries.add(new NameValue(obj.toString(), attr.getValue(obj.toString())));
            }
        } catch (IOException ex) {
            Logger.getLogger(AttributeModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
