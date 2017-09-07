if [ $# -ne 4 ]
    then
        echo 'invalid arguments, use: schema password connection userName';
    else
        echo "GRANT create session TO $4;" | sqlplus $1/$2@$3
        echo "GRANT create table TO $4;" | sqlplus $1/$2@$3
        echo "GRANT create view TO $4;" | sqlplus $1/$2@$3
        echo "GRANT create any trigger TO $4;" | sqlplus $1/$2@$3
        echo "GRANT create any procedure TO $4;" | sqlplus $1/$2@$3
        echo "GRANT create sequence TO $4;" | sqlplus $1/$2@$3
        echo "GRANT create synonym TO $4;" | sqlplus $1/$2@$3
fi
