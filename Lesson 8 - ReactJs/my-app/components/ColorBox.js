import React, { useState } from "react";

function ColorBox() {
    //const [share, setShape] = useState("square");
    const [color, setColor] = useState("deeppink");

    function handleBoxClick() {
        setColor("green");
    }

    return (
        <div
            style={{ backgroundColor: color, width: '100px', height: '100px'  }}
            onClick={handleBoxClick}
        ></div>
    );
}
export default ColorBox;