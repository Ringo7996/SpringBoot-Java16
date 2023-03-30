import React, { useEffect, useState } from "react";

function TodoList() {
    function createTodo(todoItem) {
        let ul = document.getElementById("todoList");
        let li = document.createElement("li");
        let input = document.createElement("input");
        input.type = "checkbox";
        let span = document.createElement("span");
        span.textContent = ` ${todoItem} `;
        let editBtn = document.createElement("button");
        editBtn.textContent = "Edit"
        // editBtn.onClick = 
        let deleteBtn = document.createElement("button");
        deleteBtn.textContent = "Delete"
        // deleteBtn.onClick = function () {
        //     deleteTodo();
        // };


        addEvent(editBtn, deleteBtn, input)
        li.appendChild(input);
        li.appendChild(span);
        li.appendChild(editBtn);
        li.appendChild(deleteBtn);
        ul.appendChild(li);
    }


    useEffect(() => {
        let li = document.querySelectorAll("li");
        console.log(li)
        li.forEach(element => {
            let checkBox = element.children[0];
            let span = element.children[1];
            let editBtn = element.children[2];
            let deleteBtn = element.children[3];

            checkBox.onClick = changeColor;
            editBtn.onClick = editTodo;
            deleteBtn.onClick = deleteTodo;
        });
    });

    function addEvent(editBtn, deleteBtn, input) {
        console.log(editBtn);
        console.log("a");
        editBtn.onClick = function (event) {
            editTodo(event);
        }
    }

    function addTodo() {
        let inputTodo = document.getElementById("inputTodo");
        if (inputTodo.value === "") {
            alert("Nội dung rỗng");
            return;
        }
        createTodo(inputTodo.value);
        inputTodo.value = "";
    }

    let deleteTodo = (event) => {
        let li = event.target.parentElement;
        li.parentElement.removeChild(li);
    }

    function changeColor(event) {
        let checkBox = event.target;
        let span = checkBox.parentElement.children[1]
        if (checkBox.checked === true) {
            span.style.color = "red";
        } else {
            span.style.color = "";
        }
    }

    function editTodo(event) {
        let newContent = window.prompt("Nhập nội dung muốn thay đổi");
        if (newContent === "") {
            alert("Nội dung rỗng");
            return;
        }
        let li = event.target.parentElement;
        let span = li.children[1]
        span.textContent = ` ${newContent} `;
    }



    return (
        <div>
            <div>
                <h1>TodoList App</h1>
                <input id="inputTodo" placeholder="Enter todo title..."></input>
                <button onClick={addTodo}>Add</button>
            </div>
            <ul id="todoList">
                <li>
                    <input onClick={changeColor} type="checkbox"></input>
                    <span> Đi chơi </span>
                    <button onClick={editTodo}>Edit</button>
                    <button onClick={deleteTodo}>Delete</button>
                </li>
                <li>
                    <input onClick={changeColor} type="checkbox"></input>
                    <span> Học bài </span>
                    <button onClick={editTodo}>Edit</button>
                    <button onClick={deleteTodo}>Delete</button>
                </li>
                <li>
                    <input onClick={changeColor} type="checkbox"></input>
                    <span> Đá bóng </span>
                    <button onClick={editTodo}>Edit</button>
                    <button onClick={deleteTodo}>Delete</button>
                </li>
            </ul>
        </div>
    );

}

export default TodoList;


// edit
// sửa event của các cái mới