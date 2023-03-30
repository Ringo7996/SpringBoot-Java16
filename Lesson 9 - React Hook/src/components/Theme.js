
import React, { useEffect, useState } from "react";
const themes = [
    {
        colorHeading: "#2C3639", // light theme
        colorText: "#3F4E4F",
        bg: "#F9F5EB",
    },
    {
        colorHeading: "#EAE3D2", // dark theme
        colorText: "#F9F5EB",
        bg: "#100720",
    },
];


function Theme() {

    const [theme, setTheme] = useState(themes[0]);
    function getTheme() {
        let select = document.querySelector("select");
        if (select.value == "light") {
            setTheme(themes[0]);
        }
        if (select.value == "dark") {
            setTheme(themes[1]);
        }
    }

    return (
        <div style={{ backgroundColor: theme.bg }}>
            <select onClick={getTheme}>
                <option value={"light"}>Light Theme</option>
                <option value={"dark"}>Dark Theme</option>
            </select>

            <h2 style={{ color: theme.colorHeading }}>
                Lorem ipsum dolor sit, amet consectetur adipisicing elit.
            </h2>
            <p style={{ color: theme.colorText }}>
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Quis
                placeat necessitatibus, vitae laboriosam in quos, nesciunt modi
                error sit porro, reprehenderit voluptatem dolore libero
                incidunt. Illo mollitia fugit quam inventore?
            </p>
        </div>
    );

}

export default Theme;


