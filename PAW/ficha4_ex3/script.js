const express = require('express');
const fs = require('fs');
const path = require('path');
const multer = require('multer');
const port = 3000;
let formNumber = 1;
const app = express();

const formsDirectory = path.join(__dirname, 'forms');

const upload = multer({ dest: "uploads/" });

app.use(express.static("public"));
app.use(express.urlencoded({ extended: true }));

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

// Rota para lidar com o envio do formulário e o upload da imagem
app.post('/submit', upload.single('imagem'), function(req, res) {
    const formData = req.body;
    const fileName = `form_${formNumber}`;
    const filePath = path.join(formsDirectory, fileName);

    var newPath = __dirname + "/forms/" + fileName;

    fs.copyFile(
        __dirname + "/uploads/" + req.file.filename,
        newPath + ".png",
        (err) => {
            if (err) console.log(err);
        }
    );

    // Salva os dados do formulário em um arquivo
    fs.writeFile(filePath + ".json", JSON.stringify(formData), function(err) {
        if (err) {
            console.error('Erro ao salvar o formulário:', err);
            res.status(500).send('Erro ao salvar o formulário.');
        } else {
            console.log('Formulário salvo com sucesso:', fileName);
            res.send(`<h1>Formulário enviado com sucesso. Código do inquérito: ${fileName}</h1>`);
        }
    });
    formNumber++;
});

app.get('/respostas/:codigo', function(req, res) {
    const codigo = req.params.codigo;

    // Construa o caminho do arquivo com base no código do inquérito
    const filePath = path.join(formsDirectory, `${codigo}.json`);
    const imagePath = path.join(formsDirectory, `${codigo}.png`);

    // Verifica se o arquivo JSON existe
    fs.access(filePath, fs.constants.F_OK, (err) => {
        if (err) {
            console.error('Arquivo não encontrado:', err);
            res.status(404).send('As respostas para este inquérito não foram encontradas.');
        } else {
            // O arquivo JSON existe, então leia seu conteúdo
            fs.readFile(filePath, 'utf8', (err, data) => {
                if (err) {
                    console.error('Erro ao ler o arquivo JSON:', err);
                    res.status(500).send('Erro ao ler as respostas do inquérito.');
                } else {
                    // Verifica se o arquivo de imagem existe
                    fs.access(imagePath, fs.constants.F_OK, (err) => {
                        if (err) {
                            console.error('Arquivo de imagem não encontrado:', err);
                            res.status(500).send('Erro ao carregar a imagem.');
                        } else {
                            // Se a imagem existir, envie-a junto com os dados do formulário
                            res.status(200).send(`
                                <h1>Respostas do inquérito ${codigo}</h1>
                                <p>${data}</p>
                                <img src="forms/${codigo}.png" alt="Imagem do inquérito ${codigo}">
                            `);
                        }
                    });
                }
            });
        }
    });
});


app.listen(port, () => {
    console.log(`Server is running on port ${port}`);
});
