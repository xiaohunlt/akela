/**
 * Copyright 2010 Mozilla Foundation
 *
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
package com.mozilla.pig.eval;

import java.io.IOException;

import org.apache.pig.EvalFunc;
import org.apache.pig.data.DataBag;
import org.apache.pig.data.DefaultTuple;
import org.apache.pig.data.Tuple;

public class Size extends EvalFunc<Long> {

	public Long exec(Tuple input) throws IOException {
		if (input == null) {
			return null;
		}
		
		long n = 0;
		if (input.size() != 0) { 			
			Object obj = input.get(0);
			if (obj instanceof DefaultTuple) {
				n = ((DefaultTuple)obj).size();
			} else if (obj instanceof DataBag) {
				n = ((DataBag) obj).size();
			} else if (obj instanceof String) {
			    n = ((String) obj).length();
			}
		}
		
		return n;
	}
	
}