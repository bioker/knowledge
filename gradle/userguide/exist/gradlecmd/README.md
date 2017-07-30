# Using the Gradle Command-Line

## Executing multiple tasks

+ You can execute multiple tasks in a single build by
    listing each of the tasks on the command line
+ Command `gradle compile test` will execute *compile*
    and *test* tasks
+ Gradle will execute the tasks in the order that they
    are listed on the command line and will also execute
    their dependencies
+ Gradle execute one task only one time at build

+ [Example](example1/build.gradle)

## Exclude task

+ You can exclude task with -x option `gradle dist -x test`

## Continuing the build when failure occurs

+ If you want to continue the build even if some failure occurs
    you need to use `--continue` option

## Task name abbreviation

+ You can launch the task with only enough part of task name for it
    identity
+ For example *dist* task can be launched with command
    `gradle di`
+ For example *compileTest* task can be launched with command
    `gradle cT`
