class Barrier extends Player {
    constructor(role) {
        super();
        this.role = role; // true:award, false:endgame
    }

    setImgSrc() {
        if (this.role === true) {
            this.imgObj.src = "award.png";
        } else {
            this.imgObj.src = "barrier.png";
        }
        this.width = this.imgObj.width;
        this.height = this.imgObj.height;
    }


}