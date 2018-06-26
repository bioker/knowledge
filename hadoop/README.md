# Hadoop

+ Hadoop modules
    + Common
        + Libraries and utilities required by other modules
    + YARN
        + Job scheduling and cluster resources management
    + Distributed File System (HDFS)
        + Data Storage
    + MapReduce
        + Parallel processing

## MapReduce

+ JobTracker
    + Responsible for
        + Resource management
        + Resource monitoring
        + Scheduling jobs for slaves
        + Jobs monitoring
+ TaskTracker
    + One per cluster
    + Execute job and
        provide status information

## Hadoop Distributed File System

+ Designed to run on large clusters (thousands of machines)
+ Reliable and fault-tolerant

### NameNode

+ Single
+ Manages file system metadata

### DataNode

+ One or many
+ Stores actual data

## How it works

+ User/Application submit jobs to Hadoop job client with parameters:
    + Location of input and output files
    + Java classes (jar) with implementation
        of map-reduce functions
    + Job configuration parameters
+ Hadoop Job client submits jobs and configuration to the JobTracker
+ JobTracker distributes jobs for slaves TaskTrackers,
    monitors them, provides status for client
+ TaskTracker execute the job as per MapReduce implementation
    and output of the reduce function is stored in output files in HDFS
