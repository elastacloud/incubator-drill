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
package org.apache.drill.common.expression.visitors;

import org.apache.drill.common.expression.FunctionCall;
import org.apache.drill.common.expression.IfExpression;
import org.apache.drill.common.expression.SchemaPath;
import org.apache.drill.common.expression.ValueExpressions.BooleanExpression;
import org.apache.drill.common.expression.ValueExpressions.DoubleExpression;
import org.apache.drill.common.expression.ValueExpressions.LongExpression;
import org.apache.drill.common.expression.ValueExpressions.QuotedString;

public abstract class SimpleExprVisitor<T> implements ExprVisitor<T, Void, RuntimeException>{

  @Override
  public T visitFunctionCall(FunctionCall call, Void value) throws RuntimeException {
    return visitFunctionCall(call);
  }

  @Override
  public T visitIfExpression(IfExpression ifExpr, Void value) throws RuntimeException {
    return visitIfExpression(ifExpr);
  }

  @Override
  public T visitSchemaPath(SchemaPath path, Void value) throws RuntimeException {
    return visitSchemaPath(path);
  }

  @Override
  public T visitLongConstant(LongExpression intExpr, Void value) throws RuntimeException {
    return visitLongConstant(intExpr);
  }

  @Override
  public T visitDoubleConstant(DoubleExpression dExpr, Void value) throws RuntimeException {
    return visitDoubleConstant(dExpr);
  }

  @Override
  public T visitBooleanConstant(BooleanExpression e, Void value) throws RuntimeException {
    return visitBooleanConstant(e);
  }

  @Override
  public T visitQuotedStringConstant(QuotedString e, Void value) throws RuntimeException {
    return visitQuotedStringConstant(e);
  }

  
  public abstract T visitFunctionCall(FunctionCall call);
  public abstract T visitIfExpression(IfExpression ifExpr);
  public abstract T visitSchemaPath(SchemaPath path);
  public abstract T visitLongConstant(LongExpression intExpr);
  public abstract T visitDoubleConstant(DoubleExpression dExpr);
  public abstract T visitBooleanConstant(BooleanExpression e);
  public abstract T visitQuotedStringConstant(QuotedString e); 
}
