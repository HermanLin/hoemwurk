class Ship {

  PVector pos;
  PVector vel;
  PShape model;
  float heading;
  float r = 10;

  Ship() {
    pos = new PVector(width/2, height/2);
    vel = new PVector (0, 0);
    heading = 3 * PI/2;
    
    model = createShape();
    model.beginShape();
    model.noFill();
    model.stroke(255);
    model.vertex(-r, r);
    model.vertex(r, r);
    model.vertex(0, -r);
    model.endShape(CLOSE);
  }

  void render() {
    translate(pos.x, pos.y);
    shape(model);
    translate(-pos.x,-pos.y);
  }

  void rotate(float angle) {
    heading += angle;
    model.rotate(angle);
  }
  void move() {
    if (pos.x < r) {
      pos.x = width - r;
    }
    if (pos.y < r) {
      pos.y = height - r;
    }
    if (pos.x > width - r) {
      pos.x = r;
    }
    if (pos.y > height - r) {
      pos.y = r;
    }
    
    pos = pos.add(vel);
  }
}