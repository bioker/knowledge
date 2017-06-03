def findSmallestIndex = { ArrayList<Integer> array ->
    smallestValue = array.get(0)
    smallestIndex = 0
    for(int i = 0; i < array.size(); i++){
        if(array[i] < smallestValue){
            smallestValue = array.get(i)
            array.remove(i)
            smallestIndex = i
        }
    }
    println 'smallest value index is founded: ' + smallestIndex
    return smallestIndex
}

def selectionSort = {Integer[] array ->
    ArrayList<Integer> newArray = new ArrayList<>()
    Integer smallestIndex
    for(int i = 0; i < array.size(); i++){
        smallestIndex = findSmallestIndex(array.toList())
        newArray.add(array[i])
    }
    return newArray
}



println selectionSort([9,3,6,1,8] as Integer[])
