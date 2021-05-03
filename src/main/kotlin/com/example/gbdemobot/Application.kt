package com.example.gbdemobot

import com.example.gbdemobot.bots.GbBot
import com.example.gbdemobot.bots.processors.GbProcessor
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.meta.exceptions.TelegramApiException
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession
import java.lang.Exception


val log: Logger = LoggerFactory.getLogger("main")

fun main(args: Array<String>) {

    val botSession = DefaultBotSession()

    while (true) {
        val token = args[0]
        val telegramBotsApi = TelegramBotsApi(botSession::class.java).registerBot(
            GbBot(
                gbProcessor = GbProcessor(),
                token = token
            )
        )

        try {
            botSession.stop()
            telegramBotsApi.stop()
            log.info("Starting the bot ...")
            botSession.start()
            telegramBotsApi.start()
        } catch (e: TelegramApiException) {
            log.error("Telegram API failure", e)
        }
    }
}


