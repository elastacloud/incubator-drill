/**
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
 */
package org.apache.drill.exec.memory;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.PooledByteBufAllocatorL;

public class DirectBufferAllocator extends BufferAllocator {
  static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(DirectBufferAllocator.class);

  private final PooledByteBufAllocatorL buffer = new PooledByteBufAllocatorL(true);

  public DirectBufferAllocator() {
  }

  @Override
  public ByteBuf buffer(int size) {
    // TODO: wrap it
    return buffer.directBuffer(size);
  }

  @Override
  protected boolean pre(int bytes) {
    // TODO: check allocation
    return true;
  }

  @Override
  public long getAllocatedMemory() {
    return 0;
  }

  @Override
  public ByteBufAllocator getUnderlyingAllocator() {
    return buffer;
  }

  @Override
  public BufferAllocator getChildAllocator(long initialReservation, long maximumReservation) {
    // TODO: Add child account allocator.
    return this;
  }

  @Override
  public void close() {
    // TODO: collect all buffers and release them away using a weak hashmap so we don't impact pool work
  }

}
