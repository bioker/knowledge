# Java Management Extensions

+ [Back](../README.md)

## Usage

+ View and change application configuration
+ Collect information about application working
+ Notify about errors

## Layers

+ Manager Level
    + Description
        + Components for interaction with Agent level 
    + Components
+ Agent Level
    + Description
        + Agents for MBeans publication and launching
    + Components
        + MBean server
        + Agent services
            + Dynamic Class Loader
            + Monitors
            + Timers
            + Other
+ Instrumentation Level
    + Description
        + Contains resources which is under control
    + Components
        + MBeans
            + Standard
                + Java Beans
            + Dynamic
                + Special interface implementation
            + Open
                + Dynamic MBeans which used only with simple types
            + Model
                + Fully configurable Dynamic MBeans
        + Notification Model
            + Event based model for information exchanging
        + MBean Metadata classes
