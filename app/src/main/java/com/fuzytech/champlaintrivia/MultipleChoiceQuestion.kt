package com.fuzytech.champlaintrivia

class MultipleChoiceQuestion(override val question: String, val answers: List<String>, val answer: Int) : Question<Int> {
    override fun validate(answer: Int) = answer == this.answer
}