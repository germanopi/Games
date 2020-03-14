var life=obj_player.life;
var xx = 10;
var yy = 10;
var width=xx+((life/100)*100);
var height=yy+10;
draw_set_color(c_white);
draw_rectangle(xx-1,yy-1,xx+101,height+1,0);
draw_set_color(c_red);
draw_rectangle(xx,yy,xx+100,height,0);
draw_set_color(c_green);
draw_rectangle(xx,yy,width,height,0); 
draw_set_font(fnt_UI);
draw_set_color(c_white);
draw_text(20,30,"Vida: "+ string(life));

