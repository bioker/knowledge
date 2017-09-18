#!/bin/bash

alias=$1
keystoreFile=$2
keystorePass=$3

keytool -genkey -noprompt \
    -alias $alias \
    -dname "CN=mqttserver.ibm.com, OU=ID, O=IBM, L=Hursley, S=Hants, C=GB" \
    -keystore $keystoreFile \
    -storepass $keystorePass \
    -keypass $keystorePass
