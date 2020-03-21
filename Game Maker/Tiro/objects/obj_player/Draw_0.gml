draw_self();
if(shoot){
draw_set_colour(c_red);
var dx=x+lengthdir_x(100,image_angle);
var dy=y+lengthdir_y(100,image_angle);
draw_line(x,y,dx,dy);

}

draw_set_colour(c_green);

draw_rectangle(x-50,y-30,(x-50)+life,y-30+15,0);