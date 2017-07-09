#!/bin/bash

# loop & print a folder recusively,
process_nested_dirs() {
    for i in "$1"/*;do
        if [ -d "$i" ];then
            echo "process dir: $i"
            cd $i
            git status
            cd ..
        elif [ -f "$i" ]; then
            echo "isn't dir: $i"
        fi
    done
}


# try get path from param
path=""
if [ -d "$1" ]; then
    path=$1;
else
    echo 'Param not found'
    return 1
fi

echo "base path: $path"
process_nested_dirs $path
