// hdfs dfs -rm -r loudacre/activations/account-models
// hdfs dfs -rm -r loudacre/account-models

import scala.xml._

def getactivations(xmlstring: String): Iterator[Node] = {
val nodes = (XML.loadString(xmlstring) \\ "activation")
nodes.toIterator}

def getaccount(activation: Node): String = {
(activation \ "account-number").text}

def getmodel(activation: Node): String = {
(activation \ "model").text}


sc.wholeTextFiles("hdfs:/user/df1676/loudacre/activations").
map(line => line._2).
flatMap(line => getactivations(line)).
map(line => getaccount(line) + ":" + getmodel(line)).
saveAsTextFile("hdfs:/user/df1676/loudacre/account-models")

// Then Manually move "loudacre/account-models" to "loudacre/activations/account-models"
