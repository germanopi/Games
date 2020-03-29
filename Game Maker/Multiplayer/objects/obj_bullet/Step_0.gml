/// @description Insert description here
// You can write your code in this editor
x+=dir*spd;

var instCollision=instance_place(x,y,obj_player);
if(instCollision!=noone){
	if(instCollision.sock!=sock){
		show_message("Dano!");	
	}
}