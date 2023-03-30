import React from "react";

function TodoItem({ todo, onDelete }) {
    const handleDelete = () => {
        onDelete(todo.id);

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

    return (
        <li>
            <input onClick={changeColor} type="checkbox"></input>
            <span>{todo.title}</span>
            <button onClick={handleDelete}> Delete </button>
        </li>
    )
}


export default TodoItem