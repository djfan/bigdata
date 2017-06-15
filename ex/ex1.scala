
val exchangeRate: Double = 0.88

val dollars: Int = 100.00

val dollars: Int = 100

var euros = 0.0

euros = dollars * exchangeRate

print(euros)

dollars = 500

var dollars = 500

dollars = 500.0

var eurosInt: Int = 0

eurosInt = dollars * exchangeRate

eurosInt = dollars * exchangeRate.toInt
print(eurosInt)

// The result is 0, which is not useful. Because toInt function make exchangeRate (float 0.88) equal to 0.

eurosInt = (dollars * exchangeRate).toInt
print(eurosInt)

eurosInt.getClass

dollars.getClass

exchangeRate.getClass

print("$" + dollars + " = " + eurosInt + " Euros")

27/3.0

res4 * 2

res4 = 22.5

// Because res4 is a immutable variable, we can't assign new value to it.

import scala.math.pow

pow(2,3)

import scala.math.sqrt

sqrt(64)

val record: String = "2017-01-08:10:00:00, 12345678-aaaa-1000-gggg-000111222333, 58, TRUE, enabled, disabled, 37.819722,-122.478611" 

record.length

record.contains("disabled")

record.indexOf("16")

// "16" does not appear in record.

record.toLowerCase.indexOf("true")

record.slice(63, 67)

// Last step is correct.

var record2 = record

record == record2 

record2 = "no match"

record == record2 
