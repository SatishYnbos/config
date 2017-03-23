/**
 * 
 */
package com.groovy.test

import org.junit.Test

import com.config.Property

/**
 * @author satish
 *
 */
class PropertyTest {
	@Test
	void testProperty() {
		//String propertyValue = Property.get("karoo.URL")
		Property prop = new Property()
		//String propertyValue = prop.getKarooURL()
		//println propertyValue
		prop.setSatishId("10")
		String propertyValue = prop.getSatishId()
		println propertyValue
	}
}
