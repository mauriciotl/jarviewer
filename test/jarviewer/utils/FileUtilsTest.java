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

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test class for jarexplorer.utils.FileUtils
 * 
 * @author david@developinjava.com
 */
public class FileUtilsTest {

    private static char SEPARATOR='/';
    public FileUtilsTest() {
    }

    /**
     * Test of getFolder method, of class FileUtils.
     */
    @Test
    public void testGetFolder() {
        FileUtils instance = new FileUtils(""+SEPARATOR+"a"+SEPARATOR+"b"+SEPARATOR+"c.class");
        String expResult = ""+SEPARATOR+"a"+SEPARATOR+"b";
        String result = instance.getFolder();
        assertEquals(result, expResult);
    }

    /**
     * Test of getFileName method, of class FileUtils.
     */
    @Test
    public void testGetFileName() {
        FileUtils instance = new FileUtils(""+SEPARATOR+"a"+SEPARATOR+"b"+SEPARATOR+"c.class");
        String expResult = "c.class";
        String result = instance.getFileName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFileName method of class FileUtils where there is no package.
     */
    @Test
    public void testGetFileNameNoPackage() {
        FileUtils instance = new FileUtils("c.class");
        String expResult = "c.class";
        String result = instance.getFileName();
        assertEquals(expResult, result);
    }

    public void testGetFolderNoPackage() {
        FileUtils instance = new FileUtils("c.class");
        String expResult = "";
        String result = instance.getFolder();
        assertEquals(result, expResult);
    }

}