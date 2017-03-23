/**
 * 
 */
package com.groovy.test

import org.junit.Test

import com.config.Account
import com.config.Validation
import com.config.Validator

/**
 * @author satish
 *
 */
class JsonClassParserTest {

	@Test
	void testParse() {
		Account account = new Account("account.json")
		//println account.addAmount(100)
		//println account.withdrawAmount(50)
		Validator validate = new Validator("validator.json")
		String name = "satis"
		//println validate.isNull(name)
		//println validate.isValidLength(name)
		Validation valid = new Validation()
		println valid.isNull(name)
		println valid.isValidLength(name)
		println valid.typeCheck(name)

	}
}
