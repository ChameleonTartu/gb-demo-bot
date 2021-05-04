package com.example.gbdemobot.bots

import com.example.gbdemobot.bots.processors.GbProcessor
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto
import org.telegram.telegrambots.meta.api.objects.InputFile
import org.telegram.telegrambots.meta.api.objects.Update
import java.io.File

class GbBot(
    private val gbProcessor: GbProcessor,
    private val token: String
) : TelegramLongPollingBot() {
    override fun getBotUsername(): String {
        return "I am Greenbird demo bot"
    }

    override fun getBotToken(): String {
        return token
    }

    override fun onUpdateReceived(update: Update) {
        if (update.hasMessage()) {
            val message = gbProcessor.react(update.message)
            when (message.text) {
                "blog" -> {
                    val ind = (0..5).shuffled().first()
                    val blog = listOf(
                        "https://www.greenbird.com/news/jaxb-unmarshalling-and-avoiding-the-dom",
                        "https://www.greenbird.com/news/logging-soap-traffic-in-mule-esb-versions-3-2-to-3-6",
                        "https://www.greenbird.com/news/microservices-hitting-the-brick-wall-once-again",
                        "https://www.greenbird.com/news/spring-boot-camel-atmosphere-websocket",
                        "https://www.greenbird.com/news/railway-oriented-programming-in-kotlin",
                        "https://www.greenbird.com/news/be-energized-podcast-ipaas-and-the-future-of-computing"
                    )
                    message.text = blog[ind]
                    execute(message)
                }
                "photo" -> {
                    val ind = (0..2).shuffled().first()
                    val images = listOf("thorsten.jpeg", "marius.jpeg", "liping.jpeg")
                    val photo = SendPhoto(message.chatId, InputFile(File("src/main/resources/img/${images[ind]}")))
                    execute(photo).messageId
                }
                else -> {
                    execute(message)
                }
            }
        }
    }
}
