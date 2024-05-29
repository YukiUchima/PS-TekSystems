import users from "../data/users.js";

document.addEventListener("DOMContentLoaded", () => {
  const username = document.querySelector("#registerUsername");
  const password = document.querySelector("#registerPassword");
  const password2 = document.querySelector("#registerPassword2");
  const email = document.querySelector("#email");
  const registerSubmitBtn = document.querySelector("#form-register-button");

  const errUsername = document.querySelector("#reg-username");
  const errPassword = document.querySelector("#reg-password");
  const errMatchPassword = document.querySelector("#reg-match-password");
  const errEmail = document.querySelector("#reg-email");

  username.addEventListener("change", (event) => {
    const currentUsername = event.target.value.trim();
    const reg = /^[a-z]+\w?[a-z0-9]{3,}$/i;
    if (!reg.test(String(currentUsername).toLowerCase())) {
      errUsername.classList.remove("hide");
      username.classList.add("input-error");
    } else {
      errUsername.classList.add("hide");
      username.classList.remove("input-error");
    }
  });

  password.addEventListener("change", (event) => {
    console.log("CHECKING PASSWORd");
    const currentPassword = event.target.value.trim();
    console.log(currentPassword);
    const reg = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*\W)[a-zA-Z\d\W]{8,}$/;
    if (!reg.test(String(currentPassword))) {
      errPassword.classList.remove("hide");
      password.classList.add("input-error");
    } else {
      errPassword.classList.add("hide");
      password.classList.remove("input-error");
    }
  });

  password2.addEventListener("change", (event) => {
    if (password.value !== event.target.value) {
      errMatchPassword.classList.remove("hide");
      password2.classList.add("input-error");
    } else {
      errMatchPassword.classList.add("hide");
      password2.classList.remove("input-error");
    }
  });

  email.addEventListener("change", (event) => {
    const currentEmail = event.target.value.trim();
    const reg = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]{3,}\.[a-zA-Z]{2,}$/;
    if (!reg.test(String(currentEmail).toLowerCase())) {
      errEmail.classList.remove("hide");
      email.classList.add("input-error");
    } else {
      errEmail.classList.add("hide");
      email.classList.remove("input-error");
    }
  });
});

function validateLogin() {
  console.log("VALIDATING LOGIN");
}
