let Graph = function(){
    let nodes = [];
    let links = [];

    let addNode = function(node){
        nodes.push(node);
        return this;
    }

    let deleteNode = function(node){
        let index = nodes.indexOf(node);
        if(index != -1){
            nodes.splice(index, 1);
        }
        return this;
    }

    let addLink = function(link){
        links.push(link);
        return this;
    }

    let deleteLink = function(link){
        let index = links.indexOf(link);
        if(index != -1){
            links.splice(index, 1);
        }
        return this;
    }

    let getNodes = function(){
        return nodes;
    }

    let getLinks = function(){
        return links;
    }

    return {
        addNode: addNode,
        deleteNode: deleteNode,
        addLink: addLink,
        deleteLink: deleteLink,
        getNodes: getNodes,
        getLinks: getLinks
    }
}
