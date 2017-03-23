/**
 * 
 */
package com.config

import groovy.json.JsonSlurper

/**
 * @author satish
 *
 */
class JsonParser {

	def static make(closure) {
		JsonParser parser = new JsonParser()
		closure.delegate = parser
		closure()
	}

	/**
	 * Reads the given Json file and returns the Object. We can access the Json file properties on this returned object. 
	 * @param filenName
	 * @return
	 */
	def jsonFileToRead(String fileName) {
		JSON json = JSON.getJson(fileName)
		def obj = new JsonSlurper().parse(json.getFile())
		return obj
	}

	def getJsonObject(String fileName) {
		ClassLoader classLoader = this.getClass().getClassLoader()
		File file = new File(classLoader.getResource(fileName).getFile())
		byte[] array = new byte[(int) file.length()]
		FileInputStream inputStream = new FileInputStream(file)
		inputStream.read(array)
		Class screening = classLoader.defineClass(fileName, array, 0, array.size())
		return screening
	}
}