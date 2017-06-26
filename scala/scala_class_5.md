To use both mutable and immutable versions of collections, use:

```scala
import scala.collection.mutable
```

• Then, to create a mutable Set use mutable.Set

• To create an immutable Set, simply specify it as Set



---

### different collection types

```scala
// Traversable 
val modelTrav = Traversable("MeToo", "Ronin", "iFruit")

// While you are guaranteed that all elements of the collection will be processed, you are not guaranteed of an order of processing
```

```scala
// Iterable
val models = Iterable("MeToo", "Ronin", "iFruit")
val modelIter = models.iterator
modelIter.next

// Iterable adds the ability to iterate through each element, one at a time. 
// Data is resident in memory only as it is used
```

```scala
// Seq
val mySeq = Seq("MeToo", "Ronin", "iFruit")
mySeq(1)

// Seq adds the ability to access each element at a fixed offset (index)
// First element is at index 0
// Seq(n) returns the value of the element at offset n
```

```scala
// Set
val mySet = Set("MeToo", "Ronin", "iFruit")
mySet.size
mySet("Banana")
> Boolean = false
val myset2 = mySet.drop(1)

// Set removes duplicates; 
// Does not change ordering
// Set(value) returns true or false
```

```scala
// Map - Immutable by default – values are not modified in place
val wifiStatus = Map(
"disabled" -> "Wifi off",
"enabled" -> "Wifi on but disconnected",
"connected" -> "Wifi on and connected")
wifiStatus("enabled")
> String = Wifi on but disconnected
// Map stores (key ! value) pairs

Map((key1, value1), (key2, value2))
Map(key1 -> value1, key2 -> value2)
// Keys are unique and may only appear once; values are not unique

// Commonly used for in-memory tables requiring fast access
phoneStatus.contains("DTS")
> Boolean = true
phoneStatus.keys
phoneStatus.values

// get & getOrElse
phoneStatus("key_does_not_exist")
> java.util.NoSuchElementException: key not found:
key_does_not_exist ...

phoneStatus.get("key_does_not_exist")
> Option[Any] = None
phoneStatus.get("DTS")
> Option[Any] = Some(2014-03-15:10:10:31)

phoneStatus.getOrElse("key_does_not_exist", "No Key")
> Any = No Key

// we can not change the value in Map
// we can create a mutable Map instead
val mutRec = scala.collection.mutable.Map(("Brand" -> "Titanic"), ("Model" -> "4000"), ("Wifi" -> "enabled"))
mutRec("Wifi") = "disabled"
mutRec
```

---

```scala
// Seq
// LinearSeq : Optimized for head and tail access
	// List
		// ListBuffer
	// Stream

// IndexedSeq : Optimized for apply, insert, remove, and update 
	// Array
		// ArrayBuffer
	// Vector
// * Buffer: mutable version


```

```scala
// List - finite immutable sequence
val newList = "a" :: "b" :: "c" :: Nil
> newList: List[String] = List(a, b, c)

val models = List("Titanic", "Sorrento", "Ronin")
// 0-base index

val randomlist = List("iFruit", 3, "Ronin", 5.2)
> randomlist: List[Any] = List(iFruit, 3, Ronin, 5.2)
// Lists can contain a single data type or type Any

val devices = List(("Sorrento", 10), ("Sorrento", 20), ("iFruit", 30))

val myListC = myListA.intersect(myListB)
val myListC = myListA.union(myListB) // not sysmetric

val myListE = myListA :+ "xPhone"
// append element

val myListD = myListA ++ myListB
val myListD = myListA ::: myListB
> myListC: List[String] = List(iFruit, Sorrento, Ronin, iFruit, MeToo, Ronin)
// The ::: method is specific to List, while ++ is part of any Traversable
```

```scala
// ListBuffer - immutable
val listBuf = scala.collection.mutable.ListBuffer.empty[Int]

listBuf += 17
> listBuf.type = ListBuffer(17, 29, 45)
listBuf -= 17
> listBuf.type = ListBuffer(29, 45)

// ListBuffer is mutable with respect to its elements, however, attempts to reassign the pointer address are not allowed if it was declared with val

val listBuf2 = ListBuffer("abc")
listBuf = listBuf2 // because "val listBuf"
> error: reassignment to val listBuf = listBuf2

var listBufVar = ListBuffer("one")
listBufVar = listBuf2
>scala.collection.mutable.ListBuffer[String] =
ListBuffer(abc)
//if ListBuf2 changes, ListBufVar changes as well
```

```scala
// Array - mutable(:element) But not resizable
// An Array is mutable but not resizable
// Created with a fixed number of elements
	// • You cannot change the number of elements in the array
	// • You can update the value of an existing element
// Array elements can be of a single type or Any
val devs = Array("iFruit", "MeToo", "Ronin")
devs(2) = "Ronin"

// Arrays are fixed in both size and type
val devices: Array[String] = new Array[String](4)
devices.update(0, "Sorrento")
devices
> Array[String] = Array(Sorrento, null, null, null)
devices(1) = 256
> error: type mismatch; found: Int(256) required: String
```

```scala
// Vector - immutable, modifications are not made in place
val vec = Vector(1, 18, 6)
vec.updated(1, 30) // not in place
// vec -? Vector(1, 18, 6)

// Unlike Array, a Vector has flexible size
var vec = Vector(1, 6, 21)
vec = vec :+ 5 
vec = 77 +: vec
```



```scala
// String
// Strings in Scala are treated as collections similar to Arrays
val myStr = "A Banana"
myStr(2)
```



---

```markdown
- Sets: Creating a Collection of Unique Elements
- Lists and ListBuffers: Fast Access to Head of Collection
- Arrays: Fast Access to Arbitrary Elements
- Maps: Fast Access with a Key

```



```markdown
• Tuple
	• Fixed size: Tuple2, Tuple3, ..., Tuple22
	• Not part of the collection library
	• Created at compile time, which restricts their flexibility
• List
	• Flexible size
	• Elements are immutable, so they cannot be changed by assignment
	• Fast addition and removal at head
	• Slow access to arbitrary indexes
• ListBuffer
	• Flexible size
	• Elements are mutable
	• Constant time append and prepend operations
• Array
	• Created with a fixed number of elements and not resizable
	• Fast access to arbitrary indexes
• Map
	• For working with key-value pairs
	• To create a mutable Map, import scala.collection.mutable explicitly and declare the Map as mutable.Map
```



---

### conversion

```scala
// List -> Array
val myList = List("Titanic", "F01L", "enabled", 32)
val myArray = myList.toArray
val myIterable = myList.toIterable

//Tuple -> List
val myTup = (4, "MeToo", "1.0", 37.5, 41.3, "Enabled")
val myList = myTup.productIterator.toList

//String -> Array / List / Set
val myStr = "A Banana"
myStr.toArray
myStr.toList
myStr.toSet
```



---

### type of the elements in a collection

```scala
val myMap: Map[Int,String] = Map(1 -> "a", 2 -> "b")
val myMap = Map(1 -> "a", 2 -> "b")
```



