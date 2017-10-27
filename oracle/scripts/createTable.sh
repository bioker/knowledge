if [ $# -ne 3 ]
    then
        echo 'invalid arguments, use: schema password connection';
    else
        sqlplus $1/$2@$3 as sysdba << SQL
            CREATE TABLE test ( 
                id    NUMBER,
                name VARCHAR2(40)
            );
SQL
fi
