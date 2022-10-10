class Player {
    constructor() {
    }

    setTickets(...ticket) {
        this.ticketArr = ticket;
    }

    getTickets() {
        return this.ticketArr;
    }
}