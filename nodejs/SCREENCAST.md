# NodeJS Screencast

# History

+ Created Ryan Dahi в 2009

+ NodeJS = V8 (by Google) + IO + libraries

+ Alternativities
    + Rhino
    + JSC
    + WSH
    + ...

# Global Objects

+ Java script global objects in browser
    + window
    + location
    + document

+ Java script global objects in nodejs
    + global
    + require
    + module
    + process

+ Java script global objects in browser and nodejs
    + console

# Why NodeJS

+ JavaScript for Frontend and Backend
+ Web applicatons good solution
+ Big count of clients is not problem
+ Big count of modules and package manager npm
+ Big community

# Modules usage

## Reqire

+ require
    + syntax - require('moduleName')
    + used for module to module connection

## Export

+ export
    + syntax - exports.anyVarName = anyYourObject
    + used as require command result

## Global

+ global
    + syntax - global.anyVarName = anyYourObject
    + used for real global variables

## Modules types

+ js
    + extension - .js
    + most used modules stored as js
+ node
    + extension - .node
    + used with C++ compilation
+ json
    + extension - .json
    + data module

+ modules classes
    + core modules
    + other modules

## Upload module order

+ call require('module')
+ file search
    + js
    + node
    + json
+ directory search
    + index.json file search into

## Module object

+ module objects properties
    + id - absolute file path
    + exports
        + module.exports is origin object for
            + exports
            + this
    + parent - module which 'require' this module
        + if module.parent exist then maybe you need use
            exports else you need run your code
    + filename - full path to file of this module
    + loaded - true or false dependent of status of module loading
    + children - modules which was 'required' by this module
    + paths
        + paths where module will be searched
+ module as library or application
    + if you need to use module as library but sometime you
        want use it as application you can check module.parent
        object for determination how module is used. If it
        not null then this module was 'required' from another
        code and you don't need to run the 'main' method
+ right way to using exports
    + you have three variable in module scope
        + module.exports (real object) - can be used but usually is next
            + you may need to use this for make require call of this
                module which will return function which you need. You
                can't use just 'exports' because it just link and if
                you make 'exports = somefunction' you just change link
                instead real export object
        + exports (link) - preferred variable because is short
        + this (link) - usually not used because in function scope
            is another object
+ modules stored in cache by absolute path as id and not loaded twice
    + if you use in two different modules one common it will be loaded
        one time (in first code occurrence) and another time it will be
        gotten from cache
+ modules searching order
    + core modules
    + current directory
    + absolute path
    + relative path
    + node_modules directory
        + in current directory
        + for each directory above in filesystem tree
    + $NODE_PATH
    + $HOME/.node_modules
    + $HOME/.node_libraries
    + $PREFIX/lib/node
+ we can pass parameters when calling 'require'

# NPM using

+ npm adduser - create user
+ npm init - create initial package.json
+ npm publish - publish module to some registry
+ npm search - search module in some registry
    + modules will be installed in nearest dir above with package.json
        or node_modules dir. If this objects not found - use current dir
+ npm install - install module from some registry
+ npm update - update modules
+ npm remove - remove modules
+ npmjs - private repository [github](https://github.com/isaacs/npmjs.org)
+ npm install can be used with git repository url or simple directory
+ npm packages is semver.org versioned
+ package.json
    + dependencies - modules is needed
    + devDependencies - modules for development (download if call npm i in this module)
    + main - entry point of module (use in require)
    + bin - used for calling module functional from shell after global installation 
        as simple shell command
    + scripts - shell scripts by string name keys
+ global modules
    + npm -g install - install module in system modules dir
    + any action can be done with -g parameter and will be applied to global modules
    + global keyword can be understood as system

# Module Util

+ ```require('util');```
+ ```util.inspect(object)``` return string representation of object
+ ```util.format("My %s %d %j", "string", 123, {test:"obj"})``` format
    passed parameters to string with modificators
+ ```util.inherits(object1, object2)``` allow use oop inheritance with js objects

# Module console

+ used util.format and util.inspect for output
+ module which inject to global variables
+ ```console.log()``` pass message to standard output stream
+ ```console.error()``` pass message to standard error stream
+ ```console.trace()``` pass stacktrace to standard error stream
+ debug method of console object exist in browser but in node is not

# Error

+ For inherit Error object we can use util.inherits
+ We can use Error.captureStackTrace(this) in constructor
    for getting stacktrace to variable 'stack'

# EventEmitter

+ Base object for event actions implementation
+ ```require('events').EventEmitter;```
+ ```eventEmitter.on(eventName, functionHandler){}``` can be used for
    add new handlers of events
+ ```eventEmitter.emit(eventName, data);``` can be used for
    events generating
+ events in node will be executed synchronously (order saved) instead asynchronously
    as in web browser
    + asynchronously mode can be used with wrapping handler code
        in functions ```setImmediate(() => {});``` and
        ```process.nextTick()```
+ handlers can be gotten with method ```eventEmitter.listeners(event)```
+ count of handlers can be gotten with method 
    ```EventEmitter.listenersCount(eventEmitter, event)```
+ event can be called only once, for this we need to use
    ```eventEmitter.once(eventName, eventHandler);```
+ event with name - 'error' throws exception
    + ```eventEmitter('error');``` throw TypeError
    + ```eventEmitter('error', function(err){});``` handle error with function
    + ```eventEmitter('error', new Error());``` throw Error
+ EventEmitter with function handlers can make troubles with memory leak
    + if we link large objects which must be deleted with long time living
        objects through handlers we make memory leak danger
    + if EventEmmiter has more event handler then count in _maxListeners it show
        warning about memory leak

# Web server

## [Node JS http doc](https://nodejs.org/dist/latest-v6.x/docs/api/http.html)

+ create server ```var http = require('http'); var server = new http.Server();``` or see
    documentation for other ways
+ start server to listen ```server.listen(1337, '127.0.0.1');```
+ create server handler ``` server.on('request', function(req, res){});```
+ server parents: http.Server -> net.Server -> EventEmitter
+ server has some events, one of it - 'request', we can override it
+ for complete response use method ```res.end();```
+ for url parsing use module ```var url = require('url'); url.parse(req.url, true);```
