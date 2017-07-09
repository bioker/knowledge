#!/bin/bash

# loop & print a folder recusively,
process_nested_dirs() {
    for i in "$1"/*;do
        if [ -d "$i" ];then
            echo "process dir: $i"
            cd $i
            git add .
            git commit -m "\"""$2""\""
            git push
            cd ..
        elif [ -f "$i" ]; then
            echo "isn't dir: $i"
        fi
    done
}


# try get path from param
path=""
comment=""

if [ $# -eq 0 ]
  then
    echo "No arguments supplied"
    return 1
fi
if [ $# -eq 1 ]
  then
    echo "Comment argument not found"
    return 1
else
    echo "comment: $2"
    comment=$2;
fi
if [ -d "$1" ]; then
    path=$1;
else
    echo 'directory not found'
    return 1
fi

echo "base path: $path"
process_nested_dirs $path $comment
