# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.2/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.2/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.0.2/reference/htmlsingle/#web)

### Guides

The following guides illustrate how to use some features concretely:
RomanNumeralConverterController" that defines a REST controller for converting between Roman numerals and Arabic numerals (i.e. digits). It defines two endpoints, "digittonum" and "numtodigit", which can be accessed via a GET request and accept a single path variable "value". The "digittonum" endpoint converts an Arabic numeral (a positive integer between 1 and 4000) to a Roman numeral, while the "numtodigit" endpoint converts a Roman numeral to an Arabic numeral.

The class defines two private static arrays, "ROMAN_NUMERALS" and "NUMERIC_VALUES", that store the Roman numeral symbols and their corresponding values respectively.

The "convertDigitToNumeral" method is called when the "digittonum" endpoint is accessed. It first checks if the value passed in the path variable is within the valid range (1-4000). If it is not, it returns a response with a status of BAD_REQUEST and an error message. If the value is valid, it uses a "StringBuilder" to iterate through the "NUMERIC_VALUES" array, appending the corresponding Roman numeral from the "ROMAN_NUMERALS" array to the "StringBuilder" for each value in the input that is less than the current value in the "NUMERIC_VALUES" array. The resulting Roman numeral is returned in the response.

The "convertNumeralToDigit" method is called when the "numtodigit" endpoint is accessed. It first checks if the value passed in the path variable is a valid Roman numeral using a regular expression. If it is not, it returns a response with a status of BAD_REQUEST and an integer 0. If the value is valid, it uses a loop to iterate through the input Roman numeral, using the "indexOf" method to determine the corresponding value of each symbol in the "NUMERIC_VALUES" array and adding it to a variable "digit". If a symbol's value is greater than the previous symbol's value, the method subtracts twice the value of the previous symbol from "digit" to account for the fact that it was added earlier. The resulting Arabic numeral is returned in the response.

