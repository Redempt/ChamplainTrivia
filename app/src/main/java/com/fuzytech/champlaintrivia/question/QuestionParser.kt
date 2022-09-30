package com.fuzytech.champlaintrivia.question

import org.json.JSONArray
import org.json.JSONObject
import java.lang.IllegalArgumentException

object QuestionParser {

    fun parse(input: String): List<Question<*>> {
        val list = JSONArray(input)
        val out = mutableListOf<Question<*>>()
        for (i in 0..list.length()) {
            val entry = list[i] as JSONObject
            val type = entry["type"] as String
            val question = entry["question"] as String
            out.add(when (type) {
                "string" -> MultipleChoiceQuestion(question, entry["answers"] as List<String>, entry["answer"] as Int)
                "openresponse" -> OpenResponseQuestion(question, entry["answer"] as String)
                "image" -> MultipleChoiceQuestion(question, entry["answers"] as List<Int>, entry["answer"] as Int)
                else -> throw IllegalArgumentException("Invalid question type")
            })
        }
        return out
    }

}