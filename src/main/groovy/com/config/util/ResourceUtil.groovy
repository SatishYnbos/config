/**
 * 
 */
package com.config.util

/**
 * @author satish
 *
 */
class ResourceUtil {

	/**
	 * This method will get the file from resources source folder by providing
	 * the file name
	 * 
	 * @param fileName
	 * @return
	 */
	static File getResource(String fileName) {
		ResourceUtil util = new ResourceUtil()
		ClassLoader classLoader = util.getClass().getClassLoader()
		File file = new File(classLoader.getResource(fileName).getFile())
		return file
	}
}
