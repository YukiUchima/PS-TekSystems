document.addEventListener("DOMContentLoaded", function () {
  // targetting selectors
  const calculator = document.querySelector(".calculator");
  const keys = calculator.querySelector(".calculator__keys");
  const display = document.querySelector(".calculator__display");

  keys.addEventListener("click", (e) => {
    if (e.target.matches("button")) {
      const key = e.target;
      const action = key.dataset.action;
      const keyContent = key.textContent;
      const displayedNum = display.textContent;

      const previousKeyType = calculator.dataset.previousKeyType;

      if (!action) {
        if (displayedNum === "0" || previousKeyType === "operator") {
          display.textContent = keyContent;
          calculator.dataset.previousKeyType = "number";
        } else {
          display.textContent = displayedNum + keyContent;
        }
      }

      if (action === "decimal") {
        // Do nothing if string has a dot
        if (!displayedNum.includes(".")) {
          display.textContent = displayedNum + ".";
        } else if (previousKeyType === "operator") {
          display.textContent = "0.";
        }

        calculator.dataset.previousKeyType = action;
      }

      if (
        action === "add" ||
        action === "subtract" ||
        action === "multiply" ||
        action === "divide"
      ) {
        const firstValue = calculator.dataset.firstValue;
        const operator = calculator.dataset.operator;

        if (firstValue && operator && previousKeyType !== "operator") {
          const secondValue = displayedNum;
          display.textContent = calculate(firstValue, operator, secondValue);
          calculator.dataset.firstValue = display.textContent;
        } else {
          calculator.dataset.firstValue = displayedNum;
        }

        key.classList.add("is-depressed");
        calculator.dataset.previousKeyType = "operator";
        calculator.dataset.operator = action;
      }

      if (action === "calculate") {
        const firstValue = calculator.dataset.firstValue;
        const operator = calculator.dataset.operator;
        const secondValue = displayedNum;

        if (firstValue) {
          if (previousKeyType === "calculate") {
            firstValue = displayedNum;
          }
          display.textContent = calculate(firstValue, operator, secondValue);
        }

        calculator.dataset.previousKeyType = action;
      }

      if (action === "clear") {
        // ...
        calculator.dataset.previousKeyType = action;
        display.textContent = 0;
        calculator.dataset.firstValue = 0;
        calculator.dataset.operator = "";
        calculator.dataset.previousKeyType = "";
      }

      // Remove .is-depressed class from all keys
      Array.from(key.parentNode.children).forEach((k) =>
        k.classList.remove("is-depressed")
      );
    }
  });

  //   END OF DOM CONTENT LOADED
});

const calculate = (n1, operator, n2) => {
  let result = "";
  n1 = parseFloat(n1);
  n2 = parseFloat(n2);

  switch (operator) {
    case "add":
      result = n1 + n2;
      break;
    case "subtract":
      result = n1 - n2;
      break;
    case "multiply":
      result = n1 * n2;
      break;
    case "divide":
      result = n1 / n2;
      break;
    default:
      result = 0;
      break;
  }
  return result;
};
