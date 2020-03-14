// Camera suavemente acompanha o jogador 
camX+= (x - (view_wport[0]/2) - camX)*0.02;
camY+= (y - (view_hport[0]/2) - camY)*0.02;

var camx = clamp(camX,0,room_width-view_wport[0]);
var camy = clamp(camY,0,room_height-view_hport[0]);

camera_set_view_pos(view_camera[0], camx,camy);