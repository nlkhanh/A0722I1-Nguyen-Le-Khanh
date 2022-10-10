class LotteryTicket {
    constructor() {
        this.valueArr = Array(6);
    }

    setValue(ticketClassName) {
        let tempValueArr = document.getElementsByClassName(ticketClassName);
        for (let i = 0; i < tempValueArr.length; i++) {
            this.valueArr[i] = tempValueArr[i].innerHTML;
        }
    }

    getValue() {
        return this.valueArr;
    }
}