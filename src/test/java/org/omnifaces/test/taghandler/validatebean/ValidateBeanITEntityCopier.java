/*
 * Copyright OmniFaces
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package org.omnifaces.test.taghandler.validatebean;

import org.omnifaces.util.copier.Copier;

public class ValidateBeanITEntityCopier implements Copier {

	@Override
	public ValidateBeanITEntity copy(Object object) {
		ValidateBeanITEntity original = (ValidateBeanITEntity) object;
		ValidateBeanITEntity copy = new ValidateBeanITEntity();
		copy.setNumber1(original.getNumber1());
		copy.setNumber2(original.getNumber2());
		return copy;
	}

}