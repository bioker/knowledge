# Annotation

+ Annotations is meta information tags 
    for adding and changing behavior of code

+ Features
    + Additional information for compiler
    + Information for external tools for
        + Code generation
        + Configuration
        + etc
    + Can be used at runtime

+ Most known annotation - @Override

+ @Retention
    + Can be applied to another annotation
    + Determine life cycle of annotation
+ @Documented
    + Marks that annotation must be documented
+ @Target
    + Can be applied to another annotation
    + Determine for what elements annotation can be applied
    + Type of element can be set by ElementType parameter
        + FIELD
        + LOCAL_VARIABLE
        + etc
+ @Ineherited
    + Can be applied to another annotation
    + Annotation will be inherited by descendant classes
+ @Override
    + Can be applied only for methods
    + Checks that method is overriden (class ancestor has the same method)
+ @Deprecated
    + Marks that functional is deprecated and must not be used
+ @SafeVarargs
    + Can be applied to static and final methods and constructors with 
        variable count of parameters
    + Deny to use unsafe actions for parameters
+ @SuppressWarnings
    + Suppresses warnings from compiler

+ Life cycle of annotation
    + Can be set by RetentionPolicy parameter
    + SOURCE
        + Exists only in sources and will be removed at compilation
    + CLASS
        + Exists in class files but will be removed at start of application
    + RUNTIME
        + Exists even in runtime

+ Annotations can be applied to
    +  `@Target(ElementType.PACKAGE)`
    +  `@Target(ElementType.TYPE)`
    +  `@Target(ElementType.CONSTRUCTOR)`
    +  `@Target(ElementType.METHOD)`
    +  `@Target(ElementType.FIELD)`
    +  `@Target(ElementType.PARAMETER)`
    +  `@Target(ElementType.LOCAL_VARIABLE)`
    + Can be determined several types
        +  `@Target({ElementType.PACKAGE, ElementType.FIELD})`

+ Annotation creation
    +  `public @interface AnnotationName{String info() default ""}`
