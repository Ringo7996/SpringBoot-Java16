const quizes = [
    {
        id: 1,
        question: "1 + 1 = ?",
        answers: [1, 2, 3, 4],
    },
    {
        id: 2,
        question: "2 + 2 = ?",
        answers: [2, 3, 4, 5],
    },
    {
        id: 3,
        question: "3 + 3 = ?",
        answers: [3, 4, 5, 6],
    },
];


// Vừa vào trang hiển thị danh sách quiz (bao gồm tiêu đề và danh sách các câu trả lời)
let quizContainer = document.querySelector(".quiz-container");
quizContainer.innerHTML = "";

for (let i = 0; i < quizes.length; i++) {
    let quizItem = document.createElement("div");
    quizItem.classList.add("quiz-item");

    let question = document.createElement("h3");
    question.innerText = `Câu ${quizes[i].id}: ${quizes[i].question}`

    let quizAnswer = document.createElement("div");
    quizAnswer.classList.add("quiz-answer");
    for (let j = 0; j < quizes[i].answers.length; j++) {
        let quizAnswerItem = document.createElement("div");
        quizAnswerItem.classList.add("quiz-answer-item");
        quizAnswerItem.innerHTML = `<input type="radio" name="${quizes[i].id}">
                                    <label> ${quizes[i].answers[j]}</label>`;
        quizAnswer.appendChild(quizAnswerItem);
    }
    quizItem.appendChild(question);
    quizItem.appendChild(quizAnswer);
    quizContainer.appendChild(quizItem);
}



// Khi bấm vào nút “Random Answer” thì random câu trả lời cho từng câu hỏi và tự động được check vào (Mỗi câu hỏi chỉ check 1 câu trả lời)
let button = document.getElementById("btn");
let quizList = document.getElementsByClassName("quiz-answer")
let answerList = quizList[0];

button.addEventListener("click", function(){
    for (let i = 0; i < quizList.length; i++) {
        let answerList = quizList[i].children;
        let random = Math.floor(Math.random() * quizList.length);  // Mỗi question có bao nhiêu answer thì random từng ấy tương ứng.
        let randomAnswer = answerList[random];
        randomAnswer.firstChild.checked = true
        console.log(randomAnswer.firstChild)
  
    }
})


