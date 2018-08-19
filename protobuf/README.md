# Protocol Buffers

## Description

+ It's used to describe data format and also service definitions that
    processes the data of this format
+ One place to describe and many implementations for several languages
    to use it independently

## Features

+ Message format - single chunk of data with predefined structure to process
    in request
+ Message fields - fields for particular type of data parts
    + Simple types (strings, numbers, bytes, booleans)
    + Complex types (enums, other messages)
    + Can be repeated (in case you need a list of values in one message)
+ Version evolution control features - in case when you update your definition
    + Rules
        + Don't change number of fields for any existing fields
        + Old code can use new format (in case of saving old fields)
            + New fields will be ingored
        + New code can handle messages from code considering default values
        + `reserved` statement for avoiding to override numbers of old 
            fields that was removed
+ Code generation from `.proto` to specified language
+ Default values for fields in message
+ Import from other files
+ Nested definitions
+ Special types of fields
    + repeated (List)
    + Map
    + Any
    + OneOf
+ Packages for names resolution
+ Defining RPC services
+ Options
    + Types
        + For file
        + For message
        + For field
        + Other
    + Java related options
        + `java_package` 
        + `java_multiple_files`
        + `java_outer_classname`
        + `optimize_for`

## [Hello World example](test/README.md)
