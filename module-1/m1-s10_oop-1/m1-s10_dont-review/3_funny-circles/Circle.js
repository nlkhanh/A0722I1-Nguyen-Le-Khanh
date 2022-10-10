class Circle {
    constructor() {
    }

    getRandomRadius() {
        return Math.floor(Math.random() * (50 + 1 - 5) + 5);
    }

    getRandomColor() {
        let red = Math.floor(Math.random() * 255 + 1);
        let green = Math.floor(Math.random() * 255 + 1);
        let blue = Math.floor(Math.random() * 255 + 1);
        return "rgb(" + red + "," + green + "," + blue + ")";
    }

    getRandomPosition(distance) {
        return Math.floor(Math.random() * (distance + 1 - 2 * this.radius) + this.radius)
    }

    draw(c, ctx) {
        ctx.beginPath();
        this.color = this.getRandomColor();
        ctx.fillStyle = this.color;
        this.radius = this.getRandomRadius();
        this.x = this.getRandomPosition(c.width);
        this.y = this.getRandomPosition(c.height);
        ctx.arc(this.x, this.y, this.radius, 0, Math.PI * 2);
        ctx.fill();
    }
}

