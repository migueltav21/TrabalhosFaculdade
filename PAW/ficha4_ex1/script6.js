const fs = require('fs');

// Escolha o nome do arquivo que deseja ler
const filePath = 'file.html';

// Criação de uma stream de leitura
const readStream = fs.createReadStream(filePath);

// Evento de 'open' é disparado quando o arquivo é aberto para leitura
readStream.on('open', () => {
    console.log(`Arquivo ${filePath} aberto para leitura.`);
});

// Evento de 'data' é disparado quando dados estão disponíveis para leitura
readStream.on('data', (chunk) => {
    console.log('Parte do arquivo lida:');
    console.log(chunk.toString()); // Converte o chunk de buffer para string e imprime na console
});

// Evento de 'end' é disparado quando toda a leitura é concluída
readStream.on('end', () => {
    console.log(`Leitura do arquivo ${filePath} concluída.`);
});

// Evento de 'error' é disparado se ocorrer algum erro na leitura do arquivo
readStream.on('error', (err) => {
    console.error(`Ocorreu um erro na leitura do arquivo ${filePath}: ${err.message}`);
});
