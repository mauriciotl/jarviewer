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
 * Utility class for representing a name and a value.
 *
 * @author david@developinjava.com
 */
public class NameValue {

    private String name;
    private String value;

    /**
     * Public Contructor - the only way to construct a NameValue is through
     * this constructor.  This enforces that a NameValue always has a name
     * and corresponding value.
     *
     * @param name The name of the object.
     * @param value The value of the object.
     */
    public NameValue(String name, String value) {
        this.name = name;
        this.value = value;
    }

    /**
     * Get the name of the object represented by the NameValue.
     * @return Name.
     */
    public String getName() {
        return name;
    }

    /**
     * Get the value of the object represented by the NameValue.
     * @return Value.
     */
    public String getValue() {
        return value;
    }
}
