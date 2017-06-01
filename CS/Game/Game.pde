Ship ship;
Asteroid asteroid;
boolean upPressed = false;
boolean leftPressed = false;
boolean rightPressed = false;

void setup() {
  size(600, 400);
  background(0);
  frameRate(24);

  ship = new Ship();
  asteroid = new Asteroid(new PVector(random(0, width), random(0, height), 0), 
    new PVector(random(0, 0), random(0, 0), 0));
}

void draw() {
  if (upPressed) {
    ship.vel = new PVector(7 * cos(ship.heading), 7 * sin(ship.heading));
    ship.move();
  } else {
    ship.vel = new PVector(0, 0);
  }

  if (leftPressed) {
    ship.rotate(-1 * PI / 16);
  }
  if (rightPressed) {
    ship.rotate(PI / 16);
  }
  background(0);
  ship.render();
  asteroid.render();
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