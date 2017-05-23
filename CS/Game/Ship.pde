class Ship {

  PVector pos;
  PVector vel;
  PShape model;
  float heading;
  float r = 10;
  
  Ship() {
    pos = new PVector(width/2, height/2);
    vel = new PVector (0, 0);
    heading = 0.2;
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
    background(0);
    shape(model);
  }
  
  void rotate(float angle) {
     
  }
}