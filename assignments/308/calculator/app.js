document.addEventListener("DOMContentLoaded", function () {
  const navbar = document.querySelector(".navbar");
});

// buttons is a LIST of all button nodes
const numberBtns = document.querySelectorAll(".grid-numbers > button");
// output-screen
const output = document.querySelector("#output-screen");

// target operator buttons
const operatorBtns = document.querySelectorAll(".operatorBtn > button");

const addBtn = document.querySelector("#add");
const subBtn = document.querySelector("#subtract");
const multiBtn = document.querySelector("#multiply");
const divideBtn = document.querySelector("#divide");
const clrBtn = document.querySelector("#clear");

// addEventListeners to operators
addBtn.addEventListener("click", () => {});

numberBtns.forEach((button) => {
  button.addEventListener("click", (e) => {
    if (e.target.value === "clear" || e.target.value === "null") {
      output.innerHTML = 0;
    } else if (output.innerHTML == "0") {
      output.innerHTML = e.target.value;
    } else {
      output.innerHTML += e.target.value;
    }
  });
});

function calculate(expression) {
  let sum = 0;
  let sign = 1;
  let stack = [];
  expression = expression.split("");

  for (let i = 0; i < expression.length; i++) {
    if (expression[i] === "*" || expression[i] === "/") {
      let op = expression[i];
      let num1 = Number(stack.pop());
      let num2 = Number(expression[++i]);

      if (op === "*") {
        stack.push(num1 * num2);
      } else {
        stack.push(num1 / num2);
      }
    } else {
      stack.push(expression[i]);
    }
  }

  while (stack.length > 0) {
    let c = stack.shift();
    if (c === "-") {
      sign = -1;
    } else if (c === "+") {
      sign = 1;
    } else {
      sum += Number(c) * sign;
    }
  }
  return sum;
}

multiBtn.addEventListener("click", multiply);

// console.log(evaluate("5+4*3/2-1"));

function multiply() {
  console.log(output.innerHTML);
}
// function divide()
// function subtraction()
// function addition()
// function calculate(){
