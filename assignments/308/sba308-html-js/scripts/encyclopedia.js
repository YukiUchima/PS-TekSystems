import data from "../data/data.js";

document.addEventListener("DOMContentLoaded", () => {
  console.log("SBA 308");

  generatePlantCards(data);

  const viewInfoBtns = document.querySelectorAll("#info-button");

  viewInfoBtns.forEach((viewInfoBtn) => {
    viewInfoBtn.addEventListener("click", (event) => {
      event.preventDefault();
      console.log("VIEW INFO!");
    });
  });
});

function generatePlantCards(data) {
  const plantGrid = document.querySelector("#section-plant-grid-area");

  data.forEach((plant) => {
    let card = document.createElement("div");
    card.className = "card plant-card";
    card.innerHTML = `
      <img src="${plant.img}"
              alt="${plant.title}"
            />
            <p class="poppins-light-italic">
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Corporis
              deleniti, placeat dolorem, consectetur suscipit sint distinctio,
              accusantium facere odit adipisci tempore at dolor itaque sunt autem
              veritatis? Eveniet, sint accusamus.
            </p>
            <button class="poppins-bold info-button" id="info-button">View Info</button>
          </div>   
      `;

    plantGrid.appendChild(card);
  });
}
