let Node = function(name, x, y, color){

    let selected = false;

    if(!color){
        color = GraphUtils.defaultNodeColor;
    }

    let getName = function(){
        return name;
    }

    let getX = function(){
        return x;
    }

    let getY = function(){
        return y;
    }

    let getColor = function(){
        return color;
    }

    let isSelected = function(){
        return selected;
    }

    let setSelected = function(isSelected){
        selected = isSelected;
    }

    return {
        getName: getName,
        getX: getX,
        getY: getY,
        getColor: getColor,
        isSelected: isSelected,
        setSelected: setSelected
    }
}
