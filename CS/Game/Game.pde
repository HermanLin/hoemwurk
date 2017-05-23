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