
import React, { useEffect, useState } from "react";

function Boxes() {
    let colors = [
        '#3498db',
        '#9b59b6',
        '#e74c3c',
        '#2c3e50',
        '#d35400',
    ]

    let totalBox = [];
    let boxes = document.querySelector(".boxes");
    function create5boxes() {
        for (let i = 0; i < colors.length; i++) {
            let box = document.createElement("div");
            box.className = "box";
            box.width = "50px";
            box.height = "50px";
            box.style.backgroundColor = colors[i];
            boxes.insertAdjacentElement("beforeend", box);
            totalBox.push(box);
        }
    }
    create5boxes();
    // Render số box = số lượng màu ra ngoài màn hình bằng javascript (5 box)
    // Box được tạo bởi thẻ div, có class=“box”, background tương ứng với từng mã màu


    const [total, setTotal] = useState(5);

    function create5boxes() {
        let boxes = document.querySelector(".boxes");
        for (let i = 0; i < colors.length; i++) {
            let box = document.createElement("div");
            box.className = "box";
            box.width = "50px";
            box.height = "50px";
            box.style.backgroundColor = colors[i];
            boxes.appendChild(box);
            totalBox.push(box);

        }
        let newTotal = total + 5;
        setTotal(newTotal);
        removeBox()


    }

    function removeBox() {
        let box = document.querySelectorAll(".box");
        if (box) {
            box.forEach(element => {
                element.onclick = function () {
                    element.parentNode.removeChild(element)
                    let newTotal = total - 1;
                    setTotal(newTotal);
                }
            });
        }
    }



    return (
        <div className="wrap">
            <h1> JS DOM</h1>
            <button id="btn" onClick={create5boxes}>More boxes</button>
            <h4 id="score"> Total box: {total} <span className="points"></span></h4>
            <div className="boxes">
                <div className="box" width="50px" height="50px" style={{ backgroundColor: "#3498db" }} onClick={removeBox}></div>
                <div className="box" width="50px" height="50px" style={{ backgroundColor: "#9b59b6" }} onClick={removeBox}></div>
                <div className="box" width="50px" height="50px" style={{ backgroundColor: "#e74c3c" }} onClick={removeBox}></div>
                <div className="box" width="50px" height="50px" style={{ backgroundColor: "#2c3e50" }} onClick={removeBox}></div>
                <div className="box" width="50px" height="50px" style={{ backgroundColor: "#d35400" }} onClick={removeBox}></div>
            </div>
        </div>
    );

}

export default Boxes;


// Render số box = số lượng màu ra ngoài màn hình bằng javascript (5 box)
// Box được tạo bởi thẻ div, có class=“box”, background tương ứng với từng mã màu
// Cập nhật số lượng total box trong thẻ <span> có class “points”
// Khi bấm vào box bất kỳ thì box đó biến mất, đồng thời số lượng total box giảm đi 1
// Khi click vào nút “more box” thì số lượng box tăng lên 5 (tương ứng với 5 màu trong mảng colors), đồng thời số lượng total box cũng tăng lên 5
