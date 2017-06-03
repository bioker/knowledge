def swap = {Integer[] array, Integer left, Integer right ->
    if(left != right){
        int buf = array[right]
        array[right] = array[left]
        array[left] = buf
    }
}

def bubbleSort = {Integer[] array ->

    for(int i = 0; i < array.size() - 1; i++){
        for(int j = 0; j < array.size() - i - 1; j++){
            if(array[j] > array[j + 1]){
                swap(array, j, j + 1)
            }
        }
    }
    return array
}

def insertionSort = {Integer[] array ->
    int temp
    int j
    for(int i = 0; i < array.size() - 1; i++){
        if(array[i] > array[i + 1]){
            temp = array[i + 1]
            array[i + 1] = array[i]
            j = i
            while(j > 0 && temp < array[j - 1]){
                array[j] = array[j -1]
                j--
            }
            array[j] = temp
        }
    }
    return array
}

def selectionSort = {Integer[] array ->
    for(int min = 0; min < array.size() - 1; min++){
        int least = min
        for(int j = min + 1; j < array.size(); j++){
            if(array[j] < array[least]){
                least = j
            }
        }
        swap(array, min, least)
    }
    return array
}

def merge = {Integer[] array1, Integer[] array2 ->
    int len1 = array1.size()
    int len2 = array2.size()
    int a = 0
    int b = 0
    int len = len1 + len2
    Integer[] result = new Integer[len]
    for(int i = 0; i < len; i++){
        if(b < len2 && a < len1){
            if(array1[a] > array2[b]){
                result[i] = array2[b++]
            } else{
                result[i] = array1[a++]
            }
        } else if (b < len2){
            result[i] = array2[b++]
        } else {
            result[i] = array1[a++]
        }
    }
    return result
}

def mergeSort
mergeSort = {Integer[] array ->
    int len = array.size()
    if(len < 2){
        return array
    }
    int middle = len / 2
    return merge(
        mergeSort(Arrays.copyOfRange(array, 0, middle) as Integer[]),
        mergeSort(Arrays.copyOfRange(array, middle, len) as Integer[])
    )
}

long timestamp = System.currentTimeMillis()
println bubbleSort([15,14,13,12,11,10,9,8,7,6,5,4,3,2,1] as Integer[])
println 'bubble sort time: ' + (System.currentTimeMillis() - timestamp) + ' ms'

timestamp = System.currentTimeMillis()
println insertionSort([15,14,13,12,11,10,9,8,7,6,5,4,3,2,1] as Integer[])
println 'insertion sort time: ' + (System.currentTimeMillis() - timestamp) + ' ms'

timestamp = System.currentTimeMillis()
println selectionSort([15,14,13,12,11,10,9,8,7,6,5,4,3,2,1] as Integer[])
println 'selection sort time: ' + (System.currentTimeMillis() - timestamp) + ' ms'

timestamp = System.currentTimeMillis()
println mergeSort([15,14,13,12,11,10,9,8,7,6,5,4,3,2,1] as Integer[])
println 'merge sort time: ' + (System.currentTimeMillis() - timestamp) + ' ms'
