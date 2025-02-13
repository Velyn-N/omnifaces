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
package org.omnifaces.test.resourcehandler.versionedresourcehandler;

import static java.util.regex.Pattern.quote;
import static javax.faces.application.ResourceHandler.RESOURCE_IDENTIFIER;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.jupiter.api.Test;
import org.omnifaces.test.OmniFacesIT;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VersionedResourceHandlerIT extends OmniFacesIT {

	@FindBy(css="link[rel=stylesheet]")
	private WebElement someCss;

	@Deployment(testable=false)
	public static WebArchive createDeployment() {
		return buildWebArchive(VersionedResourceHandlerIT.class)
			.withWebXml(WebXml.withVersionedResourceHandler)
			.withFacesConfig(FacesConfig.withVersionedResourceHandler)
			.createDeployment();
	}

	@Test
	public void test() {
		String[] parts = someCss.getAttribute("href").split("\\?", 2);
		String resourceName = parts[0].split(quote(RESOURCE_IDENTIFIER + "/"), 2)[1].split("\\.xhtml", 2)[0];
		String queryString = parts[1];
		assertEquals("some.min.css", resourceName);
		assertEquals("before=true&v=3.13.3", queryString);
	}

}