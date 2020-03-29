/// @description Insert description here
// You can write your code in this editor
/// @description Insert description here
// You can write your code in this editor
var eventid  = async_load[? "id"];
var t = async_load[? "type"];


	
if(t == network_type_connect){

}else if(t == network_type_disconnect){

}else{
	var sock = async_load[? "id"];
	var buff = async_load[? "buffer"];
	
	var cmd = buffer_read(buff,buffer_string);
	if(cmd == "players"){
		ds_list_clear(clientsX);
		ds_list_clear(clientsY);
		ds_list_clear(clientsXSCALE);
		var size = buffer_read(buff,buffer_s16);
		for(var i =0; i < size; i++){
			ds_list_add(clientsX,buffer_read(buff,buffer_s16));
			ds_list_add(clientsY,buffer_read(buff,buffer_s16));
			ds_list_add(clientsXSCALE,buffer_read(buff,buffer_s16));
		}
	}else if(cmd=="bullets"){
		ds_list_clear(bulletsX);
		ds_list_clear(bulletsY);
		var size = buffer_read(buff,buffer_s16);
		for(var i =0; i < size; i++){
			ds_list_add(bulletsX,buffer_read(buff,buffer_s16));
			ds_list_add(bulletsY,buffer_read(buff,buffer_s16));
		}	
	}
}
	