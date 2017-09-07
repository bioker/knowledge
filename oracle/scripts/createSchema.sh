if [ $# -ne 4 ]
    then
        echo 'invalid arguments, use: schema password connection newSchema';
    else
        echo "CREATE SCHEMA $4" | sqlplus $1/$2@$3 as sysdba
fi
