/// @description Insert description here
// You can write your code in this editor
show_debug_message("Sou o cliente!");

client = network_create_socket(network_socket_tcp);
network_connect(client, "127.0.0.1", 6510);
buff = buffer_create( 256, buffer_grow, 1);

player = instance_create_depth(48,48,0,obj_player);
player.image_alpha = 1;


clientsX = ds_list_create();
clientsY = ds_list_create();
clientsXSCALE = ds_list_create();

bulletsX = ds_list_create();
bulletsY = ds_list_create();