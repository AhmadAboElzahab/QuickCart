from flask import Flask
import requests
import socket

app = Flask(__name__)

# Register with Eureka
def register_with_eureka():
    eureka_server_url = 'http://localhost:8761/eureka/apps/notificationService'
    service_url = 'http://localhost:3003'

    data = {
        "instance": {
            "instanceId": "notificationService:" + socket.gethostname(),
            "app": "notificationService",
            "hostName": "localhost",
            "ipAddr": "127.0.0.1",
            "port": {
                "$": 3003,
                "@enabled": "true"
            },
            "homePageUrl": service_url,
            "statusPageUrl": service_url + "/status",
            "healthCheckUrl": service_url + "/health",
            "vipAddress": "notificationService",
            "dataCenterInfo": {
                "@class": "com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo",
                "name": "MyOwn"
            }
        }
    }

    headers = {'Content-Type': 'application/json'}

    response = requests.post(eureka_server_url, json=data, headers=headers)
    print(response.status_code, response.content)

register_with_eureka()

@app.route('/')
def hello():
    return 'Hello, Flask!'

if __name__ == '__main__':
    app.run(port=3003)
