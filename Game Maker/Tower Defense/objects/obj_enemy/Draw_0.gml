draw_self();

// Barra de vida dos inimigos
var xx= x-48;
var yy=y-32;
var ww=xx+((life/100)*100);
var hh=yy+10;
draw_set_color(c_red);
draw_rectangle(xx,yy,xx+100,hh,0);
draw_set_color(c_green);
draw_rectangle(xx,yy,ww,hh,0);