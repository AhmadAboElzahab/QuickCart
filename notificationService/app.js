const express = require("express");
const nodemailer = require("nodemailer");
const { Eureka } = require("eureka-js-client");

const app = express();
const port = 3003;

app.use(express.json());

app.post("/", async function addPayment(req, res) {
  const transporter = nodemailer.createTransport({
    service: "hotmail",
    auth: {
      user: "quick.cart@hotmail.com",
      pass: "ahmad4sy",
    },
  });

  try {
    const { email, amount } = req.body;

    const mailOptions = {
      from: "quick.cart@hotmail.com",
      to: email,
      subject: "License",
      html: `<p>${amount}</p>`,
    };

    transporter.sendMail(mailOptions, (error, info) => {
      if (error) {
        console.log("Error occurred:", error.message);
        res.status(500).json({ message: "Failed to send email." });
      } else {
        console.log("Email sent:", info.response);
        res.json({ message: "Payment added and email sent." });
      }
    });
  } catch (error) {
    console.error(error);
    res.status(500).json({ message: "Failed to create and add Payment." });
  }
});

const client = new Eureka({
  instance: {
    instanceId: "notificationService",
    app: "notificationService",
    hostName: "localhost",
    ipAddr: "127.0.0.1",
    port: {
      $: port,
      "@enabled": "true",
    },
    vipAddress: "notificationService",
    dataCenterInfo: {
      "@class": "com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo",
      name: "MyOwn",
    },
  },
  eureka: {
    host: "localhost",
    port: 8761,
    servicePath: "/eureka/apps/",
  },
});

client.start((error) => {
  if (error) {
    console.error(error);
  } else {
    app.listen(port, () => {
      console.log(`Connected on http://localhost:${port}/`);
    });
  }
});
