import React, { useEffect, useState } from "react";
import TodoItem from "./TodoItem";

function TodoList(props) {
    const [todos, setTodos] = useState([]);
    const [title, setTitle] = useState();

    const API_URL = "http://localhost:8080/api/todos"

    useEffect(() => {
        const getAllTodoList = async () => {
            try {
                let todoList = await (await fetch(API_URL)).json();
                // let todoList = await todoListResult.json();
                setTodos(todoList);
                console.log(todoList)
            } catch (error) {
                console.error(error)
            }
        }

        getAllTodoList();
    }, [todos]);




    const handleDelete = async (index) => {
        try {
            let result = await fetch(API_URL + "/" + index, {
                method: "DELETE"
            });

            if (result.status === 204) {
                let resultTodoList = todos.filter(todo => todo.id !== index)
                setTodos(resultTodoList)

            } else {
                console.error(result);
                alert("error when delete")
            }
        } catch (error) {
            console.error(error);
        }
    }

    const addTodo = () => {
        let todoText = document.getElementById("todoText");
        if (todoText.value === "") {
            alert("Nội dung rỗng");
            return;
        }
        handlePost(todoText.value);
    }

    const handlePost = async (todoTextValue) => {
        try {
            let result = await fetch(API_URL, {
                method: "POST",
                headers: { "content-type": "application/json" },
                body: JSON.stringify(
                    {
                        title: `${todoTextValue}`
                    }
                )
            });

            if (result.status === 201) {
                let resultTodoList = todos.filter(todo => todo)
                setTodos(resultTodoList)

            } else {
                console.error(result);
                alert("error when post")
            }
        } catch (error) {
            console.error(error);
        }

    }



    return (
        <>
            <h1>TodoList App</h1>
            <input id="todoText" type="text" placeholder="Enter todo title..." value={title} onChange={e => setTitle(e.target.value)}></input>
            <button id="addtodoButton" onClick={addTodo}>Add</button>


            <ul>
                {/* List */}
                {todos.length > 0 && todos.map((todo) => (
                    <TodoItem key={todo.id} todo={todo} onDelete={handleDelete} />
                ))}
            </ul>
        </>
    )
}

export default TodoList

// trong return ko dung dc if, for, chi dung dc funtion kieu xml, nhu la map