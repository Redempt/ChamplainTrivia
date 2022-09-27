package com.fuzytech.champlaintrivia.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fuzytech.champlaintrivia.R

/**
 * A simple [Fragment] subclass.
 * Use the [StringQuestionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StringQuestionFragment : Fragment() {
    private lateinit var question: String
    private lateinit var answers: List<String>
    private var answer: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            question = it.getString("question")!!
            answers = it.getStringArrayList("answers")!!
            answer = it.getInt("answer")!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_string_question, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment StringQuestionFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(question: String, answers: ArrayList<String>, answer: Int) =
            StringQuestionFragment().apply {
                arguments = Bundle().apply {
                    putString("question", question)
                    putStringArrayList("answers", answers)
                    putInt("answer", answer)
                }
            }
    }
}