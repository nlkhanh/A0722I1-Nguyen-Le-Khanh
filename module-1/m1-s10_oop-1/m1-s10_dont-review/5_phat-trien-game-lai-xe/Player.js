class Player {
    constructor() {
        this.imgObj = new Image();
        this.point = 0;
    }

    increasePoint() {
        this.point++;
    }

    setPosition(x, y) {
        this.x = x;
        this.y = y;
    }

    getPositionX() {
        return this.x;
    }

    getPositionY() {
        return this.y;
    }

    setSpeed(speed) {
        this.speed = speed;
    }

    getSpeed() {
        return this.speed;
    }

    increaseSpeed(speedUp) {
        this.speed += speedUp;
    }

    setImgSrc(src) {
        this.imgObj.src = src;
        this.width = this.imgObj.width;
        this.height = this.imgObj.height;
    }

    getImgSrc() {
        return this.imgObj.src;
    }

    getWidth() {
        return this.width;
    }

    getHeight() {
        return this.height;
    }

    draw(ctx) {
        let imgObj = this.imgObj;
        let x = this.x;
        let y = this.y;
        imgObj.src = this.getImgSrc();
        imgObj.onload = function () {
            ctx.drawImage(imgObj, x - imgObj.width / 2, y - imgObj.height / 2);
        }
    }

    erase(ctx) {
        let imgObj = this.imgObj;
        let x = this.x;
        let y = this.y;
        ctx.clearRect(x - imgObj.width / 2, y - imgObj.height / 2, imgObj.width, imgObj.height);
    }

    move(speedX, speedY) {
        this.x += speedX;
        this.y += speedY;
    }

    touchBorder(canvas) {
        return (this.x <= (this.width / 2) ||
            this.x >= (canvas.width - this.width / 2) ||
            this.y <= (this.height / 2) ||
            this.y >= (canvas.height - this.height / 2));
    }

    touchBarrier(barrier) {
        let barrierW = barrier.getWidth();
        let barrierH = barrier.getHeight();
        let barrierX = barrier.getPositionX();
        let barrierY = barrier.getPositionY();
        return (this.x >= (barrierX - barrierW / 2 - this.width / 2) &&
            this.x <= (barrierX + barrierW / 2 + this.width / 2) &&
            this.y >= (barrierY - barrierH / 2 - this.height / 2) &&
            this.y <= (barrierY + barrierH / 2 + this.height / 2)
        );
    }
}