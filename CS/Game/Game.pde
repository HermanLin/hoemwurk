Ship ship;
boolean upPressed = false;
boolean leftPressed = false;
boolean rightPressed = false;

void setup() {
  size(600, 400);
  background(0);
  frameRate(24);

  ship = new Ship();
}

void draw() {
  if (upPressed) {
    ship.vel = new PVector(7 * cos(ship.heading), 7 * sin(ship.heading));
  } else {
    ship.vel = new PVector(0, 0);
  }

  if (leftPressed) {
    ship.rotate(-1 * PI / 16);
  }
  if (rightPressed) {
    ship.rotate(PI / 32);
  }
  ship.move();
  ship.edge();
  ship.render();
}
void keyPressed() {
  if (key == CODED) {
    if (keyCode == UP) {
      upPressed = true;
    } else if (keyCode == LEFT) {
      leftPressed = true;
    } else if (keyCode == RIGHT) {
      rightPressed = true;
    }
  }
}
void keyReleased() {
  if (key == CODED) {
    if (keyCode == UP) {
      upPressed = false;
    } else if (keyCode == LEFT) {
      leftPressed = false;
    } else if (keyCode == RIGHT) {
      rightPressed = false;
    }
  }
}