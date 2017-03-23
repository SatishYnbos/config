/**
 * 
 */
package com.config

import com.config.util.ResourceUtil

/**
 * @author satish
 *
 */
class JSON {

	private String jsonFile;

	private JSON(String jsonFileName) {
		this.jsonFile = jsonFileName
	}

	/**
	 * this method returns the singleton instance of this class
	 * @param jsonFileName
	 * @return
	 */
	static JSON getJson(String jsonFileName) {
		return new JSON(jsonFileName)
	}

	/**
	 * this method loads the file from the classpath
	 * @return
	 */
	File getFile() {
		return ResourceUtil.getResource(this.jsonFile)
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "JSON [jsonFile=" + jsonFile + "]";
	}
}