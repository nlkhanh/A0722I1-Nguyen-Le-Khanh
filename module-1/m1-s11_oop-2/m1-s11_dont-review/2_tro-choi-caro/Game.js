class Game {
    constructor(player1, player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    setCellArr(cellArr) {
        this.cellArr = cellArr;
    }

    setValueArr(valueArr) {
        this.valueArr = valueArr;
    }

    getNowPlayer() {
        if (this.player1.getStatus()) {
            this.nextPlayer = this.player2;
            return this.player1;
        } else {
            this.nextPlayer = this.player1;
            return this.player2;
        }
    }

    checkWinHorizontal(symbol) {
        let maxRow = this.valueArr.length;
        let maxCol = this.valueArr[0].length - 4;
        let result = false;
        for (let i = 0; i < maxRow; i++) {
            for (let j = 0; j < maxCol; j++) {
                if (
                    this.valueArr[i][j] === symbol &&
                    this.valueArr[i][j] === this.valueArr[i][j + 1] &&
                    this.valueArr[i][j] === this.valueArr[i][j + 2] &&
                    this.valueArr[i][j] === this.valueArr[i][j + 3] &&
                    this.valueArr[i][j] === this.valueArr[i][j + 4]
                ) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    checkWinVertical(symbol) {
        let maxRow = this.valueArr.length - 4;
        let maxCol = this.valueArr[0].length;
        let result = false;
        for (let i = 0; i < maxRow; i++) {
            for (let j = 0; j < maxCol; j++) {
                if (
                    this.valueArr[i][j] === symbol &&
                    this.valueArr[i][j] === this.valueArr[i + 1][j] &&
                    this.valueArr[i][j] === this.valueArr[i + 2][j] &&
                    this.valueArr[i][j] === this.valueArr[i + 3][j] &&
                    this.valueArr[i][j] === this.valueArr[i + 4][j]
                ) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    checkWinRightDiagonal(symbol) {
        let maxRow = this.valueArr.length - 4;
        let maxCol = this.valueArr[0].length - 4;
        let result = false;
        for (let i = 0; i < maxRow; i++) {
            for (let j = 0; j < maxCol; j++) {
                if (
                    this.valueArr[i][j] === symbol &&
                    this.valueArr[i][j] === this.valueArr[i + 1][j + 1] &&
                    this.valueArr[i][j] === this.valueArr[i + 2][j + 2] &&
                    this.valueArr[i][j] === this.valueArr[i + 3][j + 3] &&
                    this.valueArr[i][j] === this.valueArr[i + 4][j + 4]
                ) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    checkWinLeftDiagonal(symbol) {
        let minRow = this.valueArr.length - 6;
        let maxRow = this.valueArr.length;
        let maxCol = this.valueArr[0].length - 4;
        let result = false;
        for (let i = minRow; i < maxRow; i++) {
            for (let j = 0; j < maxCol; j++) {
                if (
                    this.valueArr[i][j] === symbol &&
                    this.valueArr[i][j] === this.valueArr[i - 1][j + 1] &&
                    this.valueArr[i][j] === this.valueArr[i - 2][j + 2] &&
                    this.valueArr[i][j] === this.valueArr[i - 3][j + 3] &&
                    this.valueArr[i][j] === this.valueArr[i - 4][j + 4]
                ) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    checkWin(nowPlayer) {
        if (
            this.checkWinHorizontal(nowPlayer.getSymbol()) ||
            this.checkWinVertical(nowPlayer.getSymbol()) ||
            this.checkWinRightDiagonal(nowPlayer.getSymbol()) ||
            this.checkWinLeftDiagonal(nowPlayer.getSymbol())
        ) {
            alert(nowPlayer.getName() + " is the Winner!");
            document.getElementById("overlay").style.display = "block";
        }
    }

    playATurn(i, j) {
        this.nowPlayer = this.getNowPlayer();
        if (this.valueArr[i][j] === "") {
            this.valueArr[i][j] = this.nowPlayer.getSymbol();
            this.cellArr[i][j].innerHTML = this.valueArr[i][j];
            this.nowPlayer.setStatus(false);
            this.nextPlayer.setStatus(true);
        } else {
            alert("The cell is not empty!")
        }
        this.checkWin(this.nowPlayer);
    }

    reset() {
        for (let i = 0; i < this.valueArr.length; i++) {
            for (let j = 0; j < this.valueArr[i].length; j++) {
                this.valueArr[i][j] = "";
                this.cellArr[i][j].innerHTML = this.valueArr[i][j]
            }
        }
        document.getElementById("overlay").style.display = "none";
    }
}