#!/bin/bash

keyFile=$1
dataFile=$2
resultFile=$3

openssl \
    dgst \
    -sha256 \
    -sign $1 \
    -out $3 \
    $2
