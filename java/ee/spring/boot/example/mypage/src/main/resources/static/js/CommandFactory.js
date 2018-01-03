let CommandFactory = (function(){

    let resetSelection = function(model){
        model.getGraph().getNodes().forEach(function(node, index, arr){
            node.setSelected(false);
        });
        model.getGraph().getLinks().forEach(function(link, index, arr){
            link.setSelected(false);
        });
    }

    let select = function(e, model, view){
        resetSelection(model);
        model.getGraph().getNodes().forEach(function(node, index, arr){
            let mouseLocation = GraphUtils.pagePointToCanvasPoint(view, e.clientX, e.clientY);
            let mouseOverNode = GraphUtils.isMouseOverNode(
                                    node, view.getNodeRadius(), mouseLocation.x, mouseLocation.y);
            if(mouseOverNode){
                node.setSelected(true);
            }
        });
    }

    let add = function(e, model, view){
        let name = prompt('Enter name for node:');
        let mouseLocation = GraphUtils.pagePointToCanvasPoint(view, e.clientX, e.clientY);
        model.getGraph().getNodes().push(new Node(name, mouseLocation.x, mouseLocation.y));
    }

    return {
        select: select,
        add: add
    }
}())