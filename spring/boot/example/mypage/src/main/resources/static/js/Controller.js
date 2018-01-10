let Controller = function(model, view){

    let clickHandler = function(){};
    let doubleClickHandler = function(){};

    let getModel = function(){
        return model;
    }

    let getView = function(){
        return view;
    }

    let setClickHandler = function(handler){
        clickHandler = handler;
    }

    let setDoubleClickHandler = function(handler){
        doubleClickHandler = handler;
    }

    view.getCanvas().onclick = function(e){
        clickHandler(e, model, view);
    }

    view.getCanvas().ondblclick = function(e){
        doubleClickHandler(e, model, view)
    }

    return {
        getModel: getModel,
        getView: getView,
        setClickHandler: setClickHandler,
        setDoubleClickHandler: setDoubleClickHandler
    }
}
