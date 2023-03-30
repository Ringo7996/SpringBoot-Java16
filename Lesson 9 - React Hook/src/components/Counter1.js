import React from "react";

class Counter1 extends React.Component {
    constructor() {
        super();
        this.state = { counter: 0, counterColor: "#333333" };
    }

    changeColor = (counterA) => {
        console.log(counterA);
        if (counterA == 0) {
            this.setState({ counterColor: "#333333" });
        }
        if (counterA > 0) {
            this.setState({ counterColor: "green" });
        }
        if (counterA < 0) {
            this.setState({ counterColor: "red" });
        }
    }

    plus = () => {
        this.setState({ counter: this.state.counter + 1 }, () => this.changeColor(this.state.counter));
    }

    minus = () => {
        let counterA = this.state.counter - 1;
        this.setState({ counter: counterA });
        this.changeColor(counterA);
    }


    render() {
        const { counter, counterColor } = this.state;
        return (
            <div class="main-container">
                <h1 class="title">Đếm số</h1>
                <h1 id="counter" style={{ color: counterColor }}> {counter} </h1>
                <div class="btn-container">
                    <button class="btn counterBtn prevBtn" onClick={this.minus}>Trừ </button>
                    <button class="btn counterBtn nextBtn" onClick={this.plus}>Cộng </button>
                </div>
            </div>
        )

    }


}

export default Counter1;

