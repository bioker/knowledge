#!/bin/bash

alias=$1
keystoreFile=$2
certFile=$3

keytool -import -alias $alias -file $certFile -keystore $keystoreFile
