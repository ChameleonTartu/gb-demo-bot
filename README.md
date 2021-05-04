## Greenbird Sample Telegram bot

This bot was created for Greenbird's internal meetup. It is distributed under MIT license.

### How to run it?

The bot is `TelegramLongPolling` bot. In practice, it means that you will need to deploy it on the server.
The solution doesn't suite serverless architecture as it is. Also, it means that `Application.kt` has an infinite loop keeping it up and running.

As this bot is command line Kotlin app, you will need to pass token as a parameter. Apart, of this there are no other requirements.


### What is the purpose of this project?

Teach people how to start making bots, show basic capabilities of Telegram.

### What is the name of the bot?

@gb-demo-bot


### How to setup VPS for running bot

All instructions apply to Ubuntu system. With minimal modifications you can apply them to any UNIX-based systems.

```
export TOKEN=<PUT YOUR TELEGRAM TOKEN HERE>
mkdir tb && cd tb
apt install -y unzip
wget https://github.com/ChameleonTartu/gb-demo-bot/archive/refs/heads/master.zip
unzip master.zip
rm master.zip
apt install -y curl
apt install -y zip
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk list java
sdk install java 11.0.11-zulu
sdk install maven
cd gb-demo-bot-master
mvn clean install -q
apt install -y docker.io
docker stop gb-demo-bot-app
docker rm gb-demo-bot-app
docker build -t gb-demo-bot:1.0 .
docker run -d -e TOKEN=$TOKEN gb-demo-bot:1.0 --name gb-demo-bot-app
```
