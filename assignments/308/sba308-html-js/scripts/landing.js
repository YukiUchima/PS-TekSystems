import users from "../data/users.js";

document.addEventListener("DOMContentLoaded", () => {
  console.log("SBA 308");

  const exitFormBtns = document.querySelectorAll(".cancel-login");

  const allForms = document.querySelectorAll(".form-submit");

  // Prevent submission/refreshing page when clicking button
  allForms.forEach((preventForm) => {
    preventForm.addEventListener("submit", (event) => {
      event.preventDefault();
    });
  });

  // Close active form
  exitFormBtns.forEach((exitFormBtn) => {
    exitFormBtn.addEventListener("click", (e) => {
      toggleModal();
    });
  });
});

function toggleModal(modalForm = "") {
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
