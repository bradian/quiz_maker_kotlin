package com.example.quizmakerkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_quiz.*

/**
 * A simple [Fragment] subclass.
 */
class QuizFragment : Fragment() {

    private lateinit var quizViewModel: QuizViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        quizViewModel = ViewModelProviders.of(activity as AppCompatActivity).get(QuizViewModel::class.java)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quiz, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvQuestion.text = quizViewModel.question
        btnConfirmAnswer.setOnClickListener {
            if(quizViewModel.isAnswerCorrect(etAnswer.text.toString())){
                Toast.makeText(context, "Your answer is correct!",Toast.LENGTH_LONG).show()
                findNavController().navigateUp()
            }else{
                Toast.makeText(context,"Your answer is not correct!  The correct answer is: ${quizViewModel.answer}",Toast.LENGTH_LONG).show()
            }
        }
    }


}
