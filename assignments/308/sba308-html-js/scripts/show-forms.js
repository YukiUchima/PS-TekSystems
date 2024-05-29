import users from "../data/users.js";

document.addEventListener("DOMContentLoaded", () => {
  const exitFormBtns = document.querySelectorAll(".cancel-form");

  const formLoginBtn = document.querySelector("#form-login-button");
  const formRegisterBtn = document.querySelector("#form-register-button");

  // const allForms = document.querySelectorAll(".form-submit");

  formLoginBtn.addEventListener("click", () => {
    toggleModal("user-login-form");
  });

  formRegisterBtn.addEventListener("click", () => {
    toggleModal("registration-form");
  });

  // Close active form
  exitFormBtns.forEach((exitFormBtn) => {
    exitFormBtn.addEventListener("click", () => {
      toggleModal();
    });
  });
});

export function toggleModal(modalForm = "") {
  const blurBackground = document.querySelector("#section-main");
  const blurFooter = document.querySelector("footer");

  blurBackground.classList.remove("blur");
  blurFooter.classList.remove("blur");

  const hiddenForms = document.querySelectorAll(".user-form");
  hiddenForms.forEach((hideForm) => {
    hideForm.classList.add("hidden");
  });

  if (modalForm) {
    const targetForm = document.querySelector(`#${modalForm}`);
    targetForm.addEventListener("submit", (event) => {
      event.preventDefault();
    });

    targetForm.classList.remove("hidden");
    blurBackground.classList.add("blur");
    blurFooter.classList.add("blur");

    // Clear out input
    const inputs = targetForm.querySelectorAll("input");
    inputs.forEach((input) => {
      input.value = "";
    });
  }
}
