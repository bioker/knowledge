for i in ./*;do
    echo "$i"; 
    cd "$i"; 
    if [ -d ".git" ];then 
        echo "found .git"; 
        echo "delete..."; 
        rm -rf .git; 
    fi; 
    if [ -f ".gitignore" ];then 
        echo "found .gitigonre"; 
        echo "delete..."; 
        rm .gitignore; 
    fi; 
    cd ..;
done
