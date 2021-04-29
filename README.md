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
