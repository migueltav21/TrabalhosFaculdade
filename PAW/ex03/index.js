const express = require("express");
const multer = require("multer");
const fs = require("fs");
const app = express();
const random = require("crypto");
const email = require("./email");

app.set("view engine", "ejs");
app.use(express.static("public"));
app.use(express.static("submitedForms"));
app.use(express.urlencoded({ extended: true }));

const menu = [
    { name: "Pizza", price: 10 },
    { name: "Spaghetti", price: 20 },
    { name: "Pasta", price: 30 },
];

const upload = multer({ dest: "uploads/" });

app.get("/", (req, res) => {
    res.render("home.ejs", {
        menu: menu,
    });
});

app.post("/sendOpinion", upload.single("file"), (req, res) => {
    res.render("home.ejs", {
        menu: menu,
    });

    const mailOptions = {
        from: "email@gmail.com", // email do remetente
        to: "exemplo@gmail.com", // email de destino
        subject: "Assunto do E-mail",
        text: "Conteúdo do E-mail em texto simples",
        html: "<h3>Conteúdo do E-mail em HTML</h3><p>Você pode adicionar tags HTML aqui.</p>",
    };

    email.sendEmail(mailOptions);

    var fileName =
        random.randomInt(0, 10) +
        "" +
        random.randomInt(0, 10) +
        "" +
        random.randomInt(0, 10) +
        "" +
        random.randomInt(0, 10);

    var newPath = __dirname + "/submitedForms/" + fileName;

    sendEmail();

    fs.mkdir(newPath, (err) => {
        if (err) console.log(err);
        else {
            fs.copyFile(
                __dirname + "/uploads/" + req.file.filename,
                newPath + "/" + fileName + ".png",
                (err) => {
                    if (err) console.log(err);
                    else {
                        fs.unlink(
                            __dirname + "/uploads/" + req.file.filename,
                            (err) => {
                                if (err) console.log(err);
                            }
                        );
                    }
                }
            );

            fs.writeFile(
                newPath + "/form.json",
                JSON.stringify(req.body),
                (err) => {
                    if (err) console.log(err);
                }
            );
        }
    });
});

app.post("/askFile", (req, res) => {
    console.log(req.body.code);

    fs.access(__dirname + "/submitedForms/" + req.body.code, fs.F_OK, (err) => {
        if (err) {
            res.render("home.ejs", {
                menu: menu,
            });
        } else {
            fs.readFile(
                __dirname + "/submitedForms/" + req.body.code + "/form.json",
                "utf8",
                (err, data) => {
                    if (err) res.render("responses.ejs");
                    else {
                        var data = JSON.parse(data);
                        console.log(
                            __dirname +
                                "/submitedForms/" +
                                req.body.code +
                                "/" +
                                req.body.code +
                                ".png"
                        );
                        res.render("responses.ejs", {
                            name: data.username,
                            age: data.userAge,
                            food: data.food,
                            score: data.score,
                            image: req.body.code + "/" + req.body.code + ".png",
                        });
                    }
                }
            );
        }
    });
});

app.listen(3000);
