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
package jarviewer.utils;

/**
 * Utility class responsible for splitting a full file path into its constituent
 * file name and folder name.
 *
 * @author david@developinjava.com
 */
public class FileUtils {

    private String folder;
    private String fileName;
    private static char SEPARATOR = '/';

    /**
     * Public Contructor.
     * Takes a full file name including path and splits this up into the
     * filename and the path.
     *
     * @param fullName The full filename and path.
     */
    public FileUtils(String fullName) {
        int sep = fullName.lastIndexOf(SEPARATOR);
        if (sep > 0) {
            folder = fullName.substring(0, sep);
            fileName = fullName.substring(sep + 1, fullName.length());
        } else {
            folder = "";
            fileName = fullName;
        }
    }

    /**
     * Gets the path element (folder name).
     * @return The folder name.
     */
    public String getFolder() {
        return folder;
    }

    /**
     * Gets the file name (without path).
     * @return The file name without path.
     */
    public String getFileName() {
        return fileName;
    }
}
