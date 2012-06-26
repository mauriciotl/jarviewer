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
 * 
 * @author david@developinjava.com
 */
public class NameValueTest {

    public NameValueTest() {
    }

    @Test
    public void testGetName() {
        NameValue instance = new NameValue("myName", "myValue");
        String expResult = "myName";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetValue() {
        NameValue instance = new NameValue("myName", "myValue");
        String expResult = "myValue";
        String result = instance.getValue();
        assertEquals(expResult, result);
    }

}