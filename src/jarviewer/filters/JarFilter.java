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
package jarviewer.filters;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 * File filter for use with a JFileChooser that allows Jar files only to be
 * selected.
 *
 * @author david@developinjava.com
 */
public class JarFilter extends FileFilter {

    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        if (f.getPath().toLowerCase().endsWith(".jar")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getDescription() {
        return "Jar Files (*.jar)";
    }
}
