/*******************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package org.apache.drill.common.physical.pop;

import java.util.Iterator;
import java.util.List;

import org.apache.drill.common.JSONOptions;
import org.apache.drill.common.config.DrillConfig;
import org.apache.drill.common.physical.FieldSet;
import org.apache.drill.common.physical.ReadEntry;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;

public abstract class ScanPOP<T extends ReadEntry> extends POPBase implements SourcePOP{
  static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ScanPOP.class);
  
  private List<T> readEntries;
  
  public ScanPOP(List<T> readEntries, FieldSet fieldSet) {
    super(fieldSet);
    this.readEntries = readEntries;
  }

  @JsonProperty("entries")
  public List<T> getReadEntries() {
    return readEntries;
  }
  
  @Override
  public Iterator<PhysicalOperator> iterator() {
    return Iterators.emptyIterator();
  }

  
}