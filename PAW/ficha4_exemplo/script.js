const express = require('express');
const fs = require('fs');
const port = 3000;

const app = express();

app.get('/home', function(req, res) {
    fs.readFile('./index.html', function(err, data) {
        if (err) {
            res.writeHead(404, {'Content-Type': 'text/html'});
            return res.end("404 Not Found");
        }
        res.writeHead(200, {'Content-Type': 'text/html'});
        res.write(data);
        return res.end();
    });
});

app.get('/resposta', function(req, res) {
    const { nome, idade, presente } = req.query;
    console.log(req.url);
    console.log(nome);
    console.log(idade);
    console.log(presente);
    res.send(`<h1>${nome} foi processado!</h1>`);
});

app.post('/resposta', function(req, res){
    var data = "";
    req.on('data', function(chunk){data += chunck})
    req.on('end', function(){
        req.rawBody = data;
        req.jsonBody = querystring.parse(data);
        console.log(req.rawbody);
        console.log(req.jsonBody);
        req.send(`<h1> ${req.jsonBody.nome} foi processado! </h1>`);
    })
})

app.listen(port, () => {
    console.log(`Server is running on port ${port}`);
});
