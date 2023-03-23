import React, { useEffect, useState } from "react";

function Counter() {
    const [counter, setCounter] = useState(0);
    const [counterColor, setCounterColor] = useState("#333333");


    function changeColor(counterA){
        if (counterA == 0){
            setCounterColor("#133333")
        }
        if (counterA > 0){
            setCounterColor("green");
        }
        if (counterA < 0){
            setCounterColor("red");
        }
    }

    function plus() {
        let counterA = counter+1;
        setCounter(counterA);
        changeColor(counterA);
    }
    // function minus() {
    //     setCounter(counter-1);
    // }

    const minus = () => {
        let counterA = counter-1;
        setCounter(counterA);
        changeColor(counterA);
   }

    return (
        <div class="main-container">
            <h1 class="title">Đếm số</h1>
            <h1 id="counter" style={{color: counterColor}}> {counter} </h1>
            <div class="btn-container">
                <button class="btn counterBtn prevBtn"  onClick={minus} >Trừ
                </button>
                <button class="btn counterBtn nextBtn"  onClick={plus}>Cộng               
                </button>
            </div>
        </div> 
    );
}
export default Counter;