const squares = document.querySelectorAll('.square');
const message = document.querySelector('#message');
let currentPlayer = 'X';
let gameActive = true;

squares.forEach(square => {
  square.addEventListener('click', handleClick);
});

function handleClick(event) {
  const square = event.target;
  const squareIndex = parseInt(square.id) - 1;

  if (square.innerText !== '' || !gameActive) {
    return;
  }

  square.innerText = currentPlayer;
  square.classList.add(currentPlayer.toLowerCase());

  checkWin();

  if (gameActive) {
    switchPlayer();
     makeBotMove(); // add this line to make the bot move after the player
  }
}

function switchPlayer() {
  currentPlayer = currentPlayer === 'X' ? 'O' : 'X';
}

function checkWin() {
  const winningMoves = [
    [0, 1, 2],
    [3, 4, 5],
    [6, 7, 8],
    [0, 3, 6],
    [1, 4, 7],
    [2, 5, 8],
    [0, 4, 8],
    [2, 4, 6]
  ];

  winningMoves.forEach(move => {
    if (squares[move[0]].innerText !== '' &&
      squares[move[0]].innerText === squares[move[1]].innerText &&
      squares[move[1]].innerText === squares[move[2]].innerText) {
      gameActive = false;
      message.innerText = `${currentPlayer} wins!`;
    }
  });

  if (isBoardFull() && gameActive) {
    gameActive = false;
    message.innerText = "It's a tie!";
  }
}

function isBoardFull() {
  return [...squares].every(square => square.innerText !== '');
}

function makeBotMove() {
    if (!gameActive) {
      return;
    }
  
    const boardState = getBoardState();
    const url = new URL('http://localhost:8080/bot/move');
    url.searchParams.set('board', boardState.join(','));
  
    fetch(url, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json;charset=UTF-8'
      }
    })
      .then(response => response.json())
      .then(data => {
        if (data.move !== -1) {
          const botSquare = squares[data.move];
          botSquare.innerText = 'O';
          botSquare.classList.add('o');
          checkWin(); // call checkWin() after the bot move
          switchPlayer();
        }
  
        if (isBoardFull()) {
          gameActive = false;
          message.innerText = "It's a tie!";
        }
      })
      .catch(error => console.error(error));
  }
  

function getBoardState() {
    let board = [];
  
    squares.forEach(square => {
      board.push(square.innerText);
    });
  
    return board;
  }
  

//setInterval(() => {
 // if (currentPlayer === 'O' && gameActive) {
   // makeBotMove();
  ///}
//}, 1000);

