```bash
# scheme://authority/path
# hdfs://namenodehost/parent/child
```

```shell
hdfs dfs -du [-s] [-h] URI # size of file
hdfs dfs -getfacl <path> # permission
hdfs dfs -setfacl
hdfs dfs -mkdir [-p] <paths> # p for parent dir
hdfs dfs -test -[ezd] URI # e for exist; z for zero; d for dir. Return 0 if True.
hdfs dfs -touchz URI # create a file of zero length
```

