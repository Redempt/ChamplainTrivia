package com.fuzytech.champlaintrivia.question

class OpenResponseQuestion(override val question: String, private val answer: String) : Question<String> {

    override fun validate(answer: String) = answer.lowercase().matches(this.answer.toRegex())


}