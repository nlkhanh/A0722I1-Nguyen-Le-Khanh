class Player {
    constructor(name, status, symbol) {
        this.name = name;
        this.status = status;
        this.symbol = symbol;
    }

    setStatus(status) {
        this.status = status;
    }

    getStatus() {
        return this.status;
    }

    getSymbol() {
        return this.symbol;
    }

    getName() {
        return this.name;
    }
}