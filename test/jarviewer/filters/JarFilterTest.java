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
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * JUnit test class for jarexplorer.filters.JarFilter
 *
 * @author david@developinjava.com
 */
public class JarFilterTest {

    public JarFilterTest() {
    }

    /**
     * Test of accept method, of class JarFilter.
     */
    @Test
    public void testAcceptJar() {
        System.out.println("accept");
        File f = null;
        try {
            f = File.createTempFile("jarexplorer_test", ".jar");
            JarFilter instance = new JarFilter();
            boolean expResult = true;
            boolean result = instance.accept(f);
            assertEquals(expResult, result);
        } catch (IOException ex) {
            Logger.getLogger(JarFilterTest.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (f!=null)
                f.delete();
        }

    }

    /**
     * Test of accept method, of class JarFilter.
     */
    @Test
    public void testAcceptNonJar() {
        System.out.println("accept");
        File f = null;
        try {
            f = File.createTempFile("jarexplorer_test", ".bar");
            JarFilter instance = new JarFilter();
            boolean expResult = false;
            boolean result = instance.accept(f);
            assertEquals(expResult, result);
        } catch (IOException ex) {
            Logger.getLogger(JarFilterTest.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (f!=null)
                f.delete();
        }

    }

    /**
     * Test of getDescription method, of class JarFilter.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        JarFilter instance = new JarFilter();
        String expResult = "Jar Files (*.jar)";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }
}