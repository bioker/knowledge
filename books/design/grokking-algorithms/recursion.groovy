class Box{
    String boxName
    boolean hasKey
    ArrayList<Box> nestedBoxes = new ArrayList<>()
}

def simpleSearch = {Box box -> 

    boolean keyFound 
    ArrayList<Box> boxes = new ArrayList<>()

    boxes.add(box)
    Box currentBox = box

    while(boxes.size() > 0){
        keyFound = currentBox.isHasKey()
        if (!keyFound){
            println 'key not found in ' + currentBox.getBoxName()
            boxes.remove(currentBox)
            boxes.addAll(currentBox.getNestedBoxes())
            if(boxes.size() < 1) break
            currentBox = boxes.get(0)
        } else {
            return true
        }
    }
    return false
}

def recursionSearch 

recursionSearch = {Box box ->
    println 'search in ' + box.getBoxName()
    boolean keyFound = box.isHasKey()
    if(!keyFound){
        for(Box nestedBox : box.getNestedBoxes()){
            keyFound = recursionSearch(nestedBox)
            if(keyFound) break
        }
    }
    return keyFound
}

Box mainBox = new Box()
mainBox.setBoxName('mainBox')
Box secondBox = new Box()
secondBox.setBoxName('secondBox')
Box thirdBox = new Box()
thirdBox.setBoxName('thirdBox')
thirdBox.setHasKey(true)
mainBox.getNestedBoxes().add(secondBox)
mainBox.getNestedBoxes().add(thirdBox)

println 'start simple search' 
long timestart = System.currentTimeMillis()
println 'result of simple search: ' + simpleSearch(mainBox)
println 'time: ' + (System.currentTimeMillis() - timestart) + ' ms'

println 'start recursion search' 
timestart = System.currentTimeMillis()
println 'result of recursion search: ' + recursionSearch(mainBox)
println 'time: ' + (System.currentTimeMillis() - timestart) + ' ms'


