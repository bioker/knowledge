#!/bin/bash

keyName=$1
crtName=$2

openssl \
    req \
    -nodes \
    -x509 \
    -sha256 \
    -newkey rsa:2048 \
    -keyout $keyName \
    -out $crtName \
    -days 365 \
    -subj "/C=NL/ST=Zuid Holland/L=Rotterdam/O=Sparkling Network/OU=IT Dept/CN=Sign Key"
