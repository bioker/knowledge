#!/bin/bash

certFile=$1
signature=$2
data=$3

openssl \
    dgst \
    -sha256 \
    -verify  <(openssl x509 -in $certFile  -pubkey -noout) \
    -signature $signature \
    $data
