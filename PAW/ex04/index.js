const express = require("express");
const multer = require("multer");
const path = require("path");
const fs = require("fs");
const app = express();

app.set("view engine", "ejs");
app.use(express.static("public"));
app.use(express.urlencoded({ extended: true }));

const storage = multer.diskStorage({
    destination: function (req, file, cb) {
        cb(null, "Files");
    },

    filename: function (req, file, cb) {
        const ext = path.extname(file.originalname);
        const fileName = file.originalname.split(".")[0];
        const uniqueSuffix = Date.now() + "-" + Math.round(Math.random() * 1e9);
        cb(null, fileName + "-" + uniqueSuffix + ext);
    },
});

const requestCount = {};
const upload = multer({ storage: storage });

app.get("/", (req, res) => {
    res.render("index.ejs");
});

app.post("/upload", upload.single("file"), (req, res) => {
    console.log(req.file.filename);
    res.render("index.ejs");
});

app.get("/download", (req, res) => {
    res.render("download.ejs");
});

app.post("/downloadFile", (req, res) => {
    const fileName = req.body.name;
    const filePath = __dirname + "/Files/" + fileName;

    fs.access(filePath, fs.constants.F_OK, (err) => {
        if (err) {
            console.error("Arquivo não encontrado:", err);
            res.status(404).send("Arquivo não encontrado");
        } else {
            console.log("Arquivo encontrado!");
            res.download(filePath, fileName, (err) => {
                if (err) {
                    console.log("MERDA");
                } else {
                    console.log("Download concluído!");
                }
            });
        }
    });
});

app.listen(3000);
