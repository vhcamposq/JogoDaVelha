let x = document.querySelector(".x");
let o = document.querySelector(".o");
let boxes = document.querySelectorAll(".box");
let buttons = document.querySelectorAll("#buttons-container button");
let messageContainer = document.querySelector("#message");
let messageText = document.querySelector("#message p");
let secondPlayer;

//contador de jogadas
let player1 = 0;
let player2 = 0;

//adicionando evento de click aos boxes
for (let i = 0; 1 < boxes.length; i++) {
  //quando alguem clica na caixa
  boxes[i].addEventListener("click", function () {
    let el;
    if (player1 == player2) {
      // x
      el = x;
    } else {
      // o
      el = o;
    }
    let cloneEl = el.cloneNode(true);

    this.appendChild(cloneEl);
  });
}
