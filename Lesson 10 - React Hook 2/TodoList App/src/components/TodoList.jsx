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









    

    const updateStatus = async (id) => {
        const todo = todos.find((todo) => todo.id === id);
        let updateTodo = { title: todo.title, status: !todo.status };
        handleUpdateTodo(id, updateTodo);
    };


    const handleUpdateTodo = async (id, updateTodo) => {
        // Goi PUT API de update todo
        try {
            let putResult = await fetch(API_URL + "/" + id, {
                headers: {
                    "Content-type": "application/json; charset=UTF-8",
                },
                method: "PUT",
                body: JSON.stringify(updateTodo),
            });
            if (putResult.status === 200) {
                const updatedTodos = todos.map(todoItem => {
                    if (todoItem.id === id) {
                        return { ...todoItem, title: updateTodo.title, status: updateTodo.status };
                    } else {
                        return todoItem;
                    }
                })
                setTodos(updatedTodos);
            } else {
                console.error(putResult);
                alert("Error when updating todo item");
            }
        } catch (error) {
            console.error(error);
        }
    };





    return (
        <>
            <h1>TodoList App</h1>
            <input id="todoText" type="text" placeholder="Enter todo title..." value={title} onChange={e => setTitle(e.target.value)}></input>
            <button id="addtodoButton" onClick={addTodo}>Add</button>
            <ul>
                {/* List */}
                {todos.length > 0 && todos.map((todo) => (
                    <TodoItem key={todo.id} todo={todo} onDelete={handleDelete} onChangeStatus={updateStatus} />
                ))}
            </ul>
        </>
    )
}

export default TodoList
// trong return ko dung dc if, for, chi dung dc funtion kieu xml, nhu la map