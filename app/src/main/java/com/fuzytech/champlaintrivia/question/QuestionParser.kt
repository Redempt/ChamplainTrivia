package com.fuzytech.champlaintrivia.question

import org.json.JSONArray
import org.json.JSONObject

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
                else -> throw IllegalArgumentException("Invalid question type $type")
            })
        }
        return out
    }

}