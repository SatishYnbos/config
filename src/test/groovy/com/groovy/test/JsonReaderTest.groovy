/**
 *
 */
package com.groovy.test
import static org.junit.Assert.*;

import org.junit.*;

import com.config.JsonParser

import groovy.json.JsonSlurper
/**
 * @author satish
 *
 */
class JsonParserTest {
	@Test
	void testJsonReader() {

		JsonParser.make {
			jsonFileToRead "screening.json"
			getJsonObject "screening.json"
		}


		/*def object = JsonParser.readJsonFile("screening.json")
		 assertEquals(object.id, "001000062805126")
		 assertNotEquals(object.id, "00100006280512")*/
	}
}
