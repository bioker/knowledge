#!/bin/bash

# loop & print a folder recusively,
print_folder_recurse() {
    for i in "$1"/*;do
        if [ -d "$i" ];then
            echo "dir: $i"
            print_folder_recurse "$i"
        elif [ -f "$i" ]; then
            # replace tabs with 4 spaces
            expand -t 4 $i | tee $i
        fi
    done
}


# try get path from param
path=""
if [ -d "$1" ]; then
    path=$1;
else
    exit 1
fi

echo "base path: $path"
print_folder_recurse $path
