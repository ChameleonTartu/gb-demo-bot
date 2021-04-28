package com.example.gbdemobot.bots.processors

import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Message
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow
import java.util.*


class GbProcessor {
    fun react(message: Message): SendMessage {
        val sendMessage = SendMessage()
        sendMessage.chatId = "${message.chatId}"
        sendMessage.replyMarkup = ReplyKeyboardRemove(true)

        println("Message: $message")

        val command = message.text
        if (command != null) {
            when {
                command.startsWith("/commands") -> {
                    val commands = listOf(
                        "/start - when you don't know how to start press me ;-)",
                        "/site - check our webpage",
                        "/teams - we will tell you who we are and about our teams",
                        "/blog - we are writing, you can find something for yourself",
                        "/photo - we will show you arbitrary person from the team"
                    )
                    sendMessage.text = commands.joinToString(separator = "\n")
                }
                command.startsWith("/start") -> {
                    sendMessage.text = "Hello! I'm GB demo bot. Type /commands to know what I can do."
                }
                command.startsWith("/site") -> {
                    sendMessage.text = "Glad you asked. Here our website: https://www.greenbird.com/"
                }
                command.startsWith("/teams") -> {
                    sendMessage.text = "We have 3 main vectors: Utilihive, Cloudwheel and Consultancy"

                    val keyboardMarkup = ReplyKeyboardMarkup()
                    val keyboard: MutableList<KeyboardRow> = ArrayList()
                    val row = KeyboardRow()
                    row.add("Utilihive")
                    row.add("Cloudwheel")
                    row.add("Consultancy")

                    keyboard.add(row)
                    keyboardMarkup.keyboard = keyboard
                    sendMessage.replyMarkup = keyboardMarkup
                }
                command.startsWith("Utilihive") -> {
                    sendMessage.text = "Greenbird's core product is Utilihive. Read more at: https://www.greenbird.com/utilihive"

                }
                command.startsWith("Cloudwheel") -> {
                    sendMessage.text = "Greenbird's platform. We are also building custom solutions on top of it: https://www.greenbird.com/solutions/cloudwheel-ipaas"
                }
                command.startsWith("Consultancy") -> {
                    sendMessage.text = "Greenbird was founded as a Consultancy firm. If you want to collaborate with us, write to: info@greenbird.com"
                }
                command.startsWith("/blog") -> {
                    sendMessage.text = "We call it News, but it is practically the same: https://www.greenbird.com/news"
                }
                command.startsWith("/photo") -> {
                    sendMessage.text = "photo"
                }
            }
        }
        return sendMessage
    }
}
