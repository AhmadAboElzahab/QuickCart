const express = require("express");
const Eureka = require("eureka-js-client").Eureka;
const mongoose = require("mongoose");
const User = require("./routes/user");
const bodyParser = require("body-parser");

const app = express();

const port = 3000;

app.use(express.json());

app.use("/service/", User);

require("dotenv").config();
const client = new Eureka({
  instance: {
    instanceId: "userService",
    app: "userService",
    hostName: "localhost",
    ipAddr: "127.0.0.1",
    port: {
      $: port,
      "@enabled": "true",
    },
    vipAddress: "userService",
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
  mongoose.set("strictQuery", false);
  mongoose
    .connect(process.env.DB_CONNECT)
    .then(() => {
      app.listen(3000, () => {
        console.log(`Coneected on http://localhost:3000}/`);
      });
    })
    .catch((error) => {
      console.log(error);
    });
});
