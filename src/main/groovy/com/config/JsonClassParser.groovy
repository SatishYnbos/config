/**
 * 
 */
package com.config

import com.config.util.ResourceUtil
import groovy.json.JsonSlurper

/**
 * @author satish
 *
 */
class JsonClassParser {
	Map jsonMap = null

	JsonClassParser(String jsonFile) {
		def mc = new ExpandoMetaClass(JsonClassParser, false, true)
		mc.initialize()
		this.metaClass = mc
		load(jsonFile)
	}

	void load(String jsonFile) {
		File file = ResourceUtil.getResource(jsonFile)
		jsonMap = new JsonSlurper().parse(file)
	}

	def methodMissing(String name, args) {
		Map subMap = jsonMap
		Object result = null
		if (subMap.containsKey("methods")) {
			subMap = jsonMap.methods
		}
		if (subMap.containsKey(name)) {
			String value = subMap.get(name)
			Closure cl = new GroovyShell().evaluate(value)
			if (cl.getMaximumNumberOfParameters() == 1) {
				result = cl.call(args.getAt(0))
				return result
			} else {
				Closure clo = cl.curry(jsonMap.fields.balance)
				result = clo.call(args.getAt(0))
				jsonMap.fields.put("balance", result)
				return result
			}
			println jsonMap
		}
	}
}
