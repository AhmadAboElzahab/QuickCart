const express = require("express");
const Eureka = require("eureka-js-client").Eureka;

const app = express();
const port = 3000;

// Set up Eureka client
const client = new Eureka({
  instance: {
    instanceId: "userService", // replace with a unique identifier for your service
    app: "userService", // replace with your service name
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
    host: "localhost", // replace with your Eureka server host
    port: 8761, // replace with your Eureka server port
    servicePath: "/eureka/apps/",
  },
});
app.get("/test", (req, res) => {
  res.json({ message: "Hello from your service!" });
});

client.start((error) => {
  console.error(error || "Eureka registration complete");

  // Start your Express app after successfully registering with Eureka
  app.listen(port, () => {
    console.log(`Server is running on port ${port}`);
  });
});
