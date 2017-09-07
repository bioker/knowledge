if [ $# -ne 5 ]
    then
        echo 'invalid arguments, use: schema password connection userName userPass';
    else
        echo "CREATE USER $4 IDENTIFIED BY $5" | sqlplus $1/$2@$3
fi
