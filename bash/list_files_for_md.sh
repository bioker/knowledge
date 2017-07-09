for i in ./*; do 
    basename=$(basename "$i"); 
    echo "# ${basename%.*}"; 
done
