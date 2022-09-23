package com.fuzytech.champlaintrivia

interface Question<A> {

    public val question: String

    public fun validate(answer: A): Boolean

}