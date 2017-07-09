for i in ./*;do
    echo "$i"; 
    if [ -d "$i" ];then
        echo "process dir: $i";
        cd "$i";
        $1
        cd ..;
    fi;
done
