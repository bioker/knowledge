let View = function(canvas, model){
    let context = canvas.getContext('2d');
    let nodeRadius = GraphUtils.defaultNodeRadius;
    let topIndent = canvas.getBoundingClientRect().top;
    let leftIndent = canvas.getBoundingClientRect().left;
    let backgroundColor = GraphUtils.defaultBackgroundColor;
    let shadowColor = GraphUtils.defaultShadowColor;
    let labelColor = GraphUtils.defaultLabelColor;
    let linkColor = GraphUtils.defaultLinkColor;
    let font = GraphUtils.defaultFont;

    let renderNode = function(node){

        context.save();

        if(node.isSelected()){
            context.shadowColor = shadowColor;
            context.shadowBlur = 20;
        }

        context.beginPath();
        context.fillStyle = node.getColor();
        context.arc(node.getX(), node.getY(), nodeRadius, 0, Math.PI * 2)
        context.fill();
        context.fillStyle = labelColor;
        context.font = font;
        let fontPoint = GraphUtils.tangentPoint(node.getX(), node.getY(), nodeRadius, 45);
        context.fillText(node.getName(), fontPoint.x, fontPoint.y);

        context.restore();
    }

    let renderLink = function(link){

        context.save();

        context.strokeStyle = linkColor;
        context.beginPath();
        context.moveTo(link.getNode1().getX(), link.getNode1().getY())
        context.lineTo(link.getNode2().getX(), link.getNode2().getY())
        context.stroke();

        context.restore();
    }

    let clear = function(){
        context.save();
        context.clearRect(0, 0, canvas.width, canvas.height);
        context.fillStyle = backgroundColor;
        context.fillRect(0, 0, canvas.width, canvas.height);
        context.restore();
    }

    let render = function(){
        clear();
        model.getGraph().getLinks().forEach(function(link, index, arr){
            renderLink(link);
        });
        model.getGraph().getNodes().forEach(function(node, index, arr){
            renderNode(node);
        });
    }

    let getCanvas = function(){
        return canvas;
    }

    let getModel = function(){
        return model;
    }

    let getNodeRadius = function(){
        return nodeRadius;
    }

    let setNodeRadius = function(radius){
        nodeRadius = radius;
    }

    let getTopIndent = function(){
        return topIndent;
    }

    let getLeftIndent = function(){
        return leftIndent;
    }

    let getBackgroundColor = function(){
        return backgroundColor;
    }

    let setBackgroundColor = function(bgColor){
        backgroundColor = bgColor;
    }

    let getShadowColor = function(){
        return shadowColor;
    }

    let setShadowColor = function(sColor){
        shadowColor = sColor;
    }

    let getLabelColor = function(){
        return labelColor;
    }

    let setLabelColor = function(lColor){
        labelColor = lColor;
    }

    let getLinkColor = function(){
        return linkColor;
    }

    let setLinkColor = function(lColor){
        linkColor = lColor;
    }

    let getFont = function(){
        return font;
    }

    let setFont = function(f){
        font = f;
    }
    return {
        clear: clear,
        render: render,
        getCanvas: getCanvas,
        getModel: getModel,
        getTopIndent: getTopIndent,
        getLeftIndent: getLeftIndent,
        getNodeRadius: getNodeRadius,
        setNodeRadius: setNodeRadius,
        setBackgroundColor: setBackgroundColor,
        getBackgroundColor: getBackgroundColor,
        setShadowColor: setShadowColor,
        getShadowColor: getShadowColor,
        getLabelColor: getLabelColor,
        setLabelColor: setLabelColor,
        getLinkColor: getLinkColor,
        setLinkColor: setLinkColor,
        getFont: getFont,
        setFont: setFont
    }
}
