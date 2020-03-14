
part_system = part_system_create();               // Indica que o objeto possui sistema de particulas
part_emitter = part_emitter_create(part_system); // Emissor de particulas
part_system_position(part_system,x,y); // Local da emissão
global.p1 = part_type_create(); // Cria sistema de particulas

// Define particulas
part_type_shape(global.p1, pt_shape_star); 
part_type_colour2(global.p1,c_yellow, c_red);
part_type_alpha2(global.p1, 1, 0);
part_type_blend(global.p1, 1);
part_type_speed(global.p1, 1,3, -0.20, 1);
part_type_life(global.p1, 50,100);

alarm[0]=60;