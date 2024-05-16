const numberBtn = document.querySelector("#btn");
let number = 0;

numberBtn.addEventListener("click", (event) => {
  event.preventDefault();
  numberBtn.innerHTML = ++number;
});
