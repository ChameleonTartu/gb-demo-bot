package com.example.gbdemobot

import com.example.gbdemobot.bots.GbBot
import com.example.gbdemobot.bots.processors.GbProcessor
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.meta.exceptions.TelegramApiException
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession


val log: Logger = LoggerFactory.getLogger("main")

fun main(args: Array<String>) {
    val token = args[0]
    val telegramBotsApi = TelegramBotsApi(DefaultBotSession::class.java).registerBot(
        GbBot(
            gbProcessor = GbProcessor(),
            token = token
        )
    )
    telegramBotsApi.stop()
    try {
        log.info("Starting the bot ...")
        telegramBotsApi.start()
    } catch (e: TelegramApiException) {
        log.error("Telegram API failure", e)
    } finally {
        log.info("Stopping the bot ...")
        telegramBotsApi.stop()
    }
}
