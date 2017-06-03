
def binarySearch = {list, value ->

    if(!list instanceof Integer[]) throw new RuntimeException('list is not Integer array')
    if(!value instanceof Integer) throw new RuntimeException('value is not Integer')

    println 'trying find the value: ' + value

    for(int i = 0; i < list.size(); i++){
        print list[i] + ' '
        println ''
    }

    int low = 0
    int high = list.size() - 1

    while(low <= high){
        mid = (low + high).intdiv(2)
        guess = list[mid]
        if(guess == value){
            println 'value is found'
            return mid
        }
        if(guess > value){
            println 'value is below'
            high = mid - 1
        } else {
            println 'value is above'
            low = mid + 1
        }
    }
    return null
}

int[] list = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
int value = 1

def result = binarySearch(list, value)

println 'target index: ' + result
