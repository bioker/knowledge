function View(canvas, model){
    this.context = canvas.getContext('2d');
    this.width = canvas.width;
    this.height = canvas.height;
    this.topIndent = canvas.getBoundingClientRect().top;
    this.leftIndent = canvas.getBoundingClientRect().left;
    this.model = model;
    this.pointRadius = 10;
}

View.prototype.renderPoint(point, atOnce){
    if(atOnce){
        this.context.beginPath();
    }
    this.context.arc(point.x, point.y, this.pointRadius, 0, Math.PI * 2)
    if(atOnce){
        this.context.stroke();
    }
}

View.prototype.clear = function(){
    this.context.clearRect(0, 0, this.width, this.height);
};

View.prototype.render(){
    this.clear();
    this.context.beginPath();
    model.points.forEach(function(point, index, arr){
        this.renderPoint(point);
    }, this);
    this.context.stroke();
}

//View.prototype.onclick = function(x, y){
//    let canvasClickPoint = this.pagePointToCanvasPoint(x, y);
//    this.onclickProcessor(this, canvasClickPoint.x, canvasClickPoint.y);
//}
//
//View.prototype.onclickProcessor = function(){};
//
//View.prototype.pagePointToCanvasPoint = function(x, y){
//    return {x: x - this.leftIndent, y: y - this.topIndent};
//};
//
//View.prototype.changeColor = function(color){
//    this.context.fillStyle = color;
//};
//
//View.prototype.drawCircle = function(x, y, r){
//    this.context.beginPath();
//    this.context.arc(x, y, r, 0, Math.PI * 2)
//    this.context.fill();
//};
//
//View.prototype.drawLine = function(x1, y1, x2, y2){
//    this.context.beginPath();
//    this.context.moveTo(x1, y1);
//    this.context.lineTo(x2, y2);
//    this.context.stroke();
//};
//
