#!/bin/bash
echo "Test Message" | \
mailx -s "Test Subject" \
    -S smtp-use-starttls \
    -S ssl-verify=ignore \
    -S smtp-auth=login \
    -S smtp=smtp://smtp.gmail.com:587 \
    -S from="from@mail.net" \
    -S smtp-auth-user="from@mail.net" \
    -S smtp-auth-password="secret" \
    -S ssl-verify=ignore \
    "to@mail.net"
