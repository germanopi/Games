/// @description Insert description here
// You can write your code in this editor
show_debug_message("sou o server");


server = network_create_server( network_socket_tcp, 6510, 32);
buff = buffer_create( 256, buffer_grow, 1);

clients = ds_map_create();