import data from "./data.js";

document.addEventListener("DOMContentLoaded", () => {
  generateProductCards(data);
});

const singleView = document.querySelector("#single-card");
const gridContainer = document.querySelector(".grid-container");
const viewLink = document.querySelector("#view-link");

singleView.addEventListener("click", changeView);

function changeView() {
  // update grid-container to show single cards
  if (gridContainer.classList.contains("single-card-view")) {
    gridContainer.classList.remove("single-card-view");
    viewLink.text = "Single Column View";
  } else {
    gridContainer.classList.add("single-card-view");
    viewLink.text = "Dual Column View";
  }
}

function generateProductCards(data) {
  const productGrid = document.getElementById("productGrid");

  data.forEach((item) => {
    let card = document.createElement("div");
    card.className = "card";
    card.innerHTML = `
            <div class="image-container">
              <img class="original-image" src="${item.img}" alt="${item.title}">
              <div class="zoomed-image-container">
                <img src="${item.img}" alt="${item.title}" class="zoomed-image">
              </div>
            </div>
            <div class="details">
                <h3>${item.title}</h3>
            </div>
        `;
    productGrid.appendChild(card);
  });
}
