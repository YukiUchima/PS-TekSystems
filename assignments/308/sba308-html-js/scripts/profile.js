import users from "../data/users.js";

document.addEventListener("DOMContentLoaded", () => {
  let uid = localStorage.getItem("userID");

  const logoutBtn = document.querySelector(".logout-btn");

  logoutBtn.addEventListener("click", () => {
    if (localStorage.getItem("loggedIn")) {
      localStorage.setItem("loggedIn", false);
      localStorage.setItem("userID", "");
    }
    window.location.href = "landingPage.html";
  });

  if (uid) {
    setProfile(uid);
  }
});

function setProfile(uid) {
  users.forEach((user) => {
    if (user.id == uid) {
      setAvatar(user.avatar);
    }
  });
}

function setAvatar(imgFile) {
  const avatar = document.querySelector(".profile-aside-left > img");
  avatar.src = imgFile;
}
