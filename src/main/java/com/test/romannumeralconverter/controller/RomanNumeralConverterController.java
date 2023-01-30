package com.test.romannumeralconverter.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanNumeralConverterController {

	private static final String[] ROMAN_NUMERALS = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV",
			"I" };
	private static final int[] NUMERIC_VALUES = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

	@GetMapping("/digittonum/{value}")
	public ResponseEntity<String> convertDigitToNumeral(@PathVariable("value") Integer value) {
		if (value <= 0 || value > 4000) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Invalid value. Please enter a value between 1 and 4000.");
		}

		StringBuilder numeral = new StringBuilder();
		for (int i = 0; i < NUMERIC_VALUES.length; i++) {
			while (value >= NUMERIC_VALUES[i]) {
				numeral.append(ROMAN_NUMERALS[i]);
				value -= NUMERIC_VALUES[i];
			}
		}
		return ResponseEntity.status(HttpStatus.OK).body(numeral.toString());

	}

	@GetMapping("/numtodigit/{value}")
	public ResponseEntity<Integer> convertNumeralToDigit(@PathVariable("value") String value) {
		if (!value.matches("^[MDCLXVI]+$")) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(0);
		}

		int digit = 0;
		for (int i = 0; i < value.length(); i++) {
			if (i > 0 && NUMERIC_VALUES[indexOf(ROMAN_NUMERALS,
					String.valueOf(value.charAt(i)))] > NUMERIC_VALUES[indexOf(ROMAN_NUMERALS,
							String.valueOf(value.charAt(i - 1)))]) {
				digit += NUMERIC_VALUES[indexOf(ROMAN_NUMERALS, String.valueOf(value.charAt(i)))]
						- 2 * NUMERIC_VALUES[indexOf(ROMAN_NUMERALS, String.valueOf(value.charAt(i - 1)))];
			} else {
				digit += NUMERIC_VALUES[indexOf(ROMAN_NUMERALS, String.valueOf(value.charAt(i)))];
			}
		}
		return ResponseEntity.status(HttpStatus.OK).body(digit);
	}

	private int indexOf(String[] arr, String key) {
		int i = 0;
		for (String str : arr) {
			if (str.equals(key)) {
				return i;
			}
			i++;
		}
		return -1;
	}

}
