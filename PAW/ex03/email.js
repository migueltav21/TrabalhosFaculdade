const nodemailer = require("nodemailer");

function sendEmail(mailOptions) {
    const transporter = nodemailer.createTransport({
        service: "gmail",
        auth: {
            user: "email@gmail.com", // email do remetente
            pass: "App password", // manda-me mensagem e eu digo te como obter esta pass, pq nao é a que tu usas
        },
    });

    transporter.sendMail(mailOptions, function (error, info) {
        try {
            console.log(info.messageId);
        } catch {
            console.log(error);
        }
    });
};

exports.sendEmail = sendEmail;
