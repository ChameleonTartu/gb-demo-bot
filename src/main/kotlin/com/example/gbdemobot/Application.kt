package com.example.gbdemobot

import com.example.gbdemobot.bots.GbBot
import com.example.gbdemobot.bots.processors.GbProcessor
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.meta.exceptions.TelegramApiException
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession


fun main(args: Array<String>) {
    val token = args[0]
    while (true) {
        val telegramBotsApi = TelegramBotsApi(DefaultBotSession::class.java).registerBot(
            GbBot(
                gbProcessor = GbProcessor(),
                token = token
            )
        )
        telegramBotsApi.stop()
        println("Stopped bot!")
        try {
            println("Started bot!")
            telegramBotsApi.start()
        } catch (e: TelegramApiException) {
            println("Crashed!")
            e.printStackTrace()
        } finally {
            println("Stopped bot")
            telegramBotsApi.stop()
        }
    }
}
