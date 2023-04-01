import React from "react";

function TodoItem({ todo, onDelete, onChangeStatus }) {
    const handleDelete = () => {
        onDelete(todo.id);

    }

    const handleChangeStatus = () => {
        onChangeStatus(todo.id);
    }

    return (
        <li>
          <input type="checkbox" checked={todo.status} onChange={handleChangeStatus} />
            <span className={todo.status ? "active" : ""}>{todo.title}</span>
            <button onClick={handleDelete}> Delete </button>
        </li>
    )
}


export default TodoItem