/**
 * 
 */
package com.config

/**
 * @author satish
 *
 */
class Validation {

	def isNull = { param ->
		if(param == null) {
			return true
		} else {
			return false
		}
	}

	def isValidLength = { param ->
		if (param.length() > 5 && param.length() < 10) {
			return true
		} else {
			return false
		}
	}

	def typeCheck = { param ->  param.class }
}
