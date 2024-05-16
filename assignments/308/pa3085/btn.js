const btn1 = document.querySelector("#btn1");
const btn2 = document.querySelector("#btn2");
const btn3 = document.querySelector("#btn3");
const btn4 = document.querySelector("#btn4");
const middleBtn = document.querySelector("#btn5");
const btn6 = document.querySelector("#btn6");
const btn7 = document.querySelector("#btn7");
const btn8 = document.querySelector("#btn8");
const btn9 = document.querySelector("#btn9");

const shiftingBtns = [btn1, btn2, btn3, btn6, btn9, btn8, btn7, btn4];

middleBtn.addEventListener("click", rotate);

function rotate() {
  let prev;
  let temp;
  shiftingBtns.forEach((btn, index) => {
    if (index - 1 < 0) {
      // Account for out-of-range bounds
      prev = shiftingBtns[7].innerHTML;
    } else {
      prev = temp;
    }
    temp = btn.innerHTML;
    btn.innerHTML = prev;
  });
}
