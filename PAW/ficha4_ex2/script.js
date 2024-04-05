const express = require('express');
const fs = require('fs');
const morgan = require('morgan');

const port = 3000;

const app = express();

// Configuração do Morgan para logging de solicitações
const accessLogStream = fs.createWriteStream('access.log', { flags: 'a' });
app.use(morgan('combined', { stream: accessLogStream }));

// Middleware para logging
app.use(function(req, res, next) {
    const logEntry = `${new Date().toISOString()} - ${req.method} ${req.originalUrl}`;
    
    // Verifica se a solicitação é para a pesquisa de latitude e longitude
    if (req.originalUrl.startsWith('/search?latitude=') && req.originalUrl.includes('&longitude=')) {
        // Extrai as coordenadas de latitude e longitude da URL
        const latitude = req.query.latitude;
        const longitude = req.query.longitude;
        // Adiciona as coordenadas ao log
        logEntry += ` - Latitude: ${latitude}, Longitude: ${longitude}`;
    }

    fs.appendFile('server.log', logEntry + '\n', (err) => {
        if (err) {
            console.error('Erro ao gravar no arquivo de log:', err);
        }
    });
    next();
});

app.use(express.static("public"));

app.get('/home', function(req, res) {
    res.render("index.ejs");
});

// Middleware para lidar com solicitações para URLs não encontradas
app.use((req, res, next) => {
    res.status(404).send("Página não encontrada");
});

app.listen(port, () => {
    console.log(`Server is running on port ${port}`);
});
