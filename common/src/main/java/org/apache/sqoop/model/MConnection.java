/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.sqoop.model;

import java.util.List;

/**
 * Metadata describing all required information to build up an connection
 * object. Both connector and framework will have it's own MConnection part of
 * metadata.
 */
public class MConnection extends MPersistableEntity {

  private final List<MForm> forms;

  public MConnection(List<MForm> forms) {
    this.forms = forms;
  }

  public List<MForm> getForms() {
    return forms;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("connection, forms:");
    sb.append(forms);
    return sb.toString();
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }

    if (!(other instanceof MConnection)) {
      return false;
    }

    MConnection mc = (MConnection) other;
    return forms.equals(mc.forms);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    for(MForm form : forms) {
      result = 31 * result + form.hashCode();
    }

    return result;
  }
}
