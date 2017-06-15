```shell
spark-shell --master local
```

```scala
//1
val mydata = sc.textFile("file:/home/df1676/frostroad.txt")

//2
mydata.count()

//3
res1: Long = 23

//4
mydata.collect()
```

```shell
# 5
hdfs dfs -mkdir -p loudacre/weblog

#6
hdfs dfs -put ./2014-03-15.log loudacre/weblog/.

#7
hdfs dfs -cat loudacre/weblog/2014-03-15.log
```

```scala
//8
val logfile: String = "hdfs:/user/df1676/loudacre/weblog/2014-03-15.log"

//9
val mydata = sc.textFile(logfile)

//10
mydata.take(10)

//11
val jpgdata = mydata.filter(line => line matches ".*.jpg.*")

//12
jpgdata.take(10)

//13
sc.textFile(logfile).filter(line => line matches ".*.jpg.*").count()
//Long = 423

//14
val l = mydata.map(line => line.length())

//15
// "[\\p{Punct}\\s]+"
// val w = mydata.map(line => line.split("[\\p{Punct}\\s]+"))
val w = mydata.map(line => line.split(" "))

//16
val ip = mydata.flatMap(line => line.split(' ').take(1))

//17
ip.foreach(println)

//18
ip.saveAsTextFile("hdfs:/user/df1676/loudacre/iplist")

```

```shell
# 19
hdfs dfs -ls -r ./loudacre/iplist
```

```scala
//20
val logfile : String = "hdfs:/user/df1676/loudacre/weblogs"

//21
val mydata = sc.textFile(logfile)

//22
mydata.take(10)

//23
val jpgdata = mydata.filter(line => line matches ".*.jpg.*")

//24
jpgdata.take(10)

//25
sc.textFile(logfile).filter(line => line matches ".*.jpg.*").count()
//Long = 64978 

//26
val l = mydata.map(line => line.length())

//27
val w = mydata.map(line => line.split(" "))

//28
val ip = mydata.flatMap(line => line.split(' ').take(1))

//29
ip.foreach(println)

//30
ip.saveAsTextFile("hdfs:/user/df1676/loudacre/bigiplist")


```

```shell
#31
hdfs dfs -ls -r ./loudacre/bigiplist
```
