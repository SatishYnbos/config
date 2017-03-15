/**
 *
 */
package com.groovy.test
import static org.junit.Assert.*;

import org.junit.*;
import groovy.json.JsonSlurper
/**
 * @author satish
 *
 */
class JsonReaderTest {
	@Test
	void testJsonReader() {
		File file = new File("C:/Users/satish/workspace/config/src/test/groovy/com/groovy/test/screening.json")
		def jsonSlurper = new JsonSlurper()
		def object = jsonSlurper.parse(file)
		println object
		assertEquals(object.id, "001000062805126")
		assertNotEquals(object.id, "00100006280512")
		println object.id
	}
}
