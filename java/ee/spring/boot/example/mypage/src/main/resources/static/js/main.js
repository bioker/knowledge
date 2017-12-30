let model = new Model();
model.points = [
                new Point('point1', 10, 10),
                new Point('point2', 50, 50),
                new Point('point3', 100, 100),
                ];
let view = new View(document.getElementById('canvas'), model);

setInterval(view.render, 10);
