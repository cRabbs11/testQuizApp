package com.ekochkov.testquizapp.utils

import com.ekochkov.testquizapp.R
import com.ekochkov.testquizapp.di.data.entity.Question

class PopulateDB() {

    fun getQuestions(): List<Question> {
     val list = arrayListOf<Question>()
        list.add(getQuestion1())
        list.add(getQuestion2())
        list.add(getQuestion3())
        list.add(getQuestion4())
        list.add(getQuestion5())
        list.add(getQuestion6())
        list.add(getQuestion7())
        list.add(getQuestion8())
        list.add(getQuestion9())
        list.add(getQuestion10())
        list.add(getQuestion11())
        return list
    }

    fun getQuestion1() : Question {
        val question = Question(
            id = 1,
            question = "Кто был первым космонавтом?",
            answerVar1 = "Гагарин",
            answerVar2 = "Терешкова",
            answerVar3 = "Армстронг",
            answerVar4 = "Джо Перри",
            rightAnswer = "Гагарин",
            image = R.drawable.q1)
        return question
    }

    fun getQuestion2() : Question {
        val question = Question(
            id = 2,
            question = "Какое сопротилвение у сверхпроводника?",
            answerVar1 = "0 Ом",
            answerVar2 = "1 Ом",
            answerVar3 = "-1 Ом",
            answerVar4 = "Бесконечность",
            rightAnswer = "0 Ом",
            image = R.drawable.q2)
        return question
    }

    fun getQuestion3() : Question {
        val question = Question(
            id = 3,
            question = "Кто сделал первую атомную бомбу?",
            answerVar1 = "Эйнштейн",
            answerVar2 = "Оппенгеймер",
            answerVar3 = "Сахаров",
            answerVar4 = "Эдисон",
            rightAnswer = "Оппенгеймер",
            image = R.drawable.q3)
        return question
    }

    fun getQuestion4() : Question {
        val question = Question(
            id = 4,
            question = "Какое животное может жить в космосе?",
            answerVar1 = "Таракан",
            answerVar2 = "Тихоходка",
            answerVar3 = "Человек",
            answerVar4 = "Гриб",
            rightAnswer = "Тихоходка",
            image = R.drawable.q4)
        return question
    }

    fun getQuestion5() : Question {
        val question = Question(
            id = 5,
            question = "Какая страна не высаживалась на луну?",
            answerVar1 = "СССР",
            answerVar2 = "Китай",
            answerVar3 = "Индия",
            answerVar4 = "Франция",
            rightAnswer = "Франция",
            image = R.drawable.q5)
        return question
    }

    fun getQuestion6() : Question {
        val question = Question(
            id = 6,
            question = "Сколько планет в солнечной системе?",
            answerVar1 = "6",
            answerVar2 = "8",
            answerVar3 = "10",
            answerVar4 = "12",
            rightAnswer = "8",
            image = R.drawable.q6)
        return question
    }

    fun getQuestion7() : Question {
        val question = Question(
            id = 7,
            question = "Ближайшая к солнцу звезда?",
            answerVar1 = "Альфа Центавра",
            answerVar2 = "Солнце",
            answerVar3 = "Полярная звезда",
            answerVar4 = "Сириус",
            rightAnswer = "Альфа Центавра",
            image = R.drawable.q7)
        return question
    }

    fun getQuestion8() : Question {
        val question = Question(
            id = 8,
            question = "Меньше какой температуры по цельсию нельзя ничего охладить?",
            answerVar1 = "-99.97",
            answerVar2 = "-543.76",
            answerVar3 = "−273.15",
            answerVar4 = "0",
            rightAnswer = "−273.15",
            image = R.drawable.q8)
        return question
    }

    fun getQuestion9() : Question {
        val question = Question(
            id = 9,
            question = "С какой высоты оффициально начинается космос?",
            answerVar1 = "400 км",
            answerVar2 = "300 км",
            answerVar3 = "200 км",
            answerVar4 = "100 км",
            rightAnswer = "100 км",
            image = R.drawable.q9)
        return question
    }

    fun getQuestion10() : Question {
        val question = Question(
            id = 10,
            question = "Сколько спутников у Марса",
            answerVar1 = "0",
            answerVar2 = "1",
            answerVar3 = "2",
            answerVar4 = "3",
            rightAnswer = "2",
            image = R.drawable.q10)
        return question
    }

    fun getQuestion11() : Question {
        val question = Question(
            id = 11,
            question = "Какая сила тока смертельна для человека",
            answerVar1 = "0,01 А",
            answerVar2 = "0,1 А",
            answerVar3 = "1 А",
            answerVar4 = "10 А",
            rightAnswer = "0,01 А",
            image = R.drawable.q11)
        return question
    }
}