class Asteroid {
 
  PVector pos;
  PVector vel;
  PShape model;
  float heading;
  
  Asteroid (PVector position , PVector velocity) {
   pos = position;
   vel = velocity;
   heading = 0;
   
   model = createShape(ELLIPSE, pos.x, pos.y, 10, 10);
   model.noFill();
   model.stroke(255);
  }
  
  void render() {
     translate(pos.x, pos.y);
     shape(model);
  }
}