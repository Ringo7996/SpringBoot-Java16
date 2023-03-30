import React from "react";

class Document1 extends React.Component {
    constructor() {
        super();
        this.state = { display: "" };
    }

    addItem = () => {
        let input = document.querySelector("input");
        let ul = document.getElementById("list");
        let value = input.value;
        if (value === "") {
            alert("Nội dung rỗng");
            return;
        }
        let addli = document.createElement("li");
        addli.textContent = value;
        ul.appendChild(addli);
        input.value = "";
    }


    removeItem = () => {
        let ul = document.getElementById("list");
        let lastli = document.querySelector("#list > li:last-child");
        if (lastli) {
            ul.removeChild(lastli);
        }
    }

    hideShow = () => {
        let hideBtn = document.getElementById("hideBtn");
        if (this.state.display !== "none") {
            this.setState({display:"none"});
            hideBtn.textContent = "Show";
        } else {
            this.setState({display:""});
            hideBtn.textContent = "Hide";
        }
    }

    render() {
        const { display } = this.state;
        return (
            <div>
            <button onClick={this.addItem}>Add</button>
            <input></input>
            <button onClick={this.removeItem}>Remove</button>
            <button id="hideBtn" onClick={this.hideShow}>Hide</button>
            <ul id="list" style={{ display: display }}>
                <li>Item 1</li>
                <li>Item 2</li>
                <li>Item 3</li>
            </ul>
        </div>
        )

    };

};

export default Document1;


// Thêm 1 nút “add” + 1 ô input để nhập text. Mỗi khi bấm nút thêm 1 thẻ <li> có nội dung là nội dung trong ô input vào cuối danh sách
// Thêm 1 nút “remove”. Chức năng để xóa thẻ <li> cuối cùng của danh sách
// Thêm 1 nút “Hide” trên đầu của danh sách <ul>.
// Khi bấm vào “Hide” thì <ul> sẽ ẩn. Đồng thời label của nút “Hide” => “Show”
// Và ngược lại Khi bấm vào “Show” thì <ul> sẽ hiện. Đồng thời label của nút “Show” => “Hide”
