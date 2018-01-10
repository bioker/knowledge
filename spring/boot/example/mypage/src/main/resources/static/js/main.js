
document.getElementById('canvas').width = document.body.clientWidth;
document.getElementById('canvas').height = document.body.clientHeight;

let model = new Model(new Graph());

let node1 = new Node('node1', 200, 100);
let node2 = new Node('node2', 100, 200);
node2.setSelected(true);
let node3 = new Node('node3', 100, 100);
let link1 = new Link('type1', node1, node2);

model.getGraph()
            .addNode(node1)
            .addNode(node2)
            .addNode(node3)
            .addLink(link1);

let view = new View(document.getElementById('canvas'), model);
let controller = new Controller(model, view);

controller.setClickHandler(CommandFactory.select);
controller.setDoubleClickHandler(CommandFactory.add);

setInterval(view.render.bind(view), 10);
