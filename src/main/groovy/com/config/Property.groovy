/**
 *
 */
package com.config

import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * @author satish
 *
 */
class Property {
	Properties properties;
	Map propertyMap = [:]

	Property() {
		def mc = new ExpandoMetaClass(Property, false, true)
		mc.initialize()
		this.metaClass = mc
		load()
		Enumeration<?> props = properties.propertyNames()
		while (props.hasMoreElements()) {
			String property = (String) props.nextElement();
			propertyMap.put(property, properties.getProperty(property))
		}
	}

	def methodMissing(String name, args) {
		// Intercept method that starts with get.
		if (name.startsWith("get")) {
			convenientMap()
			String key = name.substring(3)
			if (key.charAt(0).isLowerCase()) {
				throw new RuntimeException("Please check the method naming convention: "+name)
			}
			if(!propertyMap.containsKey(key)) {
				throw new RuntimeException("Don't have this property in property File: "+key)
			}
			def result = propertyMap.get(key)
			// Add new method to class with metaClass.
			//this.metaClass."$name" = {-> result }
			result
		} else if (name.startsWith("set")) {
			String key = name.substring(3)
			if (key.charAt(0).isLowerCase()) {
				throw new RuntimeException("Please follow method naming convention: "+name)
			}
			// Add new method to class with metaClass.
			//this.metaClass."$name"// = args
			propertyMap.put(key, args.getAt(0).toString())
			println propertyMap
		} else {
			throw new MissingMethodException(name, this.class, args)
		}
	}

	/**
	 * this method loads the property file
	 */
	void load() {
		InputStream input = this.class.getClassLoader().getResourceAsStream("czen.properties")
		properties = new Properties()
		properties.load(input)
	}

	/**
	 * it updates the propertyMap to use in methodMissing()
	 */
	private void convenientMap() {
		String[] keyArray = propertyMap.keySet().toArray(new String[propertyMap.size()])
		for (String orginalKey : keyArray) {
			String capKey = capitalizeFirstLetter(orginalKey)
			if (capKey.contains('.')) {
				String newKey = capKey.replace('.', '')
				if (!newKey.equals(orginalKey)) {
					propertyMap.put(newKey, propertyMap.get(orginalKey))
					propertyMap.remove(orginalKey)
				}
			}
		}
	}

	/**
	 * this method capitalize the first letter of the string and every word after . character  
	 * @param string
	 * @return
	 */
	public String capitalizeFirstLetter(String string) {
		Pattern pattern = Pattern.compile("\\b[a-z.]");
		Matcher matcher = pattern.matcher(string);
		StringBuffer buffer = new StringBuffer();
		while (matcher.find())
			matcher.appendReplacement(buffer, matcher.group().toUpperCase());
		matcher.appendTail(buffer);
		return buffer.toString();
	}
}
