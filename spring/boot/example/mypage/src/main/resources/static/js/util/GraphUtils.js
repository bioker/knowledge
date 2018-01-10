let GraphUtils = (function(){

    let isMouseOverNode = function(node, nodeRadius, x, y){
        return Math.sqrt((x-node.getX()) ** 2 + (y - node.getY()) ** 2) < nodeRadius;
    }

    let pagePointToCanvasPoint = function(view, x, y){
        return {x: x - view.getLeftIndent(), y: y - view.getTopIndent()};
    }

    // used for determine point on tangent of circle
    let tangentPoint = function(centerX, centerY, radius, degree){
        let degreeToRadiansCoef = Math.PI / 180;
        let resultX = radius * Math.sin(degreeToRadiansCoef * degree);
        let resultY = radius * Math.cos(degreeToRadiansCoef * degree);
        return {
            x: centerX + resultX,
            y: centerY - resultY,
        }
    }

    return {
        isMouseOverNode: isMouseOverNode,
        pagePointToCanvasPoint: pagePointToCanvasPoint,
        tangentPoint: tangentPoint,
        defaultNodeRadius: 15,
        defaultBackgroundColor: '#534b56',
        defaultNodeColor: '#b4c9dc',
        defaultShadowColor: '#f2e0e0',
        defaultLabelColor: '#000000',
        defaultLinkColor: '#ffffff',
        defaultFont: '30px Arial'
    }

}())