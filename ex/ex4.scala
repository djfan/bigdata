// nyu hpc dumbo

sc.textFile("file:/home/df1676/devicestatus.txt").map(x => x.split(x(19)).map(_.trim)).filter(y => y.length==14).map(x => (x(0), x(1).split(' ')(0),x(2), x(12), x(13))).map(_.productIterator.mkString(",")).saveAsTextFile("hdfs:/user/df1676/loudacre/devstatus/devicestatus_etl")
