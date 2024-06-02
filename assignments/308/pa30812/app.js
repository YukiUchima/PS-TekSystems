"use strict";

// SQUARE
function displaySquare() {
  const width = 7;
  const height = 5;
  let row;
  for (let i = 0; i < height; i++) {
    row = "";
    for (let j = 0; j < width; j++) {
      row += "*";
    }
    console.log(row);
  }
}

// Checkerboard
function displayCheckerboard() {
  const width = 7;
  const height = 5;
  let row;
  for (let i = 0; i < height; i++) {
    let size = width - (i % 2);
    row = size < width ? " " : "";
    for (let j = 0; j < size; j++) {
      row += " *";
    }
    console.log(row);
  }
}

// X - Cross
function displayX(size) {
  for (let row = 0; row <= size; row++) {
    let str = "";
    for (let col = 0; col < size; col++) {
      if (row == col || col == size - 1 - row) {
        str += "*";
      } else {
        str += " ";
      }
    }
    console.log(str);
  }
  return;
}

// lower triangle
function displayLowTriangle() {
  let side = 6;
  let row = "";
  for (let i = 0; i < side; i++) {
    row += "*";
    console.log(row);
  }
}

// upper triangle
function displayUppTriangle() {
  let side = 6;
  let row = "*".repeat(side + 1);
  for (let i = side; i > 0; i--) {
    row = row.substring(0, row.length - 1);
    console.log(row);
  }
}

// Upside-down Trapezoid
function displayTrapezoid(width, height) {
  let spacer = "";
  let star = "";
  if (height * 2 > width) {
    console.log("Impossible SHAPE!");
    return;
  }
  for (let row = 0; row < height; row++) {
    star = spacer;
    let size = width - row * 2;
    for (let col = 1; col <= size; col++) {
      star += "*";
    }
    console.log(star);
    spacer += " ";
  }
}

displayX(9);
