/// @description Insert description here
// You can write your code in this editor
var eventid  = async_load[? "id"];
var t = async_load[? "type"];

if(server == eventid){
	
	if(t == network_type_connect){
		var sock = async_load[? "socket"];
		var inst = instance_create_depth(0,0,0,obj_player);
		inst.sock = sock;
		ds_map_add(clients,sock,inst);
		show_message("Novo player conectado!");
	}else if(t == network_type_disconnect){
		var sock = async_load[? "socket"];
		var inst = clients[? sock];
		ds_map_delete(clients,sock);
		instance_destroy(inst);
	}
	
}else{
	
	//Acontecimentos no game!
	
	var sock = async_load[? "id"];
	var inst = clients[? sock];
	var buff = async_load[? "buffer"];
	
	var cmd = buffer_read(buff,buffer_string);
	if(cmd == "atualizar_posicao"){
		show_debug_message("posicao atualizada!");
		inst.x = buffer_read(buff,buffer_s16);
		inst.y = buffer_read(buff,buffer_s16);
		inst.image_xscale = buffer_read(buff,buffer_s16);
	}else if(cmd=="nova_bullet"){
		var bullet = instance_create_depth(0,0,0,obj_bullet);
		bullet.x=buffer_read(buff,buffer_s16);
		bullet.y=buffer_read(buff,buffer_s16);
		bullet.dir = buffer_read(buff,buffer_s16);	
		bullet.sock=sock;
	}
}