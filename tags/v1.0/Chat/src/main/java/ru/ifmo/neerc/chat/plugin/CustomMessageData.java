/*
   Copyright 2009 NEERC team

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
/*
 * Date: Nov 18, 2007
 *
 * $Id$
 */
package ru.ifmo.neerc.chat.plugin;

import ru.ifmo.ips.config.Config;

/**
 * <code>CustomMessageData</code> interface
 *
 * @author Matvey Kazakov
 */
public interface CustomMessageData {
    
    String getDataType();
    
    void serialize(Config cfg);
    
    void deserialize(Config cfg);
    
    String asString();
}