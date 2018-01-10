let Link = function(type, node1, node2){

    let selected = false;

    let getType = function(){
        return type;
    }

    let getNode1 = function(){
        return node1;
    }

    let getNode2 = function(){
        return node2;
    }

    let isSelected = function(){
        return selected;
    }

    let setSelected = function(isSelected){
        selected = isSelected;
    }
    return {
        getType: getType,
        getNode1: getNode1,
        getNode2: getNode2,
        isSelected: isSelected,
        setSelected: setSelected
    }
}